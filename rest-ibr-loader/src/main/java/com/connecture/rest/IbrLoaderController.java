package com.connecture.rest;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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
  @Value("${periods.path}")
  private String periodsUrl;
  @Value("${inbound.path}")
  private String inboundUrl;

  @Autowired
  private IbrLoaderService ibrLoaderService;

  private RestClient rc = new RestClient(user, password);

  @RequestMapping(value = "/loadIbr",
      method = RequestMethod.POST,
      consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public Object loadIbr(@RequestParam(value = "endpoint") String renewalPeriodXref,
      /*@RequestParam(value = "endpoint") String endpoint,*/
      @RequestParam(value = "file") MultipartFile file) throws Exception
  {
    List<String> paths = Arrays.asList(periodsUrl, renewalPeriodXref, inboundUrl);
    return rc.post(endpointUrl, paths, XmlUnmarshaller.unmarshal(file))
        .readEntity(String.class);
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
  public String test() throws IOException
  {
    return rc.get().readEntity(String.class);
  }
}
