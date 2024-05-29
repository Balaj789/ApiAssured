package com.TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderTest1 {
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "balaji", "software" },
      new Object[] { 2, "b" },
    };
  }
}
