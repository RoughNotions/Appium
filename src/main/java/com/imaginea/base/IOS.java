package com.imaginea.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class IOS implements MobileOS {

	public IOSDriver getDriver(String url,DesiredCapabilities capability) throws MalformedURLException {

		return new IOSDriver(new URL(url), capability);

	}
}
