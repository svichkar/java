package com.connecture.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import com.connecture.domain.CreateRenewalRequest;
import com.connecture.insureadvantage.sgrenewals.model.FeedRenewalQuoteInfo;

public class XmlUnmarshaller
{
  private static final Logger LOGGER = LoggerFactory.getLogger(XmlUnmarshaller.class);

  public static Object unmarshal(final MultipartFile file)
  {
    try
    {
      LOGGER.info("Trying to parse XML into FeedRenewalQuoteInfo object.");
      return (FeedRenewalQuoteInfo) JAXBContext
          .newInstance(FeedRenewalQuoteInfo.class)
          .createUnmarshaller()
          .unmarshal(file.getInputStream());
    }
    catch (JAXBException | IOException e1)
    {
      LOGGER.info("XML file cannot be parsed into FeedRenewalQuoteInfo object.", e1);
      try
      {
        LOGGER.info("Trying to parse XML into CreateRenewalRequest object.");
        return (CreateRenewalRequest) JAXBContext
            .newInstance(CreateRenewalRequest.class)
            .createUnmarshaller()
            .unmarshal(file.getInputStream());
      }
      catch (JAXBException | IOException e2)
      {
        LOGGER.error("XML file cannot be parsed into neither FeedRenewalQuoteInfo or CreateRenewalRequest object", e2);
        return null;
      }
    }
  }
}