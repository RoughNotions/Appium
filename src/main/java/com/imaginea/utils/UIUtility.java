package com.imaginea.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class UIUtility {
    protected AppiumDriver driver;
    protected static final int pageTimeoutTime = 15;

    public UIUtility(AppiumDriver driver) {
        this.driver = driver;
    }

    public void initPage(WebElement initialElement, WebElement... initialElements) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, pageTimeoutTime), this);
        if (initialElement != null) {
            waitForElementVisibility(90, initialElement);
            for (WebElement element : initialElements) {
                waitForElementVisibility(90, element);
            }
        }
    }

    public void waitForElementVisibility(int timeout, WebElement element) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
    }

    public void clickElementusingClassName(String className) {
        driver.findElementByClassName(className).click();

    }

    public void clickElementusingID(String ID) {
        driver.findElementById(ID).click();
    }

    public void enterTextusingID(String locator, String sText) {
        driver.findElementById(locator).clear();
        driver.findElementById(locator).sendKeys(sText);
        driver.hideKeyboard();
    }

    public String getTextMSG(String resourceID) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return driver.findElementById(resourceID).getText();
    }

    public void clickElementusingLinkedText(String str) {
        driver.findElementByLinkText(str).click();
    }

    public void clickElementusingXPath(String continueButton) {
        driver.findElementByXPath(continueButton).click();
    }

    public void pressEnter(String locator) {
        driver.findElementById(locator).sendKeys(Keys.ENTER);
    }

    public boolean isElementPresent(String uname) {
        List<WebElement> ele = driver.findElementsById(uname);
        if (ele.size() > 0)
            return true;
        else
            return false;
    }

    public boolean isElementExists(String uname) {
        List<WebElement> ele = driver.findElementsByXPath(uname);
        if (ele.size() > 0)
            return true;
        else
            return false;
    }

    public void enterTextusingIDDontHide(String text, String email) {
        driver.findElementById(text).clear();
        driver.findElementById(text).sendKeys(email);
    }

    public void clickonSearchBox(String searchBox) {
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
    public List<String> getListOfByText(AppiumDriver<WebElement> driver, By by) {
        List<String> list = new ArrayList<String>();
        waitForElementVisibility(10000, driver.findElement(by));
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
    public void clickElementByText(String description) {
        WebElement element = driver
                .findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"%s\")", description)));
        waitForElementVisibility(10, element);
        element.click();
        sleep(10000L);
    }

    public void sleep(Long millis) {
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
    public String getElementTextByIndex(int index) {
        sleep(15000L);
        return driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().index(%d)", index)))
                .getText();
    }

    public List<String> getListOfElementsByID(String ID) {
        List<WebElement> ele = driver.findElementsById(ID);
        waitForElementVisibility(10, ele.get(0));
        List<String> text = new ArrayList<String>();
        for (int i = 0; i < ele.size(); i++) {
            System.out.println(ele.get(i).getText());
            text.add(ele.get(i).getText());
        }
        System.out.println("count --->" + text.size());
        return text;
    }

    /**
     * Swipe down page
     * 
     * @param driver
     */
    public void swipeDown() {
        Dimension dimensions = driver.manage().window().getSize();
        Double screenHeightStart = dimensions.getHeight() * 0.9;
        int scrollStart = screenHeightStart.intValue();
        Double screenHeightEnd = dimensions.getHeight() * 0.5;
        int scrollEnd = screenHeightEnd.intValue();
        driver.swipe(0, scrollStart, 0, scrollEnd, 2000);
    }

    public List<WebElement> getElementsTextByIndex(int index) {
        sleep(15000L);
        return driver.findElements(MobileBy.AndroidUIAutomator(String.format("new UiSelector().index(%d)", index)));
    }

    public List<String> getTitles(int index) {
        List<WebElement> ele = getElementsTextByIndex(index);
        List<String> names = new ArrayList<String>();
        for (int i = 0; i < ele.size(); i++) {
            System.out.println(ele.get(i).getText());
            names.add(ele.get(i).getText());
        }
        System.out.println("count --->" + names.size());
        return names;
    }

    public void enterTextByID(String id, String text) {
        driver.findElementById(id).clear();
        driver.findElementById(id).sendKeys(text);
        driver.hideKeyboard();
    }

    /**
     * Zoom Image on single tap
     * 
     * @param driver
     * @param resourceId
     */
    public void zoomImageById(String resourceId) {
        WebElement element = driver.findElement(By.id(resourceId));
        waitForElementVisibility(20, element);
        driver.tap(1, element, 2);
    }

    public List<WebElement> getElementsTextById(String resourceId) {
        return driver.findElementsById(resourceId);
    }

    public void tapElement(WebElement element) {
        TouchAction touch = new TouchAction(driver);
        waitForElementVisibility(10, element);
        touch.tap(element).perform();

    }

    public void swipeRight(WebElement element) {
        MobileElement mobileElement = (MobileElement) element;
        mobileElement.swipe(SwipeElementDirection.RIGHT, 5000);
    }

    private int getX(WebElement element, int x) {
        // Declare variable that contains the dimensions of the device screen
        Dimension winSize;
        // Retrieve the actual device dimensions
        winSize = element.getSize();
        return (int) ((winSize.width * x) / 100);
    }

    private int getY(WebElement element, int y) {
        // Declare variable that contains the dimensions of the device screen
        Dimension winSize;
        // Retrieve the actual device dimensions
        winSize = element.getSize();
        return (int) ((winSize.height * y) / 100);
    }

    public void swipeLeft(WebElement element) {
        Dimension size = driver.manage().window().getSize();
        int x1 = (int) (size.width * 0.20);
        int y1 = 1190;
        TouchAction action = new TouchAction((MobileDriver)driver);
        MobileElement mobileElement = (MobileElement) element;
        action.longPress(mobileElement).moveTo(x1,y1).release().perform();
    }

    public void scrollToExactText(String sText) {
        driver.scrollToExact(sText);
    }

    public void rotate(String myOrientation) {
        String orientation = driver.getOrientation().value();
        try {
            if (!orientation.equalsIgnoreCase(myOrientation)) {

                try {
                    ScreenOrientation.valueOf(myOrientation);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                driver.rotate(ScreenOrientation.valueOf(myOrientation));
                driver.rotate(ScreenOrientation.LANDSCAPE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pressEnterKeyInAndroid() {
        ((AndroidDriver) (this.driver)).pressKeyCode(AndroidKeyCode.ENTER);
    }

    public void pressBackKeyInAndroid() {
        ((AndroidDriver) (this.driver)).pressKeyCode(AndroidKeyCode.BACK);
    }

    public void pressHomeKeyInAndroid() {
        ((AndroidDriver) (this.driver)).pressKeyCode(AndroidKeyCode.HOME);

    }

    public void openNotifications() {
        AndroidDriver driver = (AndroidDriver) (this.driver);
        driver.openNotifications();
    }

    public String getTextUsingXpath(String locator) {
        return driver.findElementByXPath(locator).getText();

    }

    public String getCurrentActivityName() {
        AndroidDriver driver = (AndroidDriver) (this.driver);
        return driver.currentActivity();
    }

    public int getRandomNo(int number) {
        Random random = new Random();
        return random.nextInt(number);
    }
}
