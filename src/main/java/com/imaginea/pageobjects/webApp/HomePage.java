package com.imaginea.pageobjects.webApp;

import java.util.List;

import org.openqa.selenium.By;

import com.imaginea.utils.UIUtility;

import io.appium.java_client.AppiumDriver;

public class HomePage extends UIUtility {
	
	private By menuIcon= By.cssSelector("span.hdr-icon.menu.lfloat.menuIcon_h");
	private String categoryMenu= "//div[text()='%s' and @class='catName ellip']";
	private String subCategories="//div[text()='%s' and @class='catName ellip']/../following-sibling::div[@class='subCatHldr'][1]/a";
	private String relavantSubCategories="//div[text()='%s' and @class='catName ellip']/../following-sibling::div[@class='subCatHldr'][1]/a[text()='%s']/following-sibling::div[1]/a";
	public HomePage(AppiumDriver driver) {
		super(driver);
	}

	public void selectCategory(String categoryOption) {
		By category= By.xpath(String.format(categoryMenu, categoryOption));
		clickElement(category);
	}
	
	public void clickMenuicon() {
		clickElement(menuIcon);
	}
	
	public List<String> getSubCategories(String categoryMenu) {
		By category= By.xpath(String.format(subCategories, categoryMenu));
		return getElementsText(category);
	}
	
	public void clickSubCategory(String categoryMenu,String subCategory){
		By category= By.xpath(String.format(subCategories, categoryMenu));
		clickSubElementFromList(category,subCategory);
	}
	
	public List<String> getRelavantSubCategories(String categoryMenu,String subCategory) {
		By category= By.xpath(String.format(relavantSubCategories, categoryMenu,subCategory));
		return getElementsText(category);
	}
}
