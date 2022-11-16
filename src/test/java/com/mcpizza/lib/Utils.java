package com.mcpizza.lib;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
	public static void moveToElement_Actions(WebElement ele)
	{
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
	}
	
	public static void sendKeys_Actions(WebElement ele, String value)
	{
		Actions act=new Actions(driver);
		act.sendKeys(value).perform();
	}
	public static void click_Actions(WebElement ele)
	{
		Actions act=new Actions(driver);
		act.click(ele).perform();
	}
}
