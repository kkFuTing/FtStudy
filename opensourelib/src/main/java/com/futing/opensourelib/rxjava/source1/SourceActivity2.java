package com.futing.opensourelib.rxjava.source1;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * TODO RxJava的观察者模式
 * 1：Observer 源码看看
 * 2：Observable创建过程 源码分析
 * 3：subscribe订阅过程 源码分析
 */
public class SourceActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 结论： new ObservableCreate() {source == 自定义source}
        // 2：Observable创建过程 源码分析
        Observable.create(

                        // 自定义source
                        new ObservableOnSubscribe<String>() {
                            @Override
                            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                                // 发射器.onNext
                                emitter.onNext("A");
                            }
                        })


                // 3：subscribe订阅过程 源码分析
                // ObservableCreate. subscribe
                .subscribe(


                        // 自定义观察者
                        // 1：Observer 源码看看
                        new Observer<String>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                Log.d(Flag.TAG, "onSubscribe: " + Thread.currentThread().getName());

                            }

                            @Override
                            public void onNext(String s) {
                                Log.d(Flag.TAG, "onNext: " + s);

                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.d(Flag.TAG, "onError: " + e.getMessage());
                            }

                            @Override
                            public void onComplete() {
                                Log.d(Flag.TAG, "onComplete: ");

                            }
                        });
    }
}
