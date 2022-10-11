package com.mingliu.listeners;


import com.mingliu.base.BaseTest;
import com.mingliu.manager.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.BeforeTest;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class TestResultListener implements IHookable {


    @Override
    public void run(IHookCallBack iHookCallBack, ITestResult iTestResult) {
        //保证@Test注解标注的测试方法能够正常执行
        iHookCallBack.runTestMethod(iTestResult);
        //判断用例结果是否异常

        //说明：LoginTest.java中捕获的异常是Assert.assertTrue(displayed);
        //assert为false时，会抛出异常
        if (iTestResult.getThrowable() != null) {
            //testResult参数提供了getInstance方法，可以获取当前测试类的实例（对象）
            BaseTest baseTest = (BaseTest) iTestResult.getInstance();
            AppiumDriver driver = baseTest.driver;
            //保存到allure报表中
//            saveScreenshotToAllure(takeScreenshotAsByte(driver));
            Allure.addAttachment("Page screenshot", new ByteArrayInputStream(takeScreenshotAsByte(driver)));
            //保存到本地
            takeScreenshot(driver, "test_" + System.currentTimeMillis());
        }
    }

//    @Attachment(value = "Page screenshot", type = "image/png")
//    public byte[] saveScreenshotToAllure(byte[] data){
//        //返回的字节数组的数据 作为附件添加到Allure报表中--》@Attachment注解来实现的
//        return data;
//    }

    /**
     * 生成字节数组的截图数据
     *
     * @param driver
     * @return
     */
    public byte[] takeScreenshotAsByte(AppiumDriver driver) {
        byte[] data = driver.getScreenshotAs(OutputType.BYTES);
        return data;
    }

    /**
     * 生成截图以普通文件的形式，并且保存到本地
     *
     * @param driver
     * @param fileName
     */
    public void takeScreenshot(AppiumDriver driver, String fileName) {
        File srcFile = driver.getScreenshotAs(OutputType.FILE);
        File destFile = new File(System.getProperty("user.dir") + "/screenshot/" + fileName + ".png");
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
