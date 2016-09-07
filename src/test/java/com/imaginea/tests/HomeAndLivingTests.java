package com.imaginea.tests;


import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.imaginea.pageobjects.HomeAndLivingPageActivity;
import com.imaginea.pageobjects.HomePageActivity;
import com.imaginea.pageobjects.MaterialMainActivity;

@Listeners(com.imaginea.tests.ExtentReporterNG.class)
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

	@Test(description = "Verify Home & Living Category and sub category list")
	public void verifyHomeLivingCategory() {
		homePage = new HomePageActivity(driver);
		homePage.selectCategory(categoryMenu);
		homeLivingPageActivity = new HomeAndLivingPageActivity(driver);
		System.out.println(homeLivingPageActivity.getSubCategoryList());
		Assert.assertEquals(homeLivingPageActivity.getSubCategoryList(),
				Arrays.asList(category));
	}

	
	@Test(description = "Verify Items in Sub Categories")
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
	@Test
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
	
	@Test
	public void verifySwipeFunctionality(){
		homePage = new HomePageActivity(driver);
		homePage.selectCategory(categoryMenu);
		String subCategory="Kitchen Appliances";
		homeLivingPageActivity = new HomeAndLivingPageActivity(driver);
		homeLivingPageActivity.selectSubCategory(subCategory);
		homeLivingPageActivity.swipeShopNow();
	}
	
	@Test
	public void verifyScrollFunctionality(){
		homePage = new HomePageActivity(driver);
		homePage.selectCategory(categoryMenu);
		String subCategory="Home Decoratives";
		homeLivingPageActivity = new HomeAndLivingPageActivity(driver);
		homeLivingPageActivity.selectSubCategory(subCategory);
		homeLivingPageActivity.scrollToHomeDecorSection();
		homeLivingPageActivity.pressBackKeyInAndroid();
		homeLivingPageActivity.pressHomeKeyInAndroid();
		homeLivingPageActivity.openNotifications();
	}
	
	@Test
	public void searchForProduct(){
		homePage = new HomePageActivity(driver);
		String product="Beans";
		String subProduct="Daily Needs";
		homePage.tapOnSearch();
		homePage.enterProductToSearch(product);
		
		Assert.assertTrue(homePage.verifySearchResultsText(product),"Product name is not displayed in Search Results Text");
		homePage.tapOnAppllyFilter();
		int count=homePage.getCountOfSubCategory(subProduct);
		homePage.tapOnCategory(subProduct);
		
		MaterialMainActivity mainActivity= new MaterialMainActivity(driver);
		Assert.assertTrue(mainActivity.verifyProductCountHeading(count),"Product count heading is not matching");
		Assert.assertEquals(mainActivity.getCategoryName(),subProduct,"Sub Product name is not matching");
		
		int subCategoryCount=mainActivity.getCategoryListCount();    
		Assert.assertTrue(mainActivity.verifySumOfCategories(count),"Sum of all sub categories are not matching with SubCategory count");
		
		int randomNo=mainActivity.getRandomNo(subCategoryCount);
		
		
		String relavantProduct=mainActivity.getRandomSubCategoryName(mainActivity.getSubCategoriesList(),randomNo);
		int countRelavantProduct=mainActivity.getRandomSubCategoryCount(mainActivity.getSubCategoriesList(),randomNo);
		
		homePage.tapOnCategory(relavantProduct);
		mainActivity.clickApplyFilters();
		
		Assert.assertTrue(homePage.verifySearchResultsCount(countRelavantProduct,product),"Product name and count is not displayed in Search Results Text");
		
	}
	
	
	@Test
	public void verifyAppScreenOrientation(){
		homePage = new HomePageActivity(driver);
		homePage.rotate("LANDSCAPE");
	}
	@AfterMethod
	public void afterMethod() {
		driver.closeApp();
	}
}
