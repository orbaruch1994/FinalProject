package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage{
	@FindBy(css="#checkout_btn")
	private WebElement confirmBtn;
	@FindBy(css=".table.confirm_products>tbody>tr")
	private List<WebElement> checkList;
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickConfirm() {
		click(confirmBtn);
	}
	
	//Validation
	public int numberOfItems() {
		int i = 0;
		for (@SuppressWarnings("unused") WebElement item : checkList) {
			i += 1;
		}
		return i;
	}	

}
