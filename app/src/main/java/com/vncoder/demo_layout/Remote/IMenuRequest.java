package com.vncoder.demo_layout.Remote;

import com.vncoder.demo_layout.Item.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface IMenuRequest {
    @GET
    Call<List<Item>> getMenuList(@Url String url);
}
