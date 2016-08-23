package com.imaginea.utils;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class UIUtility {
	protected AppiumDriver driver;
	protected static final int pageTimeoutTime = 15;

	public UIUtility(AppiumDriver driver) {
		this.driver = driver;	
	}

	public void initPage(WebElement initialElement, WebElement... initialElements) {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, pageTimeoutTime), this);
		if (initialElement != null) {
			waitForElementVisibility(driver, 60, initialElement);
			for (WebElement element : initialElements) {
				waitForElementVisibility(driver, 60, element);
			}
		}
	}

	public void waitForElementVisibility(WebDriver driver, int timeout, WebElement element) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
	}

	public static void clickElementusingClassName(AppiumDriver driver, String className) {
		driver.findElementByClassName(className).click();

	}

	public static void clickElementusingID(AppiumDriver driver, String ID) {
		driver.findElementById(ID).click();
	}

	public static void enterTextusingID(AppiumDriver driver, String text, String email) {
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

	public static void clickElementusingLinkedText(AppiumDriver driver, String str) {
		driver.findElementByLinkText(str).click();
	}

	public static void clickElementusingXPath(AppiumDriver driver, String continueButton) {
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

	public static void enterTextusingIDDontHide(AppiumDriver driver, String text, String email) {
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
}
