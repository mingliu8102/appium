package com.mingliu.actions;

import com.mingliu.base.BaseAction;
import com.mingliu.page.FindPage;

public class FindPageAction extends BaseAction {
    FindPage findPage;

    public FindPageAction() {
        findPage = new FindPage();
    }

    //点击搜索框
    public void intoSearch() {
        click(findPage.searchBar);
    }
}
