package com.connecture.rest;

import static java.util.stream.Collectors.toList;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.connecture.domain.CreateRenewalRequest;
import com.connecture.service.IbrLoaderService;
import com.connecture.util.XmlUnmarshaller;

@RestController
public class IbrLoaderController
{
  private static final Logger LOGGER = LoggerFactory.getLogger(IbrLoaderController.class);

  @Value("${endpoint.url}")
  private String endpointUrl;
  @Value("${auth.user}")
  private String user;
  @Value("${auth.password}")
  private String password;
  @Value("${periods.path}")
  private String periodsUrl;
  @Value("${inbound.path}")
  private String inboundUrl;

  @Autowired
  private IbrLoaderService ibrLoaderService;

  @RequestMapping(value = "/loadIbr",
      method = RequestMethod.POST,
      consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Response> loadIbr(@RequestParam(value = "endpoint") String renewalPeriodXref,
      /*@RequestParam(value = "endpoint") String endpoint,*/
      @RequestParam(value = "file") MultipartFile file) throws Exception
  {
    CreateRenewalRequest ibrObject = (CreateRenewalRequest) XmlUnmarshaller.unmarshal(file);
    LOGGER.info("Creating renewal period:\n {0}", ibrObject.getRenewalPeriodInfo().toString());
    Response response = ibrLoaderService.createRenewalPeriod(ibrObject.getRenewalPeriodInfo());
    if (HttpStatus.OK.value() != response.getStatus())
    {
      LOGGER.info("Renewal period was not created. Response:\n {0}", response.toString());
      return new ArrayList<>();
    }
    LOGGER.info("Creating Renewal Quotes");
    return ibrObject.getFeedRenewalQuoteInfos().stream()
        .map(quote -> ibrLoaderService.createRenewalQuote(renewalPeriodXref, quote))
        .collect(toList());
  }

  @RequestMapping(value = "/test",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public String test() throws IOException
  {
    return "test";
  }
}
