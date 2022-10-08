package com.mingliu.search;

import com.mingliu.actions.FindPageAction;
import com.mingliu.actions.LoginAction;
import com.mingliu.actions.SearchPageAction;
import com.mingliu.base.BaseTest;
import com.mingliu.manager.DriverManager;
import com.mingliu.page.FindPage;
import com.mingliu.page.LoginPage;
import com.mingliu.page.SearchPage;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {
    AppiumDriver driver;
    FindPage findPage;
    FindPageAction findPageAction;
    SearchPage searchPage;
    SearchPageAction searchPageAction;

    @BeforeClass
    public void init() {
        driver = DriverManager.getdriver();
        findPage = new FindPage();
        findPageAction = new FindPageAction();
        searchPage=new SearchPage();
        searchPageAction=new SearchPageAction();
    }

    @Description("测试搜索歌曲")
    @Parameters("song")
    @Test
    public void searchSong(String song){
        findPageAction.intoSearch();
        searchPageAction.search(song);
        Assert.assertTrue(searchPage.firstRes.getText().equals(song));
    }
}
