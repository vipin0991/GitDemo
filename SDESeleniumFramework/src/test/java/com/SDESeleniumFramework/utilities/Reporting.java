package com.SDESeleniumFramework.utilities;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.SDESeleniumFramework.testCases.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends BaseClass implements ITestListener {

	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	    public void onStart(ITestContext arg) {
			String	timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String repName = "Test-Report-"+timeStamp+".html";
			htmlReporter = new ExtentSparkReporter("D:\\Selenium\\workspace\\SDESeleniumFramework\\test-output\\"+repName);
			
			try {
				htmlReporter.loadXMLConfig("../SDESeleniumFramework/extent-config.xml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			extent = new ExtentReports();
			//System.out.println(htmlReporter.getFile());
			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("Host Name", "localHost");
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("User", "Vipin");
			
			htmlReporter.config().setDocumentTitle("SDE Selenium Framework");
			htmlReporter.config().setReportName("Functional Test Cases Automation Report");
			htmlReporter.config().setTheme(Theme.DARK);
			
    }

    // This belongs to ITestListener and will execute, once the whole Test is finished

    @Override
    public void onFinish(ITestContext arg0) {
        Reporter.log("About to end executing Class " + arg0.getName(), true);
        extent.flush();
    }
    // This belongs to ITestListener and will execute before each test method

    @Override
    public void onTestStart(ITestResult arg0) {
        Reporter.log("Testcase " + arg0.getName() + " started successfully", true);
    }

    // This belongs to ITestListener and will execute only on the event of successfull test method
    public void onTestSuccess(ITestResult arg) {
    	logger = extent.createTest(arg.getName());
    	logger.log(Status.PASS, MarkupHelper.createLabel(arg.getName(), ExtentColor.GREEN));
 
    }

    // This belongs to ITestListener and will execute only on the event of fail test

    public void onTestFailure(ITestResult arg) {
    	//System.out.println(arg+"\n"+"@@"+arg.getTestClass()+"\n"+"##"+arg.getTestClass().getRealClass()+""+(WebDriver)arg.getTestClass().getRealClass().getField("driver").get(arg.getInstance()));
     	logger = extent.createTest(arg.getName());
    	logger.log(Status.FAIL, MarkupHelper.createLabel(arg.getName(), ExtentColor.RED));
    	
    	try {
			driver = (WebDriver)arg.getTestClass().getRealClass().getField("driver").get(arg.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	String path = null;
    	
		try {
			path = captureScreenshot(driver);
			//System.out.println(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	File f = new File(path);
    	
    	if(f.exists()) {
    		logger.fail("Screenshot is below:"+ logger.addScreenCaptureFromPath(path));
    		logger.fail(arg.getThrowable());
    	}
    	
    }

    // This belongs to ITestListener and will execute only on the event of skipped test method

    public void onTestSkipped(ITestResult arg) {
    	logger = extent.createTest(arg.getName());
    	logger.log(Status.SKIP, MarkupHelper.createLabel(arg.getName(), ExtentColor.ORANGE));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
    }
}