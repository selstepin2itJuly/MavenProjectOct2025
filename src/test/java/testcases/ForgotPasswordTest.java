package testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.ForgotPasswordPage;
import testbase.DriverInstance;

public class ForgotPasswordTest {
	private static final Logger logger = LogManager.getLogger(ForgotPasswordTest.class);
	private DriverInstance driverInstance;
	@Test(description ="Verify Forgot Password Functionality with Valid Username", enabled=true)
  public void TC004_Forgot_Password_Cancel() throws IOException {
		driverInstance.getLoginPage().clickOnForgotPwdLink();
		driverInstance.getForgotPasswordPage().enterUsername("Admin");
		driverInstance.getForgotPasswordPage().clickCancel();
		boolean act = driverInstance.getLoginPage().isForgotPwdLinkDisplayed();
		driverInstance.getTestBase().attachScreenshot();
		Assert.assertEquals(act, true);
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

