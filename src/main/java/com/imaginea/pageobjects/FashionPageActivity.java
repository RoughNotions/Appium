package com.imaginea.pageobjects;

import io.appium.java_client.AppiumDriver;

import java.util.List;

import org.openqa.selenium.By;

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
	private String productTitle = "com.snapdeal.main:id/productTitle";
	private String startPrice = "com.snapdeal.main:id/filterTextStart";
	private String endPrice = "com.snapdeal.main:id/filterTextEnd";
	private String productDisplayPrice = "com.snapdeal.main:id/productDisplayPrice";
	private String productDiscountPrice = "com.snapdeal.main:id/productDiscount";
	private String imageId="com.snapdeal.main:id/imageView";
	private String menuCartIcon="com.snapdeal.main:id/menu_cart_icon";
	private String txtProductName ="com.snapdeal.main:id/txtProductName";
	private String txtCount="com.snapdeal.main:id/txtCount";

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
	
	/**
	 * To click field by Text
	 * 
	 * @param title
	 */
	public void selectCategoryByText(String title){
			String category = String.format(
					"//android.widget.TextView[@text='%s']", title);
			waitForElementVisibility(driver, 30,
					driver.findElement(By.xpath(category)));
			UIUtility.clickElementusingXPath(driver, category);
	}
	
	/**
	 * Click on Apply Button
	 */
	public void clickApplyButton(){		
		clickElementByText(driver, "APPLY");
	}
	
	/**
	 * Get Product Title List
	 * 
	 * @return
	 */
	public List<String> getProductTitleList() {
		swipeDown(driver);
		return getListOfElementsByID(driver, productTitle);
	}	

	/**
	 * Set Price Filter
	 * @param sPrice
	 * @param ePrice
	 */
	public void setPriceFilter(String sPrice ,String ePrice){
		enterTextByID(driver, startPrice,sPrice);
		enterTextByID(driver, endPrice,ePrice);
		clickElementByText(driver, "Apply Filters");
	}

	/**
	 * Get Product Display Price List
	 * 
	 * @return
	 */
	public List<String> getProductDisplayPriceList() {
		swipeDown(driver);
		return getListOfElementsByID(driver, productDisplayPrice);
	}
	
	
	/**
	 * Get Product Discount List
	 * 
	 * @return
	 */
	public List<String> getProductDiscountPriceList() {
		swipeDown(driver);
		return getListOfElementsByID(driver, productDiscountPrice);
	}
	
	/**
	 * Zoom Image by single tap
	 */
	public void zoomImage(){
		zoomImageById(driver, imageId);
	}
	
	/**
	 * Click On Menu Cart Icon
	 */
	public void clickMenuCartIcon(){
		clickElementusingID(driver, menuCartIcon);
	}
	
	/**
	 * Get Product Name Added to cart list
	 * @return
	 */
	public List<String> getCartProductNameList(){
		return getListOfElementsByID(driver, txtProductName);
	}
	
	/**
	 * Get Count Of cart Product List
	 * @return
	 */
	public List<String> getCartProductCountList(){
		return getListOfElementsByID(driver, txtCount);
	}
}
