package com.store.tests;

import org.testng.annotations.Test;

import com.store.events.AccountPageEvents;
import com.store.events.HomePageEvents;
import com.store.util.BaseTest;


public class AccountTest extends BaseTest {

	@Test
	public void RegisterNewAccount() {

		HomePageEvents homePageEvents = new HomePageEvents(getDriver());
		homePageEvents.goToRegisterLink();

		AccountPageEvents accountPageEvents = new AccountPageEvents(getDriver());
		accountPageEvents.verifyAccountPage();

		accountPageEvents.fillOutAccount();
		accountPageEvents.submitNewAccount();
	}
}
