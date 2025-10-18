package testbase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import commonUtility.Common;
import testcases.LoginTest;

public class TestBase extends Common{
	private static final Logger logger = LogManager.getLogger(TestBase.class);
	private WebDriver driver ;
	private String browser;
	private String cnfigFilePath=System.getProperty("user.dir")+"/src/test/resources/config/config.properties";
	private Properties prop;
	private String url;
	private String paralleEnable;
	private String parallelBrowser;
	/**
	 * Initialize WebDriver based on configuration
	 * @return WebDriver instance
	 * @throws IOException
	 */
	public WebDriver initializeDriver() throws IOException {
		logger.info("Initializing WebDriver");
		prop=new Properties();
		FileInputStream buffer = new FileInputStream(cnfigFilePath);
		prop.load(buffer); // config.properties file loaded
		browser = prop.getProperty("browser");
		url = prop.getProperty("url");
		paralleEnable = prop.getProperty("parallel");
		parallelBrowser = prop.getProperty("parallel.browsers");
		
		if(browser==null) {
			browser=System.getProperty("browser");
			if(browser==null) {
				browser="chrome";
			}
		}
		if(browser.equalsIgnoreCase("chrome")) 
		{
				ChromeOptions options = new ChromeOptions();
				//options.addArguments("--start-fullscreen");
				options.addArguments("--start-maximized");		
				driver= new ChromeDriver(options);
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			//options.addArguments("--start-fullscreen");
			options.addArguments("--start-maximized");		
			driver= new FirefoxDriver(options);
		} else if(browser.equalsIgnoreCase("edge")) {
			EdgeOptions options = new EdgeOptions();
			//options.addArguments("--start-fullscreen");
			options.addArguments("--start-maximized");		
			driver= new EdgeDriver(options);
		}
		else if(browser.equalsIgnoreCase("safari")) {
			SafariOptions options = new SafariOptions();
			//options.addArguments("--start-fullscreen");
			options.setCapability("start-maximized", true);	
			driver= new SafariDriver(options);
		}
			//driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		return driver;
	}
}
