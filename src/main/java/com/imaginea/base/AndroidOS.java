package com.imaginea.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AndroidOS implements MobileOS {

	@SuppressWarnings("rawtypes")
	public AndroidDriver getDriver(String url,DesiredCapabilities capability) throws MalformedURLException {

		return new AndroidDriver(new URL(url), capability);

	}

}
