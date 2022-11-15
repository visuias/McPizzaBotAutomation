package com.mcpizza.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mcpizza.base.BaseClass;



public class McPizzaTests extends BaseClass {
    @Test
    public void addProductToCart() throws Exception {
    	Reporter.log("Step 1: Launch Mc Pizza url ");
    	driver.get("https://c6.avaamo.com/web_channels/c767654d-6709-43f6-bb0c-ce1d2c559f6a/demo.html?banner=true&demo=true&banner_text=%20&banner_title=This%20is%20how%20the%20chat%20agent%20shows%20up");
     
    	
    	Assert.assertTrue(driver.findElement(By.xpath("//h3[small[contains(text(),'Welcome to Pizza Shoppe')]]/preceding-sibling::im")).isDisplayed());
    	
    	Reporter.log("*** Mc Pizza url launched successfully ***");
    	
    }
}
