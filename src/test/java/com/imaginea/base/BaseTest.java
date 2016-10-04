package com.imaginea.base;

import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.imaginea.utils.FileUtilities;

import io.appium.java_client.AppiumDriver;

@Listeners(com.imaginea.base.ExtentReport.class)
public class BaseTest {

    @SuppressWarnings("rawtypes")
    protected AppiumDriver driver;
    DriverFactory factory;
    String screenShotNameWithTimeStamp;
    FileUtilities utils;

    @BeforeClass
    public void setup() {
        try {
            utils = new FileUtilities();
            Properties properties = utils.getProperties();
            factory = new DriverFactory();
            driver = factory.getDriver(properties);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void startApp() {
        utils = new FileUtilities();
        Properties properties = utils.getProperties();
        if (properties.getProperty("APP_TYPE").equalsIgnoreCase("WebApp")) {
            if (driver != null)
                driver.get("https://m.snapdeal.com");
            else {
                factory = new DriverFactory();
                driver = factory.getDriver(properties);
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                driver.get("https://m.snapdeal.com");
            }
        }
        else{
            driver.closeApp();
            driver.launchApp();
        }
    }
    

    @BeforeSuite
    public void setupTestSuite() {
        FileUtilities utils = new FileUtilities();
        utils.deleteExisitngFolder(System.getProperty("user.dir") + File.separator + "ScreenShots");
    }

    @AfterClass(alwaysRun = true)
    public void clearSession() {
        driver.quit();
    }

}
