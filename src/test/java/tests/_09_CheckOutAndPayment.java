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

import pages.CartPage;
import pages.CheckOutPage;
import pages.HomePage;
import pages.LocationPage;
import pages.ProductPage;

public class _09_CheckOutAndPayment {

	WebDriver driver;

	@BeforeClass
	public void before() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.bestbuy.com/");
	}

	@Test(priority = 10)
	public void checkOut() throws InterruptedException {
		LocationPage lPage = new LocationPage(driver);
		lPage.clickOnUSA();

		HomePage hPage = new HomePage(driver);
		hPage.selectBrand();

		ProductPage pPage = new ProductPage(driver);
		pPage.addBrandItem();

		CartPage cPage = new CartPage(driver);
		cPage.checkOutPage();

		CheckOutPage coPage = new CheckOutPage(driver);
		coPage.guestDetail("hariparames@gmail.com", "475 896 5874");
		takeScreenshot("CheckOutAndPayment");

		coPage.paymentDetail("4111111111111111", "12/25", "123", "hari", "P", "123 Main St", "San Francisco", "CA",
				"94105");
		takeScreenshot("CheckOutAndPayment1");

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
