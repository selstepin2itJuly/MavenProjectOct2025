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

public class MyInfoTest {
	 private static final Logger logger = LogManager.getLogger(MyInfoTest.class);
	 private DriverInstance driverInstance;
	
  @Test(priority = 2, description ="Verify the menu item count on My Info page", dependsOnMethods = {"TC006_VerifyTheMenuItemTextOnMyInfo"})
  public void TC005_VerifyTheMenuItemCountOnMyInfo() throws IOException {
	  logger.info("Start TC005_VerifyTheMenuItemCountOnMyInfo test case");
	  //driverInstance.getLoginPage().loginToApplication("Admin", "admin123");
	  //driverInstance.getTestBase().attachScreenshot();
	  //boolean act = driverInstance.getDashboardPage().isDashboardHeaderDisplayed();
	  //driverInstance.getDashboardPage().clickOnMyInfoOption();
	  //driverInstance.getTestBase().attachScreenshot();
	  int actCount = driverInstance.getMyInfoPage().getMyInfoTabsCount();
	  driverInstance.getTestBase().attachScreenshot();
	  Assert.assertEquals(actCount, 10);
	  logger.info("Ending TC005_VerifyTheMenuItemCountOnMyInfo {}, {}", actCount, 10);
  }
  
  @Test(priority = 1, description = "Verify the menu item text on My Info page")
  public void TC006_VerifyTheMenuItemTextOnMyInfo() throws IOException {
	  logger.info("Start TC006_VerifyTheMenuItemTextOnMyInfo test case");
	  driverInstance.getLoginPage().loginToApplication("Admin", "admin123");
	  boolean act = driverInstance.getDashboardPage().isDashboardHeaderDisplayed();
	  driverInstance.getTestBase().attachScreenshot();
	  driverInstance.getDashboardPage().clickOnMyInfoOption();
	  List<String> actList = driverInstance.getMyInfoPage().getMyInfoMenuItemText();
	  List<String> expList = List.of("Personal Details",
			    					 "Contact Details",
			    					 "Emergency Contacts",
			    					 "Dependents",
			    					 "Immigration",
			    					 "Job",
			    					 "Salary",
			    					 "Report-to",
			    					 "Qualifications",
			    					 "Memberships");
	  
	  //Soft Assertion
	  SoftAssert softAssert = new SoftAssert();
	  driverInstance.getTestBase().attachScreenshot();
	  for(int i=0; i<actList.size(); i++) {
		  softAssert.assertEquals(actList.get(i), expList.get(i), "Menu Item Text at index "+i+" do not match!");
	  }
	  softAssert.assertAll();
	  logger.info("Ending TC006_VerifyTheMenuItemTextOnMyInfo {} \n {}", actList, expList);
	  
  }
  
  
  @BeforeClass
  public void beforeClass() throws IOException {
	  //browser and url open
	  logger.info("Initializing DriverInstance before each test method");
	  driverInstance = new DriverInstance();
	  
	  
  }

  @AfterClass
  public void afterClass() {
	  logger.info("Quitting browser after each test method");
	  //browser close
	  driverInstance.getDashboardPage().logoutFromApplication();
	  driverInstance.quitBrowser();
  }

}
