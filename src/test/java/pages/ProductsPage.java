package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage{
	@FindBy(css="[href='https://automationteststore.com/index.php?rt=product/category&path=49']")
	private WebElement fregrenceBtn;
	@FindBy(css="#maincontainer > div > div > div > div > ul > li:nth-child(1) > div > a")
	private WebElement menBtn;
	@FindBy(css=".col-md-3.col-sm-6.col-xs-12")
	private List<WebElement> itemsList;
	@FindBy(css=".menu_text")
	private WebElement welcomeLabel;
	@FindBy(css=".maintext")
	private WebElement categoryLabel;
	@FindBy(css=".nav-pills.categorymenu>li")
	private List<WebElement> categoryList;
	
	public ProductsPage(WebDriver driver) {
		super(driver);
	}
	
	public void chooseCategory() {
		click(fregrenceBtn);
		click(menBtn);
	}
	
	public void chooseProduct(String name) {
		for (WebElement item : itemsList) {
			WebElement titleLink = item.findElement(By.cssSelector(".fixed>.prdocutname"));
			if (titleLink.getText().equalsIgnoreCase(name)) {
				System.out.println(titleLink);
				click(titleLink);
				break;
			}
		}
	}
	
	//Validation
	
	public String welcomeBackText() {
		return getText(welcomeLabel);
	}
	
	public String categoryPicked() {
		return getText(categoryLabel);
	}
}
