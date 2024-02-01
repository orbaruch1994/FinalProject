package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	@FindBy(css="#customer_menu_top>li>a")
	private WebElement loginOrRegisterBtn;
	@FindBy(css=".col-md-3.col-sm-6.col-xs-12")
	private List<WebElement> homePageItemList;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void loginOrRegisterBtn() {
		click(loginOrRegisterBtn);
	}
	
	public void chooseProductFromHomePage(String name) {
		waiting(500);
		for (WebElement item : homePageItemList) {
			WebElement titleLink = item.findElement(By.cssSelector(".fixed>.prdocutname"));
			if (titleLink.getText().equalsIgnoreCase(name)) {
				click(titleLink);
				break;
			}
		}
	}
	
	public void addProductFromHomePage(String name) {
		for (WebElement item : homePageItemList) {
			WebElement titleLink = item.findElement(By.cssSelector(".fixed>a"));
			if (titleLink.getText().equalsIgnoreCase(name)) {
				WebElement addBtn = item.findElement(By.cssSelector(".fa.fa-cart-plus.fa-fw"));
				addBtn.click();
				break;
			}
		}
	}
}
