package com.jackie.testmmkv.net.interceptor;

import android.util.Log;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

//添加基本参数,对参数加密后，作为sig的value值，  给所有的请求添加公共参数，然后再把所有的参数用 key=value&key=value&key=value的方式拼接，
//用MD5加密，加密后的值作为sign参数的的值，然后在进行请求
public class BaseParamInterceptor implements Interceptor{
    private static final String TAG = "BaseParamInterceptor";
    @Override
    public Response intercept(Chain chain) throws IOException {

        Request oldRequest = chain.request();
//        String url = oldRequest.url().toString();
        Response response = null;

        //添加参数
        Request newRequest = addParam(oldRequest);
//        Log.i(TAG, "intercept: --------"+newRequest.body().toString());
//        newRequest.body().toString();
        response = chain.proceed(newRequest);
//        ResponseBody value = response.body();
//        byte[] resp = value.bytes();
//        String json = new String(resp,"UTF-8");


        return response;
    }

    //添加公共参数
    private Request addParam(Request oldRequest){
        HttpUrl.Builder builder = oldRequest.url()
                .newBuilder()
                .setEncodedQueryParameter("app_key","app_key")
                .setEncodedQueryParameter("nonce","⼀一个随机数，随机性越⼤大越好，每个请求都需要重新⽣生成")
                .setEncodedQueryParameter("timestamp","当前Unix毫秒时间戳，每个请求都需要重新⽣生成");
//                .setEncodedQueryParameter("sig","签名参数，对除sig外的所有参数进⾏行行签名计算得到的值");

        Request newRequest = oldRequest.newBuilder()
                .method(oldRequest.method(),oldRequest.body())
                .url(builder.build())
                .build();

        return newRequest;
    }

}
