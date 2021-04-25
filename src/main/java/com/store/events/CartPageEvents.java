package com.store.events;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;



import com.store.objects.CartPageElements;
import com.store.utils.Elements;

public class CartPageEvents {
	
	WebDriver driver;
	Elements element = new Elements();
	
	public CartPageEvents(WebDriver driver){
		this.driver = driver;
	}
	
	public void starEmptyCart() {
		element.getWebElement(driver, "XPATH", CartPageElements.clickHere);
	}

	public void addtoCart() throws InterruptedException {
		
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(1000);
        element.getWebElement(driver, "XPATH", CartPageElements.items_1).click();
		Thread.sleep(1000);
		element.getWebElement(driver, "XPATH", CartPageElements.item_1_color).click();
		element.getWebElement(driver, "XPATH", CartPageElements.item_1_size).click();
		element.getWebElement(driver, "ID", CartPageElements.item_1_qty).sendKeys("2");
		element.getWebElement(driver, "XPATH", CartPageElements.addtoCart).click();
		Thread.sleep(1000);
		element.getWebElement(driver, "XPATH", CartPageElements.toCheckout).click();
		Thread.sleep(1000);
		element.getWebElement(driver, "XPATH", CartPageElements.toContinue).click();
		
	}
	
	
	
}
