package com.imaginea.tests.web;

import org.testng.annotations.Test;

import com.imaginea.base.BaseTest;

public class HomeAndLivingTests extends BaseTest{

	@Test
	public void basic(){
		driver.get("https://www.snapdeal.com");
	}
}
