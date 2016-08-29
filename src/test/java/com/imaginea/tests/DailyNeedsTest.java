package com.imaginea.tests;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.imaginea.pageobjects.DailyNeedsPageActivity;
import com.imaginea.pageobjects.HomePageActivity;
import com.imaginea.utils.UIUtility;

public class DailyNeedsTest extends BaseTest {
	@BeforeMethod
	public void beforeMethod() {
		driver.launchApp();
	}
	
	@Test(description = "Verify DailyNeeds Category and sub category list")
	public void verifyDailyNeedsCategory() {
		HomePageActivity homePage = new HomePageActivity(driver);
		homePage.selectCategory("Daily Needs");
		DailyNeedsPageActivity dailyneedsactivity = new DailyNeedsPageActivity(driver);
		String category[] = {"Shopping List","Beauty & Personal Care","Food & Gourmet","Health & Wellness","Nutrition & Supplements","Household Essentials","Baby Care","Pet Supplies"};
		Assert.assertEquals(dailyneedsactivity.getSubCategoryList(),
				Arrays.asList(category));
	}
	
	
	
	@Test(description = "Verify Sub Category")
	public void verifySubCategory() {
	HomePageActivity homePage = new HomePageActivity(driver);
	String category[] = {"Beauty & Personal Care","Food & Gourmet","Health & Wellness",
			"Nutrition & Supplements","Household Essentials","Baby Care","Pet Supplies"};	
	String subcategory[] = {"Makeup","Tea Coffee & Beverages","Health Monitors & Devices",
			"Ayurveda & Organic Products","House & Kitchen Cleaners","Diapers & Potty Training","Dog Supplies"};
				for (int i = 0; i < category.length; i++) {
					homePage.selectCategory("Daily Needs");
		DailyNeedsPageActivity dailyneedsactivity = new DailyNeedsPageActivity(driver);
		 dailyneedsactivity.selectSubCategory(category[i]);
		 Assert.assertEquals(UIUtility.getElementTextByIndex(driver, 1),
					subcategory[i], "Sub Category result field didn't match");
			driver.navigate().back();
		
				}
		
	}
	}
