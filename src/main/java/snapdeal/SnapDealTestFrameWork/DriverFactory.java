package snapdeal.SnapDealTestFrameWork;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

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
		if (osName.equalsIgnoreCase("Android"))
			try {
				driver = new AndroidOS().getDriver(getDesiredCapabailities());
				AndroidDriver adriver = (AndroidDriver) driver;
				return adriver;
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		else if(osName.equalsIgnoreCase("IOS"))
			try {
				driver = new IOS().getDriver(getDesiredCapabailities());
				IOSDriver idriver = (IOSDriver) driver;
				return idriver;

			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		return driver;

	}

	public static DesiredCapabilities getDesiredCapabailities() {
		DesiredCapabilities capability = new DesiredCapabilities();

		File file = new File("config.properties");
		Properties prop = new Properties();
		FileInputStream inStream;
		try {
			inStream = new FileInputStream(file);
			try {
				prop.load(inStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		capability.setCapability(MobileCapabilityType.BROWSER_NAME, prop.getProperty("BROWSER_NAME"));
		capability.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("DEVICE_NAME"));
		capability.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getProperty("PLATFORM_NAME"));
		capability.setCapability("appPackage", prop.getProperty("APP_PACKAGE"));
		capability.setCapability("appActivity", prop.getProperty("APP_ACTIVITY"));
		return capability;
	}
}
