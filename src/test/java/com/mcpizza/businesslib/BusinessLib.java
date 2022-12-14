package com.mcpizza.businesslib;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.mcpizza.base.BaseClass;
import com.mcpizza.lib.Utils;
import com.relevantcodes.extentreports.LogStatus;

public class BusinessLib extends BaseClass {

	//Currently storing in variables but we will not hardcode the xpath or send the environment variables through property file.
	
	public static  By xpath_GetStarted= By.xpath("//a[contains(text(),'Get Started')]");
	public static  By xpath_FirstName= By.xpath("//input[@id='first_name']");
	public static  By xpath_Email= By.xpath("//input[@id='email']");
	public static  By xpath_Next= By.xpath("//button[text()='Next']");
	public static  By xpath_QueryTextBox= By.xpath("//textarea[@id='queryTextbox']");
	public static  By xpath_Send= By.xpath("//button[text()='Send']");
	public static  By xpath_Submit= By.xpath("//button[text()='Submit' and @aria-label='Submit']");
	public static  By xpath_SubmitSuccess= By.xpath("//button/strong[text()='Submitted successfully']");
	public static  By xpath_WelcomeImage= By.xpath("//h3[small[contains(text(),'Welcome to Pizza Shoppe')]]/preceding-sibling::img");
	
	public static  By xpath_McPizzaOrdreBtn= By.xpath("//a[contains(text(),'McPizza order')]");
	public static  By xpath_SubmitBtn= By.xpath("//button[text()='Submit' and @aria-label='Submit']");
	public static  By xpath_ThickCrust= By.xpath("//div[text()='Thin Crust']/following-sibling::div//a[text()='Thick Crust']");
	public static  By xpath_OrderPlaced= By.xpath("//div/p[contains(text(),'CONGRATS ! ORDER PLACED .')]");
	public static  By xpath_Yes= By.xpath("//a[text()='Yes']");
	
	
	
	public  boolean LaunchUrl(String url)
	{
		boolean flag=false;
			try {
				driver.get(url);
				
				Assert.assertTrue(driver.findElement(xpath_WelcomeImage).isDisplayed());
					
				flag=true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return flag;
	}
	
	public  boolean Login(String firstName, String email)
	{

    		boolean flag =false;
			try {
				driver.findElement(xpath_WelcomeImage).click();
				driver.findElement(xpath_GetStarted).click();
				
				
				driver.switchTo().frame("avaamoIframe");
				driver.findElement(xpath_FirstName).sendKeys(firstName);
				driver.findElement(xpath_Email).sendKeys(email);
				
				
				driver.findElement(xpath_Next).click();
				
				flag= driver.findElement(xpath_QueryTextBox).isDisplayed();
				
				Assert.assertTrue(flag);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return flag;
		
    	
	}
	
	public String SendTextAndVerifyResponse(String text)
	{
		String value=null;
		
			try {
				driver.findElement(xpath_QueryTextBox).sendKeys(text);
				driver.findElement(xpath_Send).click();
				
				value= driver.findElement(By.xpath("//div[contains(@aria-label,'"+text+"')]/following-sibling::div//p")).getText();
				
				
				test.log(LogStatus.INFO,"Verify Response to text. Actual: "+value);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return value;
	}
	
	public void OrderPizzaThickCrust(String veg, String size, String type)
	{
	
		
		try {
			driver.findElement(xpath_McPizzaOrdreBtn).click();
			driver.findElement(By.xpath("//a[text()='"+veg+"']")).click();
			driver.findElement(By.xpath("//input[contains(@value,'"+type+"')]")).click();
			driver.findElement(xpath_SubmitBtn).click();
			
			Assert.assertTrue(driver.findElement(xpath_SubmitSuccess).isDisplayed());
			
			driver.findElement(xpath_ThickCrust).click();
			
			driver.findElement(By.xpath("//a[text()='"+size+"']")).click();
			
			driver.findElement(xpath_Yes).click();
			
			Assert.assertTrue(driver.findElement(xpath_OrderPlaced).isDisplayed());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
