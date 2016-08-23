package com.imaginea.pageobjects;

import org.openqa.selenium.By;

import com.imaginea.utils.UIUtility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class HomePageActivity extends UIUtility {

	By homeMenu = MobileBy.className("android.widget.TextView");
	public static String uname = "com.snapdeal.main:id/firstEmailEditText";
	String imageButton = "android.widget.ImageButton";
	String loginLink = "com.snapdeal.main:id/loggedUserEmail";
	String continueButton = "com.snapdeal.main:id/continuebtn";
	String password = "com.snapdeal.main:id/thirdEditText";
	String loginButton = "com.snapdeal.main:id/loginNewBtn";
	String errorMSG = "com.snapdeal.main:id/errorTextView";
	String searchBoxB = "com.snapdeal.main:id/search_text_view";
	String searchBoxA = "com.snapdeal.main:id/search_edit_text_autocomplete";
	String mobileRechargeLink = "com.snapdeal.main:id/mobileRechargeItem";

	public HomePageActivity(AppiumDriver driver) {
		super(driver);
		initPage(driver.findElement(homeMenu));
	}

	public void login() {
		UIUtility.clickElementusingClassName(driver, imageButton);
		UIUtility.clickElementusingID(driver, loginLink);
		UIUtility.enterTextusingID(driver, uname, "avinash.golla@yahoo.com");
		UIUtility.clickElementusingID(driver, continueButton);
		UIUtility.enterTextusingID(driver, password, "12345");
		UIUtility.clickElementusingID(driver, loginButton);

	}

	public String getErroMsg() {
		return wrongPasswordErrorMSG(errorMSG);
	}

	public String wrongPasswordErrorMSG(String errorMSG) {
		return UIUtility.getErrorMSG(driver, errorMSG);

	}

}
