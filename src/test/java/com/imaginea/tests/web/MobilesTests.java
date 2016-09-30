package com.imaginea.tests.web;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.imaginea.base.BaseTest;
import com.imaginea.pageobjects.webApp.HomeAndLivingPage;
import com.imaginea.pageobjects.webApp.HomePage;
import com.imaginea.pageobjects.webApp.MobilePage;

public class MobilesTests extends BaseTest {
	HomePage homePage;
	MobilePage mobilepage;
	String categoryMenu = "Mobiles & Tabs";
	String mobileCategory[] = { "Mobile Phones", "Tablets", "Power Banks", "Mobile Cases & Covers", "Screen Guards",
			"Mobile Accessories", "Wearable & Smartwatches", "Tablet Accessories", "Mobile Insurance & Warranty",
			"Refurbished Mobiles", "Refurbished Tablets" };
	String mobileAccessoriesSubCategory[] = { "Bluetooth Devices", "Selfie Sticks", "Cables & Chargers", "Batteries",
			"Anti Radiation Chips", "Mobile Spare Parts", "Memory Cards", "Car Mobile Chargers & Holders",
			"All Mobile Accessories" };
	String refurbishedMobilesSubCategory[] = { "Unboxed Mobiles", "Refurbished Mobiles", "All Refurbished Mobiles" };
	String tabletSubCategory[] = { "Cases & Covers", "Screen Guards", "Keyboards", "Cables & Chargers",
			"Cleaning Cloths, Docks & Stands", "Stylus Pens", "3D Glasses", "All Tablet Accessories" };

	@BeforeMethod
	public void beforeMethod() {
		driver.get("https://m.snapdeal.com");
	}

	@Test(description = "Verify Mobile Category list")
	public void verifyMobileCategoryItems() {
		mobilepage = new MobilePage(driver);
		mobilepage.clickMenuicon();
		mobilepage.selectCategory(categoryMenu);
		Assert.assertEquals(mobilepage.getSubCategories(categoryMenu), Arrays.asList(mobileCategory));

	}

	@Test(description = "Verify Subcategory list under Mobile Accessories")
	public void verifyMobileAccessoriesSubCategoryItems() {
		String subCategoryMenu = "Mobile Accessories";
		mobilepage = new MobilePage(driver);
		mobilepage.clickMenuicon();
		mobilepage.selectCategory(categoryMenu);
		mobilepage.clickSubCategory(categoryMenu, subCategoryMenu);
		Assert.assertEquals(mobilepage.getRelavantSubCategories(categoryMenu, subCategoryMenu),
				Arrays.asList(mobileAccessoriesSubCategory));

	}

	@Test(description = "Verify Subcategory list under Refurbished Mobiles")
	public void verifyRefurbishedSubCategoryItems() {
		String subCategoryMenu = "Refurbished Mobiles";
		mobilepage = new MobilePage(driver);
		mobilepage.clickMenuicon();
		mobilepage.selectCategory(categoryMenu);
		mobilepage.clickSubCategory(categoryMenu, subCategoryMenu);
		Assert.assertEquals(mobilepage.getRelavantSubCategories(categoryMenu, subCategoryMenu),
				Arrays.asList(refurbishedMobilesSubCategory));

	}

	@Test(description = "Verify Subcategory list under Tablet Accessories")
	public void verifyTabletAccessoriesSubCategoryItems() {
		String subCategoryMenu = "Tablet Accessories";
		mobilepage = new MobilePage(driver);
		mobilepage.clickMenuicon();
		mobilepage.selectCategory(categoryMenu);
		mobilepage.clickSubCategory(categoryMenu, subCategoryMenu);
		Assert.assertEquals(mobilepage.getRelavantSubCategories(categoryMenu, subCategoryMenu),
				Arrays.asList(tabletSubCategory));

	}

	@Test(description = "Verify mobiles by price")
	public void verifyMobilesByPrice() {
		String priceTypes[] = { "Rs. 2000-5000", "Rs. 5000-8000", "Rs. 8000-15000", "Rs. 15000-25000",
				"Above Rs. 25000", "Below Rs. 2000", "View All" };

		String subCategoryMenu = "Mobile Phones";
		String subsubCategoryMenu = "All Mobile Phones";
		mobilepage = new MobilePage(driver);
		mobilepage.clickMenuicon();
		mobilepage.selectCategory(categoryMenu);
		mobilepage.clickSubCategory(categoryMenu, subCategoryMenu);
		mobilepage.clickOnSubSubCategory(subsubCategoryMenu);
		Assert.assertEquals(mobilepage.getPriceTypes(), Arrays.asList(priceTypes));

	}

}
