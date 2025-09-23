package Selenium.FrameworkDesignauto.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Selenium.FrameworkDesignauto.pageobjects.CartPage;

public class AbstractComponents {
	
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;

	public void waitforElementToAppear(By findBy) {
		
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated((findBy)));
	}
	
	public void waitforWebElementToAppear(WebElement findBy) {
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf((findBy)));
		}
	
	public CartPage gotocart()
	{
		cartHeader.click();
		CartPage cartpage=new CartPage(driver);
		return cartpage;
		
	}
	
	public void waitforElementToDisappear(WebElement Ele) {
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(Ele));
	}
}
