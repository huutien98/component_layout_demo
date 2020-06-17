package com.vncoder.demo_layout.Helper;

import com.vncoder.demo_layout.Remote.IMenuRequest;
import com.vncoder.demo_layout.Remote.RetrofitClient;

public class Common {
    public static IMenuRequest getIMenuRequest()
    {
        return RetrofitClient.getClient("https://api.androidhive.info/json/menu.json/").create(IMenuRequest.class);
    }
}
