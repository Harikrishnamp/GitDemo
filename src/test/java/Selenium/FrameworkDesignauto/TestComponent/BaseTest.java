package Selenium.FrameworkDesignauto.TestComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Reader;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Selenium.FrameworkDesignauto.LandingPage;
import Selenium.FrameworkDesignauto.pageobjects.Landingpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public Landingpage landingpage;
	public WebDriver InitializeDriver(WebDriver driver) throws IOException 
	{
		//properities class
		Properties prop=new Properties();
		FileInputStream fil = new FileInputStream(System.getProperty("user.dir")
			    + "\\src\\main\\java\\SeleniumFramework\\Resources\\GlobalData.properties");
		prop.load(fil);
		String browserName=System.getProperty("browser")!=null? System.getProperty("browser"): prop.getProperty("browser");
		//String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		System.out.println(">>> ChromeDriver created successfully ✅");
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println(">>> Edge created successfully ✅");
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			System.out.println(">>> Edge created successfully ✅");
		}
		
		else {
	        System.out.println(">>> No browser matched ❌");
		}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().window().maximize();
	return driver;
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";

	}
	
	@BeforeMethod
	public Landingpage LaunchApplication() throws IOException
	{
		driver=InitializeDriver(driver);
		landingpage=new Landingpage(driver);
		landingpage.goTo();
		return landingpage;
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
