package com.imaginea.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UIUtility {
	protected AppiumDriver driver;
	protected static final int pageTimeoutTime = 15;

	public UIUtility(AppiumDriver driver) {
		this.driver = driver;
	}

	public void initPage(WebElement initialElement,
			WebElement... initialElements) {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,
				pageTimeoutTime), this);
		if (initialElement != null) {
			waitForElementVisibility(driver, 90, initialElement);
			for (WebElement element : initialElements) {
				waitForElementVisibility(driver, 90, element);
			}
		}
	}

	public static void waitForElementVisibility(WebDriver driver, int timeout,
			WebElement element) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions
				.visibilityOf(element));
	}

	public static void clickElementusingClassName(AppiumDriver driver,
			String className) {
		driver.findElementByClassName(className).click();

	}

	public static void clickElementusingID(AppiumDriver driver, String ID) {
		driver.findElementById(ID).click();
	}

	public static void enterTextusingID(AppiumDriver driver, String text,
			String email) {
		driver.findElementById(text).clear();
		driver.findElementById(text).sendKeys(email);
		driver.hideKeyboard();
	}

	public static String getErrorMSG(AppiumDriver driver, String resourceID) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver.findElementById(resourceID).getText();
	}

	public static void clickElementusingLinkedText(AppiumDriver driver,
			String str) {
		driver.findElementByLinkText(str).click();
	}

	public static void clickElementusingXPath(AppiumDriver driver,
			String continueButton) {
		driver.findElementByXPath(continueButton).click();
	}

	public static void pressEnter(AppiumDriver driver, String locator) {
		driver.findElementById(locator).sendKeys(Keys.ENTER);
	}

	public static boolean isElementPresent(AppiumDriver driver, String uname) {
		List<WebElement> ele = driver.findElementsById(uname);
		if (ele.size() > 0)
			return true;
		else
			return false;
	}

	public static void enterTextusingIDDontHide(AppiumDriver driver,
			String text, String email) {
		driver.findElementById(text).clear();
		driver.findElementById(text).sendKeys(email);
	}

	public static void clickonSearchBox(AppiumDriver driver, String searchBox) {
		driver.findElementById(searchBox).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get List of Text
	 * 
	 * @param driver
	 * @param by
	 * @return
	 */
	public static List<String> getListOfByText(AppiumDriver<WebElement> driver,
			By by) {
		List<String> list = new ArrayList<String>();
		waitForElementVisibility(driver, 10000, driver.findElement(by));
		List<WebElement> element = driver.findElements(by);
		for (WebElement e : element) {
			list.add(e.getText());
		}
		return list;
	}

	/**
	 * 
	 * @param driver
	 * @param description
	 */
	public static void clickElementByText(AppiumDriver driver,
			String description) {
		driver.findElement(
				MobileBy.AndroidUIAutomator(String.format(
						"new UiSelector().text(\"%s\")", description))).click();
	}

	public static void sleep(Long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param driver
	 * @param description
	 */
	public static String getElementTextByIndex(AppiumDriver driver, int index) {
		sleep(15000L);
		return driver.findElement(
				MobileBy.AndroidUIAutomator(String.format(
						"new UiSelector().index(%d)", index))).getText();
	}

	public static List<String> getListOfElementsByID(AppiumDriver driver,
			String ID) {
		List<WebElement> ele = driver.findElementsById(ID);
		List<String> text = new ArrayList<String>();
		for (int i = 0; i < ele.size(); i++) {
			System.out.println(ele.get(i).getText());
			text.add(ele.get(i).getText());
		}
		System.out.println("count --->"+text.size());
		return text;
	}
	
	/**
	 * Swipe down page
	 * @param driver
	 */
	public static void swipeDown(AppiumDriver driver){
		Dimension dimensions = driver.manage().window().getSize();
		Double screenHeightStart = dimensions.getHeight() * 0.7;
		int scrollStart = screenHeightStart.intValue();		
		Double screenHeightEnd = dimensions.getHeight() * 0.4;
		int scrollEnd = screenHeightEnd.intValue();
		driver.swipe(0,scrollStart,0,scrollEnd,2000);
	}
	public static List<WebElement> getElementsTextByIndex(AppiumDriver driver, int index) {
		sleep(15000L);
		return driver.findElements(MobileBy.AndroidUIAutomator(String.format("new UiSelector().index(%d)", index)));
	}
	
	public static List<String> getTitles(AppiumDriver driver, int index){
		List<WebElement> ele = getElementsTextByIndex(driver,index);
		List<String> names = new ArrayList<String>();
		for (int i = 0; i < ele.size(); i++) {
			System.out.println(ele.get(i).getText());
			names.add(ele.get(i).getText());
		}
		System.out.println("count --->"+names.size());
		return names;
	}
	
	public static void enterTextByID(AppiumDriver driver, String id,
			String text) {
		driver.findElementById(id).clear();
		driver.findElementById(id).sendKeys(text);
		driver.hideKeyboard();
	}	
}
