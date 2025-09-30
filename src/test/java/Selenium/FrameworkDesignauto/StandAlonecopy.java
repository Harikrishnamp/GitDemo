dspackage Selenium.FrameworkDesignauto;

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

public class StandAlonecopy extends BaseTest{
	
	@Test
	 public void SubmitOrder() throws InterruptedException, IOException
	 {
		// TODO Auto-generated method stub
		String productName = "ZARA COAT 3";
		Landingpage landingpage=LaunchApplication();
		productCatalog ProductCatalog=landingpage.loginApplication("Har@gmail.com", "Hari@123");
		List<WebElement>products=ProductCatalog.getProductlist();
		ProductCatalog.AddproductToCart(productName);
		CartPage cartpage=ProductCatalog.gotocart();
		boolean match=cartpage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(5000);
		CheckOutPage checkoutpage=cartpage.gotocheckout();
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(5000);
		checkoutpage.selectcountry("India");
		ConfirmationPage confirmationpage=checkoutpage.submitorder();
		//Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,-600)");
		Thread.sleep(5000);
		String confirmessage=confirmationpage.textmessge();
		Assert.assertTrue(confirmessage.equalsIgnoreCase("Thankyou for the order."));

		
	 }
	
	public void postjira()
	{
		System.out.println("postjira")
	}


}
