package com.mcpizza.lib;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.mcpizza.base.BaseClass;

public class Utils extends BaseClass {

	public static void clickJs(WebElement ele)
	{
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	executor.executeScript("arguments[0].click();", ele);
	}
	
	public static void sendkeysJs(WebElement ele, String value)
	{

		JavascriptExecutor jse = ((JavascriptExecutor)driver);        	
		
		jse.executeScript("arguments[0].value='"+value+"';", ele);

	}
}
