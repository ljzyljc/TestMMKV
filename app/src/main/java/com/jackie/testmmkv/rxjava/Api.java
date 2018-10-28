package com.jackie.testmmkv.rxjava;


import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by Jackie on 2018/7/16.
 */
public interface Api {

    @GET("https://www.baidu.com")
    Observable<User> login(@Body User user);

    @GET
    Observable<LoginResponse> register(@Body LoginResponse request);

    @GET("http://gaapi.jl.gov.cn:80/econsole/api/news/top/3")
    Flowable<UserData> loginLLL();

    /**
     *普通写法
     */
    @GET("service/getIpInfo.php")
    Flowable<BaseResponse<IpResult>> getData(@Query("ip") String ip);


    @GET()
    Flowable<BaseResponse<Object>> get(
            @Url String url,
            @QueryMap Map<String, String> maps
    );

    @FormUrlEncoded
    @POST()
    Flowable<ResponseBody> post(
            @Url String url,
            @FieldMap Map<String, String> maps);

    @POST()
    Flowable<ResponseBody> json(
            @Url String url,
            @Body RequestBody jsonStr);

    @Multipart
    @POST()
    Flowable<ResponseBody> upLoadFile(
            @Url String url,
            @Part() RequestBody requestBody);

    @POST()
    Flowable<ResponseBody> uploadFiles(
            @Url String url,
            @Path("headers") Map<String, String> headers,
            @Part("filename") String description,
            @PartMap Map<String, RequestBody> maps);

    @Streaming
    @GET
    Flowable<ResponseBody> downloadFile(@Url String fileUrl);
}
