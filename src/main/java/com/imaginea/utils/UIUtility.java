package com.imaginea.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

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
    	PageFactory.initElements(new AjaxElementLocatorFactory(driver, pageTimeoutTime), this);
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
        WebElement element = driver.findElementByClassName(className);
        fluentWait(element);
        element.click();

    }

    public void clickElementusingID(String ID) {        
        waitForElementById(ID);
        WebElement element = driver.findElementById(ID);
        waitForElementVisibility(50, element);
        element.click();
    }

    public void enterTextusingID(String locator, String sText) {
        driver.findElementById(locator).clear();
        driver.findElementById(locator).sendKeys(sText);
        try {
            driver.hideKeyboard();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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
        waitForElementByXPath(continueButton);
        driver.findElementByXPath(continueButton).click();
    }
    
    public void clickElement(By by) {        
    	waitForElement(by);
        driver.findElement(by).click();
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

    public int getElementCountUsingXPath(String locator) {
        return driver.findElementsByXPath(locator).size();
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
    public void swipeToLeft(WebElement element) {    	
    	  
    	Dimension size = element.getSize();
        int x = (int) (size.width * 0.20);
        int y = size.height;
        TouchAction action = new TouchAction((MobileDriver) driver);
        MobileElement mobileElement = (MobileElement) element;
        action.longPress(mobileElement).moveTo(element, x, y).release().perform();
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
        TouchAction action = new TouchAction((MobileDriver) driver);
        MobileElement mobileElement = (MobileElement) element;
        action.longPress(mobileElement).moveTo(x1, y1).release().perform();
    }

    public void scrollToExactText(String sText) {
        driver.scrollToExact(sText);
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

    public void clickElementByText(String description) {
        sleep(2000L);
        fluentWait(driver
                .findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"%s\")", description)))).click();
    }

    public void sleep(Long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String getElementTextByIndex(int index) {        
        WebElement element =  driver.findElement(MobileBy.AndroidUIAutomator(String.format("new UiSelector().index(%d)", index)));
        fluentWait(element);
        return element.getText();
    }

    public List<String> getListOfElementsByID(String ID) {
        WebElement id = driver.findElementById(ID);
        fluentWait(id);
        List<WebElement> ele = driver.findElementsById(ID);        
        List<String> text = new ArrayList<String>();
        for (int i = 0; i < ele.size(); i++) {
            System.out.println(ele.get(i).getText());
            text.add(ele.get(i).getText());
        }
        System.out.println("count --->" + text.size());
        return text;
    }

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

    public void zoomImageById(String resourceId) {
        WebElement element = driver.findElement(By.id(resourceId));
        waitForElementVisibility(20, element);
        driver.tap(1, element, 2);
    }

    public void rotate(String myOrientation) {
        String orientation = driver.getOrientation().value();
        try {
            if (!orientation.equalsIgnoreCase(myOrientation)) {

                try {
                    driver.rotate(ScreenOrientation.valueOf(myOrientation));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            } else {
                try {
                    driver.rotate(ScreenOrientation.valueOf(myOrientation));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public WebElement waitForElementById(final String id) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = null;
        try {
            element = driver.findElementById(id);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
        }
        return element;
    }

    public WebElement waitForElementByClassName(final String className) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = null;
        try {
            element = driver.findElementByClassName(className);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
        }
        return element;
    }

    public WebElement waitForElementByXPath(final String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = null;
        try {
            element = driver.findElementByXPath(xpath);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
        }
        return element;
    }

    public void tapElementByDescription(String description) {
        WebElement element = driver.findElement(
                MobileBy.AndroidUIAutomator(String.format("new UiSelector().description(\"%s\")", description)));
        waitForElementVisibility(10, element);
        element.click();
    }

    public WebElement waitForElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = null;
        try {
            element = driver.findElement(by);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
        }
        return element;
    }
    
    public List<WebElement> getElements(By by) {
    	waitForElement(by);
        return driver.findElements(by);
    }

    public List<String> getElementsText(By by) {
    	List<WebElement> list=getElements(by);
    	List<String> options= new LinkedList<String>();
    	for(WebElement ele:list){
    		options.add(ele.getText());
    	}
    	return options;
        
    }
    
    public WebElement fluentWait(final WebElement element) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(90, TimeUnit.SECONDS)
                .pollingEvery(15, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return element;
            }
        });
        return foo;
    };
    
    public WebElement fluentWaitBy(final By by) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(90, TimeUnit.SECONDS)
                .pollingEvery(15, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {                
                return driver.findElement(by);
            }
        });
        return foo;
    };
    public void clickSubElementFromList(By by,String text) {
        sleep(3000L);
    	List<WebElement> list=getElements(by);
    	for(WebElement ele:list){
    		if(ele.getText().trim().equalsIgnoreCase(text)){
    			ele.click();
    			break;
    		}
    	}
    }
    
    public boolean isElementExistInWeb(By by){
        return fluentWaitBy(by).isEnabled();
    }
    
    public void waitForElementToBeVisible(By by){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
    }
    public void clickSubElementFromList(List<WebElement> elements,String text) {
    	for(WebElement ele:elements){
    		if(ele.getText().trim().equalsIgnoreCase(text)){
    			ele.click();
    			break;
    		}
    	}
    }
    
    public void waitForPageLoad(){
    	while(true){
    	String pageStatus=(String)((JavascriptExecutor)driver).executeScript("return document.readyState");
    	if(pageStatus.equalsIgnoreCase("complete")){
    		break;
    	}else{
    		System.out.println("The status is "+pageStatus);
    	}
    	}
    }
    
    public void waitforAjaxLoading(){
    	   JavascriptExecutor  Js=(JavascriptExecutor)driver ;
    	   try{
    		   System.out.println(Js.executeScript("return window.jQuery"));
    	   }
    	   catch(Exception e){
    		   e.printStackTrace();
    	   }
    	   try{
    		   if((boolean) Js.executeScript("return window.jQuery != undefined")){
        		   while(!(boolean) Js.executeScript("return jQuery.active == 0")){
        			   sleep(1500l);
        			   break;
        		   }
        		   
        	   } 
    		   if((boolean) Js.executeScript("return window.jQuery == null")){
        		   System.out.println("The value is null............................");
        	   } 
    		   
    	   }  catch(Exception e){
    		   e.printStackTrace();
    	   }
    	 
    	    }
    
}
