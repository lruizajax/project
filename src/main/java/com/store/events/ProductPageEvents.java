package com.store.events;

import org.openqa.selenium.WebDriver;



import com.store.objects.ProductPageElements;
import com.store.utils.Elements;

public class ProductPageEvents {
	
	WebDriver driver;
	Elements element = new Elements();
	
	public ProductPageEvents(WebDriver driver){
		this.driver = driver;
	}
	
	public void TypeProduct() {
		element.getWebElement(driver, "ID", ProductPageElements.inputsearch).sendKeys("FRENCH");
	}

	public void SubmitSearch() {
		element.getWebElement(driver, "XPATH", ProductPageElements.btnsearch).submit();
	}
	
	public void getItemsOnSearch() {
		element.getListWebElements(driver, "CLASSNAME", ProductPageElements.itemsFounded);
		
	}
	
}
