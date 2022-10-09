package com.mingliu.login;

import com.mingliu.actions.LoginAction;
import com.mingliu.base.BaseTest;
import com.mingliu.data.LoginData;
import com.mingliu.manager.DriverManager;
import com.mingliu.page.LoginPage;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

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
        //
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //同意隐私条款
//        WebElement agree = (WebElement) driver.findElement(By.id("com.netease.cloudmusic:id/agree"));
//        loginPage.click(loginPage.agree);
        loginAction.agree();
        //权限申请
//        WebElement perm = (WebElement) driver.findElement(By.id("com.lbe.security.miui:id/permission_allow_foreground_only_button"));
//        perm.click();
        loginAction.permit();
        loginAction.agreePrivacy();
        //其他登陆方式
//        WebElement thirdLoginText = (WebElement) driver.findElement(By.id("com.netease.cloudmusic:id/thirdLoginTextView"));
//        thirdLoginText.click();
        loginAction.thirdPart();
    }



    @Description("测试第三方登陆")
    @Test(dataProvider = "loginData",dataProviderClass = LoginData.class)
    public void thirdPartLoginTest(String email,String password)  {
        //mail登陆
//        WebElement mailCoin = (WebElement)driver.findElement(AppiumBy.ByAccessibilityId.accessibilityId("mail"));
//        mailCoin.click();
        loginAction.useEmail();
        //同意用户协议
//        WebElement positiveBtn = (WebElement) driver.findElement(By.id("com.netease.cloudmusic:id/positiveBtn"));
//        positiveBtn.click();
//        loginAction.userPolicy();
//        WebElement emailAddr = (WebElement) driver.findElement(By.id("com.netease.cloudmusic:id/email"));
//        emailAddr.sendKeys("1360061632@qq.com");
//        WebElement password = (WebElement) driver.findElement(By.id("com.netease.cloudmusic:id/password"));
//        password.sendKeys("xxx");
//        loginAction.emailLogin("1360061632@qq.com", "xxx");
        loginAction.emailLogin(email,password);
//        WebElement loginBtn = (WebElement) driver.findElement(By.id("com.netease.cloudmusic:id/login"));
//        loginBtn.click();
        loginAction.login();
        boolean displayed=false;
        try{
            WebElement searchBar = (WebElement) driver.findElement(By.id("com.netease.cloudmusic:id/searchBar"));
            displayed=searchBar.isDisplayed();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Assert.assertTrue(displayed);
        }

    }
    @AfterMethod(description = " 返回登陆界面")
    public void backTOLogin(){
        loginAction.back();
    }

}
