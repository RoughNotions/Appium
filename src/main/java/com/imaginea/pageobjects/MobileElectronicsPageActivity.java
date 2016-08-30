package com.imaginea.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;

import com.imaginea.utils.UIUtility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

/**
 * 
 * @author avinashg
 *
 */
@Listeners(com.imaginea.tests.ExtentReporterNG.class)

public class MobileElectronicsPageActivity extends UIUtility {

	By homeMenu = MobileBy.className("android.widget.TextView");
	String title = "android.widget.TextView";
	String mobileElectronics = "//*[text()='Mobiles & Electronics']";
	String mobileByTypes = "com.snapdeal.main:id/tysProductItemTitle";
	String mobileByPrice = "com.snapdeal.main:id/txvProductItemTitle";
	String mobileByPicks = "com.snapdeal.main:id/price_range_text";
	String gameTypes = "com.snapdeal.main:id/price_range_text";
	String gameItems = "com.snapdeal.main:id/txvProductItemTitle";
	String bestDeals = "com.snapdeal.main:id/tysProductItemTitle";
	String trimmersPrice = "com.snapdeal.main:id/tysProductItemTitle";
	String greatDeals = "com.snapdeal.main:id/price_range_text";
	String moreLink = "//android.widget.TextView[text()='More']";
	String applianceItems = "com.snapdeal.main:id/txvProductItemTitle";
	String tabletTypes = "com.snapdeal.main:id/tysProductItemTitle";
	String tabletItems = "com.snapdeal.main:id/txvProductItemTitle";
	String osText = "com.snapdeal.main:id/price_range_text";
	String priceStore = "com.snapdeal.main:id/price_range_text";
	String item = "//android.widget.TextView[text()='Televisions']";
	String cartButton = "com.snapdeal.main:id/addCartBUtton";
	String goToCart = "com.snapdeal.main:id/addCartBUtton";
	String removeItem = "com.snapdeal.main:id/btnMinus";
	String remove = "com.snapdeal.main:id/tvNoDialog";
	String firstTV = "com.snapdeal.main:id/productTitle";

	public MobileElectronicsPageActivity(AppiumDriver driver) {
		super(driver);
		sleep(5000L);
		initPage(driver.findElement(homeMenu));
	}

	public void navigateToBackPage() {
		driver.navigate().back();
		/* Below code also works 
		 * AndroidDriver adriver = (AndroidDriver) driver;
		 * adriver.pressKeyCode(AndroidKeyCode.BACK);
		 */
	}

	public String getPageTitle(String subCategoryName) {
		String category = String.format("//android.widget.TextView[@text='%s']", subCategoryName);
		UIUtility.waitForElementVisibility(driver, 60, driver.findElementByXPath(category));
		return driver.findElementByXPath(category).getText();

	}

	public List<String> getAllMobilesByPriceRange() {
		List<String> text = UIUtility.getListOfElementsByID(driver, mobileByPrice);
		List<String> fList = new ArrayList<String>();
		for (int i = 0; i < 6; i++) {
			fList.add(text.get(i));

		}
		return fList;
	}

	public List<String> getAllMobilesByPriceType() {
		UIUtility.waitForElementVisibility(driver, 60, driver.findElementById(mobileByTypes));
		List<String> text = UIUtility.getListOfElementsByID(driver, mobileByTypes);
		return text;
	}

	public List<String> getAllMobilesByPicks() {
		driver.scrollToExact("Top Picks");
		List<String> text = UIUtility.getListOfElementsByID(driver, mobileByPicks);
		return text;
	}

	public List<String> getAllGameItems() {
		List<String> text = UIUtility.getListOfElementsByID(driver, gameItems);
		List<String> ftext = new ArrayList<String>();
		for (int i = 0; i < 5; i++)
			ftext.add(text.get(i));
		return ftext;
	}

	public List<String> getAllGameTypes() {
		driver.scrollTo("Play Games with consoles");

		List<String> text = UIUtility.getListOfElementsByID(driver, gameTypes);
		return text;
	}

	public List<String> getAllBestDeals() {
		driver.scrollToExact("Limited Period Offer");
		List<String> text = UIUtility.getListOfElementsByID(driver, bestDeals);
		return text;
	}

	public List<String> getAllApplianceItems() {
		List<String> text = UIUtility.getListOfElementsByID(driver, applianceItems);
		return text;
	}

	private void clickMoreLink() {
		UIUtility.clickElementusingXPath(driver, moreLink);
	}

	public List<String> getGreatDeals() {
		driver.scrollTo("Great Deals");
		List<String> text = UIUtility.getListOfElementsByID(driver, greatDeals);
		return text;
	}

	public List<String> getAllTrimmersByPrice() {
		driver.scrollToExact("Trimmers By Price");
		List<String> text = UIUtility.getListOfElementsByID(driver, trimmersPrice);
		return text;
	}

	public List<String> getTabletTypes() {
		List<String> text = UIUtility.getListOfElementsByID(driver, tabletTypes);
		return text;
	}

	public List<String> getTabletItems() {
		List<String> text = UIUtility.getListOfElementsByID(driver, tabletItems);
		return text;
	}

	public List<String> getPriceStore() {
		driver.scrollTo("20,000 and Above");
		List<String> text = UIUtility.getListOfElementsByID(driver, priceStore);
		return text;
	}

	public List<String> getOS() {
		driver.scrollTo("Shop By Operating System");
		List<String> text = UIUtility.getListOfElementsByID(driver, osText);
		return text;
	}

	public void addItemToCart(String item) {
		UIUtility.clickElementByText(driver, item);
		sleep(5000L);
		UIUtility.clickElementByText(driver, getFirstItemTitle());
		sleep(5000L);
		UIUtility.clickElementByText(driver, getFirstTVTitle());
		sleep(5000L);
		UIUtility.clickElementusingID(driver, cartButton);
	}

	public void removeItemToCart() {
		sleep(5000L);
		UIUtility.clickElementusingID(driver, goToCart);
		sleep(5000L);
		UIUtility.clickElementusingID(driver, removeItem);
		UIUtility.clickElementusingID(driver, remove);
		navigateToBackPage();
	}

	public String getCartButtonText() {
		return driver.findElementById("com.snapdeal.main:id/addCartBUtton").getText();

	}

	public String getFirstTVTitle() {
		return driver.findElementById(firstTV).getText();
	}

	public String getFirstItemTitle() {
		return driver.findElementById(mobileByPrice).getText();
	}

	public void swipeAndZoom(String item) {
		UIUtility.clickElementByText(driver, item);
		sleep(5000L);
		UIUtility.clickElementByText(driver, getFirstItemTitle());
		sleep(5000L);
		UIUtility.clickElementByText(driver, getFirstTVTitle());
		UIUtility.clickElementusingID(driver, "com.snapdeal.main:id/imageView");
		for (int i = 0; i < 10; i++)
			driver.pinch(driver.findElementById("com.snapdeal.main:id/imageView"));
	}

	public List<String> getEquipmentTypes() {
		List<String> text = UIUtility.getListOfElementsByID(driver, mobileByPrice);
		return text;
	}

	public List<String> getOfficeMustHaves() {
		UIUtility.swipeDown(driver);
		List<String> text = UIUtility.getListOfElementsByID(driver, tabletTypes);
		return text;
	}

	public List<String> getShopByType() {
		driver.scrollTo("Shop By Type");
		List<String> text = UIUtility.getListOfElementsByID(driver, mobileByPicks);
		return text;
	}
}
