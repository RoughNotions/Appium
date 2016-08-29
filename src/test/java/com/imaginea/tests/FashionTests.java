package com.imaginea.tests;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.imaginea.pageobjects.FashionPageActivity;
import com.imaginea.pageobjects.HomePageActivity;
import com.imaginea.utils.UIUtility;

/**
 * All test case of Fashion Category are updated in this page
 * 
 * @author krishnakumarnellore
 *
 */
public class FashionTests extends BaseTest {

	@BeforeMethod
	public void beforeMethod() {
		driver.launchApp();
	}

	@Test(description = "Verify Fashion Category and sub category list")
	public void verifyFashionCategory() {
		HomePageActivity homePage = new HomePageActivity(driver);
		homePage.selectCategory("Fashion");
		FashionPageActivity fashionPageActivity = new FashionPageActivity(
				driver);
		String category[] = { "Men's Fashion", "Women's Fashion",
				"Baby & Kids", "Jewellery", "Bags & Luggage",
				"Sports, Fitness & Outdoor" };
		Assert.assertEquals(fashionPageActivity.getSubCategoryList(),
				Arrays.asList(category));
	}

	@Test(description = "Verify Sub Category")
	public void verifySubCategory() {
		SoftAssert s_assert = new SoftAssert();
		HomePageActivity homePage = new HomePageActivity(driver);
		String category[] = { "Men's Fashion", "Women's Fashion",
				"Baby & Kids", "Jewellery", "Bags & Luggage",
				"Sports, Fitness & Outdoor" };
		String subCategory[] = { "Clothing", "Ethnic Wear", "Kids Clothing",
				"Fashion Jewellery", "Backpacks & More", "Sports" };

		for (int i = 0; i < category.length; i++) {
			homePage.selectCategory("Fashion");
			FashionPageActivity fashionPageActivity = new FashionPageActivity(
					driver);
			fashionPageActivity.selectSubCategory(category[i]);
			s_assert.assertEquals(UIUtility.getElementTextByIndex(driver, 1),
					subCategory[i], "Sub Category result field didn't match");
			driver.navigate().back();
		}
		s_assert.assertAll();
	}

	@Test(description = "Verify List of Sort Type Avilable for Fashion Category")
	public void verifyMenFashionClothingCategorySortType() {
		HomePageActivity homePage = new HomePageActivity(driver);
		homePage.selectCategory("Fashion");
		FashionPageActivity fashionPageActivity = new FashionPageActivity(
				driver);
		fashionPageActivity.selectSubCategory("Men's Fashion");
		UIUtility.sleep(10000L);
		UIUtility.clickElementByText(driver, "Clothing");
		UIUtility.sleep(10000L);
		UIUtility.clickElementByText(driver, "Sort\nPopularity");
		String sortCategory[] = { "Relevance", "Popularity",
				"Price Low To High", "Price High To Low", "New Arrival",
				"Discount" };
		Assert.assertEquals(fashionPageActivity.getSortCategoryList(),
				Arrays.asList(sortCategory));
	}

	@Test(description = "Verify Sort By discount in Fashion Category")
	public void verifyMenFashionSortByDiscount() {
		HomePageActivity homePage = new HomePageActivity(driver);
		homePage.selectCategory("Fashion");
		FashionPageActivity fashionPageActivity = new FashionPageActivity(
				driver);
		fashionPageActivity.selectSubCategory("Men's Fashion");
		UIUtility.sleep(5000L);
		UIUtility.clickElementByText(driver, "Clothing");
		UIUtility.sleep(5000L);
		UIUtility.clickElementByText(driver, "Sort\nPopularity");
		UIUtility.clickElementByText(driver, "Discount");
		UIUtility.sleep(5000L);
		Assert.assertTrue(fashionPageActivity.getProductDiscountList().get(0)
				.contains("% OFF"), "Discount is not shown");
		
		}

	@AfterMethod
	public void afterMethod() {
		driver.closeApp();
	}
}
