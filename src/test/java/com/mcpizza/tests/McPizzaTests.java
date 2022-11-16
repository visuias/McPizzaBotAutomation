package com.mcpizza.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mcpizza.base.BaseClass;
import com.mcpizza.businesslib.BusinessLib;
import com.mcpizza.lib.Utils;
import com.mongodb.util.Util;
import com.relevantcodes.extentreports.LogStatus;



public class McPizzaTests extends BaseClass {
	
	public static String url ="https://c6.avaamo.com/web_channels/c767654d-6709-43f6-bb0c-ce1d2c559f6a/demo.html?banner=true&demo=true&banner_text=%20&banner_title=This%20is%20how%20the%20chat%20agent%20shows%20up";
	
	@Test
    public void ValidateIrrelavantQuestions() throws Exception {
		
		//Variable initialization:
		String response1="Couldn't be better. Living in the virtual moment. Thanks.";
    	String response2="I live in cyberspace, for now.";
    	String response3="Yes I am! Did I have you fooled?";
    	String response4="I am sorry. I don't have an answer for that.";
    	String response5="Here is an option I can help with";
    	
    	BusinessLib bLib=new BusinessLib();
    	
    	//launch url
    	if(bLib.LaunchUrl(url))
		{
    		test.log(LogStatus.PASS,"Mc Pizza url launched successfully  ");
		}
		else
		{
			test.log(LogStatus.FAIL,"Mc Pizza url launch Failed");
		}
    	//Login
    	if(bLib.Login("Viswa", "viswa@gmail.com"))
		{
			test.log(LogStatus.PASS,"Logged in successfully");
		}
		else
		{
			test.log(LogStatus.FAIL,"LogIn Failed");
		}
    	
    	
    	//Verify different responses
    	String actual1=bLib.SendTextAndVerifyResponse("How are you?");
    	if(actual1.equalsIgnoreCase(response1))
		{
    		test.log(LogStatus.PASS,"Expected response "+response1+" and Actual reponse is matched.");
		}
		else
		{
			test.log(LogStatus.FAIL,"Expected response "+response1+" and Actual reponse"+actual1+" does not match.");
		}
    	
    	String actual2=bLib.SendTextAndVerifyResponse("where do you live?");
    	if(actual2.equalsIgnoreCase(response2))
		{
    		test.log(LogStatus.PASS,"Expected response "+response2+" and Actual reponse is matched.");
		}
		else
		{
			test.log(LogStatus.FAIL,"Expected response "+response2+" and Actual reponse"+actual2+" does not match.");
		}
    	
    
    	String actual4=bLib.SendTextAndVerifyResponse("Where did you get your name?");
    	if(actual4.equalsIgnoreCase(response4))
		{
    		test.log(LogStatus.PASS,"Expected response "+response4+" and Actual reponse is matched.");
		}
		else
		{
			test.log(LogStatus.FAIL,"Expected response "+response4+" and Actual reponse"+actual4+" does not match.");
		}
    	
    	String actual5=bLib.SendTextAndVerifyResponse("I want to order biryani");
    	if(actual5.contains(response5))
		{
    		test.log(LogStatus.PASS,"Expected response "+response5+" and Actual reponse is matched.");
		}
		else
		{
			test.log(LogStatus.FAIL,"Expected response "+response5+" and Actual reponse"+actual5+" does not match.");
		}
    }
	
	@Test
    public void OrderVegThickCrustPizza() throws Exception {
    	
		String response= "Here is an option I can help with";
    	BusinessLib bLib=new BusinessLib();
    	//launch url
    	if(bLib.LaunchUrl(url))
		{
    		test.log(LogStatus.PASS,"Mc Pizza url launched successfully  ");
		}
		else
		{
			test.log(LogStatus.FAIL,"Mc Pizza url launch Failed");
		}
    	//Login
    	if(bLib.Login("Viswa", "viswa@gmail.com"))
		{
			test.log(LogStatus.PASS,"Logged in successfully");
		}
		else
		{
			test.log(LogStatus.FAIL,"LogIn Failed");
		}
    	
    	
    	//Verify Response
    	if(bLib.SendTextAndVerifyResponse("Pizza").contains(response))
		{
    		test.log(LogStatus.PASS,"Expected response "+response+" and Actual reponse is matched.");
		}
		else
		{
			test.log(LogStatus.FAIL,"Expected response "+response+" and Actual reponse does not match.");
		}
    	
    	//Order Pizza
    	bLib.OrderPizzaThickCrust("veg", "Small", "cheese");
    	test.log(LogStatus.PASS,"Ordered Veg Cheese Pizza successfully");
    }
}
