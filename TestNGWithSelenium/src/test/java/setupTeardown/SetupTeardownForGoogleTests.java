package setupTeardown;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

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

	@BeforeSuite
	public void Setup() throws IOException {

		fileUtils = new FileUtils(
				"D:/Personal Codebase/algorithm/Algorithms/TestNGWithSelenium/src/test/resources/files/config.properties");
		browser = fileUtils.getSelectedBrowser();
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

		jsExecutor = (JavascriptExecutor) driver;
		browserUtil = new BrowserWindowUtil(driver);
		browserUtil.MaximizeBrowserWindow();
		driver.get(fileUtils.getSelectedUrl());

	}

	@AfterSuite
	public void Teardown() {
		driver.close();
		driver.quit();

	}

}
