package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchAndBuyTest extends BaseTest {

	@Test(description = "Search product from the search field")
	public void tc01_searchProduct() {
		generalPage.search("shirt");
		String expected = "shirt";
		String actual = searchPage.searchCriteriaField();
		Assert.assertEquals(actual, expected);
	}

	@Test(description = "Choose product and add it to the cart")
	public void tc02_addItemToCart() {
		searchPage.descriptionCheckBox();
		searchPage.chooseProductFromSearch("Casual 3/4 Sleeve Baseball T-Shirt");
		itemPage.addToCart();
		String expected = "Casual 3/4 Sleeve Baseball T-Shirt";
		String actual = cartPage.getItemTitle();
		Assert.assertEquals(actual, expected);
	}

	@Test(description = "Click checkout to go to payment")
	public void tc03_buyItem() {
		cartPage.clickCheckout();
		int expected = 1;
		int actual = checkoutPage.numberOfItems();
		Assert.assertEquals(actual, expected);
	}

	@Test(description = "Click on Confirm Order to end the purchase")
	public void tc04_confirmOrder() {
		checkoutPage.clickConfirm();
		String expected = "CHECKOUT CONFIRMATION";
		String actual = confirmedPage.confirmedMsg();
		Assert.assertEquals(actual, expected);
	}

}
