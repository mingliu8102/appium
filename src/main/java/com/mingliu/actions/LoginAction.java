package com.mingliu.actions;

import com.mingliu.base.BaseAction;
import com.mingliu.page.LoginPage;


public class LoginAction extends BaseAction {
    LoginPage loginPage;

    public LoginAction() {
        loginPage = new LoginPage();
    }

    //同意用户协议
    public void agree() {
        click(loginPage.agree);
    }

    //允许权限申请
    public void permit() {
        click(loginPage.permissionBtn);
    }

    //选择第三方登陆
    public void thirdPart() {
        click(loginPage.thirdLoginText);
    }

    //邮箱登陆
    public void useEmail() {
        click(loginPage.mailCoin);
    }

    //同意用户协议
    public void userPolicy() {
        click(loginPage.positiveBtn);
    }

    //邮箱密码登陆
    public void emailLogin(String email, String password) {
        sendKeys(loginPage.emailAddr, email);
        sendKeys(loginPage.password, password);
    }

    //确认登陆
    public void login() {
        click(loginPage.loginBtn);
    }

    //立即体验，不登陆账号
    public void guestLogin() {
        click(loginPage.guest);
    }

}
