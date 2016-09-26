package com.imaginea.tests.nativeApp;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.imaginea.base.BaseTest;
import com.imaginea.pageobjects.nativeApp.HomePageActivity;

public class SnapdealTests extends BaseTest {
	@BeforeMethod
	public void beforeMethod() {
	driver.launchApp();
	}

	@Test
	public void loginAndLogOut() {
		HomePageActivity homePage = new HomePageActivity(driver);
		homePage.login();
		Assert.assertEquals(homePage.getErroMsg(), "Incorrect username or password");
	}

	
	@AfterMethod
	public void afterMethod() {
		driver.closeApp();
	}
}
