package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{
	@FindBy(css=".col-md-3.col-sm-6.col-xs-12")
	private List<WebElement> searchResultsList;
	@FindBy(css=".checkbox>#description")
	private WebElement descriptionCheckBox;
	@FindBy(css=".input-group>#search_button")
	private WebElement searchBtn;
	@FindBy(css="[name='keyword']")
	private WebElement searchCriteriaLabel;
	
	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	public void chooseProductFromSearch(String name) {
		for (WebElement result : searchResultsList) {
			WebElement title = result.findElement(By.cssSelector(".fixed>.prdocutname"));
			if (title.getText().equalsIgnoreCase(name)) {
				click(title);
				break;
			}
		}
	}
	
	public void descriptionCheckBox() {
		click(descriptionCheckBox);
		click(searchBtn);
	}
	
	//Validation
	public String searchCriteriaField() {
		return getValue(searchCriteriaLabel);
	}
	
}
