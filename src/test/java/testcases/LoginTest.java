package testcases;

import org.testng.annotations.Test;

import testbase.DriverInstance;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	 private static final Logger logger = LogManager.getLogger(LoginTest.class);
	 private DriverInstance driverInstance;
	
  @Test(priority = 1, description ="Verify Login Functionality with Valid Credentials")
  public void TC001_Login_Successful() throws IOException {
	  logger.info("Starting TC001_Login_Successful test case");
	  driverInstance.getLoginPage().loginToApplication("Admin", "admin123");
	  boolean act = driverInstance.getDashboardPage().isDashboardHeaderDisplayed();
	  driverInstance.getTestBase().attachScreenshot();
	  Assert.assertEquals(act, true);
	  logger.info("Ending TC001_Login_Successful test case", act);
  }
  
  @Test(priority = 2, description ="Verify Login Functionality with Invalid Credentials")
  public void TC002_Login_UnSuccessful() throws IOException {
	  logger.info("Starting TC002_Login_UnSuccessful test case");
	  driverInstance.getLoginPage().loginToApplication("Admin1", "admin123");
	  boolean act = driverInstance.getDashboardPage().isDashboardHeaderDisplayed();
	  driverInstance.getTestBase().attachScreenshot();
	  Assert.assertEquals(act, false);
	  logger.info("Ending TC002_Login_UnSuccessful test case", act);
  }
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
	  driverInstance.quitBrowser();
  }

}
