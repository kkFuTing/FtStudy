package com.futing.uiapplication.leo_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.futing.uiapplication.R;

import java.util.ArrayList;
import java.util.List;

// TODO: 2024/8/27 吸顶效果 感觉和面试相关性不大，大概看看吧
public class MainActivity extends AppCompatActivity {

    private List<Star> starList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recycle);

        init();

        RecyclerView recyclerView = findViewById(R.id.rv_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 自定义分割线 主要是这里
        recyclerView.addItemDecoration(new StarDecoration(this));
        recyclerView.setAdapter(new StarAdapter(this, starList));
    }

    private void init() {
        starList = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 20; j++) {
                if (i % 2 == 0) {
                    starList.add(new Star("何炅" + j, "快乐家族" + i));
                } else {
                    starList.add(new Star("汪涵" + j, "天天兄弟" + i));
                }
            }
        }
    }
}