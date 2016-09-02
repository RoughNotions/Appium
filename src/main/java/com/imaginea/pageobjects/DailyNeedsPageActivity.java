package com.imaginea.pageobjects;

import io.appium.java_client.AppiumDriver;

import java.util.List;

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
		clickElementByText(subCategory);
	}
	/**
	 * Get Sub Category List
	 * 
	 * @return
	 */
	public List<String> getSubCategoryList() {
		return getListOfElementsByID(DailyNeedsSubCategory);
	}
	/**
	 * Get List of Sort Category
	 * 
	 * @return
	 */
	public List<String> getSortCategoryList() {
		return getListOfElementsByID(sortResourceId);
	}

	/**
	 * Get Product Discount List
	 * 
	 * @return
	 */
	public List<String> getProductDiscountList() {
		swipeDown();
		return getListOfElementsByID(productDiscount);
	}

}
