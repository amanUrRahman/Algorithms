package setupTeardown;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import fileUtils.FileUtils;
import generalUtil.BrowserWindowUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SetupTeardownForGoogleTests {

	protected static WebDriver driver = null;
	protected JavascriptExecutor jsExecutor = null;
	public FileUtils fileUtils = null;
	public FileUtils log4JPropertyFileLocation = null;
	public BrowserWindowUtil browserUtil = null;
	public String browser = null;
	public String url = null;
	public Boolean cloudTesting = null;
	public DesiredCapabilities caps = null;
	public static final String USERNAME = "amanrahman1";
	public static final String AUTOMATE_KEY = "vAPbdqyMWX4ybXeGeJzz";
	public static final String CloudURL = "https://" + USERNAME + ":" + AUTOMATE_KEY
			+ "@hub-cloud.browserstack.com/wd/hub";
	private static Logger Log = LogManager.getLogger(SetupTeardownForGoogleTests.class);
	private static LoggerContext context = (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);

	@BeforeSuite
	public void Setup() throws IOException {
		context.setConfigLocation(new File("src/test/resources/files/log4j2.xml").toURI());
		Log.info("**********Before Suite has initiated**********");
		fileUtils = new FileUtils("src/test/resources/files/config.properties");
//		log4JPropertyFileLocation = new FileUtils("D:/Personal Codebase/algorithm/Algorithms/TestNGWithSelenium/src/test/resources/files/log4j2.properties");
//		PropertyConfigurator.configure(p);

		browser = fileUtils.getSelectedBrowser();
		if (fileUtils.getcloudTesting())
			cloudTesting = true;
		else
			cloudTesting = false;
		Log.info("**********Before Suite has completed**********");
	}

	@BeforeTest
	public void SetupForEachTest() throws IOException {
		Log.info("**********Before Test is executing**********");
		if (cloudTesting.equals(true)) {
			Log.info("Setting capabilities for Cloud testing");
			caps = new DesiredCapabilities();
			caps.setCapability("browser", fileUtils.getcloudParameters().get("browser"));
			caps.setCapability("browser_version", fileUtils.getcloudParameters().get("browser_version"));
			caps.setCapability("os", fileUtils.getcloudParameters().get("os"));
			caps.setCapability("os_version", fileUtils.getcloudParameters().get("os_version"));
			caps.setCapability("resolution", fileUtils.getcloudParameters().get("resolution"));
			// caps.setCapability("name", "Sample Demo Test");
		} else if (cloudTesting.equals(false)) {
			Log.info("Setting capabilities for local execution");
			if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			}
		}
		jsExecutor = (JavascriptExecutor) driver;
		browserUtil = new BrowserWindowUtil(driver);
		Log.info("**********Before Test has completed**********");
	}

	@BeforeMethod
	public void SetupForEachMethod() throws IOException {
		Log.info("**********Before Method is executing**********");
		if (cloudTesting.equals(true)) {
			Log.info("Initiating driver and opening the specified url in cloud");
			driver = new RemoteWebDriver(new URL(CloudURL), caps);
			driver.get("http://www.google.com");
		} else if (cloudTesting.equals(false)) {
			Log.info("Initiating driver and opening the specified url in local machine");
			driver.get(fileUtils.getSelectedUrl());
			browserUtil.MaximizeBrowserWindow();
		}
		Log.info("**********Before Method has completed**********");
	}

	@AfterSuite
	public void Teardown() {
		Log.info("**********After Suite is executing**********");
		driver.close();
		driver.quit();
		Log.info("Closed all instances fo browsers");
		Log.info("**********After Suite has completed**********");

	}

}
