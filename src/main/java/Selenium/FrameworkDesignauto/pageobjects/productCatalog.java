package Selenium.FrameworkDesignauto.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Selenium.FrameworkDesignauto.AbstractComponents.AbstractComponents;

public class productCatalog extends AbstractComponents {
	WebDriver driver;
	public productCatalog(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this); //as driver is missing in @FindBy so add this step
	}
	
	//List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
	
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	By addtocart=By.xpath(".//div[@class='card-body']/button[2]");
	By toastmessage=By.cssSelector("#toast-container"); //By.cssSelector("#toast-container")
	
	@FindBy(css=".ng-animating")
	WebElement disppear;//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	 
	public List<WebElement> getProductlist()
	{
		return products;
	}
	
	public WebElement getProductbyName(String productName) {
		
		WebElement prod=getProductlist().stream().filter(product->
		product.findElement(By.xpath(".//div[@class='card-body']//h5//b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void AddproductToCart(String productName)
	{
		WebElement prod= getProductbyName(productName);
		prod.findElement(addtocart).click();
		waitforElementToAppear(toastmessage);
		waitforElementToDisappear(disppear);
		
	}

	

	
	
	
	
	
	

}
