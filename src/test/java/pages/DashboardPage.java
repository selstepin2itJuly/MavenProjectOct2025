package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testcases.LoginTest;

public class DashboardPage {
	private static final Logger logger = LogManager.getLogger(DashboardPage.class);
	private WebDriver driver;
	/**
	 * Constructor to initialize DashboardPage elements
	 * @param driver WebDriver instance
	 */
	public DashboardPage(WebDriver driver) {
		logger.info("Initializing DashboardPage elements");
		this.driver = driver;
		PageFactory.initElements(driver, this); //initialization of page elements
	}
	
	//page locators
	@FindBy(xpath="//h6[text()='Dashboard']")
	private WebElement dashboardHeader;
	
	@FindBy(xpath="//*[@class='oxd-userdropdown-name']")
	private WebElement userDropdown;
	
	@FindBy(linkText="Logout")
	private WebElement logoutLink;
	
	@FindBy(xpath="//span[text()='My Info']")
	private WebElement myInfoOption;
	
	@FindBy(xpath="//span[text()='Admin']")
	private WebElement adminOption;
	
	//page actions
	/**
	 * get dashboard header text
	 * @return String
	 */
	public String getDashboardHeaderText() {
		return dashboardHeader.getText();
	}
	
	/**
	 * verify dashboard header is displayed
	 * @return boolean
	 */
	public boolean isDashboardHeaderDisplayed() {
		logger.info("Checking if dashboard header is displayed");
		boolean flag = false;
		try {
			flag = dashboardHeader.isDisplayed();
		}catch(Exception e) {
			e.getMessage();
			flag = false;
		}
		return flag;
	}
	
	/**
	 * logout from application
	 */
	public void logoutFromApplication() {
		logger.info("Logging out from application");
		userDropdown.click();
		logoutLink.click();
	}
	
	/**
	 * Click on My Info option
	 */
	public void clickOnMyInfoOption() {
		logger.info("Clicking on My Info option");
		myInfoOption.click();
	}
	/**
	 * Click on Admin option
	 */
	public void clickOnAdminOption() {
		logger.info("Clicking on Admin option");
		adminOption.click();
	}
}