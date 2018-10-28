package com.jackie.testmmkv.rxjava;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by Jackie on 2018/8/28.
 */
public class BaseSbuscriber<T> extends DisposableSubscriber<T> {
    private static final String TAG = "BaseSbuscriber";
    private Context mContext;
    public BaseSbuscriber(Context context){
        this.mContext = context;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ----1-----");
    }

    @Override
    public void onNext(T t) {
        Log.i(TAG, "onNext: --------");
    }

    @Override
    public void onError(Throwable t) {
        Toast.makeText(mContext,t.getMessage(),Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onError: ");
    }

    @Override
    public void onComplete() {
        Log.i(TAG, "onComplete: -----4---");
    }
}
