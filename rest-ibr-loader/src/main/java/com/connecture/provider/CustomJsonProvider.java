package com.connecture.provider;

import static com.fasterxml.jackson.databind.MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES;
import static com.fasterxml.jackson.databind.MapperFeature.ALLOW_EXPLICIT_PROPERTY_RENAMING;
import static com.fasterxml.jackson.databind.MapperFeature.USE_WRAPPER_NAME_AS_PROPERTY_NAME;
import static com.fasterxml.jackson.databind.PropertyNamingStrategy.LOWER_CAMEL_CASE;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

@Provider
@Consumes(MediaType.WILDCARD)
@Produces(MediaType.APPLICATION_JSON)
public class CustomJsonProvider extends JacksonJaxbJsonProvider
{
  public CustomJsonProvider()
  {
    super();
    super.setAnnotationsToUse(DEFAULT_ANNOTATIONS);
    super.setMapper(getObjectMapper());
  }

  private ObjectMapper getObjectMapper() {
    return new ObjectMapper()
        .enable(ALLOW_EXPLICIT_PROPERTY_RENAMING)
        .enable(ACCEPT_CASE_INSENSITIVE_PROPERTIES)
        .enable(USE_WRAPPER_NAME_AS_PROPERTY_NAME)
        .setPropertyNamingStrategy(LOWER_CAMEL_CASE);
  }

}
