package demoTests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;

public class CalculatorTests {

	public static WindowsDriver<RemoteWebElement> driver = null;

	@BeforeMethod
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("app", "C:\\Windows\\System32\\calc.exe");
		caps.setCapability("platformName", "Windows");
		caps.setCapability("deviceName", "WindowsPC");
		driver = new WindowsDriver<RemoteWebElement>(new URL("http://127.0.0.1:4723/"), caps);
	}

	@AfterMethod
	public void shutDown() {
		driver.quit();
	}
	
	@Test
	public void checkNums() {
		Actions action = new Actions(driver);
		action.sendKeys("2").perform();
		//driver.findElementByName("Two").click();
		//driver.findElementByName("About Notepad").click();
		//driver.findElementByName("OK").click();
		//String version = driver.findElementByName("Version 1909 (OS Build 18363.904)").getAttribute("LegacyIAccessible.Name");
		//System.out.println("The version of the notepad application is: " + version);
		
	}
	
	@Test
	public void sendText() {
		driver.findElementByAccessibilityId("15").sendKeys("This is just for a demo");
		driver.findElementByAccessibilityId("15").clear();
	}
}
