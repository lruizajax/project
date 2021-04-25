package com.store.tests;

import org.testng.annotations.Test;

import com.store.events.ProductPageEvents;
import com.store.util.BaseTest;


public class SearchTest extends BaseTest {

	@Test
	public void SearchProductInStore() {


		ProductPageEvents productPageEvents = new ProductPageEvents(getDriver());
		productPageEvents.TypeProduct();
		productPageEvents.SubmitSearch();
		productPageEvents.getItemsOnSearch();
	}
}
