package com.imaginea.pageobjects.webApp;

import java.util.List;

import org.openqa.selenium.By;

import com.imaginea.utils.UIUtility;

import io.appium.java_client.AppiumDriver;

public class HomePage extends UIUtility {
	
	private By menuIcon= By.cssSelector("span.hdr-icon.menu.lfloat.menuIcon_h");
	private String categorymenu= "//div[text()='%s' and @class='catName ellip']";
	private String subcategories="//div[text()='%s' and @class='catName ellip']/../following-sibling::div[@class='subCatHldr'][1]/a";
	public HomePage(AppiumDriver driver) {
		super(driver);
	}

	public void selectCategory(String categoryMenu) {
		By category= By.xpath(String.format(categorymenu, categoryMenu));
		clickElement(category);
	}
	
	public void clickMenuicon() {
		clickElement(menuIcon);
	}
	
	public List<String> getSubCategories(String categoryMenu) {
		By category= By.xpath(String.format(subcategories, categoryMenu));
		return getElementsText(category);
	}

}
