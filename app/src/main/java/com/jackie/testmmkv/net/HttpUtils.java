package com.jackie.testmmkv.net;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.jackie.testmmkv.net.interceptor.BaseParamInterceptor;
import com.jackie.testmmkv.rxjava.RetrofitClient;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpUtils {

    private static final int DEFAULT_TIMEOUT = 20;
    private RequestApi apiService;
    private static final String TAG = "HttpUtils";
    public static final String Base_URL = "http://ip.taobao.com/";
    public static String baseUrl = Base_URL;
    private static OkHttpClient okHttpClient;
    private Cache cache = null;
    private File httpCacheDirectory;
    private static Context mContext;
    private static Retrofit retrofit;
    private static class SingletonHolder{
        private static HttpUtils INSTANCE = new HttpUtils(mContext);
    }

    public static HttpUtils getInstance(Context context){
        if (context != null){
            mContext = context;
        }
        return SingletonHolder.INSTANCE;
    }

    public static HttpUtils getInstance(Context context, String url) {
        if (context != null) {
            mContext = context;
        }

        return new HttpUtils(context, url);
    }

    public static HttpUtils getInstance(Context context, String url, Map<String, String> headers) {
        if (context != null) {
            mContext = context;
        }
        return new HttpUtils(context, url, headers);
    }


















    private HttpUtils(Context context) {

        this(context, baseUrl, null);
    }

    private HttpUtils(Context context, String url) {

        this(context, url, null);
    }

    private HttpUtils(Context context, String url, Map<String, String> headers) {

        if (TextUtils.isEmpty(url)) {
            url = baseUrl;
        }

        if (httpCacheDirectory == null) {
            httpCacheDirectory = new File(mContext.getCacheDir(), "tamic_cache");
        }

        try {
            if (cache == null) {
                cache = new Cache(httpCacheDirectory, 10 * 1024 * 1024);
            }
        } catch (Exception e) {
            Log.e("OKHttp", "Could not create http cache", e);
        }
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //okhttp配置
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new BaseParamInterceptor())
                .addNetworkInterceptor(interceptor)
                .cache(cache)
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT,TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT,TimeUnit.SECONDS)
                .connectionPool(new ConnectionPool(8,15,TimeUnit.SECONDS))
                .build();
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(url)
                .build();


    }

    //请求参数打印
    static HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
        @Override
        public void log(String message) {
            Log.i(TAG, "okhttp --> request--> log: "+message);
        }
    });




    public RequestApi createBaseApi(){
        apiService = create(RequestApi.class);
        return apiService;
    }


    public <T> T create(final Class<T> service){
        if (service == null){
            throw new RuntimeException("Api service is null");
        }
        return retrofit.create(service);
    }
}
