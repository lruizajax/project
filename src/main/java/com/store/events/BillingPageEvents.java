package com.store.events;

import org.openqa.selenium.WebDriver;


import com.store.objects.BillingPageElements;
import com.store.utils.Elements;

public class BillingPageEvents {
	
	WebDriver driver;
	Elements element = new Elements();
	
	public BillingPageEvents(WebDriver driver){
		this.driver = driver;
	}
	
	public void fillOutBilling() {
		element.getWebElement(driver, "ID", BillingPageElements.firstname).sendKeys("Roberto");
		element.getWebElement(driver, "ID", BillingPageElements.middlename).sendKeys("C.");
		element.getWebElement(driver, "ID", BillingPageElements.lastname).sendKeys("Rojas");
		element.getWebElement(driver, "ID", BillingPageElements.email).sendKeys("drojas@gmail.com");
		element.getWebElement(driver, "ID", BillingPageElements.address_1).sendKeys("drojas@gmail.com");
	}
	
}
