package com.imaginea.tests.web;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.imaginea.base.BaseTest;
import com.imaginea.pageobjects.webApp.DailyNeedsPage;

public class DailyNeedsTests extends BaseTest {
	String categoryMenu = "Daily Needs";
	String category[] = { "Beauty & Personal Care", "Food & Gourmet", "Baby Care", "Household Essentials",
			"Nutrition & Supplements", "Pet Supplies" };
	String BeautyandPersonalCareSubcategories[] = { "Makeup", "Skin Care", "Hair Care", "Bath & Shower",
			"Men's Grooming", "Perfumes & Fragrances", "Oral Care", "Feminine Care", "Beauty Accessories",
			"Kits & Gift Sets", "All Beauty & Personal Care", };

	@BeforeMethod
	public void beforeMethod() {
		driver.get("https://m.snapdeal.com");
	}

	@Test(description = "Verify Daily Needs Category and sub category list")
	public void verifyDailyNeedsCategory() {
		DailyNeedsPage dailyneedspage = new DailyNeedsPage(driver);
		dailyneedspage.clickMenuicon();
		dailyneedspage.selectCategory(categoryMenu);
		Assert.assertEquals(dailyneedspage.getSubCategories(categoryMenu), Arrays.asList(category));
	}

	@Test(description = "Verify Daily Needs Category and sub category list")
	public void verifyBeautyandPersonalCareSubcategories() {
		String subCategory = "Beauty & Personal Care";
		DailyNeedsPage dailyneedspage = new DailyNeedsPage(driver);
		dailyneedspage.clickMenuicon();
		dailyneedspage.selectCategory(categoryMenu);
		System.out.println(dailyneedspage.getSubCategories(categoryMenu));
		dailyneedspage.clickSubCategory(categoryMenu, subCategory);
		System.out.println(dailyneedspage.getRelavantSubCategories(categoryMenu, subCategory));
		Assert.assertEquals(dailyneedspage.getRelavantSubCategories(categoryMenu, subCategory),
				Arrays.asList(BeautyandPersonalCareSubcategories));
	}

	@Test(description = "Verify List of Sort Type Avilable for Daily Needs")
	public void verifyBeautyAndPersonalCareCategorySortType() {
		String subCategory = "Beauty & Personal Care";
		DailyNeedsPage dailyneedspage = new DailyNeedsPage(driver);
		dailyneedspage.clickMenuicon();
		dailyneedspage.selectCategory(categoryMenu);
		System.out.println(dailyneedspage.getSubCategories(categoryMenu));
		dailyneedspage.clickSubCategory(categoryMenu, subCategory);
		dailyneedspage.clickElementByText("Makeup");
		dailyneedspage.clickElementByText("Eyes");
		dailyneedspage.clickElementByText("Kajal");
		//dailyneedspage.clickOnSortPopularity();
		String sortCategory[] = { "Relevance", "Popularity", "Price Low To High", "Price High To Low", "New Arrival",
				"Discount", };
		Assert.assertEquals(dailyneedspage.getSortingCategoryList(), Arrays.asList(sortCategory));

	}

}
