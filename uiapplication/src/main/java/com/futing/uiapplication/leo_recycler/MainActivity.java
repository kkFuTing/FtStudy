package com.futing.uiapplication.leo_recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.futing.uiapplication.R;

import java.util.ArrayList;
import java.util.List;

// TODO: 2024/8/27

/**
 * 回收与复用
 */


public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recycle);

        rv = (RecyclerView) findViewById(R.id.rv_list);

//        rv.setLayoutManager(new GridLayoutManager(this, 3)); //onCreateViewHolder 上下滚动不会打印，快速滑动才会
        rv.setLayoutManager(new GridLayoutManager(this, 7));   //改成7 以后，上下滚动onCreateViewHolder就会多了；跟原理有关，只能存五分
        //在滑动是在不断回收复用 -》ontouchevent  思路 -》move
        rv.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));

        final List<String> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add("" + i);
        }

        final CustomAdapter adapter = new CustomAdapter(this, list);
        rv.setAdapter(adapter);
    }
}