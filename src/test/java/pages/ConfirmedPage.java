package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmedPage extends BasePage {
	@FindBy(css = ".maintext")
	private WebElement confirmedLable;

	public ConfirmedPage(WebDriver driver) {
		super(driver);
	}

	// Validation
	public String confirmedMsg() {
		return getText(confirmedLable);
	}
}
