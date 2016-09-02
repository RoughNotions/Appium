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
		String category[] = { "Shopping List", "Beauty & Personal Care", "Food & Gourmet", "Health & Wellness",
				"Nutrition & Supplements", "Household Essentials", "Baby Care", "Pet Supplies" };
		Assert.assertEquals(dailyneedsactivity.getSubCategoryList(), Arrays.asList(category));
	}

	@Test(description = "Verify Sub Category")
	public void verifySubCategory() {
		HomePageActivity homePage = new HomePageActivity(driver);
		String category[] = { "Beauty & Personal Care", "Food & Gourmet", "Health & Wellness",
				"Nutrition & Supplements", "Household Essentials", "Baby Care", "Pet Supplies" };
		String subcategory[] = { "Makeup", "Tea Coffee & Beverages", "Health Monitors & Devices",
				"Ayurveda & Organic Products", "House & Kitchen Cleaners", "Diapers & Potty Training", "Dog Supplies" };
		for (int i = 0; i < category.length; i++) {
			homePage.selectCategory("Daily Needs");
			DailyNeedsPageActivity dailyneedsactivity = new DailyNeedsPageActivity(driver);
			dailyneedsactivity.selectSubCategory(category[i]);
			Assert.assertEquals(dailyneedsactivity.getElementTextByIndex( 1), subcategory[i],
					"Sub Category result field didn't match");
			driver.navigate().back();

		}
	}

	@Test(description = "Verify List of Sort Type Avilable for Daily Needs")
	public void verifyBeautyAndPersonalCareCategorySortType() {
		HomePageActivity homePage = new HomePageActivity(driver);
		homePage.selectCategory("Daily Needs");
		DailyNeedsPageActivity dailyneedsactivity = new DailyNeedsPageActivity(driver);
		dailyneedsactivity.selectSubCategory("Beauty & Personal Care");
		dailyneedsactivity.sleep(10000L);
		dailyneedsactivity.clickElementByText( "Makeup");
		dailyneedsactivity.sleep(10000L);
		dailyneedsactivity.clickElementByText( "Sort\nPopularity");
		String sortCategory[] = { "Relevance", "Popularity", "Price Low To High", "Price High To Low", "New Arrival",
				"Discount" };
		Assert.assertEquals(dailyneedsactivity.getSortCategoryList(), Arrays.asList(sortCategory));
	}
	
	@Test(description = "Verify Sort By discount in MakeUP")
	public void verifyMakeUpByDiscount() {
		HomePageActivity homePage = new HomePageActivity(driver);
		homePage.selectCategory("Daily Needs");
		DailyNeedsPageActivity dailyneedsactivity = new DailyNeedsPageActivity(driver);
		dailyneedsactivity.selectSubCategory("Beauty & Personal Care");
		dailyneedsactivity.sleep(5000L);
		dailyneedsactivity.clickElementByText( "Makeup");
		dailyneedsactivity.sleep(5000L);
		dailyneedsactivity.clickElementByText( "Sort\nPopularity");
		dailyneedsactivity.clickElementByText( "Discount");
		dailyneedsactivity.sleep(5000L);
		Assert.assertTrue(dailyneedsactivity.getProductDiscountList().get(0)
				.contains("% OFF"), "Discount is not shown");
		
		}
	@Test(description = "Verify Sort By Price Low To High in Makeup")
	public void verifyMakeUpByPriceLowToHigh() {
		HomePageActivity homePage = new HomePageActivity(driver);
		homePage.selectCategory("Daily Needs");
		DailyNeedsPageActivity dailyneedsactivity = new DailyNeedsPageActivity(driver);
		dailyneedsactivity.selectSubCategory("Beauty & Personal Care");
		dailyneedsactivity.sleep(5000L);
		dailyneedsactivity.clickElementByText( "Makeup");
		dailyneedsactivity.sleep(5000L);
		dailyneedsactivity.clickElementByText( "Sort\nPopularity");
		dailyneedsactivity.clickElementByText( "Price Low To High");
		dailyneedsactivity.sleep(5000L);
		Assert.assertTrue(dailyneedsactivity.getProductDiscountList().get(0)
				.contains("price"), "Price Low To High is not shown");
	}
	@Test(description = "Verify Sort By Price Low To High in Makeup")
	public void verifyMakeUpByPriceHighToLow() {
		HomePageActivity homePage = new HomePageActivity(driver);
		homePage.selectCategory("Daily Needs");
		DailyNeedsPageActivity dailyneedsactivity = new DailyNeedsPageActivity(driver);
		dailyneedsactivity.selectSubCategory("Beauty & Personal Care");
		dailyneedsactivity.sleep(5000L);
		dailyneedsactivity.clickElementByText( "Makeup");
		dailyneedsactivity.sleep(5000L);
		dailyneedsactivity.clickElementByText( "Sort\nPopularity");
		dailyneedsactivity.clickElementByText( "Price High To Low");
		dailyneedsactivity.sleep(5000L);
		Assert.assertTrue(dailyneedsactivity.getProductDiscountList().get(0)
				.contains("price"), "Price High To Low is not shown");
	}
	@Test(description = "Verify Sort By New Arrival in Makeup")
	public void verifyMakeUpByNewArrival() {
		HomePageActivity homePage = new HomePageActivity(driver);
		homePage.selectCategory("Daily Needs");
		DailyNeedsPageActivity dailyneedsactivity = new DailyNeedsPageActivity(driver);
		dailyneedsactivity.selectSubCategory("Beauty & Personal Care");
		dailyneedsactivity.sleep(5000L);
		dailyneedsactivity.clickElementByText( "Makeup");
		dailyneedsactivity.sleep(5000L);
		dailyneedsactivity.clickElementByText( "Sort\nPopularity");
		dailyneedsactivity.clickElementByText( "New Arrival");
		dailyneedsactivity.sleep(5000L);
		Assert.assertTrue(dailyneedsactivity.getProductDiscountList().get(0)
				.contains("price"), "New Arrival is not shown");
	}
}
