package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GeneralPage extends BasePage {
	@FindBy(css = ".top.menu_account")
	private WebElement dropDown;
	@FindBy(css = ".fa.fa-unlock")
	private WebElement logoutBtn;
	@FindBy(css = ".maintext")
	private WebElement logoutMsg;
	@FindBy(css = "[title='Continue']")
	private WebElement continueBtn;
	@FindBy(css="#customer_menu_top")
	private WebElement loginLabel;
	@FindBy(css=".nav.topcart.pull-left>.dropdown.hover>.dropdown-toggle")
	private WebElement cartBtn;
	@FindBy(css=".dropdown-toggle>.label.label-orange.font14")
	private WebElement cartLabel;
	@FindBy(css=".btn-group.search-bar>#filter_keyword")
	private WebElement searchField;
	@FindBy(css=".nav-pills.categorymenu>li>a")
	private WebElement homePageBtn;

	public GeneralPage(WebDriver driver) {
		super(driver);
	}

	public void logout() {
		click(dropDown);
		click(logoutBtn);
		waiting(500);
		click(continueBtn);
	}
	
	public void homePage() {
		click(homePageBtn);
	}
	
	public void homePageCartBtn() {
		click(cartBtn);
	}
	
	public void search(String name) {
		fillText(searchField, name);
		submit(searchField);
	}

	// Validation
	public String loggedOutMsg() {
		return getText(logoutMsg);
	}
	
	public String loginOrRegisterMsg() {
		return getText(loginLabel);
	}
	
	public String cartNumberOfItems() {
		return getText(cartLabel);
	}
}
