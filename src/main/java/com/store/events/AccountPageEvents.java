package com.store.events;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;

import com.store.objects.AccountPageElements;
import com.store.utils.Elements;

public class AccountPageEvents {
	
	WebDriver driver;
	Elements element = new Elements();
	
	public AccountPageEvents(WebDriver driver){
		this.driver = driver;
	}
	
	public void verifyAccountPage(){
		
		Assert.assertEquals(element.getWebElement(driver, "XPATH", AccountPageElements.titleAccountSection).getText(),"CREATE AN ACCOUNT","Test Passed");
		
	}
	public void fillOutAccount() {
		element.getWebElement(driver, "ID", AccountPageElements.firstname).sendKeys("Roberto");
		element.getWebElement(driver, "ID", AccountPageElements.middlename).sendKeys("C.");
		element.getWebElement(driver, "ID", AccountPageElements.lastname).sendKeys("Rojas");
		element.getWebElement(driver, "ID", AccountPageElements.email).sendKeys("drojas@gmail.com");
		element.getWebElement(driver, "ID", AccountPageElements.password).sendKeys("drojas@gmail.com");
		element.getWebElement(driver, "ID", AccountPageElements.repassword).sendKeys("drojas@gmail.com");
		element.getWebElement(driver, "ID", AccountPageElements.newsletter).click();
	}
	
	public void submitNewAccount() {
		element.getWebElement(driver, "XPATH", AccountPageElements.btnRegister).submit();
	}

}
