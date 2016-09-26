package com.imaginea.pageobjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;

import com.imaginea.utils.UIUtility;

public class MaterialMainActivity   extends UIUtility{

	String productCount_Id="com.snapdeal.main:id/numberOfProducts";
	String categoryTitleTxt ="//*[@resource-id='com.snapdeal.main:id/categoryTitleTxt' and @index='1']";
	String categoryList="//android.widget.ListView[@resource-id='com.snapdeal.main:id/categoryList']/android.widget.LinearLayout/android.widget.LinearLayout";
	String shortListButton="//android.widget.TextView[@resource-id='com.snapdeal.main:id/collections_tab']";
	String resultslabel="//android.widget.TextView[@resource-id='com.snapdeal.main:id/total_result_text_view']";
	
	String shortListIcon="//android.widget.TextView[@resource-id='com.snapdeal.main:id/spell_check_partial_text_view']/../following-sibling::android.widget.FrameLayout[%d]/android.widget.RelativeLayout[@resource-id='com.snapdeal.main:id/product_grid_mainLayout']/android.widget.FrameLayout[@resource-id='com.snapdeal.main:id/productHeart']";
	String shortListStatus="//android.widget.TextView[@resource-id='com.snapdeal.main:id/spell_check_partial_text_view']/../following-sibling::android.widget.FrameLayout[%d]/android.widget.RelativeLayout[@resource-id='com.snapdeal.main:id/product_grid_mainLayout']/android.widget.FrameLayout[@resource-id='com.snapdeal.main:id/productHeart']/android.widget.ImageView";
	String shortListCount="//android.widget.TextView[contains(@text,'Shortlist')]";
	public MaterialMainActivity(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public boolean verifyProductCountHeading(int count){
		String textMesg=getTextMSG(productCount_Id);
		if(textMesg.equals(count+" Product(s)")){
			return true;
		}
		return false;
	}
	
	public String getCategoryName(){
		return getTextUsingXpath(categoryTitleTxt);
	}
	public int getCategoryListCount(){
		List<WebElement> list=driver.findElementsByXPath(categoryList);
		return list.size();
	}
	
	public int getSumofCategories(){
		List<AndroidElement> findElementsByXPath = driver.findElementsByXPath(categoryList);
		int count=0;
		for(AndroidElement  element :findElementsByXPath){
			count=count+Integer.parseInt(element.findElementByXPath("//android.widget.TextView[@resource-id='com.snapdeal.main:id/count']").getText().replaceAll("\\D",""));
		}
		return count;
	}
	
	public boolean verifySumOfCategories(int count){
		if(getSumofCategories()==count){
			return true;
		}
		return false;
	}
	
	public List<AndroidElement> getSubCategoriesList(){
		List<AndroidElement> findElementsByXPath = driver.findElementsByXPath(categoryList);
		return findElementsByXPath;
	}
	public String getRandomSubCategoryName(List<AndroidElement> androidElements,int i){
		String productCategoryName=androidElements.get(i).findElementByXPath("//android.widget.TextView[@resource-id='com.snapdeal.main:id/childTitle']").getText();
		return productCategoryName;
	}
	
	public int getRandomSubCategoryCount(List<AndroidElement> androidElements,int i){
		int value=Integer.parseInt(androidElements.get(i).findElementByXPath("//android.widget.TextView[@resource-id='com.snapdeal.main:id/count']").getText().replaceAll("\\D",""));
		return value;
	}
	
	public void clickApplyFilters(){
		clickElementByText("Apply Filters"); 
		sleep(5000l);
	}

	public void tapOnProduct(String description){
		clickElementByText(description);
	}

	public void navigateToHomePage(){
		tapOnQuickAccessMenu(); 
		tapOnHomeOption();
	}
	
	public void tapOnHomeOption(){
		clickElementByText("Home"); 
	}
	
	public void tapOnQuickAccessMenu(){
		tapElementByDescription("Quick Access"); 
	}
	
	public void tapOnSettings(){
		clickElementByText("Settings"); 
	}
	public void clickShortListatBottom(){
		clickElementusingXPath(shortListButton);
	}
	
	public String getTextInResultsSection(){
		return getTextUsingXpath(resultslabel);
	}
	
	public boolean verifyTextInResultsSection(int productCount){
		String actual=getTextInResultsSection();
		if(actual.equals("Showing "+productCount+" results")){
			return true;
		}
		return false;
	}
	public String getTextInShortListOption(){
		return getTextUsingXpath(shortListCount);
	}
	public int getShortListedCount(){
		String text=getTextInShortListOption();
		text=text.replaceAll("\\D", "");
		if(text.trim().length()>0){
			return Integer.parseInt(text);
		}else{
			return 0;
		}	
	}
	
	public void tapShortListOptionInMenu(){
		clickElementusingXPath(shortListCount);
	}
	public void shortListAProduct(int productCount){
		for(int i=1;i<=productCount;i++){
		clickElementusingXPath(String.format(shortListIcon,i));
		}
	}
	
	public boolean verifyShortliststatus(int productCount){
		for(int i=1;i<=productCount;i++){
			if(getElementCountUsingXPath(String.format(shortListStatus,i))!=2){
				System.out.println(i+"Item is not shortlisted ");
				return false;
			}
		}
	return true;
	}
	
	public boolean statusOfUnShortListedProducts(int productCount){
		for(int i=1;i<=productCount;i++){
			if(getElementCountUsingXPath(String.format(shortListStatus,i))!=1){
				System.out.println(i+"Item is not unshortlisted ");
				return false;
			}
		}
	return true;
	}
	
	public void swipePriorityOptions(){
		WebElement element = null;
		String category = "//android.widget.Switch[@resource-id='com.snapdeal.main:id/settingsNotificationButton']";
		waitForElementVisibility(30, driver.findElementByXPath(category));
		element= driver.findElementByXPath(category);	
		swipeRight(element);
		swipeToLeft(element);
}
}
