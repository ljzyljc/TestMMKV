//package com.jackie.testmmkv.rxjava;
//
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.util.SparseArray;
//import android.view.View;
//import android.widget.Button;
//import android.widget.Toast;
//
//
//import com.jackie.testmmkv.R;
//
//import org.reactivestreams.Subscriber;
//import org.reactivestreams.Subscription;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.TimeUnit;
//
//import io.reactivex.BackpressureStrategy;
//import io.reactivex.Flowable;
//import io.reactivex.FlowableEmitter;
//import io.reactivex.FlowableOnSubscribe;
//import io.reactivex.Observable;
//import io.reactivex.ObservableEmitter;
//import io.reactivex.ObservableOnSubscribe;
//import io.reactivex.ObservableSource;
//import io.reactivex.Observer;
//import io.reactivex.Scheduler;
//import io.reactivex.android.schedulers.AndroidSchedulers;
//import io.reactivex.disposables.CompositeDisposable;
//import io.reactivex.disposables.Disposable;
//import io.reactivex.functions.BiFunction;
//import io.reactivex.functions.Consumer;
//import io.reactivex.functions.Function;
//import io.reactivex.functions.Predicate;
//import io.reactivex.schedulers.Schedulers;
//import retrofit2.Retrofit;
//
//
///**
// * Created by Jackie on 2018/7/16.
// */
//public class RxJavaTestActivity extends AppCompatActivity {
//    private static final String TAG = "RxJavaTestActivity";
//    Button button;
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_rxjava);
//        button = findViewById(R.id.btn);
//        final ExecutorService executorService = Executors.newCachedThreadPool();
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                testAsyn(1);
////                testAsyn(2);
////                testAsyn(3);
////                testAsyn(4);
////                testAsyn(5);
////                request();
////                for (int i=0;i<5;i++){
////                    final int finalI = i;
////                    executorService.submit(new Runnable() {
////                        @Override
////                        public void run() {
//////                            test1(finalI);
////                            testAsyn(finalI);
////                        }
////                    });
////                }
//            }
//        });
////        test1(1);
////        test1(2);
////        test1(3);
////        test1(4);
////        test1(5);
////        test2();
////        test3();
////        test4();
////        test5();
////        test6();
////        test7();
////        test8();
////        test9();
////        test10();
////        test11();
////        test12();
////        test13();
//
//
//    }
//
//    public void testAsyn(final int index){
//        new AsyncTask<Void, Void, String>() {
//            @Override
//            protected String doInBackground(Void... voids) {
//                Log.i(TAG, "doInBackground: -----"+index);
//                return null;
//            }
//        }.execute();
//    }
//
//    public void test1(final int count){
//        Log.i(TAG, "test1: -------"+count+Thread.currentThread().getName());
//        //创建一个上游的Observable
//        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                //ObservableEmitter: 发出事件
//
//                e.onNext(1);
//                e.onNext(2);
//                e.onNext(3);
//                e.onComplete();
//            }
//        });
//        //创建一个下游的Observer
//        Observer<Integer> observer = new Observer<Integer>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                // Disposable 用完即丢的，一次性的
//                Log.i(TAG, "onSubscribe: ");
//            }
//
//            @Override
//            public void onNext(Integer value) {
//                Log.i(TAG, "onNext: "+value);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.i(TAG, "onError: "+e.getMessage());
//            }
//
//            @Override
//            public void onComplete() {
//                Log.i(TAG, "onComplete: -------------"+count);
////                HashMap hashMap = new HashMap();
////                hashMap.put();
////                SparseArray array = new SparseArray();
////                array.put();
//            }
//        };
//        //建立连接
//        observable.subscribe(observer);
//    }
//
//
//    public void test2(){
//        //带有一个Consumer参数的方法表示下游只关心onNext事件, 其他的事件我假装没看见,
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                Log.i(TAG, "subscribe: ---1");
//                e.onNext(1);
//                Log.i(TAG, "subscribe: ---2");
//                e.onNext(2);
//                Log.i(TAG, "subscribe: ---3");
//                e.onNext(3);
//                Log.i(TAG, "subscribe: ---onComplete");
//                e.onComplete();
//                Log.i(TAG, "subscribe: ----4");
//                e.onNext(4);
//            }
//        }).subscribe(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer interger) throws Exception {
//                Log.i(TAG, "accept: ------onNext--"+interger);
//            }
//        });
//
//    }
//
//    //线程调度
//    public void test3(){
//        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                Log.i(TAG, "subscribe: ----"+Thread.currentThread().getName());
//                e.onNext(1);
//            }
//        });
//
//        Consumer<Integer> consumer = new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) throws Exception {
//                Log.i(TAG, "accept: ----"+Thread.currentThread().getName());
//                Log.i(TAG, "accept: -----onNext()---"+integer);
//            }
//        };
//        //TODO:subscribeOn() 指定的是上游发送事件的线程, observeOn() 指定的是下游接收事件的线程.
////        observable.subscribeOn(Schedulers.newThread())
////                .observeOn(AndroidSchedulers.mainThread())
////                .subscribe(consumer);
//        observable.compose(RxTransformers.<Integer>io_main())
//                .subscribe(consumer);
////        多次指定上游的线程只有第一次指定的有效, 也就是说多次调用subscribeOn() 只有第一次的有效, 其余的会被忽略.
////
////                多次指定下游的线程是可以的, 也就是说每调用一次observeOn() , 下游的线程就会切换一次.
////        Schedulers.io() 代表io操作的线程, 通常用于网络,读写文件等io密集型的操作
////        Schedulers.computation() 代表CPU计算密集型的操作, 例如需要大量计算的操作
////        Schedulers.newThread() 代表一个常规的新线程
////        AndroidSchedulers.mainThread() 代表Android的主线程
//
//
//    }
//    //网络请求
//    public void test4(){
//        //用于管理水管开关（Disposable）的容器类
//        final CompositeDisposable compositeDisposable = new CompositeDisposable();
//
//        Retrofit retrofit = RetrofitUtils.create();
//        Api api = retrofit.create(Api.class);
//        api.loginLLL()
//                .compose(RxTransformers.<UserData>io_main_flo())
////                .subscribeOn(Schedulers.io())
////                .observeOn(AndroidSchedulers.mainThread())
////                .subscribe(new Observer<User>() {
////                    @Override
////                    public void onSubscribe(Disposable d) {
////                        compositeDisposable.add(d);
////                    }
////
////                    @Override
////                    public void onNext(User value) {
////                        Log.i(TAG, "onNext: ------"+value.toString());
////                    }
////
////                    @Override
////                    public void onError(Throwable e) {
////                        Log.i(TAG, "onError: ----"+e.getMessage());
////                    }
////
////                    @Override
////                    public void onComplete() {
////                        Log.i(TAG, "onComplete: --");
////                    }
////                });
//                .subscribe(new BaseSbuscriber<UserData>(this){
//                    @Override
//                    public void onNext(UserData userData) {
//
//                    }
//                });
//
//
//    }
//
//    //变化操作符 map     map中的函数作用是将圆形事件转换为矩形事件
//    public void test5(){
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                e.onNext(1);
//                e.onNext(2);
//                e.onNext(3);
//            }
//        }).map(new Function<Integer, String>() {
//
//            @Override
//            public String apply(Integer integer) throws Exception {
//                return "结果是"+integer;
//            }
//        }).subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                Log.i(TAG, "accept: "+s);
//            }
//        });
//    }
//
////    FlatMap将一个发送事件的上游Observable变换为多个发送事件的Observables，
////      然后将它们发射的事件合并后放进一个单独的Observable里.
////    FIXME:flatMap并不保证事件的顺序,如果需要保证顺序则需要使用concatMap.
//    public void test6(){
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                e.onNext(1);
//                e.onNext(2);
//                e.onNext(3);
//            }
//        }).flatMap(new Function<Integer, ObservableSource<String>>() {
//            @Override
//            public ObservableSource<String> apply(Integer integer) throws Exception {
//                List<String> list = new ArrayList<>();
//                for (int i = 0;i < 3;i++){
//                    list.add("i am value "+integer);
//                }
//                return Observable.fromIterable(list).delay(10, TimeUnit.MILLISECONDS);
//            }
//        }).subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                Log.i(TAG, "accept: -------"+s);
//            }
//        });
//    }
//
//    //flatmap实际应用，先注册后登陆
//    public void test7(){
//        Retrofit retrofit = RetrofitUtils.create();
//        final Api api = retrofit.create(Api.class);
//        api.register(new LoginResponse())
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnNext(new Consumer<LoginResponse>() {
//                    @Override
//                    public void accept(LoginResponse loginResponse) throws Exception {
//
//                    }
//                }).observeOn(Schedulers.io())    //切换到IO线程做登陆请求
//                .flatMap(new Function<LoginResponse, ObservableSource<User>>() {
//                    @Override
//                    public ObservableSource<User> apply(LoginResponse loginResponse) throws Exception {
//                        return api.login(new User());
//                    }
//                }).observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<User>() {
//                    @Override
//                    public void accept(User user) throws Exception {
//                        Toast.makeText(RxJavaTestActivity.this,"登陆成功",Toast.LENGTH_SHORT).show();
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//                        Toast.makeText(RxJavaTestActivity.this,"登陆失败",Toast.LENGTH_SHORT).show();
//                    }
//                });
//    }
//    public void test8(){
//
//        Observable<Integer> observable1 = Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                e.onNext(1);
//                e.onNext(2);
//                e.onNext(3);
//                e.onComplete();
//            }
//        });
//        Observable<String> observable2 = Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(ObservableEmitter<String> e) throws Exception {
//                e.onNext("A");
//                e.onNext("B");
//                e.onNext("C");
//                e.onComplete();
//            }
//        });
//        Observable.zip(observable1, observable2, new BiFunction<Integer, String, String>() {
//            @Override
//            public String apply(Integer integer, String s) throws Exception {
//                return integer + s;
//            }
//        }).subscribe(new Observer<String>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(String value) {
//                Log.i(TAG, "onNext: -----"+value);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//                Log.i(TAG, "onComplete: ----");
//            }
//        });
//
//    }
//
//    public void test9(){
//        Observable<Integer> observable1 = Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                for (int i = 0;;i++){
//                    e.onNext(i);
//                }
//            }
//        }).subscribeOn(Schedulers.io());
//        Observable<String> observable2 = Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(ObservableEmitter<String> e) throws Exception {
//                e.onNext("A");
//
//            }
//        }).subscribeOn(Schedulers.io());
//        Observable.zip(observable1, observable2, new BiFunction<Integer, String, String>() {
//            @Override
//            public String apply(Integer integer, String s) throws Exception {
//                return integer + s;
//            }
//        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                Log.i(TAG, "accept: --------"+s);
//            }
//        });
//    }
//
//    //filter过滤
//    // sample 每隔指定时间就从上游发送一个事件给下游
//    //这两个方法有缺点，就是丢失了大部分的事件
//    public void test10(){
////        Observable.create(new ObservableOnSubscribe<Integer>() {
////
////            @Override
////            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
////                for (int i = 0;;i++){
////                    e.onNext(i);
////                }
////            }
////        }).subscribeOn(Schedulers.io())
////                //过滤一下
////            .filter(new Predicate<Integer>() {
////                @Override
////                public boolean test(Integer integer) throws Exception {
////                    return integer % 100 == 0;
////                }
////            })
////        .observeOn(AndroidSchedulers.mainThread())
////        .subscribe(new Consumer<Integer>() {
////            @Override
////            public void accept(Integer integer) throws Exception {
////                Log.i(TAG, "accept: --------"+integer);
////            }
////        });
//                Observable.create(new ObservableOnSubscribe<Integer>() {
//
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//                for (int i = 0;;i++){
//                    e.onNext(i);
//                }
//            }
//        }).subscribeOn(Schedulers.io())
//                        .sample(2,TimeUnit.SECONDS)
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(new Consumer<Integer>() {
//                            @Override
//                            public void accept(Integer integer) throws Exception {
//                                Log.i(TAG, "accept: ------"+integer);
//                            }
//                        });
//    }
//    //背压策略
//    public void test11(){
//        Flowable.create(new FlowableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(FlowableEmitter<Integer> e) throws Exception {
//                for (int i = 0;i<1209;i++){
//                    e.onNext(i);
//                }
//            }
//        }, BackpressureStrategy.ERROR).subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<Integer>() {
//                    @Override
//                    public void onSubscribe(Subscription s) {
//
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        Log.i(TAG, "onError: ----错误----"+t);
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//
//
//    }
//
//    //真正的响应式
//    public void test12(){
//        Flowable.create(new FlowableOnSubscribe<Integer>() {
//
//
//            @Override
//            public void subscribe(FlowableEmitter<Integer> e) throws Exception {
//                Log.i(TAG, "subscribe: ------"+e.requested());
//            }
//        },BackpressureStrategy.ERROR)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//        .subscribe(new Subscriber<Integer>() {
//            @Override
//            public void onSubscribe(Subscription s) {
//                Log.i(TAG, "onSubscribe: ");
////                s.request(2);
//            }
//
//            @Override
//            public void onNext(Integer integer) {
//                Log.i(TAG, "onNext: ---"+integer);
//            }
//
//            @Override
//            public void onError(Throwable t) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });
//
//
//
//    }
//
//    Subscription subscription;
//    public void request(){
//        //下游每消费96个事件，便会自动触发内部的request()去设置上游的requested的值
//        subscription.request(96);
//    }
//
//    public void test13(){
//        Flowable.create(new FlowableOnSubscribe<Integer>() {
//
//            @Override
//            public void subscribe(FlowableEmitter<Integer> e) throws Exception {
//                Log.i(TAG, "subscribe: -----"+e.requested());
//                boolean flag ;
//                for (int i = 0;;i++){
//                    while (e.requested() == 0){
//                        flag = false;
//                        if (!flag){
//                            flag = true;
//                        }
//                    }
//                    e.onNext(i);
//                    Log.i(TAG, "subscribe: -----"+i);
//                }
//
//
//            }
//        },BackpressureStrategy.ERROR)
//        .subscribeOn(Schedulers.io())
//        .observeOn(AndroidSchedulers.mainThread())
//        .subscribe(new Subscriber<Integer>() {
//            @Override
//            public void onSubscribe(Subscription s) {
//                Log.i(TAG, "onSubscribe: -------");
//                subscription = s;
//            }
//
//            @Override
//            public void onNext(Integer integer) {
//                Log.i(TAG, "onNext: ------"+integer);
//            }
//
//            @Override
//            public void onError(Throwable t) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });
//
//    }
//
//    public void test14(){
//
//
//    }
//
//
//
//}
