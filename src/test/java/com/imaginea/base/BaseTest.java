package com.imaginea.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.TestNG;
import org.testng.annotations.BeforeClass;
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

	@BeforeClass
	public void setup() {
		try {
			FileUtilities utils = new FileUtilities();
			Properties properties=utils.getProperties();
			factory= new DriverFactory();
			driver= factory.getDriver(properties);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@BeforeSuite
	public void setupTestSuite() {
		FileUtilities utils = new FileUtilities();
		utils.deleteExisitngFolder(System.getProperty("user.dir") + File.separator + "ScreenShots");
	}

}
