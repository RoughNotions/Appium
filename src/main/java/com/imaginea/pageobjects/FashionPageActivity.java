package com.imaginea.pageobjects;

import io.appium.java_client.AppiumDriver;

import java.util.List;

import org.openqa.selenium.By;

import com.imaginea.utils.UIUtility;
/**
 * All Keyword of Fashion Page should be update here
 * @author krishnakumarnellore
 *
 */
public class FashionPageActivity extends UIUtility {

	private String fashionSubCategory = "com.snapdeal.main:id/subCategoryTitleTextView";

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

}
