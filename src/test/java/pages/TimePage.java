package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TimePage {

	private static final Logger logger = LogManager.getLogger(TimePage.class);
	private WebDriver driver;

	/**
	 * Constructor to initialize TimePage elements
	 * @param driver WebDriver instance
	 */

	public TimePage(WebDriver driver) {
		logger.info("Initializing TimePage elements");
		this.driver = driver;
		PageFactory.initElements(driver, this); // initialization of page elements
	}
	
	// page locators
	
	// page actions
}
