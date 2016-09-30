package com.imaginea.pageobjects.webApp;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

public class MobilePage extends HomePage {

	private String subSubCategoryLoc = "//div[@class='subCatBlock']/a[text()='%s']";
	public String mobileTypes = ".routeThroughCookieCSF_h.listItem.arrw.ripplelink";

	public MobilePage(AppiumDriver driver) {
		super(driver);
	}

	public void clickOnSubSubCategory(String subSubCategoryName) {
		By subSubCategory = By.xpath(String.format(subSubCategoryLoc, subSubCategoryName));
		clickElement(subSubCategory);

	}

	public List<String> getPriceTypes() {
		List<WebElement> mobileTypes = driver
				.findElementsByCssSelector(".routeThroughCookieCSF_h.listItem.arrw.ripplelink");
		List<String> fList = new ArrayList<String>();
		for (int i = 0; i < mobileTypes.size(); i++) {
			fList.add(mobileTypes.get(i).getText());

		}
		return fList;
	}
}
