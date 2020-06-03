/*
Author: Aman Ur Rahman
Program: GoogleTests
Description:
This class consists of all the individual tests that are applied to Google Search Results
*/
package testScripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import setupTeardown.SetupTeardownForGoogleTests;

public class GoogleTests extends SetupTeardownForGoogleTests {

	@Test
	public void PopularityCheck() {
		driver.findElement(By.xpath("//input[@name='q']")).clear();
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Aman ur rahman14343");
		jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//input[@type='submit']")));
		if (driver.findElements(By.xpath("//div[@id='result-stats']")).size() > 0) {
			Long SearchResults = Long.valueOf(driver.findElement(By.xpath("//div[@id='result-stats']")).getText().split("results")[0]
					.split(" ")[1].replace(",", ""));
			if (SearchResults > 1000000) {
				System.out.println("The input is famous and has many over a million results");
			} else {
				System.out.println("The input is not that famous and has few search results");
			}

		} else
			System.out.println("The element is not present on the screen");

	}

}