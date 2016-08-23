package com.imaginea.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import com.imaginea.utils.UIUtility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class MobileElectronicsPageActivity extends UIUtility {

	By homeMenu = MobileBy.className("android.widget.TextView");
	String title = "android.widget.TextView";
	String mobileElectronics = "//*[text()='Mobiles & Electronics']";
	String mobileByTypes = "com.snapdeal.main:id/tysProductItemTitle";
	String mobileByPrice = "com.snapdeal.main:id/txvProductItemTitle";
	String mobileByPicks = "com.snapdeal.main:id/price_range_text";

	public MobileElectronicsPageActivity(AppiumDriver driver) {
		super(driver);
		initPage(driver.findElement(homeMenu));
	}

	public void navigateToBackPage() {
		driver.navigate().back();
	}

	public String getPageTitle(String subCategoryName) {
		String category = String.format("//android.widget.TextView[@text='%s']", subCategoryName);
		return driver.findElementByXPath(category).getText();

	}

	public List<String> getAllMobilesByPriceRange() {
		List<String> text = UIUtility.getListOfElementsByID(driver, mobileByPrice);
		List<String> fList = new ArrayList<String>();
		for (int i = 0; i < 6; i++) {
			fList.add(text.get(i));

		}
		return fList;
	}

	public List<String> getAllMobilesByPriceType() {
		List<String> text = UIUtility.getListOfElementsByID(driver, mobileByTypes);
		return text;
	}

	public List<String> getAllMobilesByPicks() {
		driver.scrollToExact("Top Picks");
		List<String> text = UIUtility.getListOfElementsByID(driver, mobileByPicks);
		return text;
	}
}
