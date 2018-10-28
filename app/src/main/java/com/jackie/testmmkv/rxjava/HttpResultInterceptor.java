package com.jackie.testmmkv.rxjava;

import android.util.Log;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.lang.ref.SoftReference;

import io.reactivex.ObservableOperator;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Jackie on 2018/8/24.
 */
public class HttpResultInterceptor {

    private static final String TAG = "HttpResultInterceptor";

    public enum Type{
        ALL,
        ERROR,
        LOADING,
        NONE
    }

    public static ObservableOperator get(HttpResultHandler handler,Type type){
        return new OperatorHttpResult(handler,type);
    }

    private static class OperatorHttpResult<T> implements ObservableOperator<T,T>,Subscription{
        private SoftReference<HttpResultHandler> mHandler;
        private Type mType;

        OperatorHttpResult(HttpResultHandler httpResultHandler){
            mHandler = new SoftReference<>(httpResultHandler);
        }
        OperatorHttpResult(HttpResultHandler httpResultHandler,Type type){
            mHandler = new SoftReference<>(httpResultHandler);
            mType = type;
        }

        @Override
        public Observer<? super T> apply(Observer<? super T> observer) throws Exception {
//            HttpResultSubscriber<? super T> parent = new HttpResultSubscriber<>(observer,mHandler,mType);
//            return parent;
            return null;
        }

        @Override
        public void request(long n) {

        }

        @Override
        public void cancel() {

        }
    }
    private static class HttpResultSubscriber<T> implements Subscriber<T>{


        private Subscriber<? super T> mChild;
        private SoftReference<HttpResultHandler> mHandler;
        private boolean showProgress;
        private boolean showError;

        private boolean done;
        HttpResultSubscriber(Subscriber<? super T> child,
                             SoftReference<HttpResultHandler> preHandler,
                             Type type) {
            mChild = child;
            mHandler = preHandler;
            switch (type) {
                case ERROR:
                    showProgress = false;
                    showError = true;
                    break;
                case LOADING:
                    showProgress = true;
                    showError = false;
                    break;
                case NONE:
                    showProgress = false;
                    showError = false;
                    break;
                default://all
                    showProgress = true;
                    showError = true;
                    break;
            }
        }


        @Override
        public void onSubscribe(Subscription s) {

        }

        @Override
        public void onNext(T t) {
            Log.i(TAG, "onNext: -------------");
        }

        @Override
        public void onError(Throwable t) {
            Log.i(TAG, "onError: ----------");
        }

        @Override
        public void onComplete() {
            Log.i(TAG, "onComplete: ------------");
        }
    }


    public interface HttpResultHandler {

        void showProgress();

        void dismissProgress();

        void onTokenInvalid(String msg);

        //其他功能可扩展
        //        void showMessage(String msg);
        //        void lowerVersion();
    }



}
