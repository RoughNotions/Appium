package com.imaginea.pageobjects;

import io.appium.java_client.AppiumDriver;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.imaginea.utils.UIUtility;

/**
 * All Keyword of Fashion Page should be update here
 * 
 * @author krishnakumarnellore
 *
 */
public class FashionPageActivity extends UIUtility {

	private String fashionSubCategory = "com.snapdeal.main:id/subCategoryTitleTextView";
	private String sortResourceId = "com.snapdeal.main:id/sort_by_radio_button";
	private String productDiscount = "com.snapdeal.main:id/productDiscount";
	private String flipper = "android.widget.ViewFlipper";

	public FashionPageActivity(AppiumDriver driver) {
		super(driver);
	}

	/**
	 * Select Sub Category of Fashion
	 * 
	 * @param subCategory
	 */
	public void selectSubCategory(String subCategory) {
		clickElementByText(driver, subCategory);
	}

	/**
	 * Get Sub Category List
	 * 
	 * @return
	 */
	public List<String> getSubCategoryList() {
		return getListOfElementsByID(driver, fashionSubCategory);
	}

	/**
	 * Get List of Sort Category
	 * 
	 * @return
	 */
	public List<String> getSortCategoryList() {
		return getListOfElementsByID(driver, sortResourceId);
	}

	/**
	 * Get Product Discount List
	 * 
	 * @return
	 */
	public List<String> getProductDiscountList() {		
		driver.findElementByClassName(flipper).click();
		sleep(1000L);
		driver.findElementByClassName(flipper).click();
		sleep(1000L);
		driver.findElementByClassName(flipper).click();
		return getListOfElementsByID(driver, productDiscount);
	}
}
