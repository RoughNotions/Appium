package com.imaginea.pageobjects;

import static org.bytedeco.javacpp.lept.pixDestroy;
import static org.bytedeco.javacpp.lept.pixRead;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.lept.PIX;
import org.bytedeco.javacpp.tesseract.TessBaseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.imaginea.utils.UIUtility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * 
 * @author avinashg
 *
 */

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
	String pinCode = "com.snapdeal.main:id/shipnearPincode";
	String verifyButton = "com.snapdeal.main:id/shipnearverifyBtn";
	String imageView = "com.snapdeal.main:id/imageView";
	String applyFilter = "com.snapdeal.main:id/applyFilterButton";
	String filterButton = "com.snapdeal.main:id/filter_by_text_view";
	String enterSize = "com.snapdeal.main:id/search_txtbox";
	String spec = "com.snapdeal.main:id/featureTextView";
	String viewMore = "com.snapdeal.main:id/viewMoreButton";
	String specText = "com.snapdeal.main:id/itemTextView1";
	String sortIcon = "com.snapdeal.main:id/sort_by_text_view";
	String radioButtons = "com.snapdeal.main:id/sort_by_radio_button";
	String productDiscounts = "com.snapdeal.main:id/productDiscount";

	public MobileElectronicsPageActivity(AppiumDriver driver) {
		super(driver);
		sleep(5000L);
		initPage(driver.findElement(homeMenu));
	}

	public void navigateToBackPage() {
		driver.navigate().back();
		/*
		 * Below code also works AndroidDriver adriver = (AndroidDriver) driver;
		 * adriver.pressKeyCode(AndroidKeyCode.BACK);
		 */
	}

	public String getPageTitle(String subCategoryName) {
		String category = String.format("//android.widget.TextView[@text='%s']", subCategoryName);
		waitForElementVisibility(60, driver.findElementByXPath(category));
		return driver.findElementByXPath(category).getText();

	}

	public List<String> getAllMobilesByPriceRange() {
		List<String> text = getListOfElementsByID(mobileByPrice);
		List<String> fList = new ArrayList<String>();
		for (int i = 0; i < 6; i++) {
			fList.add(text.get(i));

		}
		return fList;
	}

	public List<String> getAllMobilesByPriceType() {
		waitForElementVisibility(60, driver.findElementById(mobileByTypes));
		List<String> text = getListOfElementsByID(mobileByTypes);
		return text;
	}

	public List<String> getAllMobilesByPicks() {
		driver.scrollToExact("Top Picks");
		List<String> text = getListOfElementsByID(mobileByPicks);
		return text;
	}

	public List<String> getAllGameItems() {
		List<String> text = getListOfElementsByID(gameItems);
		List<String> ftext = new ArrayList<String>();
		for (int i = 0; i < 5; i++)
			ftext.add(text.get(i));
		return ftext;
	}

	public List<String> getAllGameTypes() {
		driver.scrollTo("Play Games with consoles");

		List<String> text = getListOfElementsByID(gameTypes);
		return text;
	}

	public List<String> getAllBestDeals() {
		driver.scrollToExact("Limited Period Offer");
		List<String> text = getListOfElementsByID(bestDeals);
		return text;
	}

	public List<String> getAllApplianceItems() {
		List<String> text = getListOfElementsByID(applianceItems);
		return text;
	}

	private void clickMoreLink() {
		clickElementusingXPath(moreLink);
	}

	public List<String> getGreatDeals() {
		driver.scrollTo("Great Deals");
		List<String> text = getListOfElementsByID(greatDeals);
		return text;
	}

	public List<String> getAllTrimmersByPrice() {
		driver.scrollToExact("Trimmers By Price");
		List<String> text = getListOfElementsByID(trimmersPrice);
		return text;
	}

	public List<String> getTabletTypes() {
		List<String> text = getListOfElementsByID(tabletTypes);
		return text;
	}

	public List<String> getTabletItems() {
		List<String> text = getListOfElementsByID(tabletItems);
		return text;
	}

	public List<String> getPriceStore() {
		driver.scrollTo("20,000 and Above");
		List<String> text = getListOfElementsByID(priceStore);
		return text;
	}

	public List<String> getOS() {
		driver.scrollTo("Shop By Operating System");
		List<String> text = getListOfElementsByID(osText);
		return text;
	}

	public void addItemToCart(String item) {
		clickElementByText(item);
		sleep(5000L);
		clickElementByText(getFirstItemTitle());
		sleep(5000L);
		clickElementByText(getFirstTVTitle());
		sleep(5000L);
		enterTextusingIDDontHide(pinCode, "500034");
		clickElementusingID(verifyButton);
		clickElementusingID(cartButton);
	}

	public void removeItemToCart() {
		sleep(5000L);
		clickElementusingID(goToCart);
		sleep(5000L);
		clickElementusingID(removeItem);
		clickElementusingID(remove);
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
		clickElementByText(item);
		sleep(5000L);
		clickElementByText(getFirstItemTitle());
		sleep(5000L);
		clickElementByText(getFirstTVTitle());
		clickElementusingID("com.snapdeal.main:id/imageView");
		for (int i = 0; i < 10; i++)
			driver.pinch(driver.findElementById("com.snapdeal.main:id/imageView"));
	}

	public List<String> getEquipmentTypes() {
		List<String> text = getListOfElementsByID(mobileByPrice);
		return text.subList(0, 6);
	}

	public List<String> getOfficeMustHaves() {
		swipeDown();
		List<String> text = getListOfElementsByID(tabletTypes);
		return text;
	}

	public List<String> getShopByType() {
		driver.scrollTo("Shop By Type");
		List<String> text = getListOfElementsByID(mobileByPicks);
		return text;
	}

	public List<String> getAllItems() {
		List<String> text = getListOfElementsByID(mobileByPrice);
		return text;
	}

	public List<String> getTopViewedProducts() {
		swipeDown();
		List<String> text = getListOfElementsByID(mobileByTypes);
		return text;
	}

	public List<String> getItemsFromBudgetStore() {
		driver.scrollToExact("McAfee Antivirus @ Rs 99");
		List<String> text = getListOfElementsByID(mobileByPicks);
		return text;
	}

	public List<String> getAllCameraItems() {
		List<String> text = getListOfElementsByID(mobileByPrice);
		return text;
	}

	public List<String> getAllBestCameras() {
		driver.scrollToExact("Best of Cameras");
		List<String> text = getListOfElementsByID(mobileByPicks);
		return text;
	}

	public void navigateToTVPage(String item) {
		clickElementByText(item);
		sleep(5000L);
		clickElementByText(getFirstItemTitle());
		sleep(5000L);
	}

	public void applyFilter(String size) {
		clickElementusingID(filterButton);
		unCheckAllCheckBoxes();
		enterTextByID(enterSize, size);
		sleep(5000l);
		selectCheckBox();
		clickElementusingID(applyFilter);
	}

	private void selectCheckBox() {
		clickElementusingID("com.snapdeal.main:id/checkbox");
	}

	private void unCheckAllCheckBoxes() {
		AndroidDriver adriver = (AndroidDriver) driver;
		List<MobileElement> ele = adriver.findElementsByAndroidUIAutomator("new UiSelector().checked(true)");
		for (int i = 0; i < ele.size(); i++) {
			System.out.println(ele.size());
			ele.get(i).click();
		}
	}

	public String getToastMessage() {
		String filePath = System.getProperty("user.dir") + "\\toastmessages";
		File file = new File(filePath);
		file.mkdir();
		sleep(2000l);
		captureScreenshot(filePath);
		String str = "";
		BytePointer outText;
		TessBaseAPI api = new TessBaseAPI();

		if (api.Init(".", "ENG") != 0) {
			System.err.println("Could not initialize tesseract.");
			System.exit(1);
		}

		PIX image = pixRead(filePath + "\\toastmessage1.png");
		api.SetImage(image);
		// Get OCR result
		outText = api.GetUTF8Text();
		str = outText.getString();
		Assert.assertTrue(!str.isEmpty());
		System.out.println("OCR output:\n" + str);

		// Destroy used object and release memory
		api.End();
		outText.deallocate();
		pixDestroy(image);
		return str;
	}

	public void captureScreenshot(String path) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String filePath = path + "\\toastmessage1.png";
			FileUtils.copyFile(scrFile, new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Click on Apply Button
	 */
	public void clickApplyButton() {
		clickElementByText("APPLY");
	}

	public void selectMobileType(String string, String string2, String string3) {
		clickElementByText(string3);
		clickElementByText(string2);
		clickElementByText(string);
	}

	public void clickOnFirstItem() {
		clickElementByText(getFirstTVTitle());
		sleep(5000L);
		enterTextusingIDDontHide(pinCode, "500034");
		clickElementusingID(verifyButton);
	}

	public void swipeDown_Multi(int n) {
		for (int i = 1; i <= n; i++) {
			swipeDown();
		}
	}

	public String getScreenSize() {
		swipeDown();
		String str = "";
		List<WebElement> ele = driver.findElementsById(specText);
		for (int i = 0; i < ele.size(); i++)
			str = str + ele.get(i).getText();
		return str;
	}

	public void clickOnViewMoreLink() {
		clickElementusingID(viewMore);

	}

	public void clickOnTechSpecTab() {
		AndroidDriver adriver = (AndroidDriver) driver;
		adriver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"android:id/text1\").index(1)").click();
		sleep(5000l);

	}

	public void swipeImages() {
		swipeRight(driver.findElementById(imageView));
	}

	public void clickOnImage() {
		clickElementusingID(imageView);
	}

	public void sortByType(String str) {
		clickElementusingID("com.snapdeal.main:id/sort_by_text_view");
		sleep(5000l);
		List<WebElement> ele = driver.findElementsById(radioButtons);
		if (str.equalsIgnoreCase("Relevance")) {
			ele.get(0).click();
		}
		if (str.equalsIgnoreCase("Popularity")) {
			ele.get(1).click();

		}
		if (str.equalsIgnoreCase("Price Low To High")) {
			ele.get(2).click();

		}
		if (str.equalsIgnoreCase("Price High To Low")) {
			ele.get(3).click();

		}
		if (str.equalsIgnoreCase("New Arrival")) {
			ele.get(4).click();

		}
		if (str.equalsIgnoreCase("Discount")) {
			ele.get(5).click();

		}
	}

	public boolean compareDiscounts() {
		List<WebElement> ele = driver.findElementsById(productDiscounts);
		for (int i = 0; i < ele.size(); i++) {
			if (Integer.parseInt(ele.get(0).getText().substring(0, 1)) >= Integer
					.parseInt(ele.get(1).getText().substring(0, 1)))
				return true;
		}
		return false;
	}

	public List<String> getAllStationeryItems() {
		List<String> stationeryItems = getListOfElementsByID(mobileByPrice);
		return stationeryItems;
	}

}
