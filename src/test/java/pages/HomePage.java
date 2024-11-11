package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(linkText = "Top Deals")
	WebElement topDeals;

	@FindBy(linkText = "Deal of the Day")
	WebElement dealOfTheDay;

	@FindBy(xpath = "//a[text()='Yes, Best Buy Sells That']")
	WebElement bestBuySells;

	@FindBy(xpath = "(//a[contains(@class,'bottom-left-links')][normalize-space()='My Best Buy Memberships'])[1]")
	WebElement bestBuyMemberships;

	@FindBy(xpath = "//a[text()='Credit Cards']")
	WebElement creditCardsMenu;

	@FindBy(xpath = "//a[contains(@class,'bottom-left-links')][normalize-space()='Gift Cards']")
	WebElement giftCards;

	@FindBy(linkText = "Gift Ideas")
	WebElement giftIdeas;

	@FindBy(xpath = "//span[@class='v-p-right-xxs line-clamp']")
	WebElement account;

	@FindBy(xpath = "//a[text()='Sign In']")
	WebElement signIn;

	@FindBy(xpath = "//a[text()='Create Account']")
	WebElement createAccount;

	@FindBy(id = "gh-search-input")
	WebElement searchBox;

	@FindBy(xpath = "//button[@title='submit search']")
	WebElement searchSubmit;

	@FindBy(xpath = "//span[text()='Cart']")
	WebElement cart;

	@FindBy(xpath = "//a[text()='Accessibility']")
	WebElement accessibility;
	@FindBy(xpath = "//a[text()='Terms & Conditions']")
	WebElement termsAndConditions;
	@FindBy(xpath = "//a[text()='Privacy']")
	WebElement privacy;
	@FindBy(xpath = "//a[text()='Interest-Based Ads']")
	WebElement interestBased;
	@FindBy(xpath = "//a[text()='State Privacy Rights']")
	WebElement statePrivacy;

	@FindBy(xpath = "//button[@aria-label='Menu']")
	WebElement menuButton;

	@FindBy(xpath = "//button[@data-id='node-272']")
	WebElement TVandHomeTheater;

	@FindBy(xpath = "//button[@data-id='node-220']")
	WebElement TVsbyBrand;

	@FindBy(xpath = "//a[text()='Sony TVs']")
	WebElement sonyTV;

	@FindBy(xpath = "//button[text()='Brands']")
	WebElement brandButton;

	@FindBy(xpath = "//a[text()='Apple']")
	WebElement appleBrand;

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void goToSgnIn() {
		account.click();
		signIn.click();
	}

	public void goToCreateAccount() {
		account.click();
		createAccount.click();
	}

	public String menuValidation(String menuName) {
		WebElement menu = driver.findElement(By.linkText(menuName));
		menu.click();
		return driver.getTitle();
	}

	public String[] getMenuItems() {
		return new String[] { "Top Deals", "Deal of the Day", "Yes, Best Buy Sells That", "My Best Buy Memberships",
				"Gift Cards", "Gift Ideas" };
	}

	public void bottomLink() {
		accessibility.click();
	}

	public void searchProduct(String pName) {
		searchBox.sendKeys(pName);
		searchSubmit.click();
		;
	}

	public void selectTvMenuButton() {
		menuButton.click();
		TVandHomeTheater.click();
		TVsbyBrand.click();
		sonyTV.click();
	}

	public void goToCartPage() {
		cart.click();
	}

	public void selectBrand() {
		menuButton.click();
		brandButton.click();
		appleBrand.click();
	}

}
