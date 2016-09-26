package com.imaginea.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.imaginea.utils.UIUtility;

public class HomePageActivity extends UIUtility {

	By homeMenu = MobileBy.className("android.widget.TextView");
	public static String uname = "com.snapdeal.main:id/firstEmailEditText";
	String imageButton = "android.widget.ImageButton";
	String loginLink = "com.snapdeal.main:id/loggedUserEmail";
	String continueButton = "com.snapdeal.main:id/continuebtn";
	String password = "com.snapdeal.main:id/thirdEditText";
	String loginButton = "com.snapdeal.main:id/loginNewBtn";
	String errorMSG = "com.snapdeal.main:id/errorTextView";
	String searchBoxB = "com.snapdeal.main:id/search_text_view";
	String searchBoxA = "com.snapdeal.main:id/search_edit_text_autocomplete";
	String mobileRechargeLink = "com.snapdeal.main:id/mobileRechargeItem";
	String mobileElectronics = "//*[text()='Mobiles & Electronics']";
	String categoryName = "com.snapdeal.main:id/subCategoryTitleTextView";
	String skip = "com.snapdeal.main:id/tv_skip";
	String popupmodal="//android.widget.TextView[@resource-id='android:id/alertTitle' and @text='Get Google Play services']";

	public HomePageActivity(AppiumDriver driver) {
	    super(driver);
            sleep(20000L);
            initPage(driver.findElement(homeMenu));
            if(isElementPresent(skip)){
                clickElementusingID(skip);
            }
            sleep(15000L);
	}

	public void login() {
		clickElementusingClassName( imageButton);
		clickElementusingID( loginLink);
		enterTextusingID( uname, "avinash.golla@yahoo.com");
		clickElementusingID( continueButton);
		enterTextusingID( password, "12345");
		clickElementusingID( loginButton);

	}

	public String getErroMsg() {
		return wrongPasswordErrorMSG(errorMSG);
	}

	public String wrongPasswordErrorMSG(String errorMSG) {
		return getTextMSG( errorMSG);

	}

	/**
	 * Select Category by Category Name
	 * 
	 * @param categoryName
	 */
	public void selectCategory(String categoryName) {
	        sleep(5000L);
		clickElementusingClassName( imageButton);
		String category = String.format(
				"//android.widget.TextView[@text='%s']", categoryName);
		waitForElementVisibility( 30,
				driver.findElement(By.xpath(category)));
		clickElementusingXPath( category);
	}

	/**
	 * Get List of Sub Category Items Under a Category Name
	 * 
	 * @param categoryName
	 */
	public List<String> getSubItemsList() {
		List<String> text = getListOfElementsByID( categoryName);
		return text;
	}

	/**
	 * Selects a SubCategory Under a Category
	 * @param subCategoryName
	 */
	public MobileElectronicsPageActivity selectSubCategory(String subCategoryName) {
		sleep(500L);
		String subCategory = String.format("//android.widget.TextView[@text='%s']", subCategoryName);
		clickElementusingXPath( subCategory);
		return new MobileElectronicsPageActivity(driver);
	}

	public void tapOnSearch(){
		WebElement element= driver.findElementById("com.snapdeal.main:id/search_text_view");
		tapElement(element);
	}
	
	public void enterProductToSearch(String sProduct){
		enterTextusingID( "com.snapdeal.main:id/search_edit_text_autocomplete",sProduct); 
		pressEnterKeyInAndroid();
		sleep(5000l);
	}
	
	public boolean verifySearchResultsText(String sProdouct){
		String sMessage=getTextMSG( "com.snapdeal.main:id/spell_check_partial_text_view");
		if(sMessage.contains(sProdouct)){
			return true;
		}
		return false;
	}

	public boolean verifySearchResultsCount(int count,String sProdouct){
		String sMessage=getTextMSG( "com.snapdeal.main:id/spell_check_partial_text_view");
		if(sMessage.equals("Showing "+count+" results for '"+sProdouct+"'")){
			return true;
		}
		return false;
	}
	public void tapOnAppllyFilter(){
		WebElement element= driver.findElementById("com.snapdeal.main:id/filter_by_text_view");
		driver.tap(1, element, 3000);
		
	}
	
	public int getCountOfSubCategory(String subCategory){
		String locator = String.format("//android.widget.TextView[@text='%s']/following-sibling::*[1]", subCategory);
		return Integer.parseInt(getTextUsingXpath(locator).replaceAll("\\D", ""));
	}
	public void tapOnCategory(String subCategory){
		String locator = String.format("//android.widget.TextView[@text='%s']", subCategory);
		tapElement(driver.findElementByXPath(locator));
	}
	

}
