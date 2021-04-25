package com.store.events;

import org.openqa.selenium.WebDriver;

import com.store.objects.HomePageElements;
import com.store.utils.Elements;

public class HomePageEvents {

	WebDriver driver;
	Elements elements = new Elements();
	
	public HomePageEvents(WebDriver driver) {
		this.driver = driver;
	}

	public void goToSignInLink() {
		elements.getWebElement(driver, "XPATH", HomePageElements.AccountLink).click();
		elements.getWebElement(driver, "XPATH", HomePageElements.SignInLink).click();
	}

	public void goToRegisterLink() {
		elements.getWebElement(driver, "XPATH", HomePageElements.AccountLink).click();
		elements.getWebElement(driver, "XPATH", HomePageElements.RegisterLink).click();
	}
	
	public void goToCartLink() {
		elements.getWebElement(driver, "XPATH", HomePageElements.AccountLink).click();
		elements.getWebElement(driver, "XPATH", HomePageElements.MyCartLink).click();
	}
}
