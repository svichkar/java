package com.connecture.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;
import java.io.IOException;

import org.glassfish.jersey.client.JerseyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.connecture.service.IbrLoaderService;
import com.connecture.util.XmlUnmarshaller;

@RestController
public class IbrLoaderController
{
  @Value("${endpoint.url}")
  private String endpointUrl;
  @Value("${auth.user}")
  private String user;
  @Value("${auth.password}")
  private String password;

  @Autowired
  private IbrLoaderService ibrLoaderService;

  @RequestMapping(value = "/loadIbr",
      method = RequestMethod.POST,
      consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public Object loadIbr(@RequestParam(value = "endpoint") String endpoint,
      @RequestParam(value = "file") MultipartFile file) throws Exception
  {
    return XmlUnmarshaller.unmarshal(file);
  }

  @RequestMapping(value = "/loadIbr",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public Response loadIbr() throws IOException
  {
    return Response.ok().build();
  }

  @RequestMapping(value = "/test",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public Response test() throws IOException
  {
    RestClient rc = new RestClient(user, password);
    return rc.get();
  }
}
