package com.imaginea.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.appium.utils.CommandPrompt;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class DriverFactory {

    private MobileOS mobileOS;
    private CommandPrompt cmd = new CommandPrompt();
    private ArrayList<String> deviceSerail = new ArrayList<String>();

    @SuppressWarnings("rawtypes")
    public AppiumDriver getDriver(Properties properties) {
        String executionSyle = properties.getProperty("EXECUTIONSTYLE");
        AppiumDriver driver = null;

        System.setProperty(AppiumServiceBuilder.NODE_PATH, "C:\\Program Files (x86)\\Appium\\node.exe");

        System.setProperty(AppiumServiceBuilder.APPIUM_PATH,
                "C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js");

        AppiumDriverLocalService service = AppiumDriverLocalService
                .buildService(new AppiumServiceBuilder().usingAnyFreePort());
        service.start();
        saveAppiumLog(service);
        if (executionSyle.equalsIgnoreCase("local")) {
            if (properties.getProperty("OS_NAME").equalsIgnoreCase("Android")) {
                try {
                    mobileOS = (MobileOS) Class.forName(properties.getProperty("ANDROIDCLASSNAME")).newInstance();
                    return (AndroidDriver) mobileOS.getDriver(service.getUrl().toString(),
                            getDesiredCapabailities(properties, executionSyle));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (properties.getProperty("OS_NAME").equalsIgnoreCase("IOS")) {
                try {
                    mobileOS = (MobileOS) Class.forName(properties.getProperty("IOSCLASSNAME")).newInstance();
                    return (IOSDriver) mobileOS.getDriver(service.getUrl().toString(),
                            getDesiredCapabailities(properties, executionSyle));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (executionSyle.equalsIgnoreCase("SauceLabs")) {
            String url = "http://" + properties.getProperty("USERNAME") + " : " + properties.getProperty("ACCESSKEY")
                    + "@ondemand.saucelabs.com:80/wd/hub";
            if (properties.getProperty("OS_NAME").equalsIgnoreCase("Android")) {
                try {
                    mobileOS = (MobileOS) Class.forName(properties.getProperty("ANDROIDCLASSNAME")).newInstance();
                    return (AndroidDriver) mobileOS.getDriver(url, getDesiredCapabailities(properties, executionSyle));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (properties.getProperty("OS_NAME").equalsIgnoreCase("IOS")) {
                try {
                    mobileOS = (MobileOS) Class.forName(properties.getProperty("IOSCLASSNAME")).newInstance();
                    return (IOSDriver) mobileOS.getDriver(url, getDesiredCapabailities(properties, executionSyle));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return driver;
    }

    public void saveAppiumLog(AppiumDriverLocalService service) {
        try {
            OutputStream output;
            output = new FileOutputStream(System.getProperty("user.dir") + File.separator + "Appium_log.txt");
            service.addOutPutStream(output);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

    }

    public DesiredCapabilities getDesiredCapabailities(Properties prop, String exectionMode) {
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("DEVICE_NAME"));
        capability.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getProperty("PLATFORM_NAME"));
        capability.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, prop.getProperty("NEW_COMMAND_TIMEOUT")); // Default
        if (prop.getProperty("APP_TYPE").equalsIgnoreCase("NativeApp")) {
            if (exectionMode.equalsIgnoreCase("SauceLabs")) {
                capability.setCapability(MobileCapabilityType.APP, "sauce-storage:" + prop.getProperty("APP")); // Name
                                                                                                                // of
                                                                                                                // the
                                                                                                                // App
                                                                                                                // you
                                                                                                                // want
                                                                                                                // to
                                                                                                                // work
            } else {
                capability.setCapability(MobileCapabilityType.APP,
                        System.getProperty("user.dir") + "\\src\\test\\resources\\" + prop.getProperty("APP"));
            }

        } else {

            capability.setCapability(MobileCapabilityType.BROWSER_NAME, prop.getProperty("BROWSER_NAME"));

        }

        return capability;
    }

    /*
     * This method gets the device model name
     */
    public String getDeviceModel() {
        String deviceModelName = null;
        String brand = null;
        String deviceID = null;
        try {
            deviceID = getDeviceSerial().get(0);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        String deviceModel = null;
        try {
            deviceModelName = cmd.runCommand("adb -s " + deviceID + " shell getprop ro.product.model").replaceAll("\\W",
                    "");

            brand = cmd.runCommand("adb -s " + deviceID + " shell getprop ro.product.brand");
        } catch (InterruptedException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        deviceModel = deviceModelName.concat("_" + brand);

        return deviceModel.trim();

    }

    /**
     * This method start adb server
     */
    private void startADB() throws Exception {
        String output = cmd.runCommand("adb start-server");
        String[] lines = output.split("\n");
        if (lines[0].contains("internal or external command")) {
            System.out.println("Please set ANDROID_HOME in your system variables");
        }
    }

    public ArrayList<String> getDeviceSerial() {

        try {
            startADB();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // start adb service
        String output = null;
        try {
            output = cmd.runCommand("adb devices");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String[] lines = output.split("\n");

        if (lines.length <= 1) {
            System.out.println("No Device Connected");
            return null;
        } else {
            for (int i = 1; i < lines.length; i++) {
                lines[i] = lines[i].replaceAll("\\s+", "");

                if (lines[i].contains("device")) {
                    lines[i] = lines[i].replaceAll("device", "");
                    String deviceID = lines[i];
                    deviceSerail.add(deviceID);
                } else if (lines[i].contains("unauthorized")) {
                    lines[i] = lines[i].replaceAll("unauthorized", "");
                    String deviceID = lines[i];
                } else if (lines[i].contains("offline")) {
                    lines[i] = lines[i].replaceAll("offline", "");
                    String deviceID = lines[i];
                }
            }
            return deviceSerail;
        }
    }

    /*
     * This method gets the device OS API Level
     */
    public String deviceOS() {
        String deviceOSLevel = null;
        try {
            deviceOSLevel = cmd.runCommand("adb -s " + getDeviceSerial().get(0) + " shell getprop ro.build.version.sdk")
                    .replaceAll("\\W", "");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return deviceOSLevel;

    }

    public String getDeviceManufacturer() {
        try {
            return cmd.runCommand("adb -s " + getDeviceSerial().get(0) + " shell getprop ro.product.manufacturer")
                    .trim();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}