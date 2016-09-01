package com.imaginea.pageobjects;

import java.util.List;

import io.appium.java_client.AppiumDriver;

import com.imaginea.utils.UIUtility;

public class DailyNeedsPageActivity extends UIUtility {
	private String  DailyNeedsSubCategory = "com.snapdeal.main:id/subCategoryTitleTextView";
	private String sortResourceId = "com.snapdeal.main:id/sort_by_radio_button";
	private String productDiscount = "com.snapdeal.main:id/productDiscount";
	public DailyNeedsPageActivity(AppiumDriver driver) {
		super(driver);
		
	} 

	/**
	 * Select Sub Category of DailyNeeds
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
		return getListOfElementsByID(driver, DailyNeedsSubCategory);
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
		swipeDown(driver);
		return getListOfElementsByID(driver, productDiscount);
	}

}
