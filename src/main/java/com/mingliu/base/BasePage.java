package com.mingliu.base;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mingliu.manager.DriverManager;

import java.time.Duration;


public class BasePage {


    //初始化PageFactory,否则@FindBy会报空指针异常
    public BasePage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getdriver()), this);
    }


}
