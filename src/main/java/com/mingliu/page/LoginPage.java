package com.mingliu.page;

import com.mingliu.base.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    //电子邮箱密码
    @AndroidFindBy(id = "com.netease.cloudmusic:id/password")
    public WebElement password;
    //mail登陆
    @AndroidFindBy(accessibility = "mail")
    public WebElement mailCoin;
    //登陆按钮
    @AndroidFindBy(id = "com.netease.cloudmusic:id/login")
    public WebElement loginBtn;
    //电子邮箱地址
    @AndroidFindBy(id = "com.netease.cloudmusic:id/email")
    public WebElement emailAddr;
    //其他登陆方式
    @AndroidFindBy(id = "com.netease.cloudmusic:id/thirdLoginTextView")
    public WebElement thirdLoginText;
    //权限申请
    @AndroidFindBy(id = "com.lbe.security.miui:id/permission_allow_foreground_only_button")
    public WebElement permissionBtn;
    //立即体验，不登陆账号
    @AndroidFindBy(id = "com.netease.cloudmusic:id/trialT")
    public WebElement guest;
    //同意用户协议
    @AndroidFindBy(id = "com.netease.cloudmusic:id/agree")
    public WebElement agree;
    //同意用户协议
    @AndroidFindBy(id = "com.netease.cloudmusic:id/positiveBtn")
    public WebElement positiveBtn;
}