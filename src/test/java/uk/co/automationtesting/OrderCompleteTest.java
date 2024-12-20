package uk.co.automationtesting;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import Base.BasePage;
import Base.Hooks;
import pageObjects.Homepage;
import pageObjects.OrderFormPayment;
import pageObjects.OrderFormPersInfo;
import pageObjects.OrderFormShippingMethod;
import pageObjects.OrderFromDelivery;
import pageObjects.ShopContentPanel;
import pageObjects.ShopHomepage;
import pageObjects.ShopProductPage;
import pageObjects.ShoppingCart;
@Listeners(resources.Listeners.class)
public class OrderCompleteTest extends Hooks {

	public OrderCompleteTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}


	@Test
	public void endToEndTest() throws  InterruptedException, IOException {

		Homepage home = new Homepage();

		// handles cookie prompt
		//home.getCookie().click();

		home.getTestStoreLink().click();

		ShopHomepage shopHome = new ShopHomepage();
		shopHome.getProdOne().click();

		ShopProductPage shopProd = new ShopProductPage();
		Select option = new Select(shopProd.getSizeOption());
		option.selectByVisibleText("M");
		shopProd.getQuantIncrease().click();
		shopProd.getAddToCartBtn().click();

		Thread.sleep(5000);

		ShopContentPanel cPanel = new ShopContentPanel();
		cPanel.getCheckoutBtn().click();

		ShoppingCart cart = new ShoppingCart();
		cart.getHavePromo().click();
		cart.getPromoTextbox().sendKeys("20OFF");
		cart.getPromoAddBtn().click();
		Thread.sleep(5000);
		cart.getProceedCheckoutBtn().click();


		// creating an object of the order personal information page
		OrderFormPersInfo pInfo = new OrderFormPersInfo();
		pInfo.getGenderMr().click();
		pInfo.getFirstNameField().sendKeys("John");
		pInfo.getLastnameField().sendKeys("Smith");
		pInfo.getEmailField().sendKeys("johnsmith1@test.com");
		pInfo.getTermsConditionsCheckbox().click();
		pInfo.getContinueBtn().click();

		// creating an object of the order delivery info page
		OrderFromDelivery orderDelivery = new OrderFromDelivery();
		orderDelivery.getAddressField().sendKeys("123 Main Street");
		orderDelivery.getCityField().sendKeys("Houston");
		Select state = new Select(orderDelivery.getStateDropdown());
		state.selectByVisibleText("Texas");
		orderDelivery.getPostcodeField().sendKeys("77021");
		orderDelivery.getContinueBtn().click();

		// creating an object of the shipping method page
		OrderFormShippingMethod shipMethod = new OrderFormShippingMethod();
		shipMethod.getDeliveryMsgTextbox().sendKeys("If I am not in, please leave my delivery on my porch.");
		shipMethod.getContinueBtn().click();

		// creating an object of the payment options page
		OrderFormPayment orderPay = new OrderFormPayment();
		orderPay.getPayByCheckRadioBtn().click();
		orderPay.getTermsConditionsCheckbox().click();
		orderPay.getOrderBtn().click();

	}

}
