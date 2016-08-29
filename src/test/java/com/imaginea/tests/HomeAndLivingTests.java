package com.imaginea.tests;

import java.util.Arrays;

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
	String cateogoryMenu="Home & Living";
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
		homePage.selectCategory(cateogoryMenu);
		homeLivingPageActivity = new HomeAndLivingPageActivity(driver);
		System.out.println(homeLivingPageActivity.getSubCategoryList());
		Assert.assertEquals(homeLivingPageActivity.getSubCategoryList(),
				Arrays.asList(category));
	}

	
	@Test(description = "Verify Sub Category")
	public void verifySubCategories() {
		homePage = new HomePageActivity(driver);
		for (int i = 0; i < category.length-1; i++) {
			homePage.selectCategory(cateogoryMenu);
			homeLivingPageActivity = new HomeAndLivingPageActivity(driver);
			homeLivingPageActivity.selectSubCategory(category[i]);
			Assert.assertTrue(homeLivingPageActivity.verifyACategoryFromList(homeLivingPageActivity.getProductsTitles(), subCategory[i]),subCategory[i]+"is not there in the list"+category[i]);
			driver.navigate().back();
		}
	}
	
	
	@AfterMethod
	public void afterMethod() {
		driver.closeApp();
	}
}
