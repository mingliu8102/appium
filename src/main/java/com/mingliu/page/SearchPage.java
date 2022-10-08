package com.mingliu.page;

import com.mingliu.base.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasePage {
    //返回
    @AndroidFindBy(id = "com.netease.cloudmusic:id/searchBack")
    public WebElement searchBack;
    //搜索输入框
    @AndroidFindBy(id = "com.netease.cloudmusic:id/search_src_text")
    public WebElement searchTxt;
    //确认搜索
    @AndroidFindBy(id = "com.netease.cloudmusic:id/toSearch")
    public WebElement searchBtn;
    //第一个返回的结果
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView")
    public WebElement firstRes;
}