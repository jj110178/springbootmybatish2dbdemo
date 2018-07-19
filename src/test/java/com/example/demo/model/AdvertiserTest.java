package com.example.demo.model;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AdvertiserTest {

  private Advertiser a;

  @Before
  public void setup(){
    a = new Advertiser("Inmobi","Jj", 1000);
  }

  @Test
  public void constructorTest(){
    assertTrue(a.getAdvertiserName().equalsIgnoreCase("Inmobi"));
    assertTrue(a.getAdvertiserContactName().equalsIgnoreCase("Jj"));
    assertTrue(a.getCreditLimit()==1000);
  }

  @Test
  public void toStringTest() {
    String expected = "[AdvertiserName=Inmobi, ContactName=Jj, CreditLimit=1000]";
    Assert.assertEquals(expected, a.toString());
  }
}