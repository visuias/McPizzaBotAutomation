package com.mcpizza.lib;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.mcpizza.base.BaseClass;

public class Reporter extends BaseClass{

	public static String destPath=null;
	public static String AddScreenshot(String fileName)
	{
		try {
			
			SimpleDateFormat formatnew=new SimpleDateFormat("yyyyMMddHHmmssSSS");
			
			TakesScreenshot ts=(TakesScreenshot) driver;
			File srcImg=ts.getScreenshotAs(OutputType.FILE);
			
			destPath= System.getProperty("user.dir")+"\\resources\\screenshots\\"+fileName+formatnew.format(new Date())+".png";
			FileUtils.copyFile(srcImg,new File(destPath));
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return destPath;
	}

	
}
