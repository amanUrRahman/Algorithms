package setupTeardown;

import java.io.IOException;
import java.net.URL;
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
	public BrowserWindowUtil browserUtil = null;
	public String browser = null;
	public String url = null;
	public Boolean cloudTesting = null;
	public DesiredCapabilities caps = null;
	public static final String USERNAME = "amanrahman1";
	public static final String AUTOMATE_KEY = "vAPbdqyMWX4ybXeGeJzz";
	public static final String CloudURL = "https://" + USERNAME + ":" + AUTOMATE_KEY
			+ "@hub-cloud.browserstack.com/wd/hub";

	@BeforeSuite
	public void Setup() throws IOException {
		fileUtils = new FileUtils(
				"D:/Personal Codebase/algorithm/Algorithms/TestNGWithSelenium/src/test/resources/files/config.properties");
		browser = fileUtils.getSelectedBrowser();
		jsExecutor = (JavascriptExecutor) driver;
		browserUtil = new BrowserWindowUtil(driver);
		if (fileUtils.getcloudTesting())
			cloudTesting = true;
		else
			cloudTesting = false;
	}

	@BeforeTest
	public void SetupForEachTest() throws IOException {
		if (cloudTesting.equals(true)) {
			caps = new DesiredCapabilities();
			caps.setCapability("browser", fileUtils.getcloudParameters().get("browser"));
			caps.setCapability("browser_version", fileUtils.getcloudParameters().get("browser_version"));
			caps.setCapability("os", fileUtils.getcloudParameters().get("os"));
			caps.setCapability("os_version", fileUtils.getcloudParameters().get("os_version"));
			caps.setCapability("resolution", fileUtils.getcloudParameters().get("resolution"));
			//caps.setCapability("name", "Sample Demo Test");
		} else if (cloudTesting.equals(false)) {
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
	}

	@BeforeMethod
	public void SetupForEachMethod() throws IOException {
		if (cloudTesting.equals(true)) {
			driver = new RemoteWebDriver(new URL(CloudURL), caps);
			driver.get("http://www.google.com");
		} else if (cloudTesting.equals(false)) {
			driver.get(fileUtils.getSelectedUrl());
			browserUtil.MaximizeBrowserWindow();
		}
	}

	@AfterSuite
	public void Teardown() {
		driver.close();
		driver.quit();

	}

}
