package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	@FindBy(xpath = "//img[@alt='Microsoft - Surface Laptop - Copilot+ PC - 13.8\" Touch-Screen - Snapdragon X Plus - 16GB Memory - 512GB SSD (7th Edition) - Dune']")
	WebElement laptopProduct;

	@FindBy(xpath = "//button[@class='c-button c-button-primary c-button-lg c-button-block c-button-icon c-button-icon-leading add-to-cart-button ']")
	WebElement addCart;

	@FindBy(xpath = "//a[text()='Go to Cart']")
	WebElement goToCart;

	@FindBy(xpath = "//img[@alt='Samsung - Galaxy Book4 15.6\" FHD Laptop - Intel Core 7- 16GB Memory - 512GB SSD - Silver']")
	WebElement sumsProduct;

	@FindBy(xpath = "//img[@alt='Sony - 65\" Class BRAVIA XR A80L OLED 4K UHD Smart Google TV (2023)']")
	WebElement sonyTV;

	@FindBy(xpath = "//a[@role='button'][normalize-space()='iPhone']")
	WebElement iphoneBrand;

	@FindBy(xpath = "//a[text()='iPhone 16 Pro Max']")
	WebElement iphone16Max;

	@FindBy(xpath = "//a[@role='button'][normalize-space()='AirPods']")
	WebElement airPodsProduct;

	@FindBy(xpath = "//a[text() =  'AirPods Max']")
	WebElement airpodsMax;

	WebDriver driver;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void addToItems() {
		laptopProduct.click();
		addCart.click();
		goToCart.click();
	}

	public void addTvItems() {
		sonyTV.click();
		addCart.click();
		goToCart.click();
	}

	public void addBrandItem() throws InterruptedException {

		airPodsProduct.click();
		airpodsMax.click();
		addCart.click();
		goToCart.click();
	}
}
