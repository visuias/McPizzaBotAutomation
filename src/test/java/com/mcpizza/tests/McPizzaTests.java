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
		
    	BusinessLib bLib=new BusinessLib();
    	bLib.LaunchUrl(url);
    	
    	bLib.Login("Viswa", "viswa@gmail.com");
    	
    	bLib.SendTextAndVerifyResponse("How are you?", "Couldn't be better. Living in the virtual moment. Thanks.");
    	
    	bLib.SendTextAndVerifyResponse("where do you live?", "I live in cyberspace, for now.");
    	bLib.SendTextAndVerifyResponse("Are you a robot?", "Yes I am! Did I have you fooled?");
    	bLib.SendTextAndVerifyResponse("Where did you get your name?", "I am sorry. I don't have an answer for that.");
    	bLib.SendTextAndVerifyResponse("I want to order biryani", "Here is an option I can help with, based on what I understood. Can you confirm?");
    	
    	
    }
	
	@Test
    public void OrderVegThickCrustPizza() throws Exception {
    	
		
    	BusinessLib bLib=new BusinessLib();
    	bLib.LaunchUrl(url);
    	
    	bLib.Login("Viswa", "viswa@gmail.com");
    	
    	bLib.SendTextAndVerifyResponse("Pizza", "Here is an option I can help with, based on what I understood. Can you confirm?");
    	
    	bLib.OrderPizzaThickCrust("veg", "Small", "cheese");
    }
}
