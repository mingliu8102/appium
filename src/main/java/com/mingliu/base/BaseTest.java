package com.mingliu.base;

import com.mingliu.manager.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    public AppiumDriver driver;

    @Parameters({"platformName", "platformVersion", "udid", "appPackage", "appActivity"})
    @BeforeTest
    public void setUp(String platformName, String platformVersion, String udid,
                      String appPackage, String appActivity) throws Exception {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", platformName);
        desiredCapabilities.setCapability("appium:platformVersion", platformVersion);
        desiredCapabilities.setCapability("udid", udid);
        desiredCapabilities.setCapability("appium:appPackage", appPackage);
        desiredCapabilities.setCapability("appium:appActivity", appActivity);
        desiredCapabilities.setCapability("appium:autoGrantPermissions", "true");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        if (platformName.equals("Android")) {
            driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        } else if (platformName.equals("iOS")) {
            driver = new IOSDriver(remoteUrl, desiredCapabilities);
        } else {
            throw new Exception("Invalid Platform: " + platformName);
        }
        DriverManager.setDriver(driver);
    }

    @AfterTest
    public void tearDown() {
        DriverManager.getdriver().quit();
    }
}
