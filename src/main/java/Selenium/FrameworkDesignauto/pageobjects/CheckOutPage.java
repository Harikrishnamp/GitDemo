package Selenium.FrameworkDesignauto.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Selenium.FrameworkDesignauto.AbstractComponents.AbstractComponents;

public class CheckOutPage extends AbstractComponents{
	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);// TODO Auto-generated constructor stub
	}
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement Country;
	
	By dropdown=By.cssSelector(".ta-results");
	
	@FindBy(css="button[class*='ta-item']:last-of-type")
	WebElement SelectCountry;
	
	@FindBy(css=".action__submit")
	WebElement Submit;
	
	public void selectcountry(String countryname)
	{
		Actions a=new Actions(driver);
		a.sendKeys(Country, countryname).build().perform();
		waitforElementToAppear(dropdown);
		SelectCountry.click();
	}
	
	public ConfirmationPage submitorder()
	{
		Submit.click();
		return new ConfirmationPage(driver);
	}
	
	
}
