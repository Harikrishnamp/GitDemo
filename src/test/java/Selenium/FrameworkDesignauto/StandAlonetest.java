package Selenium.FrameworkDesignauto;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Selenium.FrameworkDesignauto.pageobjects.Landingpage;
import Selenium.FrameworkDesignauto.pageobjects.productCatalog;
import io.github.bonigarcia.wdm.WebDriverManager;
public class StandAlonetest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String productName = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		Landingpage landingpage=new Landingpage(driver);
		landingpage.goTo();
		landingpage.loginApplication("Har@gmail.com", "Hari@123");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		/*driver.findElement(By.id("userEmail")).sendKeys("Har@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Hari@123");
		driver.findElement(By.id("login")).click(); */
		
		productCatalog ProductCatalog=new productCatalog(driver);
		List<WebElement>products=ProductCatalog.getProductlist();		
		//List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod=products.stream().filter(product->
		product.findElement(By.xpath(".//div[@class='card-body']//h5//b")).getText().equals(productName)).findFirst().orElse(null);
		prod.findElement(By.xpath(".//div[@class='card-body']/button[2]")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		List<WebElement> cart=driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match=cart.stream().anyMatch(item->item.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(5000);
		
		driver.findElement(By.cssSelector("li[class='totalRow'] button[type='button']")).click(); 
		
		Actions a=new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India").build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("button[class*='ta-item']:last-of-type")).click();
		//Thread.sleep(5000);
		driver.findElement(By.cssSelector(".action__submit")).click();
		js.executeScript("window.scrollBy(0,-600)");
		Thread.sleep(5000);
		String message=driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(message.equalsIgnoreCase("Thankyou for the order."));
		driver.close();
		
		
		
		
		
		
		

	}

}
