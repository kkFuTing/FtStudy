package com.futing.opensourelib.rxjava.rx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;


import com.futing.opensourelib.R;
import com.futing.opensourelib.rxjava.source.L;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        String[] str = {"A", "B", "C", "D"};


        for (String s : str) {
            Log.d(L.TAG, "onCreate: " + s);
        }

//        同上面for，但是性能不如上面，不是响应式编程就没有必要这样干
        Disposable disposable = Observable.fromArray(str)
                .subscribe(v-> {
                    Log.d(L.TAG, "onCreate: " + v);
                });

        // Observable.just("A");

        // 没有订阅 没有运行
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("A");
            }
        }).doOnNext(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {

            }
        });
    }
}
