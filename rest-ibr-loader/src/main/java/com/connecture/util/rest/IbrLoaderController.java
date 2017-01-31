package com.connecture.util.rest;

import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.connecture.insureadvantage.sgrenewals.model.FeedRenewalQuoteInfo;
import com.connecture.util.service.IbrLoaderService;


@RestController
public class IbrLoaderController
{

  @Value("${endpoint.url}")
  private String endpointUrl;

  @Autowired
  IbrLoaderService ibrLoaderService;

  @RequestMapping(value = "/loadIbr",
      method = RequestMethod.POST,
      consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public String loadIbr(@RequestParam(value = "endpoint") String endpoint,
      @RequestParam(value = "file") MultipartFile file) throws Exception
  {
    FeedRenewalQuoteInfo quoteInfo = (FeedRenewalQuoteInfo) JAXBContext
        .newInstance(FeedRenewalQuoteInfo.class)
        .createUnmarshaller()
        .unmarshal(file.getInputStream());

    return endpoint + file.getOriginalFilename();
  }

  @RequestMapping(value = "/loadIbr",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public Response loadIbr() throws IOException
  {
    return Response.ok().build();
  }
}
