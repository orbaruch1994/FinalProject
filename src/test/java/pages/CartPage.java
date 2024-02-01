package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
	@FindBy(css=".pull-right.mb20>.btn.btn-orange.pull-right")
	private WebElement checkoutBtn;
	@FindBy(css=".fa.fa-arrow-right")
	private WebElement continueBtn;
	@FindBy(css=".align_left>a")
	private WebElement itemLabel;
	@FindBy(css=".input-group.input-group-sm>input")
	private WebElement quantityField;
	@FindBy(css="#cart_update")
	private WebElement updateBtn;
	@FindBy(css=".dropdown-toggle>.label.label-orange.font14")
	private WebElement quantityLabel;
	@FindBy(css=".fa.fa-trash-o.fa-fw")
	private List<WebElement> CartItemsList;
	@FindBy(css=".btn-sm")
	private WebElement deleteFromCart;
	@FindBy(css=".align_left>a")
	private WebElement itemNameLabel;
	@FindBy(css = "[title='Continue']")
	private WebElement emptyCartContinueBtn;
	
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickCheckout() {
		click(checkoutBtn);
	}

	public void countiueShopping() {
		click(continueBtn);
	}
	
	public void updateCart(String q) {
		fillText(quantityField, q);
		click(updateBtn);
	}
	
	public void removeFromCart() {
		for (@SuppressWarnings("unused") WebElement item : CartItemsList) {
			click(deleteFromCart);
		}
	}
	
	public void countinueAfterCartEmpty() {
		click(emptyCartContinueBtn);
	}
	
	//Validation
	public String quantityLabel() {
		String s = getText(quantityLabel);
		return s;
	}
	
	public String getItemTitle() {
		return getText(itemNameLabel);
	}
}
