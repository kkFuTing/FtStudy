package com.futing.opensourelib.rxjava.demo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

// TODO 零碎点
public class RxJavaDemo extends AppCompatActivity {

    private Disposable disposable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // RxAndroid有什么用
    private void test00() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("A");
            }
        })
        .observeOn(Schedulers.io()) // rxjava
        .subscribeOn(AndroidSchedulers.mainThread()) // rxandroid
        .subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                // TODO: 2024/8/18

            }
        })
        ;
    }

    private void test01() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {}
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                disposable = d;
            }

            @Override
            public void onNext(String s) {}

            @Override
            public void onError(Throwable e) {}

            @Override
            public void onComplete() {}
        });


        // ---

        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {}
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {}
        });
    }

    // 处理报黄
    private void test02() {

        // TODO: 2024/8/18 create 的话可以自己发射
        disposable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                // TODO: 2024/8/18 如果是 just那些的话，会帮我封装 了 onNext
                e.onNext("Derry");
                e.onNext("A");
                e.onComplete();
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // 最起码的写法
        if (disposable != null)
            if (!disposable.isDisposed())
                disposable.dispose();
    }
}
