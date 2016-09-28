package com.imaginea.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.android.ddmlib.AndroidDebugBridge;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class DriverFactory {
	public static AppiumDriver getDriver(String osName) {
		AppiumDriver driver = null;
		AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		saveAppiumLog(service);

		if (osName.equalsIgnoreCase("Android"))
			try {
				driver = new AndroidOS().getDriver(getDesiredCapabailities());
				AndroidDriver adriver = (AndroidDriver) driver;
				return adriver;
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		else if (osName.equalsIgnoreCase("IOS"))
			try {
				driver = new IOS().getDriver(getDesiredCapabailities());
				IOSDriver idriver = (IOSDriver) driver;
				return idriver;

			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		return driver;

	}

	public static void saveAppiumLog(AppiumDriverLocalService service) {
		try {
			OutputStream output;
			output = new FileOutputStream(System.getProperty("user.dir") + "//" + "Appium_log.txt");
			service.addOutPutStream(output);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

	}

	public static DesiredCapabilities getDesiredCapabailities() {
		DesiredCapabilities capability = new DesiredCapabilities();

		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
		Properties prop = new Properties();
		FileInputStream inStream;
		try {
			inStream = new FileInputStream(file);
			try {
				prop.load(inStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		
		capability.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("DEVICE_NAME"));
		capability.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getProperty("PLATFORM_NAME"));
		capability.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, prop.getProperty("NEW_COMMAND_TIMEOUT")); // Default
		if(prop.getProperty("APP_TYPE").equalsIgnoreCase("NativeApp")){
			capability.setCapability(MobileCapabilityType.APP,
					System.getProperty("user.dir") + "\\src\\test\\resources\\" + prop.getProperty("APP")); // Default
		}else{
			capability.setCapability(MobileCapabilityType.BROWSER_NAME, prop.getProperty("BROWSER_NAME"));
		}
		return capability;
	}
}
