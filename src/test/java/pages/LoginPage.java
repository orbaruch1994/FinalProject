package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	@FindBy(css="[name='loginname']")
	private WebElement usernameField;
	@FindBy(css="[name='password']")
	private WebElement passwordField;
	@FindBy(css="[title='Login']")
	private WebElement loginBtn;
	@FindBy(css=".col-sm-6.returncustomer>.heading2")
	private WebElement returningUserLabel;
	@FindBy(css=".alert.alert-error.alert-danger")
	private WebElement loginErrorMsg;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void login(String user, String password) {
		waiting(500);
		fillText(usernameField, user);
		fillText(passwordField, password);
		click(loginBtn);
	}
	
	// Validation
	public String returnMsg() {
		return getText(returningUserLabel);
	}
	
	public String ExpectedErrorMsg() {
		return getText(loginErrorMsg);
	}
	
	public String ActualErrorMsg() {
		String Msg = getText(loginErrorMsg);
		return Msg;
	}
	
}
