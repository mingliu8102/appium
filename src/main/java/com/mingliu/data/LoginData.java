package com.mingliu.data;

import org.testng.annotations.DataProvider;

public class LoginData {
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
                { "1360061632@qq.com", "123" },
                { "136006163@qq.com", "123" },
                { "", "123"},
                { "1360061632@qq.com", "xx" },
                { "136006163@qq.com", "xx" },
                { "1360061632@qq.com", "" },
        };
    }
}
