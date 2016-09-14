package com.imaginea.pageobjects;

import java.util.List;

import org.openqa.selenium.By;

import com.imaginea.utils.UIUtility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class DailyNeedsPageActivity extends UIUtility {
	private String DailyNeedsSubCategory = "com.snapdeal.main:id/subCategoryTitleTextView";
	private String sortResourceId = "com.snapdeal.main:id/sort_by_radio_button";
	private String productDiscount = "com.snapdeal.main:id/productDiscount";
	private String productTitle = "com.snapdeal.main:id/productTitle";
	private String productDiscountPrice = "com.snapdeal.main:id/productDiscount";

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

	/**
	 * To click field by Text
	 * 
	 * @param title
	 */
	public void selectCategoryByText(String title) {
		String category = String.format("//android.widget.TextView[@text='%s']", title);
		waitForElementVisibility(30, driver.findElement(By.xpath(category)));
		clickElementusingXPath(category);
		sleep(5000L);
	}

	/**
	 * Click on Apply Button
	 */
	public void clickApplyButton() {
		clickElementByText("APPLY");
		sleep(5000L);
	}

	/**
	 * Get Product Title List
	 * 
	 * @return
	 */
	public List<String> getProductTitleList() {
		swipeDown();
		return getListOfElementsByID(productTitle);

	}

	/**
	 * Get Product Discount List
	 * 
	 * @return
	 */
	public List<String> getProductDiscountPriceList() {
		swipeDown();
		return getListOfElementsByID(productDiscountPrice);
	}

	public void ClickOnMakeUp() {
		sleep(10000L);
		clickElementByText("Makeup");
		sleep(5000L);
	}

	public void ClickOnSortPopularity() {
		sleep(10000L);
		clickElementByText("Sort\nPopularity");
		sleep(5000L);
	}

	public void ClickOnProductDiscount() {
		sleep(5000L);
		clickElementByText("Discount");
		sleep(5000L);
	}

	public void SelectPriceLowToHigh() {
		clickElementByText("Price Low To High");
		sleep(5000L);
	}

	public void SelectPriceHighToLow() {
		clickElementByText("Price High To Low");
		sleep(5000L);
	}

	public void SelectNewArrival() {
		clickElementByText("New Arrival");
		sleep(5000L);
	}

	public String getElementTextByIndex(int num) {
		sleep(15000L);
		return driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().index(%d)", num)))
				.getText();
	}
}
