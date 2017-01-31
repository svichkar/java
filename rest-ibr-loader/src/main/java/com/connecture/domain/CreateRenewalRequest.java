package com.connecture.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.connecture.insureadvantage.sgrenewals.model.FeedRenewalQuoteInfo;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(
    name = "CreateRenewalRequest",
    namespace = "http://www.connecture.com/integration/esb/sgrenewal"
)
public class CreateRenewalRequest implements Serializable
{
  @XmlElement(name = "FeedRenewalQuoteInfo",
      namespace = "http://www.connecture.com/sgrenewals")
  private List<FeedRenewalQuoteInfo> feedRenewalQuoteInfos;

  public CreateRenewalRequest()
  {
  }

  public List<FeedRenewalQuoteInfo> getFeedRenewalQuoteInfos()
  {
    return feedRenewalQuoteInfos;
  }

  public void setFeedRenewalQuoteInfos(List<FeedRenewalQuoteInfo> feedRenewalQuoteInfos)
  {
    this.feedRenewalQuoteInfos = feedRenewalQuoteInfos;
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    CreateRenewalRequest that = (CreateRenewalRequest) o;
    return Objects.equals(feedRenewalQuoteInfos, that.feedRenewalQuoteInfos);
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(feedRenewalQuoteInfos);
  }

  @Override
  public String toString()
  {
    return "CreateRenewalRequest{" +
        "feedRenewalQuoteInfos=" + feedRenewalQuoteInfos +
        '}';
  }
}
