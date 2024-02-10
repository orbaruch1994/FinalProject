package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePagePurchaseTest extends BaseTest {

	@Test(description = "Choose product from the home page and add it to the cart")
	public void tc01_chooseProductFromHomePage() {
		generalPage.homePage();
		homePage.chooseProductFromHomePage("Benefit Bella Bamba");
		itemPage.addToCart();
		String expected = "Benefit Bella Bamba";
		String actual = cartPage.getItemTitle();
		Assert.assertEquals(actual, expected);
		cartPage.countiueShopping();
	}

	@Test(description = "Return to the home page and add product to cart directly from the home page")
	public void tc02_addToCartFromHomePage() {
		generalPage.homePage();
		homePage.addProductFromHomePage("Skinsheen Bronzer Stick");
		generalPage.homePageCartBtn();
		cartPage.clickCheckout();
		int expected = 2;
		int actual = checkoutPage.numberOfItems();
		Assert.assertEquals(actual, expected);
	}

	@Test(description = "Click on Confirm Order to end the purchase")
	public void tc03_confirmOrder() {
		checkoutPage.clickConfirm();
		String expected = "YOUR ORDER HAS BEEN PROCESSED!";
		String actual = confirmedPage.confirmedMsg();
		Assert.assertEquals(actual, expected);
	}
}
