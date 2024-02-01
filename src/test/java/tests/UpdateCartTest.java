package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateCartTest extends BaseTest{
	
	@Test(description = "Choose product and add it to the cart, change the quantity to - 3")
	public void tc01_addProduct() {
		productsPage.chooseCategory();
		productsPage.chooseProduct("ck one shock for him Deodorant");
		itemPage.changeQuantity("3");
		itemPage.addToCart();
		cartPage.countiueShopping();
	}
	
	@Test(description = "Go to the cart and change the quantity to - 5")
	public void tc02_updateCart() {
		generalPage.homePageCartBtn();
		cartPage.updateCart("5");
		String expected = "5";
		String actual = generalPage.cartNumberOfItems();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(description = "Choose category and add another item to the cart")
	public void tc03_addAnotherProduct() {
		productsPage.chooseCategory();
		productsPage.chooseProduct("Euphoria Men Intense Eau De Toilette Spray");
		itemPage.addToCart();
		generalPage.homePageCartBtn();
	}
}
