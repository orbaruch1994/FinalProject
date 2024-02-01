package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;
	WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void fillText(WebElement el, String text) {
		el.clear();
		el.sendKeys(text);
	}

	public void click(WebElement el) {
		el.click();
	}

	public void submit(WebElement el) {
		el.submit();
	}
	
	public String getValue(WebElement el) {
		return el.getAttribute("value");
	}
	
	public String getText(WebElement el) {
		return el.getText();
	}
	
	// waits
	
	public void waitForElementToBeClickable(WebElement el) {
		wait.until(ExpectedConditions.elementToBeClickable(el));
	}
	
	public void waitForElementToBeVisable(WebElement el) {
		wait.until(ExpectedConditions.visibilityOf(el));
	}

	public void waitForElementToBeInvisable(WebElement el) {
		wait.until(ExpectedConditions.invisibilityOf(el));
	}
	

	public void waiting(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
