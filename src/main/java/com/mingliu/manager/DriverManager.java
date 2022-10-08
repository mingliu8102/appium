package com.mingliu.manager;

import io.appium.java_client.AppiumDriver;

public class DriverManager {
    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<AppiumDriver>();

    //设置driver
    public static void setDriver(AppiumDriver appiumDriver) {
        driver.set(appiumDriver);
    }

    //获取dirver
    public static AppiumDriver getdriver() {
        return driver.get();
    }
}
