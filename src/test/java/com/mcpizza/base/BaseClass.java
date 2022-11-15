package com.mcpizza.base;

import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.MutableCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


import com.mcpizza.lib.Reporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseClass {
    public static WebDriver driver;
    public ExtentReports extent;
    public ExtentTest test;
    
    @BeforeClass
    public void BeforeClass()
    {
    	extent =new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html", true);
    	
    	test= extent.startTest("Starting McPizza tests");
    }
    @BeforeMethod(alwaysRun = true)
    @SuppressWarnings("unchecked")
    @Parameters("os")
    public void setUp(String os) throws Exception {
    
    	System.out.println(System.getProperty("user.dir"));
    	
    	if(os.equalsIgnoreCase("linux"))
    	{
    		//Setup chrome options to run in headless mode. This is allow execution on linux and mac also
        	ChromeOptions options =new ChromeOptions();
        	options.addArguments("window-size=1400,800");
        	options.addArguments("headless");
        	
    		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\linux\\chromedriver.exe");
    	
    		driver=new ChromeDriver(options);
    	}
    	else if(os.equalsIgnoreCase("windows"))
    	{
    		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\windows\\chromedriver.exe");
    		driver=new ChromeDriver();
    		driver.manage().window().maximize();
    	}
    	else
    	{
    		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\mac\\chromedriver.exe");
    		driver=new ChromeDriver();
    		driver.manage().window().maximize();
    	}
    	//
    	
    	
    	driver.manage().deleteAllCookies();
    	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    	
    	test.log(LogStatus.INFO, "Launched the browser successfully on "+os+" Operating System");
        }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult it) throws Exception {
    	
    	if(!it.isSuccess())
    	{
    		String destPath =Reporter.AddScreenshot(it.getMethod().getMethodName());
    		System.out.println(destPath);
    		test.log(LogStatus.FAIL, test.addScreenCapture(destPath));
    	}
    
        extent.endTest(test);
        driver.quit();
    }
    @AfterClass
    public void afterClass()
    {
    	extent.flush();
    	extent.close();
    	
    }
}

