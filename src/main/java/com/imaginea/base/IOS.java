package com.imaginea.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class IOS implements MobileOS {

	public IOSDriver getDriver(DesiredCapabilities capability) throws MalformedURLException {

		return new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capability);

	}
}
