package com.personal.configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {
    public static String toJson(Object obj){
        Gson gson = new GsonBuilder().create();
        return gson.toJson(obj);
    }
    public static <T> T fromJson(String obj, Class<T> responseType){
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(obj, responseType);
    }
}
