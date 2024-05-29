package restAssured.RestAssuredDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestNg1 {
  @Test
  public void f() {
	  System.out.println("kee");
  }
  @BeforeTest
  public void beforeTest() {
	  System.out.println("BL");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("LV");
  }

}
