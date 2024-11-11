package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccount {

	@FindBy(id = "firstName") WebElement firstName ;
	
	@FindBy(id = "lastName") WebElement lastName ;
	
	@FindBy(id = "email") WebElement email ;
	
	@FindBy(id = "fld-p1") WebElement password ;
	
	@FindBy(id = "reenterPassword") WebElement reenterPassword ;
	
	@FindBy(id = "phone") WebElement phone ;
	
	@FindBy(id = "is-recovery-phone") WebElement recoveryAccount ;
	
	@FindBy(xpath = "//button[text()='Create an Account']") WebElement createAnAccount ;
	
	
	WebDriver driver;
	public CreateAccount(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void createTheAccount(String fName,String lName,String Email,String passwd,String confirmPasswd,String mobileNo) {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		email.sendKeys(Email);
		password.sendKeys(passwd);
		reenterPassword.sendKeys(confirmPasswd);
		phone.sendKeys(mobileNo);
		recoveryAccount.click();
		createAnAccount.click();
		
	}
}
