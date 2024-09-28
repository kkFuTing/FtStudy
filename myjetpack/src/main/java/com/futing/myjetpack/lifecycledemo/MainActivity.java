package com.futing.myjetpack.lifecycledemo;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.lifecycle.Observer;


import com.futing.myjetpack.R;
import com.futing.myjetpack.lifecycledemo.adapter.GoodsAdapter;
import com.futing.myjetpack.lifecycledemo.bean.Goods;
import com.futing.myjetpack.lifecycledemo.databus.LiveDataBus;
import com.futing.myjetpack.lifecycledemo.presenter.GoodsPresenter;
import com.futing.myjetpack.lifecycledemo.view.BaseActivity;
import com.futing.myjetpack.lifecycledemo.view.IGoodsView;

import java.util.ArrayList;
import java.util.List;
//此项目是一个MVP模式的项目

/**
 * Activity 作为一个被观察者， 其他类作为观察者
 */
public class MainActivity extends BaseActivity<GoodsPresenter, IGoodsView> implements IGoodsView {



    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lifecycle);
        listView=findViewById(R.id.listView);

        presenter.fetch();

        LiveDataBus.getInstance().with("list", ArrayList.class)
                .observe(this, new Observer<ArrayList>() {
                    @Override
                    public void onChanged(ArrayList arrayList) {
                        if(arrayList!=null){
                            Log.i("jett","收到了数据"+arrayList.toString());
                        }
                    }
                });

    }
    @Override
    protected GoodsPresenter createPresenter() {
        return new GoodsPresenter();
    }
    @Override
    public void showGoodsView(List<Goods> goods) {
        listView.setAdapter(new GoodsAdapter(this,goods));
    }

    @Override
    public void showErrorMessage(String msg) {

    }

    @Override
    protected void init() {
        super.init();
//        步骤三：此时已经绑定好了！！！
        getLifecycle().addObserver(presenter);
    }
}
