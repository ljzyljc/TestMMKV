package com.jackie.testmmkv.net;

import com.jackie.testmmkv.rxjava.User;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface RequestApi {
//    http://ip.taobao.com/service/getIpInfo.php?ip=21.22.11.33
    @GET("https://free-api.heweather.com/v5/forecast")
    Observable<TaoBaoBean> getSougu(@QueryMap Map<String,Object> maps);

    @GET("{url}")
    Observable<RequestBody> getWeatherStr(@Path("url") String url,
                                          @QueryMap Map<String,String> map);


}
