package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.BasePage;

public class ShopContentPanel extends BasePage{

	public WebDriver driver;
	
	By continueShoppingBtn = By.xpath("//button[contains(text(), 'Continue')]");
	By checkoutBtn = By.xpath("//a[contains(text(),'checkout')]");
	
	public ShopContentPanel() throws IOException {
		super();
	}
	
	public WebElement getContinueShopBtn() throws IOException {
		this.driver=getDriver();
		return driver.findElement(continueShoppingBtn);
	}
	
	public WebElement getCheckoutBtn() throws IOException {
		this.driver=getDriver();
		return driver.findElement(checkoutBtn);
	}
	

}
