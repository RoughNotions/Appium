package com.imaginea.pageobjects.nativeApp;

import java.util.List;

import org.openqa.selenium.By;

import com.imaginea.utils.UIUtility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class DailyNeedsPageActivity extends UIUtility {
	private String DailyNeedsSubCategory = "com.snapdeal.main:id/subCategoryTitleTextView";
	private String sortResourceId = "com.snapdeal.main:id/sort_by_text_view";
	private String productDisplay = "com.snapdeal.main:id/productDisplayPrice";
	private String productTitle = "com.snapdeal.main:id/productTitle";
	private String productDiscountPrice = "com.snapdeal.main:id/productDiscount";
	// String Productname = "Lakme Enrich Satins Lip Color, Shade P152, 4.3 G";
	private String Menucarticon = "com.snapdeal.main:id/menu_cart_icon";
	private String txtProductName = "com.snapdeal.main:id/txtProductName";
	private String txtCount = "com.snapdeal.main:id/txtCount";
	private String MinusButton = "com.snapdeal.main:id/btnMinus";
	private String startPrice = "com.snapdeal.main:id/filterTextStart";
	private String endPrice = "com.snapdeal.main:id/filterTextEnd";
	private String productDisplayPrice = "com.snapdeal.main:id/productDisplayPrice";
	private String Filter = "com.snapdeal.main:id/filter_by_text_view";

	String Productname = "Lakme Enrich Satins Lip Color, Shade P152, 4.3 G";

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
		return getListOfElementsByID(productDisplay);
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
	 * Get Product Display Price List
	 * 
	 * @return
	 */
	public List<String> getProductDisplayPriceList() {
		swipeDown();
		swipeDown();
		return getListOfElementsByID(productDisplayPrice);
	}

	/**
	 * Click on Apply Button
	 */
	public void clickApplyButton() {
		clickElementByText("Apply Filters");
		sleep(5000L);
	}

	public void Enterpincode() {
		sleep(5000L);
		driver.findElementById("com.snapdeal.main:id/pinCodeEditText_til").sendKeys("500034");
		sleep(5000L);
		clickElementByText("DONE");
		sleep(5000L);
	}

	public String getCartButtonText() {
		return driver.findElementById("com.snapdeal.main:id/addCartBUtton").getText();

	}

	/**
	 * Set Price Filter
	 * 
	 * @param sPrice
	 * @param ePrice
	 */
	public void setPriceFilter(String sPrice, String ePrice) {
		enterTextByID(startPrice, sPrice);
		enterTextByID(endPrice, ePrice);
		clickElementByText("Apply Filters");
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

	/**
	 * Get Product Name Added to cart list
	 * 
	 * @return
	 */
	public List<String> getCartProductNameList() {
		return getListOfElementsByID(txtProductName);
	}

	/**
	 * Get Count Of cart Product List
	 * 
	 * @return
	 */
	public List<String> getCartProductCountList() {
		return getListOfElementsByID(txtCount);
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

	public void SelectProduct() {
		clickElementByText(Productname);
		sleep(5000L);
	}

	public void clickoncart() {
		clickElementusingID("com.snapdeal.main:id/menu_cart_icon");
		sleep(5000L);
	}

	public void clickonMinus() {
		clickElementusingID(MinusButton);
		sleep(5000L);
	}

	/**
	 * Click on Apply Button
	 */
	public void clickApplyFiltersButton() {
		clickElementByText("Apply Filters");
	}

	public void clickonPopUpRemove() {
		clickElementByText("REMOVE");
	}

	public void clickOnFilter() {
		clickElementusingID(Filter);
		sleep(5000L);
	}
}
