package Rahulshettyacademy.StepDefinition;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Selenium.FrameworkDesignauto.TestComponent.BaseTest;
import Selenium.FrameworkDesignauto.pageobjects.CartPage;
import Selenium.FrameworkDesignauto.pageobjects.CheckOutPage;
import Selenium.FrameworkDesignauto.pageobjects.ConfirmationPage;
import Selenium.FrameworkDesignauto.pageobjects.Landingpage;
import Selenium.FrameworkDesignauto.pageobjects.productCatalog;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends BaseTest{
	
	public Landingpage landingpage;
	public productCatalog ProductCatalog;
	public ConfirmationPage confirmationpage;
	@Given("I landed on the site")
	public void I_landed_on_the_site() throws IOException
	{
		landingpage=LaunchApplication();
	}

	@Given ("^Logged in with email (.+) and password (.+)$")
	public void Logged_in_with_email_and_password(String username, String password)
	{
		ProductCatalog=landingpage.loginApplication(username, password);
	}
	
	@When("^I added product (.+) to cart$")
	public void I_added_product_to_cart(String productName)
	{
		List<WebElement>products=ProductCatalog.getProductlist();
		ProductCatalog.AddproductToCart(productName);
	}
	
	@And("^checkout (.+) and submit the order$")
	public void checkout_and_submit_the_order(String productName) throws InterruptedException
	{
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
	}
	
	@Then ("{string} message is displayed on confirmation page")
	public void message_displayed_confirmationPage(String string) throws InterruptedException
	{
		//js.executeScript("window.scrollBy(0,-600)");
		Thread.sleep(5000);
		String confirmessage=confirmationpage.textmessge();
		Assert.assertTrue(confirmessage.equalsIgnoreCase(string));
		driver.close();
		}
	
	@Then ("{string} message is displayed")
	public void Error_message_is_displayed(String string)
	{
		//landingpage.loginApplication("Hari@gmail.com", "Hari@123");
		Assert.assertEquals(string, landingpage.getErrorMessage());
		driver.close();
		}
	
}
