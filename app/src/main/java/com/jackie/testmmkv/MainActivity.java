package com.jackie.testmmkv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.jackie.testmmkv.net.HttpUtils;
import com.jackie.testmmkv.net.TaoBaoBean;
import com.jackie.testmmkv.rxjava.Api;
import com.jackie.testmmkv.rxjava.RetrofitClient;
import com.jackie.testmmkv.rxjava.RxTransformers;
import com.jackie.testmmkv.rxjava.User;
import com.tencent.mmkv.MMKV;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go();
            }
        });
//
//        MMKV kv = MMKV.defaultMMKV();
//        kv.encode("flag",false);
//        boolean bValue = kv.decodeBool("flag");
//        Log.i(TAG, "onCreate: -1-------"+bValue);
//        kv.encode("ljc",27);
//        int iValue = kv.decodeInt("ljc");
//        Log.i(TAG, "onCreate: -2---"+iValue);
//
//        kv.encode("abc","wu yan zhu");
//        String msg = kv.decodeString("abc");
//        Log.i(TAG, "onCreate: ----3------"+msg);

//        RetrofitClient.getInstance(this).create(Api.class).login(new User("jackie","99",55))
//                .compose(RxTransformers.<User>io_main())
//                .subscribe(new Consumer<User>() {
//                    @Override
//                    public void accept(User user) throws Exception {
//                        Log.i(TAG, "accept: -----------");
//                    }
//                });



    }
    public void go(){
        Map<String,Object> map = new HashMap<>();
        map.put("city","厦门");
        map.put("key","yourkey");
//        map.put("dem","89");//city=yourcity&key=yourkey
        HttpUtils.getInstance(this).createBaseApi().getSougu(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TaoBaoBean>() {
                    @Override
                    public void accept(TaoBaoBean user) throws Exception {
                        Log.i(TAG, "accept: ------1  "+user.getHeWeather5().get(0).getStatus());
                    }


                }
                );
    }
}
