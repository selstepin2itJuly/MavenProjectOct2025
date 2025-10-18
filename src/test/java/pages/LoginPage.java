package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testcases.LoginTest;

public class LoginPage {
	private static final Logger logger = LogManager.getLogger(LoginPage.class);
	private WebDriver driver;
	/**
	 * Constructor to initialize LoginPage elements
	 * @param driver WebDriver instance
	 */
	public LoginPage(WebDriver driver) {
		logger.info("Initializing LoginPage elements");
		this.driver = driver;
		PageFactory.initElements(driver, this); //initialization of page elements
	}
	
	//page locators
	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(css="[type='submit']")
	private WebElement loginBtn;
	
	@FindBy(css="[class*='orangehrm-login-forgot-header']")
	private WebElement forgotPwdLink;
	
	//page actions
	/**
	 * Enter username in username field
	 * @param uname String
	 */
	public void enterUsername(String uname) {
		logger.info("Entering username: " + uname);
		username.sendKeys(uname);
	}
	
	/**
	 * Enter password in password field
	 * @param pwd String
	 */
	public void enterPassword(String pwd) {
		logger.info("Entering password");
		password.sendKeys(pwd);
	}
	
	/**
	 * Click on login button
	 */
	public void clickLogin() {
		logger.info("Clicking on login button");
		loginBtn.click();
	}
	
	/**
	 * Login to application with given username and password
	 * @param uname String
	 * @param pwd String
	 */
	public void loginToApplication(String uname, String pwd) {
		logger.info("Logging into application with username: " + uname);
		this.enterUsername(uname);
		this.enterPassword(pwd);
		this.clickLogin();
	}
	
	/**
	 * Click on Forgot Password link
	 */
	public void clickOnForgotPwdLink() {
		logger.info("Clicking on Forgot Password link");
		forgotPwdLink.click();
	}
	
	/**
	 * Verify if Forgot Password link is displayed
	 * @return boolean
	 */
	public boolean isForgotPwdLinkDisplayed() {
		logger.info("Checking if Forgot Password link is displayed");
		boolean flag = false;
		try {
			flag = forgotPwdLink.isDisplayed();
		}catch(Exception e) {
			e.getMessage();
			flag = false;
		}
		return flag;
	}
}
