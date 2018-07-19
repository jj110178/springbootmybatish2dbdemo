package com.example.demo.model;

public class Advertiser {
  private String advertiserName;
  private String advertiserContactName;
  private int creditLimit;

  public Advertiser(){}

  public Advertiser(String advertiserName, String advertiserContactName, int creditLimit) {
    this.advertiserName = advertiserName;
    this.advertiserContactName = advertiserContactName;
    this.creditLimit = creditLimit;
  }


  public String getAdvertiserName() {
    return advertiserName;
  }

  public void setAdvertiserName(String advertiserName) {
    this.advertiserName = advertiserName;
  }

  public String getAdvertiserContactName() {
    return advertiserContactName;
  }

  public void setAdvertiserContactName(String advertiserContactName) {
    this.advertiserContactName = advertiserContactName;
  }

  public int getCreditLimit() {
    return creditLimit;
  }

  public void setCreditLimit(int creditLimit) {
    this.creditLimit = creditLimit;
  }

  @Override
  public String toString() {
    return String.format("[AdvertiserName=%s, ContactName=%s, CreditLimit=%d]", advertiserName, advertiserContactName, creditLimit);
  }

}
