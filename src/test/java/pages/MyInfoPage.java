package pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyInfoPage {

	private static final Logger logger = LogManager.getLogger(MyInfoPage.class);
	private WebDriver driver;
	/**
	 * Constructor to initialize MyInfoPage elements
	 * @param driver WebDriver instance
	 */
	public MyInfoPage(WebDriver driver) {
		logger.info("Initializing MyInfoPage elements");
		this.driver = driver;
		PageFactory.initElements(driver, this); //initialization of page elements
	}
	
	//page locators
	
	@FindBy(css="div[class='orangehrm-tabs']>div>a")
	private List<WebElement> myInfoTabs;
	
	//page actions
	/**
	 * Get count of My Info tabs
	 * @return int
	 */
	public int getMyInfoTabsCount() {
		logger.info("Getting count of My Info tabs");
		return myInfoTabs.size();
	}
	
	public List<String> getMyInfoMenuItemText() {
		logger.info("Getting My Info menu item texts");
		List<String> temp = new ArrayList<String>();
		for(WebElement tab : myInfoTabs) {
			logger.info("Tab Text: " + tab.getText());
			temp.add(tab.getText().stripIndent().stripLeading().stripTrailing());
		}
		return temp;
		//return myInfoTabs.stream().map(tab -> tab.getText()).toList();
	}
}
