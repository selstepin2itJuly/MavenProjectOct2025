package commonUtility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import testcases.LoginTest;

public class Common {
	private static final Logger logger = LogManager.getLogger(Common.class);
	private WebDriver driver;
	
	/**
	 * Set WebDriver instance
	 * @param dr WebDriver instance
	 */
	public void setDriver(WebDriver dr) {
		logger.info("Setting WebDriver instance in Common class");
		this.driver=dr;
	}
	
	//common methods
	
	/***
	 * scroll to element using javascript executor
	 * @param ele
	 */
	
	public void scrollToElement(WebElement ele) {
		logger.info("Scrolling to element using JavaScript Executor");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false);", ele);
		js.executeScript("window.scrollBy(0,400)");
	}
	

	/**
	 * click on element using javascript executor
	 * @param ele
	 */
	public void clickOnElementUsingJS(WebElement ele) {
		logger.info("Clicking on element using JavaScript Executor");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ele);
	}
	
	/**
	 * scroll to element using actions class
	 * @param ele
	 */
	public void scrollToElementUsingActions(WebElement ele) {
		logger.info("Scrolling to element using Actions class");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Actions actions = new Actions(driver);
		actions.scrollToElement(ele).perform();
		js.executeScript("window.scrollBy(0,400)");
	}
	
	public void captureScreenshot(String fileName) throws IOException {
		String folderName = "Screenshots";
		//fileName = "test.png";
		TakesScreenshot ts = (TakesScreenshot)driver;
		File srcfb = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcfb, new File(screenshotFolder(folderName)+"/"+getTimestamp()+"_"+fileName+".png"));
	}
	
	public void attachScreenshot() throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		String src = ts.getScreenshotAs(OutputType.BASE64);
		String image ="<img src=\"data:image/png;base64,"+src+"\" height=\"600\" width=\"900\" />";
		Reporter.log(image);
	}
	private static String screenshotFolder(String s) {
		logger.info("Creating screenshot folder if not exists: " + s);
		File dir = new File(s);
		if (!dir.isDirectory())
		{
			dir.mkdirs();
		}else {
			System.out.println("Directory already present");
		}
		return s;
	}
	
	public void waitForElementToBeVisible(WebElement ele) {
		logger.info("Waiting for element to be visible for up to 20 seconds");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	//Method to get current timestamp
	private static String getTimestamp() {
		logger.info("Generating current timestamp");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-SSS");
		String fDate = sdf.format(date);
		//System.out.println(fDate);
		return fDate;
	}
	
}
