package com.store.events;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;

import com.store.objects.LoginPageElements;
import com.store.utils.Elements;

public class LoginPageEvents {
	
	WebDriver driver;
	Elements element = new Elements();
	
	public LoginPageEvents(WebDriver driver){
		this.driver = driver;
	}
	
	public void verifyLoginPage(){
		
		Assert.assertEquals(element.getWebElement(driver, "XPATH", LoginPageElements.titleLoginSection).getText(),"ALREADY REGISTERED?","Test Passed");
		
	}
	
	public void inputCredentialsAndSubmit() {
		element.getWebElement(driver, "ID", LoginPageElements.email).sendKeys("lruizabcde@gmail.com");
		element.getWebElement(driver, "ID", LoginPageElements.password).sendKeys("lima1234");
		element.getWebElement(driver, "ID", LoginPageElements.buttonLogin).submit();
	}

}
