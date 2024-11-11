package tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LocationPage;

public class _04_NavigateAllMenu {

	WebDriver driver;

	@BeforeClass
	public void before() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.bestbuy.com/");
	}

	@Test(priority = 5)
	public void testMenuNavigation() {
		LocationPage lPage = new LocationPage(driver);
		lPage.clickOnUSA();

		HomePage hPage = new HomePage(driver);
		String[] menuItems = hPage.getMenuItems();

		for (String menuItem : menuItems) {
			String pageTitle = hPage.menuValidation(menuItem);
			System.out.println(pageTitle);
			try {
				Assert.assertTrue(pageTitle.contains(menuItem), "Validation failed for menu: " + menuItem);
				System.out.println(menuItem);
				takeScreenshot("NavigateAllMenu");
			} catch (Exception e) {
				takeScreenshot("NavigateAllMenuFail");
				throw e; 
			}
		}
	}

	public void takeScreenshot(String fileName) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("screenshots/" + fileName + ".png");
		try {
			FileUtils.copyFile(srcFile, destFile);
			System.out.println("Screenshot saved: " + destFile.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterC() {
		driver.quit();
	}
}
