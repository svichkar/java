package com.connecture.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.jackson.JacksonFeature;

public class RestClient
{
  private Client client;
  private static final String CNX_SERVER_AUTH = "CNX-Server-Auth";

  public RestClient(String user, String password)
  {
    ClientConfig clientConfig = new ClientConfig();
    HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(user, password);
    clientConfig.register(feature).register(JacksonFeature.class);
    clientConfig.register(JacksonFeature.class);
    client = ClientBuilder.newClient(clientConfig);
  }

  public Response post(Object entity)
  {
    return client.target("http://localhost:7777/JerseyDemos/rest")
        .path("employees")
        .request(MediaType.APPLICATION_JSON)
        .header(CNX_SERVER_AUTH, true)
        .post(Entity.xml(entity));
  }

  public Response get()
  {
    return client.target("http://localhost:7777/loadIbr")
        .request(MediaType.APPLICATION_JSON)
        .header(CNX_SERVER_AUTH, true)
        .get();
  }
}
