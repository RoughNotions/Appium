package com.imaginea.pageobjects;

import java.util.List;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.android.AndroidDriver;

import com.imaginea.utils.UIUtility;

public class HomeAndLivingPageActivity extends UIUtility {
	private String subCategories = "com.snapdeal.main:id/subCategoryTitleTextView";
	private String shopNowButton = "com.snapdeal.main:id/shop_now_button";
	public HomeAndLivingPageActivity(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public List<String> getSubCategoryList() {
		return getListOfElementsByID(driver, subCategories);
	}
	
	/**
	 * Select Sub Category of Home And Living  
	 * 
	 * @param subCategory
	 */
	public void selectSubCategory(String subCategory) {
		clickElementByText(driver, subCategory);
	}

	public List<String> getProductTitles(){
		List<String> titles=getTitles(driver,1);
		boolean bFlag=false;
		if(titles.contains("More")){
			bFlag=true;
			clickElementByText(driver,"More");
			UIUtility.sleep(5000l);
		}
		driver.swipe(0, 788, 0, 250, 3000);
		
		while(bFlag){
			titles=getTitles(driver,1);
			if(titles.contains("Less")){
				break;
			}else if(titles.contains("More")){
				clickElementByText(driver,"More");
				UIUtility.sleep(5000l);
				titles=getTitles(driver,1);
			}
		}
		return titles;
	}
	
	public boolean verifyACategoryFromList(List<String> categories, String category){
		if(categories.contains(category)){
			return true;
		}
		return false;
	}
	
	public List<String> getProductsTitles(){
		List<String> titles=getTitles(driver,1);
		System.out.println(titles);
		return titles;
	}
}
