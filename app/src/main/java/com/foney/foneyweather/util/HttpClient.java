package com.foney.foneyweather.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by foney on 2017/8/11.
 * 网络请求工具类
 */

public class HttpClient {

    public static void sendOkHttpRequest(String url,okhttp3.Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(callback);
    }

}
