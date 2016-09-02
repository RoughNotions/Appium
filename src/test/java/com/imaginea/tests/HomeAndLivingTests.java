package com.imaginea.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;

import java.util.Arrays;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.imaginea.pageobjects.FashionPageActivity;
import com.imaginea.pageobjects.HomeAndLivingPageActivity;
import com.imaginea.pageobjects.HomePageActivity;
import com.imaginea.utils.UIUtility;

public class HomeAndLivingTests extends BaseTest{
	HomeAndLivingPageActivity homeLivingPageActivity;
	HomePageActivity homePage;
	String categoryMenu="Home & Living";
	String category[]= { "Kitchen Appliances", "Kitchenware","Tools & Hardware", "Furnishing", "Home Decoratives",
			"Furniture","Home Improvement","Home Appliances" };
	String subCategory[]= { "Water Purifiers", "Cookware",   "Tools", "Bed Linen", "Gifts & Decor",
			"Living Room","Home Utility","Iron" };
	
	@BeforeMethod
	public void beforeMethod() {
		driver.launchApp();
	}

//	@Test(description = "Verify Home & Living Category and sub category list")
	public void verifyHomeLivingCategory() {
		homePage = new HomePageActivity(driver);
		homePage.selectCategory(categoryMenu);
		homeLivingPageActivity = new HomeAndLivingPageActivity(driver);
		System.out.println(homeLivingPageActivity.getSubCategoryList());
		Assert.assertEquals(homeLivingPageActivity.getSubCategoryList(),
				Arrays.asList(category));
	}

	
//	@Test(description = "Verify Sub Category")
	public void verifySubCategories() {
		homePage = new HomePageActivity(driver);
		for (int i = 0; i < category.length-1; i++) {
			homePage.selectCategory(categoryMenu);
			homeLivingPageActivity = new HomeAndLivingPageActivity(driver);
			homeLivingPageActivity.selectSubCategory(category[i]);
			Assert.assertTrue(homeLivingPageActivity.verifyACategoryFromList(homeLivingPageActivity.getProductsTitles(), subCategory[i]),subCategory[i]+"is not there in the list"+category[i]);
			driver.navigate().back();
		}
	}
	//@Test
	public void addProductToCatalog(){
		homePage = new HomePageActivity(driver);
		homePage.selectCategory(categoryMenu);
		String subCategory="Kitchen Appliances";
		homeLivingPageActivity = new HomeAndLivingPageActivity(driver);
		homeLivingPageActivity.selectSubCategory(subCategory);
		
		Assert.assertEquals(homeLivingPageActivity.getPageTitle(subCategory), subCategory,"Page title is not matching");
		String productName=homeLivingPageActivity.clickFirsProductFromList(1);
		Assert.assertEquals(homeLivingPageActivity.getPageTitle(productName), productName,"Page title is not matching");
		String relavantProductName=homeLivingPageActivity.clickFirstSubProduct();
		
		Assert.assertEquals(homeLivingPageActivity.getPageTitle(relavantProductName), relavantProductName,"Page title is not matching");
		
		homeLivingPageActivity.clickFirstMostRelavantSubProduct();
		Assert.assertTrue(homeLivingPageActivity.verifyTextInAddToCartButton("Add to Cart"), "Add to Cart text is not showing on the button");
		homeLivingPageActivity.clickOnAddToCartButton();
		Assert.assertTrue(homeLivingPageActivity.verifyTextInAddToCartButton("Go to Cart"), "Go to Cart text is not showing on the button");
	}
	
	//@Test
	public void verifySwipeFunctionality(){
		homePage = new HomePageActivity(driver);
		homePage.selectCategory(categoryMenu);
		String subCategory="Kitchen Appliances";
		homeLivingPageActivity = new HomeAndLivingPageActivity(driver);
		homeLivingPageActivity.selectSubCategory(subCategory);
		homeLivingPageActivity.swipeShopNow();
	}
	
//	@Test
	public void verifyScrollFunctionality(){
		homePage = new HomePageActivity(driver);
		homePage.selectCategory(categoryMenu);
		String subCategory="Home Decoratives";
		homeLivingPageActivity = new HomeAndLivingPageActivity(driver);
		homeLivingPageActivity.selectSubCategory(subCategory);
		homeLivingPageActivity.scrollToHomeDecorSection();
	}
	
	@Test
	public void searchForProduct(){
		homePage = new HomePageActivity(driver);
	/*	
		homePage.tapOnSearch();
		homePage.enterProductToSearch("Beans");
		
		homePage.verifySearchResultsText("Beans");
		homePage.tapOnAppllyFilter();*/
		
		homePage.getCurrentActivityName();
		

	}
	
	//@Test
	public void verifyAppScreenOrientation(){
		homePage.rotate("LANDSCAPE");
	}
	@AfterMethod
	public void afterMethod() {
		driver.closeApp();
	}
}
