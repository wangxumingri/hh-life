package com.wxss.hhlife.base.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtils {
    private static Gson gson = new Gson();

    static {
        GsonBuilder gsonBuilder = new GsonBuilder()
                .serializeNulls()
                .setDateFormat("yyyy-MM-dd HH:mm:ss");
        gson = gsonBuilder.create();
    }

    public static String toJsonStr(Object source){
        return gson.toJson(source);
    }

    public static <T> T fromJson(String jsonStr,Class<T> tClass){
        return gson.fromJson(jsonStr,tClass);
    }
}
