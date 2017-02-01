package com.connecture.service;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.connecture.insureadvantage.sgrenewals.model.FeedRenewalQuoteInfo;
import com.connecture.insureadvantage.sgrenewals.model.RenewalPeriodInfo;
import com.connecture.rest.HttpClient;

@Service
public class IbrLoaderService
{
  private static final Logger LOGGER = LoggerFactory.getLogger(IbrLoaderService.class);
  private static final String STATUS_OPEN = "Open";

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

  private final HttpClient httpClient = new HttpClient(user, password);

  public Response createRenewalPeriod(RenewalPeriodInfo periodInfo)
  {
    LOGGER.info("Creating Renewal Period... Renewal Period: {0}", periodInfo.toString());
    periodInfo.setStatus(STATUS_OPEN);
    return httpClient.post(endpointUrl, Arrays.asList(periodsUrl), Entity.json(periodInfo));
  }

  public Response createRenewalQuote(String renewalPeriodXref, FeedRenewalQuoteInfo renewalQuoteInfo)
  {
    LOGGER.info("Creating Renewal Quote... Renewal Period: {0}; group ID: {1}; quote ID: {2}",
        renewalPeriodXref, renewalQuoteInfo.getGroup().getID(), renewalQuoteInfo.getQuote().getID());
    return httpClient.post(endpointUrl,
        Arrays.asList(periodsUrl, renewalPeriodXref, inboundUrl), Entity.xml(renewalQuoteInfo));
  }
}
