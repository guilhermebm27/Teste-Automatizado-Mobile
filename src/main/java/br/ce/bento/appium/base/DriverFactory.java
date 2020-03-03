package br.ce.bento.appium.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DriverFactory {

	private static AndroidDriver<MobileElement> driver;

	public static AndroidDriver<MobileElement> getDriver() {
		if (driver == null) {
			createDriver();
		}
		return driver;
	}

	private static void createDriver() {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("platformName", "Android");
		capability.setCapability("deviceName", "Nexus6");
		capability.setCapability("automationName", "uiautomator2");
		capability.setCapability("appPackage", "com.android.calculator2");
		capability.setCapability("appActivity", "com.android.calculator2.Calculator");

		try {
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}

	}
}
