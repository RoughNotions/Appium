package com.imaginea.tests;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
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
@Listeners(com.imaginea.tests.ExtentReporterNG.class)
public class FashionTests extends BaseTest {

	@BeforeMethod
	public void beforeMethod() {
		driver.closeApp();
		driver.launchApp();
	}

	@Test(description = "Verify Fashion Category and sub category list")
	public void verifyFashionCategory() {
		HomePageActivity homePage = new HomePageActivity(driver);
		FashionPageActivity fashionPageActivity = new FashionPageActivity(
				driver);
		String category[] = { "Men's Fashion", "Women's Fashion",
				"Baby & Kids", "Jewellery", "Bags & Luggage",
				"Sports, Fitness & Outdoor" };
		homePage.selectCategory("Fashion");
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

	@Test(description = "Verify Brand Selection in Fashion Category")
	public void testBrandSelection() {
		HomePageActivity homePage = new HomePageActivity(driver);
		homePage.selectCategory("Fashion");
		FashionPageActivity fashionPageActivity = new FashionPageActivity(
				driver);
		fashionPageActivity.selectSubCategory("Men's Fashion");
		UIUtility.sleep(5000L);
		UIUtility.clickElementByText(driver, "Clothing");
		UIUtility.sleep(5000L);
		fashionPageActivity.selectCategoryByText("Brand");
		UIUtility.sleep(2000L);
		fashionPageActivity.selectCategoryByText("Lee");
		UIUtility.sleep(2000L);
		fashionPageActivity.clickApplyButton();
		UIUtility.sleep(5000L);
		List<String> titleList = fashionPageActivity.getProductTitleList();
		Assert.assertTrue(titleList.get(0).contains("Lee"),
				"Title is not shown " + titleList);
	}

	@Test(description = "Verify Size Selection in Fashion Category")
	public void testSizeSelection() {
		HomePageActivity homePage = new HomePageActivity(driver);
		homePage.selectCategory("Fashion");
		FashionPageActivity fashionPageActivity = new FashionPageActivity(
				driver);
		fashionPageActivity.selectSubCategory("Men's Fashion");
		UIUtility.sleep(5000L);
		UIUtility.clickElementByText(driver, "Clothing");
		UIUtility.sleep(5000L);
		fashionPageActivity.selectCategoryByText("Price");
		UIUtility.sleep(2000L);
		fashionPageActivity.setPriceFilter("2000", "30000");
		UIUtility.sleep(5000L);
		List<String> titleList = fashionPageActivity
				.getProductDisplayPriceList();
		int price = Integer.parseInt(titleList.get(0).replace("Rs. ", "")
				.replace(",", ""));
		Assert.assertEquals(price > 2000, price < 30000,
				"Price is not in range");
	}

	@Test(description = "Verify Discount Selection in Fashion Category")
	public void testDiscountSelection() {
		HomePageActivity homePage = new HomePageActivity(driver);
		homePage.selectCategory("Fashion");
		FashionPageActivity fashionPageActivity = new FashionPageActivity(
				driver);
		fashionPageActivity.selectSubCategory("Men's Fashion");
		UIUtility.clickElementByText(driver, "Clothing");
		fashionPageActivity.selectCategoryByText("Discount %");
		fashionPageActivity.selectCategoryByText("40 - 50");
		fashionPageActivity.clickApplyButton();
		UIUtility.sleep(2000L);
		List<String> titleList = fashionPageActivity
				.getProductDiscountPriceList();
		Assert.assertTrue(titleList.get(0).contains("% OFF"),
				"Discount is not shown");
	}

	@Test(description = "Verify Zoom Functionality in Fashion Category")
	public void testZoomFunctionality() {
		HomePageActivity homePage = new HomePageActivity(driver);
		homePage.selectCategory("Fashion");
		FashionPageActivity fashionPageActivity = new FashionPageActivity(
				driver);
		fashionPageActivity.selectSubCategory("Men's Fashion");
		UIUtility.clickElementByText(driver, "Clothing");
		UIUtility.clickElementByText(driver, "T-Shirts & Polos");
		UIUtility.clickElementByText(driver, "T-Shirts");
		UIUtility.clickElementByText(driver,
				"Alan Jones Clothing Grey Cotton T-Shirt");
		fashionPageActivity.zoomImage();
		Assert.assertTrue(UIUtility.isElementPresent(driver,
				"com.snapdeal.main:id/imageViewZoom"),
				"Trouble in Zooming image");
	}

	@Test(description = "Verify Add to Cart Functionality in Fashion Category")
	public void testAddToCartFunctionality() {
		HomePageActivity homePage = new HomePageActivity(driver);
		homePage.selectCategory("Fashion");
		FashionPageActivity fashionPageActivity = new FashionPageActivity(
				driver);
		fashionPageActivity.selectSubCategory("Men's Fashion");
		UIUtility.clickElementByText(driver, "Clothing");
		UIUtility.clickElementByText(driver, "T-Shirts & Polos");
		UIUtility.clickElementByText(driver, "T-Shirts");
		String fashionItem = "Alan Jones Clothing Grey Cotton T-Shirt";
		UIUtility.clickElementByText(driver, fashionItem);
		UIUtility.clickElementByText(driver, "Add to Cart");
		UIUtility.clickElementByText(driver, "L");
		UIUtility.clickElementByText(driver, "Add to cart");
		fashionPageActivity.clickMenuCartIcon();
		Assert.assertEquals(
				fashionPageActivity.getCartProductNameList().get(0),
				fashionItem);
		Assert.assertEquals(
				fashionPageActivity.getCartProductCountList().get(0),
				"1");

	}

	@AfterMethod
	public void afterMethod() {
		driver.closeApp();
	}

}
