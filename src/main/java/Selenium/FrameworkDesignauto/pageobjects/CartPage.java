package Selenium.FrameworkDesignauto.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Selenium.FrameworkDesignauto.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents{
	
	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cart;
	
	@FindBy(css="li[class='totalRow'] button[type='button']")
	WebElement check;
		
	public Boolean verifyProductDisplay(String productName)
	{
	Boolean match=cart.stream().anyMatch(item->item.getText().equalsIgnoreCase(productName));
	return match;
	}
	
	public CheckOutPage gotocheckout()
	{
		check.click();
		return new CheckOutPage(driver);
	}
}
