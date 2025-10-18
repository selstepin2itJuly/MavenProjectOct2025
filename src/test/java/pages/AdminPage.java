package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtility.Common;

public class AdminPage extends Common {

	private static final Logger logger = LogManager.getLogger(AdminPage.class);
	private WebDriver driver;

	/**
	 * Constructor to initialize AdminPage elements
	 * 
	 * @param driver WebDriver instance
	 */
	public AdminPage(WebDriver driver) {
		logger.info("Initializing AdminPage elements");
		this.driver = driver;
		PageFactory.initElements(driver, this); // initialization of page elements
	}

	// page locators
	@FindBy(xpath = "//li[contains(@class,'--parent --visited')]")
	private WebElement adminUserManagement;

	@FindBy(xpath = "//label[text()='User Role']/parent::*/parent::*/descendant::div[@class='oxd-select-text-input']")
	private WebElement userRoleDropdown;

	@FindBy(css = "button[type='submit']")
	private WebElement searchButton;

	// page actions
	/**
	 * verify Admin User Management is displayed
	 * 
	 * @return boolean
	 */
	public boolean isAdminUserManagementDisplayed() {
		logger.info("Checking if Admin User Management is displayed");
		boolean flag = false;
		try {
			waitForElementToBeVisible(adminUserManagement);
			flag = adminUserManagement.isDisplayed();
			logger.info("Admin User Management displayed: " + flag);
		} catch (Exception e) {
			e.getMessage();
			logger.info("Exception occurred while checking Admin User Management display: " + e.getMessage());
		}
		return flag;
	}

	/**
	 * Select user role from dropdown
	 * 
	 * @param role String
	 */
	
	public void selectUserRoleFromDropdown(String role) {
		// code to select user role from dropdown
		logger.info("Selecting user role from dropdown: " + role);
		//userRoleDropdown.click();
		/*waitForElementToBeVisible(driver.findElement(
				By.xpath("//div[@role='listbox']/descendant::*[text()='" + role + "']")));
		clickOnElementUsingJS(driver.findElement(
				By.xpath("//div[@role='listbox']/descendant::*[text()='" + role + "']")));
				*/
		new Actions(driver).sendKeys(userRoleDropdown, Keys.ARROW_DOWN).build().perform();
	}

	/**
	 * Click on Search button
	 */
	public void clickSearchButton() {
		logger.info("Clicking on Search button");
		searchButton.click();
	}
	
	/**
	 * Validate if records with given username are displayed
	 * 
	 * @param username String
	 * @return boolean
	 */

	public boolean validateRecordsUsernameDisplayed(String username) {

		logger.info("Validating if records with username: " + username + " are displayed");
		boolean flag = false;
		try {
			waitForElementToBeVisible(
			driver
			.findElement(By.xpath("//div[text()='Username']/ancestor::div[@role='table']/descendant::*[text()='"
					+ username + "'][1]")));
			flag = driver
					.findElement(By.xpath("//div[text()='Username']/ancestor::div[@role='table']/descendant::*[text()='"
							+ username + "'][1]")).isDisplayed();
			logger.info("Records with username " + username + " displayed: " + flag);
		} catch (Exception e) {
			e.getMessage();
			logger.error(
					"Exception occurred while validating records with username " + username + ": " + e.getMessage());
		}
		return flag;
	}

	/**
	 * Validate if records with given user role are displayed
	 * 
	 * @param userRole String
	 * @return boolean
	 */
	public boolean validateRecordsUserRoleDisplayed(String userRole) {

		logger.info("Validating if records with username: " + userRole + " are displayed");
		boolean flag = false;
		try {
			flag = driver.findElement(
					By.xpath("//div[text()='User Role']/ancestor::div[@role='table']/descendant::*[text()='" + userRole
							+ "'][2]"))
					.isDisplayed();
			logger.info("Records with username " + userRole + " displayed: " + flag);
		} catch (Exception e) {
			e.getMessage();
			logger.error(
					"Exception occurred while validating records with username " + userRole + ": " + e.getMessage());
		}
		return flag;
	}

	/**
	 * Validate if records with given user status are displayed
	 * 
	 * @param userStatus String
	 * @return boolean
	 */
	public boolean validateRecordsStatusDisplayed(String userStatus) {

		logger.info("Validating if records with username: " + userStatus + " are displayed");
		boolean flag = false;
		try {
			flag = driver.findElement(By.xpath(
					"//div[text()='Status']/ancestor::div[@role='table']/descendant::*[text()='" + userStatus + "']"))
					.isDisplayed();
			logger.info("Records with username " + userStatus + " displayed: " + flag);
		} catch (Exception e) {
			e.getMessage();
			logger.error(
					"Exception occurred while validating records with username " + userStatus + ": " + e.getMessage());
		}
		return flag;
	}

}
