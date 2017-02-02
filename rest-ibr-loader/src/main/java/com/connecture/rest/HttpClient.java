package com.connecture.rest;

import static com.fasterxml.jackson.annotation.JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES;
import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.connecture.provider.CustomJsonProvider;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

@Component
public class HttpClient
{
  @Value("${auth.user}")
  private String user;
  @Value("${auth.password}")
  private String password;

  private Client client;
  private static final String CNX_SERVER_AUTH = "CNX-Server-Auth";

  public HttpClient()
  {
  }

  public HttpClient(String user, String password)
  {
    JacksonJsonProvider jacksonJsonProvider = new CustomJsonProvider()
        .configure(FAIL_ON_UNKNOWN_PROPERTIES, false);
    ClientConfig clientConfig = new ClientConfig(jacksonJsonProvider);
    clientConfig.register(HttpAuthenticationFeature.basic(user, password));
    client = ClientBuilder.newClient(clientConfig);
  }

  public Response post(String endpoint, List<String> paths, Entity entity)
  {
    return constructTargetUrl(endpoint, paths).request(MediaType.APPLICATION_JSON)
        .header(CNX_SERVER_AUTH, true)
        .post(entity);
  }

  public Response get(String endpoint, List<String> paths)
  {
    return constructTargetUrl(endpoint, paths).request()
        .header(CNX_SERVER_AUTH, true)
        .get();
  }

  private WebTarget constructTargetUrl (String endpoint, List<String> paths)
  {
    WebTarget target = client.target(endpoint);
    return paths.stream()
        .map(target::path)
        .findAny()
        .orElse(target);
  }

  public String getUser()
  {
    return user;
  }

  public void setUser(String user)
  {
    this.user = user;
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }
}
