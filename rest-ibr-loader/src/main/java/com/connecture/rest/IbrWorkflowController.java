package com.connecture.rest;

import javax.ws.rs.client.Entity;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.connecture.insureadvantage.sgrenewals.model.RenewalPeriodInfo;
import com.connecture.service.IbrLoaderService;

@RestController
public class IbrWorkflowController
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

  @RequestMapping(method = RequestMethod.POST,
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public String createRenewalPeriod(String shortDescription, String longDescription, String status, String xref)
  {
    RenewalPeriodInfo periodInfo = new RenewalPeriodInfo();
    periodInfo.setShortDescription(shortDescription);
    periodInfo.setLongDescription(longDescription);
    periodInfo.setStatus(status);
    periodInfo.setXref(xref);
    return rc.post(endpointUrl, Arrays.asList(periodsUrl), Entity.json(periodInfo)).readEntity(String.class);
  }
}
