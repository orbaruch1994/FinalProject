package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.CartPage;
import pages.CheckoutPage;
import pages.ConfirmedPage;
import pages.GeneralPage;
import pages.HomePage;
import pages.ItemPage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.SearchPage;

public class BaseTest {
	private WebDriver driver;
	GeneralPage generalPage;
	HomePage homePage;
	LoginPage loginPage;
	ProductsPage productsPage;
	ItemPage itemPage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	SearchPage searchPage;
	ConfirmedPage confirmedPage;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automationteststore.com/");
		generalPage = new GeneralPage(driver);
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		productsPage = new ProductsPage(driver);
		itemPage = new ItemPage(driver);
		cartPage = new CartPage(driver);
		checkoutPage = new CheckoutPage(driver);
		searchPage = new SearchPage(driver);
		confirmedPage = new ConfirmedPage(driver);
	}
	
	@BeforeClass 
	public void setupLogin() {
		homePage.loginOrRegisterBtn();
		loginPage.login("orbaruch111", "5057460or");
	}
	
	@AfterClass
	public void emptyCart() {
		generalPage.homePageCartBtn();
		cartPage.removeFromCart();
		cartPage.countinueAfterCartEmpty();
	}
	
//	@AfterClass
//	public void tearDown() {
//		driver.quit();
//	}

}
