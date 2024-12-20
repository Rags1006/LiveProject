package uk.co.automationtesting;

import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import Base.BasePage;
import Base.Hooks;
import pageObjects.Homepage;
import pageObjects.ShopContentPanel;
import pageObjects.ShopHomepage;
import pageObjects.ShopProductPage;
import pageObjects.ShoppingCart;
@Listeners(resources.Listeners.class)
public class AddRemoveItemBasketTest extends Hooks{
	public AddRemoveItemBasketTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	@Test
	public void addRemoveItem() throws IOException, InterruptedException {
		Homepage home = new Homepage();

		// handles cookie prompt
		//home.getCookie().click();

		home.getTestStoreLink().click();

		ShopHomepage shopHome = new ShopHomepage();
		shopHome.getProdOne().click();

		// creating an object of the shop products page (when a product has been selected)
		ShopProductPage shopProd = new ShopProductPage();
		Select option = new Select(shopProd.getSizeOption());
		option.selectByVisibleText("M");
		shopProd.getQuantIncrease().click();
		shopProd.getAddToCartBtn().click();

		// creating an object of the cart content panel (once an item was added)
		ShopContentPanel cPanel = new ShopContentPanel();
		cPanel.getContinueShopBtn().click();
		shopProd.getHomepageLink().click();
		shopHome.getProdTwo().click();
		shopProd.getAddToCartBtn().click();
		cPanel.getCheckoutBtn().click();
		
		ShoppingCart cart = new ShoppingCart();
		cart.getDeleteItemTwo().click();
		
		waitForElementInvisible(cart.getDeleteItemTwo(), 10);
		
		System.out.println(cart.getTotalAmount().getText());
		AssertJUnit.assertEquals(cart.getTotalAmount().getText(),"$45.23");
		
	}
	

}
