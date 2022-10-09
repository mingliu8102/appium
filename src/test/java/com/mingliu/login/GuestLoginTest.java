package com.mingliu.login;

import com.mingliu.actions.LoginAction;
import com.mingliu.base.BaseTest;
import com.mingliu.manager.DriverManager;
import com.mingliu.page.LoginPage;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class GuestLoginTest extends BaseTest {
    AppiumDriver driver;
    LoginPage loginPage;
    LoginAction loginAction;

    @BeforeClass
    public void init() {
        driver = DriverManager.getdriver();
        loginPage = new LoginPage();
        loginAction = new LoginAction();
    }
    @Description("游客身份登陆")
    @Test
    public void guestLoginTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginAction.agree();
        loginAction.permit();
        loginAction.guestLogin();
        loginAction.userPolicy();
        WebElement searchBar = (WebElement) driver.findElement(By.id("com.netease.cloudmusic:id/searchBar"));
        Assert.assertTrue(searchBar.isDisplayed());

    }
}
