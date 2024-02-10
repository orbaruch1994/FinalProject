package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BuyProductTest extends BaseTest {

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

	@Test(description = "Login to the website")
	public void tc02_login() {
		loginPage.login("orbaruch111", "5057460or");
		String expected = "Welcome back or";
		String actual = productsPage.welcomeBackText();
		Assert.assertEquals(actual, expected);
	}

	@Test(description = "Choose 2 catgories: FRAGRANCE & MEN")
	public void tc03_chooseCategory() {
		productsPage.chooseCategory();
		String expected = "MEN";
		String actual = productsPage.categoryPicked();
		Assert.assertEquals(actual, expected);
	}

	@Test(description = "Choose a product and click on it")
	public void tc04_chooseProduct() {
		productsPage.chooseProduct("ck one shock for him Deodorant");
		String expected = "ck one shock for him Deodorant";
		String actual = itemPage.productName();
		Assert.assertEquals(actual, expected);
	}

	@Test(description = "Add product to cart and change the quantity to - 3")
	public void tc05_addToCart() {
		itemPage.changeQuantity("3");
		itemPage.addToCart();
		String expected = "3";
		String actual = cartPage.quantityLabel();
		Assert.assertEquals(actual, expected);
	}

	@Test(description = "Continue shopping and choose another product to add to the cart")
	public void tc06_chooseAnother() {
		cartPage.countiueShopping();
		productsPage.chooseCategory();
		productsPage.chooseProduct("Euphoria Men Intense Eau De Toilette Spray");
		String expected = "Euphoria Men Intense Eau De Toilette Spray";
		String actual = itemPage.productName();
		Assert.assertEquals(actual, expected);
		itemPage.addToCart();
	}

	@Test(description = "Click on checkout to go to payment")
	public void tc07_clickCheckout() {
		cartPage.clickCheckout();
		int expected = 2;
		int actual = checkoutPage.numberOfItems();
		Assert.assertEquals(actual, expected);
	}

	@Test(description = "Click on Confirm Order to end the purchase")
	public void tc08_confirm() {
		checkoutPage.clickConfirm();
		String expected = "YOUR ORDER HAS BEEN PROCESSED!";
		String actual = confirmedPage.confirmedMsg();
		Assert.assertEquals(actual, expected);
	}
}
