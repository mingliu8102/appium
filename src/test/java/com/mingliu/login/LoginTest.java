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

public class LoginTest extends BaseTest {
    AppiumDriver driver;
    LoginPage loginPage;
    LoginAction loginAction;

    @BeforeClass
    public void init() {
        driver = DriverManager.getdriver();
        loginPage = new LoginPage();
        loginAction = new LoginAction();
    }


    @Description("测试第三方登陆")
    @Test
    public void thirdPartLoginTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //同意隐私条款
//        WebElement agree = (WebElement) driver.findElement(By.id("com.netease.cloudmusic:id/agree"));
//        loginPage.click(loginPage.agree);
        loginAction.agree();
        //权限申请
//        WebElement perm = (WebElement) driver.findElement(By.id("com.lbe.security.miui:id/permission_allow_foreground_only_button"));
//        perm.click();
        loginAction.permit();
        //其他登陆方式
//        WebElement thirdLoginText = (WebElement) driver.findElement(By.id("com.netease.cloudmusic:id/thirdLoginTextView"));
//        thirdLoginText.click();
        loginAction.thirdPart();
        //mail登陆
//        WebElement mailCoin = (WebElement)driver.findElement(AppiumBy.ByAccessibilityId.accessibilityId("mail"));
//        mailCoin.click();
        loginAction.useEmail();
        //同意用户协议
//        WebElement positiveBtn = (WebElement) driver.findElement(By.id("com.netease.cloudmusic:id/positiveBtn"));
//        positiveBtn.click();
        loginAction.userPolicy();
//        WebElement emailAddr = (WebElement) driver.findElement(By.id("com.netease.cloudmusic:id/email"));
//        emailAddr.sendKeys("1360061632@qq.com");
//        WebElement password = (WebElement) driver.findElement(By.id("com.netease.cloudmusic:id/password"));
//        password.sendKeys("xxx");
        loginAction.emailLogin("1360061632@qq.com", "xxx");
//        WebElement loginBtn = (WebElement) driver.findElement(By.id("com.netease.cloudmusic:id/login"));
//        loginBtn.click();
        loginAction.login();

        WebElement searchBar = (WebElement) driver.findElement(By.id("com.netease.cloudmusic:id/searchBar"));
        Assert.assertTrue(searchBar.isDisplayed());


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
