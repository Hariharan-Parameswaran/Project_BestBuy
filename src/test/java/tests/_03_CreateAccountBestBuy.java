package tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CreateAccount;
import pages.HomePage;
import pages.LocationPage;

public class _03_CreateAccountBestBuy {

	WebDriver driver;

	@BeforeClass
	public void before() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.bestbuy.com/");
	}

	@Test(priority = 3)
	public void createAccount() {
		try {
			LocationPage lPage = new LocationPage(driver);
			lPage.clickOnUSA();

			HomePage hPage = new HomePage(driver);
			hPage.goToCreateAccount();

			CreateAccount caPage = new CreateAccount(driver);
			caPage.createTheAccount("Hari", "Parames", "hariparames@gmail.com", "harifz_1998", "harifz_1998",
					"8760036978");

			// Take screenshot after creating the account
			takeScreenshot("CreateAccountBestBuy");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenshot("ErrorDuringAccountCreation");
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
