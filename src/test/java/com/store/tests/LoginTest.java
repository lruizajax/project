package com.store.tests;

import org.testng.annotations.Test;

import com.store.events.HomePageEvents;
import com.store.events.LoginPageEvents;
import com.store.util.BaseTest;


public class LoginTest extends BaseTest {

	@Test
	public void SingInOnStore() {

		HomePageEvents homePageEvents = new HomePageEvents(getDriver());
		homePageEvents.goToSignInLink();

		LoginPageEvents loginPageEvents = new LoginPageEvents(getDriver());
		loginPageEvents.verifyLoginPage();

		loginPageEvents.inputCredentialsAndSubmit();

	}
	
	public void Logout() {
		System.out.println("logout of store");
	}
	
	public void SingInOnStoreFail() {
		
	}
	
	public void SingInOnStoreSkipped() {
		
	}
}
