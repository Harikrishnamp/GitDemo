package Selenium.FrameworkDesignauto;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Selenium.FrameworkDesignauto.TestComponent.BaseTest;
import Selenium.FrameworkDesignauto.pageobjects.CartPage;
import Selenium.FrameworkDesignauto.pageobjects.CheckOutPage;
import Selenium.FrameworkDesignauto.pageobjects.ConfirmationPage;
import Selenium.FrameworkDesignauto.pageobjects.Landingpage;
import Selenium.FrameworkDesignauto.pageobjects.productCatalog;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidations extends BaseTest{
	
	@Test
	 public void loginError() throws InterruptedException, IOException
	 {
		// TODO Auto-generated method stub
		String productName = "ZARA COAT 3";
		landingpage.loginApplication("Hari@gmail.com", "Hari@123");
		Assert.assertEquals("Incorrect email or password.", landingpage.getErrorMessage());
	 }

	@Test
	public void productErrorvalidation()
	{
		String productName = "ZARA COAT 3";
		productCatalog ProductCatalog=landingpage.loginApplication("Har@gmail.com", "Hari@123");
		List<WebElement>products=ProductCatalog.getProductlist();
		ProductCatalog.AddproductToCart(productName);
		CartPage cartpage=ProductCatalog.gotocart();
		boolean match=cartpage.verifyProductDisplay("ZARA");
		Assert.assertFalse(match);
	}
		
		

	

}
