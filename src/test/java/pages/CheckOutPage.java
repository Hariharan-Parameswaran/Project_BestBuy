package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

	@FindBy(xpath = "//input[@id='fld-e']")
	WebElement emailData;

	@FindBy(xpath = "//input[@id='fld-p1']")
	WebElement pswdData;

	@FindBy(xpath = "//button[text() ='Sign In']")
	WebElement signInButton;

	@FindBy(xpath = "//input[@id='user.emailAddress']")
	WebElement emailAddress;

	@FindBy(xpath = "//input[@id='user.phone']")
	WebElement mobileNumber;

	@FindBy(xpath = "//button[text() ='Continue as Guest']")
	WebElement guestButton;

	@FindBy(xpath = "//input[@id='text-updates']")
	WebElement checkText;

	@FindBy(xpath = "//span[text()='Continue to Payment Information']")
	WebElement paymentCountinue;

	@FindBy(xpath = "//input[@id='cc-number']")
	WebElement cardNumber;

	@FindBy(xpath = "//input[@id='expirationDate']")
	WebElement expriedDate;

	@FindBy(xpath = "//input[@id='first-name']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='last-name']")
	WebElement lastName;

	@FindBy(xpath = "//input[@id='address-input']")
	WebElement address;

	@FindBy(xpath = "//input[@id='cvv']")
	WebElement securityCode;

	@FindBy(xpath = "//input[@id='city']")
	WebElement city;

	@FindBy(xpath = "//select[@id='state']")
	WebElement state;

	@FindBy(xpath = "//input[@id='postalCode']")
	WebElement postalCode;

	@FindBy(xpath = "//span[text()='Place Your Order']")
	WebElement placeOrder;

	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void signInDetail(String email, String pswd) {
		emailData.sendKeys(email);
		pswdData.sendKeys(pswd);
		signInButton.click();
	}

	public void guestDetail(String emAddress, String phNumber) {
		guestButton.click();
		emailAddress.sendKeys(emAddress);
		mobileNumber.sendKeys(phNumber);
		checkText.click();
		paymentCountinue.click();
	}

	public void paymentDetail(String Cnumber, String exDate, String scode, String fname, String lname, String addetail,
			String citysel, String stateSel, String posCode) {
		cardNumber.sendKeys(Cnumber);
		expriedDate.sendKeys(exDate);
		securityCode.sendKeys(scode);
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		address.sendKeys(addetail);
		city.sendKeys(citysel);
		state.sendKeys(stateSel);
		postalCode.sendKeys(posCode);
		placeOrder.click();
	}
}
