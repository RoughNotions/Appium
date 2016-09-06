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
	
	
}
