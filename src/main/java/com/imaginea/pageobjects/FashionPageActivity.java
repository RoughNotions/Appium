package com.imaginea.pageobjects;

import io.appium.java_client.AppiumDriver;

import java.util.List;

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
		swipeDown(driver);
		return getListOfElementsByID(driver, productDiscount);
	}
}
