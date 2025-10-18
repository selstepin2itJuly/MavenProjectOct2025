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

public class AdminTest {
	 private static final Logger logger = LogManager.getLogger(AdminTest.class);
	 private DriverInstance driverInstance;
	
  @Test(description ="Verify The Admin Is In The Admin Table")
  public void TC007_VerifyTheAdminIsInTheAdminTable() throws IOException {
	  logger.info("Start TC007_VerifyTheAdminIsInTheAdminTable test case");
	  driverInstance.getLoginPage().loginToApplication("Admin", "admin123");
	  boolean act = driverInstance.getDashboardPage().isDashboardHeaderDisplayed();
	  driverInstance.getTestBase().attachScreenshot();
	  driverInstance.getDashboardPage().clickOnAdminOption();
	  boolean actSearchBox = driverInstance.getAdminPage().isAdminUserManagementDisplayed();
	  Assert.assertEquals(actSearchBox, true);
	  driverInstance.getTestBase().attachScreenshot();
	  driverInstance.getAdminPage().selectUserRoleFromDropdown("Admin");
	  driverInstance.getAdminPage().clickSearchButton();
	  driverInstance.getTestBase().attachScreenshot();
	  boolean actUsernamInRecord =driverInstance.getAdminPage().validateRecordsUsernameDisplayed("Admin");
	  Assert.assertEquals(actUsernamInRecord, true);
	  boolean actUserole = driverInstance.getAdminPage().validateRecordsUserRoleDisplayed("Admin");
	  Assert.assertEquals(actUserole, true);
	  boolean actStatus = driverInstance.getAdminPage().validateRecordsStatusDisplayed("Enabled");
	  driverInstance.getTestBase().attachScreenshot();
	  Assert.assertEquals(actStatus, true);
	  logger.info("Ending TC007_VerifyTheAdminIsInTheAdminTable {}, {}");
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
	  driverInstance.getDashboardPage().logoutFromApplication();
	  driverInstance.quitBrowser();
  }

}
