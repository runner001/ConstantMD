package com.regression;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestRunner {
  @Test
  public void foo() {
	  Assert.assertTrue(true);
  }
  @BeforeTest
  public void beforeTest() {
	  System.out.println("--- Before Test ---");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("--- After Test ---");
  }

}
