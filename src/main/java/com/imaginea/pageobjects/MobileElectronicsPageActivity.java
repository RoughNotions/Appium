package com.imaginea.pageobjects;

import java.util.ArrayList;
import java.util.Collection;
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
	String gameTypes = "com.snapdeal.main:id/price_range_text";
	String gameItems = "com.snapdeal.main:id/txvProductItemTitle";
	String bestDeals = "com.snapdeal.main:id/tysProductItemTitle";
	String trimmersPrice = "com.snapdeal.main:id/tysProductItemTitle";
	String greatDeals = "com.snapdeal.main:id/price_range_text";
	String moreLink = "//android.widget.TextView[text()='More']";
	String applianceItems = "com.snapdeal.main:id/txvProductItemTitle";
	String tabletTypes = "com.snapdeal.main:id/tysProductItemTitle";
	String tabletItems = "com.snapdeal.main:id/txvProductItemTitle";
	String osText = "com.snapdeal.main:id/price_range_text";
	String priceStore = "com.snapdeal.main:id/price_range_text";

	public MobileElectronicsPageActivity(AppiumDriver driver) {
		super(driver);
		sleep(5000L);
		initPage(driver.findElement(homeMenu));
	}

	public void navigateToBackPage() {
		driver.navigate().back();
	}

	public String getPageTitle(String subCategoryName) {
		String category = String.format("//android.widget.TextView[@text='%s']", subCategoryName);
		UIUtility.waitForElementVisibility(driver, 60, driver.findElementByXPath(category));
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
		UIUtility.waitForElementVisibility(driver, 60, driver.findElementById(mobileByTypes));
		List<String> text = UIUtility.getListOfElementsByID(driver, mobileByTypes);
		return text;
	}

	public List<String> getAllMobilesByPicks() {
		driver.scrollToExact("Top Picks");
		List<String> text = UIUtility.getListOfElementsByID(driver, mobileByPicks);
		return text;
	}

	public List<String> getAllGameItems() {
		List<String> text = UIUtility.getListOfElementsByID(driver, gameItems);
		List<String> ftext = new ArrayList<String>();
		for (int i = 0; i < 5; i++)
			ftext.add(text.get(i));
		return ftext;
	}

	public List<String> getAllGameTypes() {
		driver.scrollTo("Play Games with consoles");

		List<String> text = UIUtility.getListOfElementsByID(driver, gameTypes);
		return text;
	}

	public List<String> getAllBestDeals() {
		driver.scrollToExact("Limited Period Offer");
		List<String> text = UIUtility.getListOfElementsByID(driver, bestDeals);
		return text;
	}

	public List<String> getAllApplianceItems() {
		List<String> text = UIUtility.getListOfElementsByID(driver, applianceItems);
		return text;
	}

	private void clickMoreLink() {
		UIUtility.clickElementusingXPath(driver, moreLink);
	}

	public List<String> getGreatDeals() {
		driver.scrollTo("Great Deals");
		List<String> text = UIUtility.getListOfElementsByID(driver, greatDeals);
		return text;
	}

	public List<String> getAllTrimmersByPrice() {
		driver.scrollToExact("Trimmers By Price");
		List<String> text = UIUtility.getListOfElementsByID(driver, trimmersPrice);
		return text;
	}

	public List<String> getTabletTypes() {
		List<String> text = UIUtility.getListOfElementsByID(driver, tabletTypes);
		return text;
	}

	public List<String> getTabletItems() {
		List<String> text = UIUtility.getListOfElementsByID(driver, tabletItems);
		return text;
	}

	public List<String> getPriceStore() {
		driver.scrollTo("20,000 and Above");
		List<String> text = UIUtility.getListOfElementsByID(driver, priceStore);
		return text;
	}

	public List<String> getOS() {
		driver.scrollTo("Shop By Operating System");
		List<String> text = UIUtility.getListOfElementsByID(driver, osText);
		return text;
	}
}
