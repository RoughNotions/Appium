package com.imaginea.tests.web;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.imaginea.base.BaseTest;
import com.imaginea.pageobjects.webApp.ElectronicsPage;

public class ElectronicsTests extends BaseTest {
	ElectronicsPage electronincsPage;
	String categoryMenu = "Electronics";
	String electronicsCategory[] = { "Computers, Laptops & Gaming", "TVs & Audio-Video", "Appliances",
			"Cameras & Accessories", "Stationery & Office Equipment" };
	String computersSubCategory[] = { "Laptops", "Printers & Inks", "Storage", "Computer Accessories",
			"Software & Antivirus", "Computer Components", "Gaming", "Routers & Modems", "Desktops", "Monitors",
			"Data Cards", "Extended Warranty & Insurance", "All Computers & Peripherals" };
	String tvsSubCategory[] = { "Televisions", "Home Audio Systems", "Speakers", "Headphones & Earphones",
			"Computer Speakers", "DTH Services", "Audio & Video Accessories", "Projectors", "Landline Phones",
			"Extended Warranty", "All TVs, Audio & Video" };
	String appliancesSubCategory[] = { "Air Conditioners", "Air Coolers", "Fans", "Personal Care Appliances",
			"Inverter & Stabilizers", "Home Appliances", "Security Systems", "Kitchen Appliances", "All Appliances" };
	String camerasSubCategory[] = { "Digital Cameras", "DSLRs", "Camera Lenses", "Camera Accessories", "Camcorders",
			"Binoculars & Telescopes", "Digital Photo Frames", "Selfie Sticks", "All Cameras & Accessories" };
	String stationerySubCategory[] = { "Stationery", "Office Equipment" };

	@Test(description = "Verify Electronics Category list")
	public void verifyMobileCategoryItems() {
		electronincsPage = new ElectronicsPage(driver);
		electronincsPage.clickMenuicon();
		electronincsPage.selectCategory(categoryMenu);
		Assert.assertEquals(electronincsPage.getSubCategories(categoryMenu), Arrays.asList(electronicsCategory));
	}

	@Test(description = "Verify Subcategory list under Computers, Laptops &	 Gaming")
	public void verifyComputersSubCategoryItems() {
		String subCategoryMenu = "Computers, Laptops & Gaming";
		electronincsPage = new ElectronicsPage(driver);
		electronincsPage.clickMenuicon();
		electronincsPage.selectCategory(categoryMenu);
		electronincsPage.clickSubCategory(categoryMenu, subCategoryMenu);
		Assert.assertEquals(electronincsPage.getRelavantSubCategories(categoryMenu, subCategoryMenu),
				Arrays.asList(computersSubCategory));
	}

	@Test(description = "Verify Subcategory list under TVs & Audio-video")
	public void verifyTVsSubCategoryItems() {
		String subCategoryMenu = "TVs & Audio-Video";
		electronincsPage = new ElectronicsPage(driver);
		electronincsPage.clickMenuicon();
		electronincsPage.selectCategory(categoryMenu);
		electronincsPage.clickSubCategory(categoryMenu, subCategoryMenu);
		Assert.assertEquals(electronincsPage.getRelavantSubCategories(categoryMenu, subCategoryMenu),
				Arrays.asList(tvsSubCategory));

	}

	@Test(description = "Verify Subcategory list under Appliances")
	public void verifyAppliancesSubCategoryItems() {
		String subCategoryMenu = "Appliances";
		electronincsPage = new ElectronicsPage(driver);
		electronincsPage.clickMenuicon();
		electronincsPage.selectCategory(categoryMenu);
		electronincsPage.clickSubCategory(categoryMenu, subCategoryMenu);
		Assert.assertEquals(electronincsPage.getRelavantSubCategories(categoryMenu, subCategoryMenu),
				Arrays.asList(appliancesSubCategory));

	}

	@Test(description = "Verify Subcategory list under Cameras & Accessories")
	public void verifCamerasSubCategoryItems() {
		String subCategoryMenu = "Cameras & Accessories";
		electronincsPage = new ElectronicsPage(driver);
		electronincsPage.clickMenuicon();
		electronincsPage.selectCategory(categoryMenu);
		electronincsPage.clickSubCategory(categoryMenu, subCategoryMenu);
		Assert.assertEquals(electronincsPage.getRelavantSubCategories(categoryMenu, subCategoryMenu),
				Arrays.asList(camerasSubCategory));

	}

	@Test(description = "Verify Subcategory list under Stationery & Office 	Equipments")
	public void verifyStationerySubCategoryItems() {
		String subCategoryMenu = "Stationery & Office Equipment";
		electronincsPage = new ElectronicsPage(driver);
		electronincsPage.clickMenuicon();
		electronincsPage.selectCategory(categoryMenu);
		electronincsPage.clickSubCategory(categoryMenu, subCategoryMenu);
		Assert.assertEquals(electronincsPage.getRelavantSubCategories(categoryMenu, subCategoryMenu),
				Arrays.asList(stationerySubCategory));

	}
}
