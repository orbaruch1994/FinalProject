package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends BasePage{
	@FindBy(css="[name='quantity']")
	private WebElement quantityField;
	@FindBy(css="li>.cart")
	private WebElement addToCartBtn;
	@FindBy(css=".bgnone")
	private WebElement prodLabel;
	
	public ItemPage(WebDriver driver) {
		super(driver);
	}

	public void changeQuantity(String q) {
		fillText(quantityField, q);
	}
	
	public void addToCart() {
		click(addToCartBtn);
	}
	
	// Validation
	public String productName() {
		return getText(prodLabel);
	}
	
}
