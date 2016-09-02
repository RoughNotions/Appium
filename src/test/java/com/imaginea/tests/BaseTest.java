package com.imaginea.tests;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.android.ddmlib.AndroidDebugBridge;
import com.android.ddmlib.IDevice;
import com.imaginea.base.DriverFactory;
import com.imaginea.utils.FileUtilities;

import io.appium.java_client.AppiumDriver;

public class BaseTest {

	static AppiumDriver driver;
	String screenShotNameWithTimeStamp;

	@BeforeClass
	public void setup() {
		try {
			TestNG test = new TestNG();
			test.setUseDefaultListeners(false);
			File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			FileUtilities utils = new FileUtilities();
			utils.deleteExisitngFolder(System.getProperty("user.dir") + File.separator + "ScreenShots");
			driver = DriverFactory.getDriver(properties.getProperty("OS_NAME"));
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
