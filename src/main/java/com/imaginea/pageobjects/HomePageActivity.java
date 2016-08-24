package com.imaginea.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

import java.util.List;

import org.openqa.selenium.By;

import com.imaginea.utils.UIUtility;

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
	String mobileElectronics = "//*[text()='Mobiles & Electronics']";
	String categoryName = "com.snapdeal.main:id/subCategoryTitleTextView";

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

	/**
	 * Select Category by Category Name
	 * 
	 * @param categoryName
	 */
	public void selectCategory(String categoryName) {
		UIUtility.clickElementusingClassName(driver, imageButton);
		String category = String.format(
				"//android.widget.TextView[@text='%s']", categoryName);
		waitForElementVisibility(driver, 30,
				driver.findElement(By.xpath(category)));
		UIUtility.clickElementusingXPath(driver, category);
	}

	/**
	 * Get List of Sub Category Items Under a Category Name
	 * 
	 * @param categoryName
	 */
	public List<String> getSubItemsList() {
		List<String> text = UIUtility.getListOfElementsByID(driver, categoryName);
		return text;
	}

	/**
	 * Selects a SubCategory Under a Category
	 * @param subCategoryName
	 */
	public void selectSubCategory(String subCategoryName) {
		String subCategory = String.format("//android.widget.TextView[@text='%s']", subCategoryName);
		UIUtility.clickElementusingXPath(driver, subCategory);
	}

}
