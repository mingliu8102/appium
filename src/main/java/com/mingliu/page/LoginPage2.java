package com.mingliu.page;

import com.mingliu.base.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

/**
 * 手动编写的LoginPage类，功能与LoginPage相同
 */
public class LoginPage2 extends BasePage {

    @AndroidFindBy(id = "com.netease.cloudmusic:id/agree")
    public WebElement agree;

    //权限申请
    @AndroidFindBy(id = "com.lbe.security.miui:id/permission_allow_foreground_only_button")
    public
    WebElement permissionBtn;


    //其他登陆方式
    @AndroidFindBy(id = "com.netease.cloudmusic:id/thirdLoginTextView")
    public WebElement thirdLoginText;

    //mail登陆
    @AndroidFindBy(accessibility = "mail")
    public WebElement mailCoin;

    //同意用户协议
    @AndroidFindBy(id = "com.netease.cloudmusic:id/positiveBtn")
    public WebElement positiveBtn;

    @AndroidFindBy(id = "com.netease.cloudmusic:id/email")
    public WebElement emailAddr;

    @AndroidFindBy(id = "com.netease.cloudmusic:id/password")
    public WebElement password;

    @AndroidFindBy(id = "com.netease.cloudmusic:id/login")
    public WebElement loginBtn;


}
