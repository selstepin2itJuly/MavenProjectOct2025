package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
	private static final Logger logger = LogManager.getLogger(ForgotPasswordPage.class);
	private WebDriver driver;
	/**
	 * Constructor to initialize ForgotPasswordPage elements
	 * @param driver WebDriver instance
	 */
	public ForgotPasswordPage(WebDriver driver) {
		logger.info("Initializing ForgotPasswordPage elements");
		this.driver = driver;
		PageFactory.initElements(driver, this); //initialization of page elements
	}
	
	//page locators
	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(css="[type='button']")
	private WebElement cancelBtn;
	
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
	 * Click on Cancel button
	 */
	public void clickCancel() {
		logger.info("Clicking on Cancel button");
		cancelBtn.click();
	}
}

