package Selenium.FrameworkDesignauto.TestComponent;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Reader;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Selenium.FrameworkDesignauto.pageobjects.Landingpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public Landingpage landingpage;
	public WebDriver InitializeDriver(WebDriver driver) throws IOException 
	{
		//properities class
		Properties prop=new Properties();
		FileInputStream fil=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\SeleniumFramework\\Resourses\\GlobalData.properties");
		prop.load(fil);
		String browserName=prop.getProperty("browser");
	if(browserName.equalsIgnoreCase("Chrome"))
	{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().window().maximize();
	return driver;
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
