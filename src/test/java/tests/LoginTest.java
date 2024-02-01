package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

	@Override
	public void setupLogin() {
		// Override method from baseTest
	}

	@Test(description = "Click on LOGIN OR REGISTER button and go to login page")
	public void tc01_loginOrRegister() {
		homePage.loginOrRegisterBtn();
		String expected = "RETURNING CUSTOMER";
		String actual = loginPage.returnMsg();
		Assert.assertEquals(actual, expected);
	}

	@Test(description = "Login with invalid password or username")
	public void tc02_failedLogin() {
		loginPage.login("orbaruch111", "12345");
		String expected = loginPage.ExpectedErrorMsg();
		String actual = loginPage.ActualErrorMsg();
		Assert.assertEquals(actual, expected);
	}

	@Test(description = "Login with valid password and username")
	public void tc03_login() {
		loginPage.login("orbaruch111", "5057460or");
		String expected = "Welcome back or";
		String actual = productsPage.welcomeBackText();
		Assert.assertEquals(actual, expected);
	}

	@Test(description = "Logout from the website")
	public void tc04_logout() {
		generalPage.logout();
		String expected = "Login or register";
		String actual = generalPage.loginOrRegisterMsg();
		Assert.assertEquals(actual, expected);
	}
}
