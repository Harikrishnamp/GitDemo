package Selenium.FrameworkDesignauto.TestComponent;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import SeleniumFramework.Resources.ExtentReportNG;

public class Listeners extends BaseTest implements ITestListener{
	ExtentTest test; //holdes the entry to test
	
	ExtentReports extent= ExtentReportNG.getReportObject();
	@Override
    public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getMethod().getMethodName());
        //System.out.println("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	test.log(Status.PASS, "Test passed");
        //System.out.println("Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	test.fail(result.getThrowable());
    	
    	try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
    	
    	String filePath = null;
		try {
			filePath = getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());

    	//ss
        //System.out.println("Test Failed: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        //System.out.println("Test Skipped: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Not used often
    }

    @Override
    public void onStart(ITestContext context) {
        //System.out.println("Execution Started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
    	extent.flush();
        //System.out.println("Execution Finished: " + context.getName());
    }
}
