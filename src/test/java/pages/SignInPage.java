package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

	@FindBy(id = "fld-e")
	WebElement emailAddress;

	@FindBy(id = "fld-p1")
	WebElement password;

	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signInButton;

	WebDriver driver;

	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void signInDetail(String email, String passwd) {
		emailAddress.sendKeys(email);
		password.sendKeys(passwd);
		signInButton.click();
	}
}
