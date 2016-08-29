package com.imaginea.tests;

import io.appium.java_client.AppiumDriver;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.testng.TestNG;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.imaginea.base.DriverFactory;
import com.imaginea.utils.FileUtilities;

public class BaseTest {

	static AppiumDriver driver;
	String screenShotNameWithTimeStamp;

	@BeforeClass
	public void setup() {
		try {
			TestNG test = new TestNG();
			test.setUseDefaultListeners(false);
			File file = new File("config.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			driver = DriverFactory.getDriver(properties.getProperty("OS_NAME"));	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	@BeforeSuite
	public void setupTestSuite() {
		FileUtilities utils = new FileUtilities();
		utils.deleteExisitngFolder(System.getProperty("user.dir")
				+ File.separator + "ScreenShots");
	}

}
