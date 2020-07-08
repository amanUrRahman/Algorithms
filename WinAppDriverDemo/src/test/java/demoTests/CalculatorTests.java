package demoTests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;

public class CalculatorTests {

	public static WindowsDriver driver = null;

	@BeforeMethod
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
		caps.setCapability("platformName", "Windows");
		caps.setCapability("deviceName", "WindowsPC");
		driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), caps);
	}

	@AfterMethod
	public void shutDown() {
		driver.quit();
	}

	@Test
	public void checkMultiply() throws InterruptedException {
		driver.findElementByAccessibilityId("num2Button").click();
		driver.findElementByAccessibilityId("multiplyButton").click();
		driver.findElementByAccessibilityId("num3Button").click();
		driver.findElementByAccessibilityId("equalButton").click();
		int actualResult = Integer
				.valueOf(driver.findElementByAccessibilityId("CalculatorResults").getAttribute("Name").split(" ")[2]);
		Assert.assertEquals(actualResult, 6);
	}

	@Test
	public void checkSwap() throws InterruptedException {
		driver.findElementByAccessibilityId("TogglePaneButton").click();
		if (Boolean.valueOf(driver.findElementByAccessibilityId("Standard").getAttribute("SelectionItem.IsSelected"))) {
			driver.findElementByAccessibilityId("Scientific").click();
			Assert.assertEquals(driver.findElementByAccessibilityId("Header").getAttribute("Name").split(" ")[0], "Scientific");
		} else {
			driver.findElementByAccessibilityId("Standard").click();
			Assert.assertEquals(driver.findElementByAccessibilityId("Header").getAttribute("Name").split(" ")[0], "Standard");
		}

	}
}
