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

public class _01_NavigateToBestBuy {

	WebDriver driver;

	@BeforeClass
	public void before() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.bestbuy.com/");
	}
	
	@Test(priority = 1)
	public void navigateToBestBuy() {
		takeScreenshot("navigateToBestBuy");
		String expectedTitle = "Best Buy International: Select your Country - Best Buy";
		String actualTtile = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTtile);
	}
	
	public void takeScreenshot(String fileName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File("./screenshots/" + fileName + ".png"));
            System.out.println("Screenshot taken: " + fileName);
        } catch (IOException e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
        }
    }
	
	@AfterClass
	public void afterC() {
		driver.quit();
	}
	
}
