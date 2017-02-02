package com.connecture.domain;

import javax.xml.bind.annotation.XmlElement;

public class RenewalPeriodInfo2 extends com.connecture.insureadvantage.sgrenewals.model.RenewalPeriodInfo
{
  @XmlElement(
      name = "id"
  )
  protected Long id;

  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }
}
