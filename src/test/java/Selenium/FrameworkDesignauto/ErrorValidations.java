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

public abstract class ErrorValidations extends BaseTest{
	
	@Test
	 public void SubmitOrder() throws InterruptedException, IOException
	 {
		// TODO Auto-generated method stub
		String productName = "ZARA COAT 3";
		landingpage.loginApplication("H@gmail.com", "Hari@123");
		Assert.assertEquals("Incorret mail or password.", landingpage.getErrorMessage());
	 }

		
		
		

	

}
