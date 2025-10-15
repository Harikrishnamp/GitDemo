
	package Selenium.FrameworkDesignauto.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.FrameworkDesignauto.AbstractComponents.AbstractComponents;

public class Landingpage extends AbstractComponents {
	WebDriver driver;
	public Landingpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this); //as driver is missing in @FindBy so add this step
	}
	
	//WebElement username=driver.findElement(By.id("userEmail"))
	//PageFactory
	
	@FindBy(id="userEmail")
	WebElement username;
	
	@FindBy(id="userPassword")
	WebElement passwordEl;
	
	@FindBy(id="login")
	WebElement submit;
	
	//.ng-tns-c4-0.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
	@FindBy(css="[class*='flyInOut']")
	WebElement ErrorMessage;
	
	//div[aria-label='Incorrect email or password.']
	///html[1]/body[1]/div[1]/div[1]/div[2]/div[1]
	////div[@aria-label='Incorrect email or password.']//id attribute is not available for this element
	
	public productCatalog loginApplication(String email,String password)
	{
		username.sendKeys(email);
		passwordEl.sendKeys(password);
		submit.click();
		productCatalog ProductCatalog=new productCatalog(driver);
		return ProductCatalog;

	}
	
	public String getErrorMessage()
	{
		waitforWebElementToAppear(ErrorMessage);
		return ErrorMessage.getText();
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	
	
	

}
