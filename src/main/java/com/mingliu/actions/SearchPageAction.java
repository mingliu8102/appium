package com.mingliu.actions;

import com.mingliu.base.BaseAction;
import com.mingliu.page.SearchPage;

public class SearchPageAction extends BaseAction {
    SearchPage searchPage;

    public SearchPageAction() {
        searchPage = new SearchPage();
    }

    //搜索xx歌曲
    public void search(String song) {
        sendKeys(searchPage.searchTxt, song);
        click(searchPage.searchBtn);
    }

    //返回发现页面
    public void backToFind() {
        click(searchPage.searchBack);
    }
}
