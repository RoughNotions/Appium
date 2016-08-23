package snapdeal.SnapDealTestFrameWork;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.imaginea.pageobjects.HomePageActivity;
import com.imaginea.pageobjects.MobileElectronicsPageActivity;

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
		homePage.selectSubCategory("Mobile Phones");
		MobileElectronicsPageActivity mePage = new MobileElectronicsPageActivity(driver);
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

		homePage.selectCategory("Mobiles & Electronics");
		homePage.selectSubCategory("Office Equipments");
		Assert.assertEquals(mePage.getPageTitle("Office Equipments"), "Office Equipments");
		mePage.navigateToBackPage();

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
		homePage.selectSubCategory("Mobile Phones");

		MobileElectronicsPageActivity mePage = new MobileElectronicsPageActivity(driver);

		Assert.assertEquals(mePage.getAllMobilesByPriceType(), mobileType, "Invalid Price Range");
		Assert.assertEquals(mePage.getAllMobilesByPriceRange(), priceRange, "Invalid Price Range");
		Assert.assertEquals(mePage.getAllMobilesByPicks(), mobilePicks, "Invalid Price Range");

	}

	@AfterMethod
	public void afterMethod() {
		driver.closeApp();
	}
}
