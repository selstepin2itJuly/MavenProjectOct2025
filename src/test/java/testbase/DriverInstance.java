package testbase;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pages.AdminPage;
import pages.DashboardPage;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.MyInfoPage;

public class DriverInstance {
	private static final Logger logger = LogManager.getLogger(DriverInstance.class);
	private TestBase testbase;
	private WebDriver driver;
	//Constructor
	/**
	 * Constructor to create DriverInstance and initialize WebDriver
	 * @throws IOException
	 */
	public DriverInstance() throws IOException{
		logger.info("Creating DriverInstance and initializing WebDriver");
		testbase = new TestBase();
		driver= testbase.initializeDriver();
		testbase.setDriver(driver);
		
	}
	
	/**
	 * Get a new DriverInstance
	 * @return DriverInstance
	 * @throws IOException
	 */
	public DriverInstance getDriverInstance() throws IOException{
		logger.info("Getting new DriverInstance");
		return new DriverInstance();
	}
	/**
	 * Get the WebDriver instance
	 * @return WebDriver
	 */
	public WebDriver getDriver() {
		logger.info("Getting WebDriver instance");
		return this.driver;
	}
	
	/**
	 * Get the TestBase instance
	 * @return TestBase
	 */
	public TestBase getTestBase() {
		logger.info("Getting TestBase instance");
		return this.testbase;
	}
	
	/**
	 * Get the LoginPage instance
	 * @return LoginPage
	 */
	public LoginPage getLoginPage() {
		logger.info("Getting LoginPage instance");
		return new LoginPage(this.driver);
	}
	
	/**
	 * Get the DashboardPage instance
	 * @return DashboardPage
	 */
	public DashboardPage getDashboardPage() {
		logger.info("Getting DashboardPage instance");
		return new DashboardPage(this.driver);
	}
	
	/**
	 * Get the ForgotPasswordPage instance
	 * @return ForgotPasswordPage
	 */	
	public ForgotPasswordPage getForgotPasswordPage() {
		logger.info("Getting DashboardPage instance");
		return new ForgotPasswordPage(this.driver);
	}
	/**
	 * Get the MyInfoPage instance
	 * @return MyInfoPage
	 */
	public MyInfoPage getMyInfoPage() {
		logger.info("Getting MyInfoPage instance");
		return new MyInfoPage(this.driver);
	}
	
	public AdminPage getAdminPage() {
		logger.info("Getting AdminPage instance");
		return new AdminPage(this.driver);
	}
	/**
	 * Quit the browser and end the WebDriver session
	 */
	public void quitBrowser()
	{
		logger.info("Quitting the browser");
		this.driver.quit();
	}
	
}
