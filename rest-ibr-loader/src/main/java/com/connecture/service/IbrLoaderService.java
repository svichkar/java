package com.connecture.service;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.connecture.insureadvantage.sgrenewals.model.FeedRenewalQuoteInfo;
import com.connecture.insureadvantage.sgrenewals.model.RenewalPeriodInfo;
import com.connecture.rest.HttpClient;

@Service
public class IbrLoaderService
{
  private static final Logger LOGGER = LoggerFactory.getLogger(IbrLoaderService.class);
  private static final String STATUS_OPEN = "OPEN";

  @Value("${endpoint.url}")
  private String endpointUrl;
  @Value("${periods.path}")
  private String periodsUrl;
  @Value("${inbound.path}")
  private String inboundUrl;
  @Value("#{'${endpoint.url.list}'.split(',')}")
  private List<String> endpointUrls;

  private final HttpClient httpClient;

  @Autowired
  public IbrLoaderService (HttpClient httpClient)
  {
    this.httpClient = new HttpClient(httpClient.getUser(), httpClient.getPassword());
  }

  public Response createRenewalPeriod(RenewalPeriodInfo periodInfo)
  {
    periodInfo.setStatus(STATUS_OPEN);
    LOGGER.info("Creating Renewal Period... Renewal Period: {}", periodInfo.toString());
    return httpClient.post(endpointUrl, Collections.singletonList(periodsUrl), Entity.json(periodInfo));
  }

  public Response createRenewalQuote(String renewalPeriodXref, FeedRenewalQuoteInfo renewalQuoteInfo)
  {
    LOGGER.info("Creating Renewal Quote... Renewal Period: {}; group ID: {}; quote ID: {}",
        renewalPeriodXref, renewalQuoteInfo.getGroup().getID(), renewalQuoteInfo.getQuote().getID());
    return httpClient.post(endpointUrl,
        Arrays.asList(periodsUrl, renewalPeriodXref, inboundUrl),
        Entity.xml(renewalQuoteInfo));
  }
}
