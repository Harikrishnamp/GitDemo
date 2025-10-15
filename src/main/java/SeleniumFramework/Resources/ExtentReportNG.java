package SeleniumFramework.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

	public static ExtentReports getReportObject()
	{
		String path=System.getProperty("user.dir")+"\\reports\\index.html"; //index.html file will have extent reports, 
		ExtentSparkReporter reporter=new ExtentSparkReporter(path); //ExtentSparkReporter is responsible to create html file and do configurations
	    reporter.config().setReportName("Automation Report");
	    reporter.config().setDocumentTitle("Test Results");
	    
	    ExtentReports extent=new ExtentReports();//ExtentReports  will drive all the reporting execution
	    extent.attachReporter(reporter); //extentreports will create and consolidate all the test execution and will report to main class
	    extent.setSystemInfo("Tester", "Harikrishna");
	    return extent;
	    
	    }
}
