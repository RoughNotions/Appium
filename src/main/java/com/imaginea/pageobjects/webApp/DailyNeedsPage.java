package com.imaginea.pageobjects.webApp;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.imaginea.utils.UIUtility;

import io.appium.java_client.AppiumDriver;

public class DailyNeedsPage extends UIUtility {
	private By menuIcon = By.cssSelector("span.hdr-icon.menu.lfloat.menuIcon_h");
	private String categoryMenu = "//div[text()='%s' and @class='catName ellip']";
	private String subCategories = "//div[text()='%s' and @class='catName ellip']/../following-sibling::div[@class='subCatHldr'][1]/a";
	private String relavantSubCategories = "//div[text()='%s' and @class='catName ellip']/../following-sibling::div[@class='subCatHldr'][1]/a[text()='%s']/following-sibling::div[1]/a";
	private By Makeup = By.linkText("Makeup");
	private By Productsort = By.id("productSorting");

	public DailyNeedsPage(AppiumDriver driver) {
		super(driver);
	}

	public void selectCategory(String categoryOption) {
		By category = By.xpath(String.format(categoryMenu, categoryOption));
		clickElement(category);
	}

	public void clickMenuicon() {
		sleep(3000l);
		clickElement(menuIcon);
		sleep(3000l);
	}

	public List<String> getSubCategories(String categoryMenu) {
		By category = By.xpath(String.format(subCategories, categoryMenu));
		return getElementsText(category);
	}

	public void clickSubCategory(String categoryMenu, String subCategory) {
		By category = By.xpath(String.format(subCategories, categoryMenu));
		clickSubElementFromList(category, subCategory);
	}

	public List<String> getRelavantSubCategories(String categoryMenu, String subCategory) {
		By category = By.xpath(String.format(relavantSubCategories, categoryMenu, subCategory));
		return getElementsText(category);
	}

	public void clickElementByText(String Text) {

		sleep(3000l);
		clickElementusingLinkedText(Text);
	}

	public void clickOnSortPopularity() {
		sleep(3000l);
		driver.findElementByCssSelector(".sd-icon-collapse-arrow");
	}

	/**
	 * Get List of Sort Category
	 * 
	 * @return
	 */

	public List<String> getSortCategoryList() {
		return getElementsText(Productsort);
	}

	public List<String> getSortingCategoryList() {
		List<String> option = new ArrayList<>();
		Select select = new Select(driver.findElement(By.id("productSorting")));
		for (WebElement element : select.getOptions()) {
			option.add(element.getText());
			System.out.println(element.getText());
		}
		return option;
	}

}
