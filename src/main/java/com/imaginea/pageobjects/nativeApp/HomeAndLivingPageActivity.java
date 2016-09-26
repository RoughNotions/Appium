package com.imaginea.pageobjects.nativeApp;

import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.types.CommandlineJava.SysProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.android.AndroidDriver;

import com.imaginea.utils.UIUtility;

public class HomeAndLivingPageActivity extends UIUtility {
	private String subCategories = "com.snapdeal.main:id/subCategoryTitleTextView";
	private String shopNowButton = "com.snapdeal.main:id/shop_now_button";
	public HomeAndLivingPageActivity(AppiumDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}
	public List<String> getSubCategoryList() {
		return getListOfElementsByID( subCategories);
	}
	
	/**
	 * Select Sub Category of Home And Living  
	 * 
	 * @param subCategory
	 */
	public void selectSubCategory(String subCategory) {
		clickElementByText( subCategory);
		sleep(3000L);
	}

	public List<String> getProductTitles(){
		List<String> titles=getTitles(1);
		boolean bFlag=false;
		if(titles.contains("More")){
			bFlag=true;
			clickElementByText("More");
			sleep(5000l);
		}
		driver.swipe(0, 788, 0, 250, 3000);
		
		
		while(bFlag){
			titles=getTitles(1);
			if(titles.contains("Less")){
				break;
			}else if(titles.contains("More")){
				clickElementByText("More");
				sleep(5000l);
				titles=getTitles(1);
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
		List<String> titles=getTitles(1);
		System.out.println(titles);
		return titles;
	}
	
	public String getHeaderText(){
		try{
			System.out.println(driver.findElementByXPath("//android.widget.FrameLayout[@resource-id='com.snapdeal.main:id/header_container']//android.view.View[0]//android.widget.TextView[1]").getText());
		}catch(Exception e){
			System.out.println("in ex");
		}
		
		try{
			System.out.println(driver.findElementByXPath("//android.support.v4.widget.DrawerLayout[0]/android.widget.FrameLayout[0]/android.widget.FrameLayout[0]/android.widget.FrameLayout[1]//android.view.View[0]//android.widget.TextView[1]").getText());
			driver.findElementByXPath("//*[@id='com.snapdeal.main:id/toolBar']");
			driver.findElement(By.id("com.snapdeal.main:id/toolBar'"));
			//*[@class='android.widget.TextView']");
			driver.getPageSource();
		}catch(Exception e){
			System.out.println("in ex");
		}
		
		return "..";
	}
	
	
	
	public String getPageTitle(String subCategoryName) {
		String category = String.format("//android.widget.TextView[@text='%s']", subCategoryName);
		waitForElementVisibility( 60, driver.findElementByXPath(category));
		return driver.findElementByXPath(category).getText();
	}
	
	public String clickFirsProductFromList(int index){
		List<WebElement> ele = getElementsTextByIndex(index);
		String productName = "";
		System.out.println(ele.size());
		if(ele.size()>0){
			productName = ele.get(0).getText();
			ele.get(0).click();
			sleep(3000L);
		}
		return productName;
	}
	
	public String clickFirstProductFromList(String resourceId){
		List<WebElement> ele =  getElementsTextById(resourceId);
		String productName = "";
		System.out.println(ele.size());
		if(ele.size()>0){
			productName = ele.get(0).getText();
			ele.get(0).click();
			sleep(3000L);
		}
		return productName;
	}
	
	public String clickFirstSubProduct(){
		return  clickFirstProductFromList("com.snapdeal.main:id/txvProductItemTitle");
	}
	public String clickFirstMostRelavantSubProduct(){
		return  clickFirstProductFromList("com.snapdeal.main:id/productTitle");
	}
	public void clickOnAddToCartButton(){
		WebElement element;
		try{
			element= driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'addCartBUtton')]");	
			System.out.println(element.getText());
		}catch(Exception e){
			System.out.println(e.getMessage());
			try{
				element= driver.findElementByXPath("//android.widget.TextView[@id='com.snapdeal.main:id/addCartBUtton']");	
				System.out.println(element.getText());
			}catch(Exception e1){
				System.out.println(e1.getMessage());
				element= driver.findElementById("com.snapdeal.main:id/addCartBUtton");
				System.out.println(element.getText());
			}
		}
		
		tapElement(element);
	}
	
	public void enterPincode(){
		sleep(5000l);
		WebElement element = waitForElementById("com.snapdeal.main:id/shipnearPincode"); 
	         if(element!=null){
	             element.sendKeys("500061");
	             waitForElementById("com.snapdeal.main:id/shipnearverifyBtn").click(); 
	         }  
	}
	
	
	public boolean verifyTextInAddToCartButton(String text){
		WebElement element;
		String actualtext="";
		try{
			sleep(5000l);
			element= driver.findElementById("com.snapdeal.main:id/addCartBUtton");	
			actualtext=element.getText();
		}catch(Exception e){
			System.out.println(e.getMessage());				
		}
		
		if(actualtext.equals(text)){
			return true;
		}
		System.out.println("Displaying text as "+actualtext+"instead of "+text);
		return false;
	}
	

	
	public void scrollToHomeDecorSection(){
		scrollToExactText("Wall Stickers");
	}
}
