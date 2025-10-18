package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import testbase.DriverInstance;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class TimeTest {
	 private static final Logger logger = LogManager.getLogger(TimeTest.class);
	 private DriverInstance driverInstance;
	
  @Test(description ="Verify The Time Table", enabled=true)
  public void TC009_VerifyTheTimeIsAdded() throws IOException {
	  logger.info("Start TC009_VerifyTheTimeIsAdded test case");
	  driverInstance.getLoginPage().loginToApplication("Admin", "admin123");
	  boolean act = driverInstance.getDashboardPage().isDashboardHeaderDisplayed();
	  driverInstance.getTestBase().attachScreenshot();
	  
	  // code for Time Test 
	  
	  logger.info("Ending TC009_VerifyTheTimeIsAdded {}, {}");
  }
  
  /**
   * 	@BeforeMethod
   * @throws IOException
   */
  
  
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  //browser and url open
	  logger.info("Initializing DriverInstance before each test method");
	  driverInstance = new DriverInstance();
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
	  logger.info("Quitting browser after each test method");
	  //browser close
	  driverInstance.getDashboardPage().logoutFromApplication();
	  driverInstance.quitBrowser();
  }

}
