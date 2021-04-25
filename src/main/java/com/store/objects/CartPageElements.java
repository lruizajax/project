package com.store.objects;

public interface CartPageElements {

	String clickHere = "//a[text()='here']";
	
	String items_1 = "//a[text()='Lafayette Convertible Dress']";
	String item_1_color = "//*[@id=\"swatch27\"]/span[1]/img";
	String item_1_size = "//*[@id=\"swatch73\"]/span[1]";
	String item_1_qty = "qty";
	
	String addtoCart = "//*[@id=\"product_addtocart_form\"]/div[3]/div[6]/div[2]/div[2]/button";
	
	String toCheckout = "/html/body/div/div[2]/div[2]/div/div/div[2]/div[1]/ul/li/button/span/span";
	
	String toContinue = "/html/body/div/div[2]/div[2]/div/div[1]/ol/li[1]/div[2]/div/div[1]/div/button/span/span";
	
}
