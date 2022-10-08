package com.mingliu.page;

import com.mingliu.base.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class FindPage extends BasePage {
    //发现图标
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup[1]/android.widget.TextView")
    public WebElement findBtn;
    //搜索框
    @AndroidFindBy(id = "com.netease.cloudmusic:id/searchBar")
    public WebElement searchBar;
}