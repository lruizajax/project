package com.store.tests;

import org.testng.annotations.Test;

import com.store.events.CartPageEvents;
import com.store.events.HomePageEvents;
import com.store.util.BaseTest;


public class CartTest extends BaseTest {

	@Test
	public void AddToCartItem() throws InterruptedException {

		//HomePageEvents homePageEvents = new HomePageEvents(getDriver());
		//homePageEvents.goToCartLink();
		
		CartPageEvents cartPageEvents = new CartPageEvents(getDriver());
		//cartPageEvents.starEmptyCart();
		cartPageEvents.addtoCart();
		
	}
}
