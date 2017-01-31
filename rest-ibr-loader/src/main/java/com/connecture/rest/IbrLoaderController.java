package com.connecture.rest;

import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.UnmarshalException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.connecture.domain.CreateRenewalRequest;
import com.connecture.insureadvantage.sgrenewals.model.FeedRenewalQuoteInfo;
import com.connecture.service.IbrLoaderService;


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
  public Object loadIbr(@RequestParam(value = "endpoint") String endpoint,
      @RequestParam(value = "file") MultipartFile file) throws Exception
  {
    try
    {
      FeedRenewalQuoteInfo quoteInfo = (FeedRenewalQuoteInfo) JAXBContext
          .newInstance(FeedRenewalQuoteInfo.class)
          .createUnmarshaller()
          .unmarshal(file.getInputStream());
      return quoteInfo;
    }
    catch (UnmarshalException e)
    {
      CreateRenewalRequest req = (CreateRenewalRequest) JAXBContext
          .newInstance(CreateRenewalRequest.class)
          .createUnmarshaller()
          .unmarshal(file.getInputStream());
      return req;
    }
  }

  @RequestMapping(value = "/loadIbr",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public Response loadIbr() throws IOException
  {
    return Response.ok().build();
  }
}
