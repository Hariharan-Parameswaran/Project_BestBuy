package tests;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
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

public class _02_ValiDateUrl {

	WebDriver driver;

	@BeforeClass
	public void before() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.bestbuy.com/");
	}
	
	@Test(priority = 2)
	public void validateURL() {
		String url = "https://www.bestbuy.com/";
		try {
			takeScreenshot("validateURL");
			URL link = new URL(url);
			HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
			httpConn.setRequestMethod("HEAD");
			httpConn.setConnectTimeout(5000);
			httpConn.connect();
			int responseCode = httpConn.getResponseCode();

			Assert.assertEquals(responseCode, HttpURLConnection.HTTP_OK,
					"The link is broken. Response Code: " + responseCode);
			System.out.println("The link is valid. Response Code: " + responseCode);

		} catch (IOException e) {
			Assert.fail("An error occurred while connecting to the URL: " + e.getMessage());
		}

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
