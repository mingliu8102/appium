package com.mingliu.base;

import com.mingliu.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @description：页面常用方法封装
 */
public class BaseAction {
    private static final Duration EXPLICIT_WAIT = Duration.ofSeconds(10);

    //等待元素可见
    public void waitForVisibility(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getdriver(), EXPLICIT_WAIT);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void click(WebElement webElement) {
        waitForVisibility(webElement);
        webElement.click();
    }

    public void sendKeys(WebElement webElement, String keys) {
        waitForVisibility(webElement);
        webElement.sendKeys(keys);
    }
}
