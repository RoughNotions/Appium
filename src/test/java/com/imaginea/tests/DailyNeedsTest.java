package com.imaginea.tests;

import java.util.Arrays;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.imaginea.pageobjects.DailyNeedsPageActivity;
import com.imaginea.pageobjects.FashionPageActivity;
import com.imaginea.pageobjects.HomePageActivity;
import com.imaginea.utils.UIUtility;

@Listeners(com.imaginea.tests.ExtentReporterNG.class)
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
			Assert.assertEquals(dailyneedsactivity.getElementTextByIndex(1), subcategory[i],
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
		dailyneedsactivity.selectCategoryByText("Beauty");
		dailyneedsactivity.selectCategoryByText("Makeup");

		dailyneedsactivity.ClickOnSortPopularity();
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
		dailyneedsactivity.selectCategoryByText("Beauty");
		dailyneedsactivity.selectCategoryByText("Makeup");

		dailyneedsactivity.ClickOnSortPopularity();
		dailyneedsactivity.ClickOnProductDiscount();

		Assert.assertTrue(dailyneedsactivity.getProductDiscountList().get(0).contains("Rs"),
				"Discount is not shown");

	}

	@Test(description = "Verify Sort By Price Low To High in Makeup")
	public void verifyMakeUpByPriceLowToHigh() {
		HomePageActivity homePage = new HomePageActivity(driver);
		homePage.selectCategory("Daily Needs");
		DailyNeedsPageActivity dailyneedsactivity = new DailyNeedsPageActivity(driver);
		dailyneedsactivity.selectSubCategory("Beauty & Personal Care");
		dailyneedsactivity.selectCategoryByText("Beauty");
		dailyneedsactivity.selectCategoryByText("Makeup");

		dailyneedsactivity.ClickOnSortPopularity();
		dailyneedsactivity.SelectPriceLowToHigh();
		Assert.assertTrue(dailyneedsactivity.getProductDiscountList().get(0).contains("Rs"),
				"Price Low To High is not shown");
	}

   @Test(description = "Verify Sort By Price High To Low in Makeup")
	public void verifyMakeUpByPriceHighToLow() {
		HomePageActivity homePage = new HomePageActivity(driver);
		homePage.selectCategory("Daily Needs");
		DailyNeedsPageActivity dailyneedsactivity = new DailyNeedsPageActivity(driver);
		dailyneedsactivity.selectSubCategory("Beauty & Personal Care");
		dailyneedsactivity.selectCategoryByText("Beauty");
		dailyneedsactivity.selectCategoryByText("Makeup");

		dailyneedsactivity.ClickOnSortPopularity();
		dailyneedsactivity.SelectPriceHighToLow();
		Assert.assertTrue(dailyneedsactivity.getProductDiscountList().get(0).contains("Rs"),
				"Price High To Low is not shown");
	}

	@Test(description = "Verify Sort By New Arrival in Makeup")
	public void verifyMakeUpByNewArrival() {
		HomePageActivity homePage = new HomePageActivity(driver);
		homePage.selectCategory("Daily Needs");
		DailyNeedsPageActivity dailyneedsactivity = new DailyNeedsPageActivity(driver);
		dailyneedsactivity.selectSubCategory("Beauty & Personal Care");
		dailyneedsactivity.selectCategoryByText("Beauty");
		dailyneedsactivity.selectCategoryByText("Makeup");

		dailyneedsactivity.ClickOnSortPopularity();
		dailyneedsactivity.SelectNewArrival();
		Assert.assertTrue(dailyneedsactivity.getProductDiscountList().get(0).contains("Rs"),
				"New Arrival is not shown");
	}

	


	@Test(description = "Verify Discount Selection in daily needs makeup")
	public void testDiscountSelection() {
		HomePageActivity homePage = new HomePageActivity(driver);
		homePage.selectCategory("Daily Needs");
		DailyNeedsPageActivity dailyneedsactivity = new DailyNeedsPageActivity(driver);
		dailyneedsactivity.selectSubCategory("Beauty & Personal Care");
		dailyneedsactivity.selectCategoryByText("Beauty");
		dailyneedsactivity.selectCategoryByText("Makeup");
		dailyneedsactivity.clickOnFilter();
		dailyneedsactivity.selectCategoryByText("Discount %");

		dailyneedsactivity.selectCategoryByText("40 - 50");
		dailyneedsactivity.clickApplyButton();

		List<String> titleList = dailyneedsactivity.getProductDiscountPriceList();
		Assert.assertTrue(titleList.get(0).contains("% OFF"), "Discount is not shown");
	}
	
	@Test(description = "Verify price range Selection in daily needs makeup")
	    public void testPriceRangeSelection() {
		 HomePageActivity homePage = new HomePageActivity(driver);
			homePage.selectCategory("Daily Needs");
			DailyNeedsPageActivity dailyneedsactivity = new DailyNeedsPageActivity(driver);
			dailyneedsactivity.selectSubCategory("Beauty & Personal Care");
			dailyneedsactivity.selectCategoryByText("Beauty");
			dailyneedsactivity.selectCategoryByText("Makeup");
			dailyneedsactivity.clickOnFilter();
			dailyneedsactivity.selectCategoryByText("Price");
			dailyneedsactivity.sleep(2000L);
			dailyneedsactivity.setPriceFilter("2000", "3000");
			dailyneedsactivity.sleep(5000L);
	        List<String> titleList = dailyneedsactivity.getProductDisplayPriceList();
	        int price = Integer.parseInt(titleList.get(0).replace("Rs. ", "").replace(",", ""));
	        Assert.assertEquals(price > 2000, price < 3000, "Price is not in range");
	    }


	@Test(description = "Verify Add to Cart Functionality in daily needs makeup")
	public void testAddToCartFunctionality() {
		HomePageActivity homePage = new HomePageActivity(driver);
		homePage.selectCategory("Daily Needs");
		DailyNeedsPageActivity dailyneedsactivity = new DailyNeedsPageActivity(driver);
		dailyneedsactivity.selectSubCategory("Beauty & Personal Care");

		dailyneedsactivity.selectCategoryByText("Beauty");
		dailyneedsactivity.selectCategoryByText("Makeup");
		dailyneedsactivity.SelectProduct();
		dailyneedsactivity.Enterpincode();
		dailyneedsactivity.selectCategoryByText("Add to Cart");
		
		dailyneedsactivity.clickoncart();
		String productname = "Lakme Enrich Satins Lip Color, Shade P152, 4.3 G";
		Assert.assertEquals(dailyneedsactivity.getCartProductNameList().get(0), productname);
		Assert.assertEquals(dailyneedsactivity.getCartProductCountList().get(0), "1");

	}

	@Test(description = "Verify remove from Cart Functionality in daily needs makeup")
	public void testRemovefromCartFunctionality() {
		HomePageActivity homePage = new HomePageActivity(driver);
		homePage.selectCategory("Daily Needs");
		DailyNeedsPageActivity dailyneedsactivity = new DailyNeedsPageActivity(driver);
		dailyneedsactivity.selectSubCategory("Beauty & Personal Care");

		dailyneedsactivity.selectCategoryByText("Beauty");
		dailyneedsactivity.selectCategoryByText("Makeup");
		dailyneedsactivity.SelectProduct();
		dailyneedsactivity.Enterpincode();
		dailyneedsactivity.selectCategoryByText("Add to Cart");
		
		dailyneedsactivity.clickoncart();
		dailyneedsactivity.clickonMinus();
		dailyneedsactivity.clickonPopUpRemove();
		dailyneedsactivity.pressBackKeyInAndroid();
		Assert.assertEquals(dailyneedsactivity.getCartButtonText(), "Add to Cart",
				"Invalid button type. Item has not been removed from cart");

	}

}
