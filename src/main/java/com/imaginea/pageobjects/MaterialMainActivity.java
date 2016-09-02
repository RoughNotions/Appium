package com.imaginea.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

import com.imaginea.utils.UIUtility;

public class MaterialMainActivity   extends UIUtility{

	String productCount_Id="com.snapdeal.main:id/numberOfProducts";
	String categoryTitleTxt_Id ="com.snapdeal.main:id/categoryTitleTxt";
	String categoryList="//android.widget.ListView[@resource-id='com.snapdeal.main:id/categoryList']/android.widget.LinearLayout//android.widget.LinearLayout";
	
	public MaterialMainActivity(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public void getCategoryList(){
		
		List<WebElement> list=driver.findElementsByXPath(categoryList);
		System.out.println(list.size());
	}
}
