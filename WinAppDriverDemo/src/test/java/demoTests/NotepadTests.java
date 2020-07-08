package demoTests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class NotepadTests {

	public static WindowsDriver driver = null;

	@BeforeMethod
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("app", "C:\\Windows\\notepad.exe");
		//caps.setCapability("appArguments", "file name"); //to specify personal file
		//caps.setCapability("appWorkingDir", "location of file on disk"); //to specify file location
		caps.setCapability("platformName", "Windows");
		caps.setCapability("deviceName", "WindowsPC");
		driver = new WindowsDriver(new URL("http://127.0.0.1:4723/"), caps);
	}

	@AfterMethod
	public void shutDown() {
		driver.quit();
	}
	
	@Test(priority=2)
	public void checkVersion() throws InterruptedException {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.chord(Keys.ALT + "h")).build().perform();
		action.sendKeys("a").build().perform();
		String version = driver.findElementByAccessibilityId("13579").getAttribute("Name");
		System.out.println("The version of the notepad application is: " + version);
		driver.findElementByAccessibilityId("1").click();
	}
	
	@Test(priority=1)
	public void sendText() {
		driver.findElementByAccessibilityId("15").sendKeys("This is just for a demo");
		driver.findElementByAccessibilityId("15").clear();
	}
	
	

}
