package com.imaginea.tests;

import java.io.File;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.android.ddmlib.log.LogReceiver.LogEntry;
import com.android.utils.StdLogger.Level;
import com.imaginea.pageobjects.HomePageActivity;
import com.imaginea.pageobjects.MobileElectronicsPageActivity;
import com.imaginea.utils.FileUtilities;

/**
 * 
 * @author avinashg
 *
 */
@Listeners(com.imaginea.tests.ExtentReporterNG.class)
public class MobilesElectronicsTests extends BaseTest {

	@BeforeMethod
	public void beforeMethod() {
		driver.launchApp();
	}

	@Test
	public void optionsUnderMobileElectronics() {
		List<String> subCategories = Arrays.asList("Mobile Phones", "Mobiles Accessories", "Tablets & Accessories",
				"Laptops & Computers", "TVs, Audio & Video", "Appliances", "Cameras & Accessories", "Gaming",
				"Office Equipments");

		HomePageActivity homePage = new HomePageActivity(driver);
		homePage.selectCategory("Mobiles & Electronics");
		Assert.assertEquals(homePage.getSubItemsList(), subCategories, "Incorrect List of Sub Categories");
	}

	@Test
	public void verifyAllPageNavigations() {
		HomePageActivity homePage = new HomePageActivity(driver);
		homePage.selectCategory("Mobiles & Electronics");
		MobileElectronicsPageActivity mePage = homePage.selectSubCategory("Mobile Phones");
		Assert.assertEquals(mePage.getPageTitle("Mobile Phones"), "Mobile Phones");
		mePage.navigateToBackPage();

		homePage.selectCategory("Mobiles & Electronics");
		homePage.selectSubCategory("Mobiles Accessories");
		Assert.assertEquals(mePage.getPageTitle("Mobiles Accessories"), "Mobiles Accessories");
		mePage.navigateToBackPage();

		homePage.selectCategory("Mobiles & Electronics");
		homePage.selectSubCategory("Tablets & Accessories");
		Assert.assertEquals(mePage.getPageTitle("Tablets & Accessories"), "Tablets & Accessories");
		mePage.navigateToBackPage();

		homePage.selectCategory("Mobiles & Electronics");
		homePage.selectSubCategory("Laptops & Computers");
		Assert.assertEquals(mePage.getPageTitle("Laptops & Computers"), "Laptops & Computers");
		mePage.navigateToBackPage();

		homePage.selectCategory("Mobiles & Electronics");
		homePage.selectSubCategory("TVs, Audio & Video");
		Assert.assertEquals(mePage.getPageTitle("TVs, Audio & Video"), "TVs, Audio & Video");
		mePage.navigateToBackPage();

		homePage.selectCategory("Mobiles & Electronics");
		homePage.selectSubCategory("Appliances");
		Assert.assertEquals(mePage.getPageTitle("Appliances"), "Appliances");
		mePage.navigateToBackPage();

		homePage.selectCategory("Mobiles & Electronics");
		homePage.selectSubCategory("Cameras & Accessories");
		Assert.assertEquals(mePage.getPageTitle("Cameras & Accessories"), "Cameras & Accessories");
		mePage.navigateToBackPage();

		homePage.selectCategory("Mobiles & Electronics");
		homePage.selectSubCategory("Gaming");
		Assert.assertEquals(mePage.getPageTitle("Gaming"), "Gaming");
		mePage.navigateToBackPage();

		/*
		 * homePage.selectCategory("Mobiles & Electronics");
		 * homePage.selectSubCategory("Office Equipments");
		 * Assert.assertEquals(mePage.getPageTitle("Office Equipments"),
		 * "Office Equipments"); mePage.navigateToBackPage();
		 */
	}

	@Test
	public void getMobilesByPrice_Type_TopPicks() {
		List<String> priceRange = Arrays.asList("Rs. 2000-5000", "Rs. 5000-8000", "Rs. 8000-15000", "Rs. 15000-25000",
				"Above Rs. 25000", "Below Rs. 2000");
		List<String> mobileType = Arrays.asList("Smartphones", "Feature Phones", "Refurbished & Unboxed");
		List<String> mobilePicks = Arrays.asList("Intex Cloud Breeze", "Panasonic P55 Novo (8GB)",
				"Micromax Canvas Spark 3", "Micromax Spark 2plus");

		HomePageActivity homePage = new HomePageActivity(driver);
		homePage.selectCategory("Mobiles & Electronics");
		MobileElectronicsPageActivity mePage = homePage.selectSubCategory("Mobile Phones");

		Assert.assertEquals(mePage.getAllMobilesByPriceType(), mobileType, "Invalid Price Type");
		Assert.assertEquals(mePage.getAllMobilesByPriceRange(), priceRange, "Invalid Price Range");

	}

	@Test
	public void verifyGamingItems() {
		List<String> gameItems = Arrays.asList("Gaming Consoles", "Gaming Accessories", "Gaming Titles",
				"Gaming Merchandise", "Gaming Monitors");
		List<String> bestDeals = Arrays.asList("Limited Period Offer", "Featured Deals", "Discount Offers");
		List<String> gameTypes = Arrays.asList("Top Rated Games", "PS4 Games", "Play Games with consoles",
				"Gaming Titles 50% Off");

		HomePageActivity homePage = new HomePageActivity(driver);
		homePage.selectCategory("Mobiles & Electronics");
		MobileElectronicsPageActivity mePage = homePage.selectSubCategory("Gaming");

		Assert.assertEquals(mePage.getAllGameItems(), gameItems, "Invalid Game Items");
		Assert.assertEquals(mePage.getAllBestDeals(), bestDeals, "Invalid Best Deals");
		// Assert.assertEquals(mePage.getAllGameTypes(), gameTypes, "Invalid
		// Game Types");

	}

	@Test
	public void verifyAppliances() {
		List<String> applianceItems = Arrays.asList("ACs & Air Coolers", "Washing Machines", "Geysers & Heaters",
				"Home Appliances", "Personal Care Appliances", "Irons", "Fans", "More");
		List<String> greatDeals = Arrays.asList("ACs: Upto 30% Off", "Fans: Below Rs.1000", "Inverters: Upto 50% Off",
				"Hair Dryers:Below Rs.1000");
		List<String> trimmersByPrice = Arrays.asList("Below Rs.500", "Rs.500 - Rs.1000", "Above Rs.1000");

		HomePageActivity homePage = new HomePageActivity(driver);
		homePage.selectCategory("Mobiles & Electronics");
		MobileElectronicsPageActivity mePage = homePage.selectSubCategory("Appliances");
		Assert.assertEquals(mePage.getAllApplianceItems(), applianceItems, "Invalid Appliance Items");
		Assert.assertEquals(mePage.getGreatDeals(), greatDeals, "Invalid Great Deals");

		/*
		 * Assert.assertEquals(mePage.getAllTrimmersByPrice(), trimmersByPrice,
		 * "Invalid Trimmer Prices");
		 */
	}

	@Test
	public void verifyTabletsAccessories() {
		List<String> tabletTypes = Arrays.asList("WiFi Tablets", "3G Tablets", "4G Tablets");
		List<String> tabletItems = Arrays.asList("Tablets", "Refurbished Tablets", "Cases & Covers", "Screen Guards",
				"Keyboards", "Cables & Chargers", "Cleaning Cloths, Docks & Stands", "More");
		List<String> priceStore = Arrays.asList("Below Rs 5,000", "Rs 5,000 - 10,000", "Rs 10,000 - 20,000",
				"20,000 and Above");
		List<String> osNames = Arrays.asList("Android", "iOS", "Windows", "Kindle");

		HomePageActivity homePage = new HomePageActivity(driver);
		homePage.selectCategory("Mobiles & Electronics");
		MobileElectronicsPageActivity mePage = homePage.selectSubCategory("Tablets & Accessories");
		Assert.assertEquals(mePage.getTabletTypes(), tabletTypes, "Invalid Tablet Types");
		Assert.assertEquals(mePage.getTabletItems(), tabletItems, "Invalid Tablet Items");
		Assert.assertEquals(mePage.getPriceStore(), priceStore, "Invalid PriceStore");
		/*
		 * Assert.assertEquals(mePage.getOS(), osNames, "Invalid OS types");
		 */
	}

	@Test
	public void addToCart() {
		HomePageActivity homePage = new HomePageActivity(driver);
		homePage.selectCategory("Mobiles & Electronics");
		MobileElectronicsPageActivity mePage = homePage.selectSubCategory("TVs, Audio & Video");

		mePage.addItemToCart("Televisions");
		mePage.removeItemToCart();
		Assert.assertEquals(mePage.getCartButtonText(), "Add to Cart",
				"Invalid button type. Item has not been removed from cart");

	}

	@Test
	public void verifyOfficeEquipments() {
		List<String> equipmentTypes = Arrays.asList("Note Counters & Paper Shredders", "POS Equipment",
				"Laminators & Binders", "Labeling & Stamping Machine", "Stationery", "Office Equipment");
		List<String> officeHaves = Arrays.asList("Thermal Printers", "Paper Shredders", "Lamination Machines");
		List<String> shopByType = Arrays.asList("CCTV Camera Kits", "Note Counters", "Barcode Scanners",
				"Label Printers");
		HomePageActivity homePage = new HomePageActivity(driver);
		homePage.selectCategory("Mobiles & Electronics");
		MobileElectronicsPageActivity mePage = homePage.selectSubCategory("Office Equipments");
		Assert.assertEquals(mePage.getEquipmentTypes(), equipmentTypes, "Invalid equipment Types");
		Assert.assertEquals(mePage.getOfficeMustHaves(), officeHaves, "Invalid office haves");
		Assert.assertEquals(mePage.getShopByType(), shopByType, "Invalid Shop By Types");
	}

	@Test
	public void verifyLaptopsComputers() {

		List<String> items = Arrays.asList("Laptops", "Printers & Inks", "Storage", "Computer Accessories",
				"Computer Components", "Routers & Modems", "Desktops", "More");
		List<String> topViewedProducts = Arrays.asList("Acer Laptops starting Rs.13999", "Antivirus | Upto 70% Off",
				"Logitech B170 Wireless Mouse");
		List<String> budgetStore = Arrays.asList("2-in-1 Laptops", "Assembled Desktops", "Laptop Skins",
				"McAfee Antivirus @ Rs 99");
		HomePageActivity homePage = new HomePageActivity(driver);
		homePage.selectCategory("Mobiles & Electronics");
		MobileElectronicsPageActivity mePage = homePage.selectSubCategory("Laptops & Computers");
		Assert.assertEquals(mePage.getAllItems(), items, "Invalid Items");
		Assert.assertEquals(mePage.getTopViewedProducts(), topViewedProducts, "Invalid Top Viewed Products");
		Assert.assertEquals(mePage.getItemsFromBudgetStore(), budgetStore, "Invalid Budget Store Items");

	}

	@Test
	public void verifyCamerasAccessories() {
		List<String> cameraItems = Arrays.asList("DSLRs", "Digital Cameras", "Camera Lenses", "Selfie Sticks",
				"Camera Accessories", "Binoculars & Telescopes", "Camcorders", "Digital Photo Frames");
		List<String> bestCameras = Arrays.asList("Nikon Coolpix 20.1 MP", "Nikon Coolpix 16.1 MP", "Canon EOS 1300D",
				"Sony Cybershot W800");

		HomePageActivity homePage = new HomePageActivity(driver);
		homePage.selectCategory("Mobiles & Electronics");
		MobileElectronicsPageActivity mePage = homePage.selectSubCategory("Cameras & Accessories");

		Assert.assertEquals(mePage.getAllCameraItems(), cameraItems, "Invalid Camera Items");
		/*
		 * Assert.assertTrue(mePage.getAllBestCameras().contains(bestCameras),
		 * "Invalid Best Deals");
		 */ }

	@Test
	public void filterByTelevisonSize() {

		HomePageActivity homePage = new HomePageActivity(driver);
		homePage.selectCategory("Mobiles & Electronics");
		MobileElectronicsPageActivity mePage = homePage.selectSubCategory("TVs, Audio & Video");
		mePage.navigateToTVPage("Televisions");
		mePage.applyFilter("32");
		System.out.println(mePage.getFirstTVTitle());
		Assert.assertTrue(mePage.getFirstTVTitle().contains("32"), "Invalid filter applied");

	}

	@Test
	public void verifyToastMSGAfterAddingToCart() {
		try {
			HomePageActivity homePage = new HomePageActivity(driver);
			homePage.selectCategory("Mobiles & Electronics");
			MobileElectronicsPageActivity mePage = homePage.selectSubCategory("TVs, Audio & Video");

			mePage.addItemToCart("Televisions");
			Assert.assertTrue(mePage.getToastMessage().contains("Added To Cart"), "Invalid Toast Message");
			mePage.removeItemToCart();
			Assert.assertEquals(mePage.getCartButtonText(), "Add to Cart",
					"Invalid button type. Item has not been removed from cart");
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			FileUtilities utils = new FileUtilities();
			utils.deleteExisitngFolder(System.getProperty("user.dir") + File.separator + "toastmessages");
		}
	}

	@Test
	public void filterByCompatibilityModel() {
		HomePageActivity homePage = new HomePageActivity(driver);
		homePage.selectCategory("Mobiles & Electronics");
		MobileElectronicsPageActivity mePage = homePage.selectSubCategory("Mobile Phones");
		mePage.selectMobileType("LG", "Brand", "Rs. 8000-15000");
		mePage.clickApplyButton();
		Assert.assertTrue(mePage.getFirstTVTitle().contains("LG"), "Filter is not applied properly");

	}

	@Test
	public void filterByScreenSize() {
		HomePageActivity homePage = new HomePageActivity(driver);
		homePage.selectCategory("Mobiles & Electronics");
		MobileElectronicsPageActivity mePage = homePage.selectSubCategory("Mobile Phones");
		mePage.selectMobileType("5.5 - 6.0", "Screen Size", "Rs. 8000-15000");
		mePage.clickApplyButton();
		mePage.clickOnFirstItem();
		mePage.swipeDown_Multi(4);
		mePage.clickOnViewMoreLink();
		mePage.clickOnTechSpecTab();
		String screenSize = mePage.getScreenSize();
		System.out.println(screenSize);
		Assert.assertTrue(screenSize.contains("5.5") || screenSize.contains("6.0"), "Filter is not applied properly");

	}

	@Test
	public void sortFunctionality() {
		HomePageActivity homePage = new HomePageActivity(driver);
		homePage.selectCategory("Mobiles & Electronics");
		MobileElectronicsPageActivity mePage = homePage.selectSubCategory("Mobile Phones");
		mePage.selectMobileType("5.5 - 6.0", "Screen Size", "Rs. 8000-15000");
		mePage.clickApplyButton();
		mePage.sortByType("Discount");
		Assert.assertTrue(mePage.compareDiscounts(), "Not arranged in sorted order");
	}

	@AfterMethod
	public void afterMethod() {
		driver.closeApp();
	}
}
