package com.futing.myjetpack.roomdemo02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.ListView;


import com.futing.myjetpack.R;
import com.futing.myjetpack.roomdemo02.adapter.GoodsAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    StudentViewModel studentViewModel;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_roomdemo2);
        listView = findViewById(R.id.listView);

        studentViewModel = ViewModelProviders.of(this).get(StudentViewModel.class);
        studentViewModel.getAllLiveDataStudent().observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(List<Student> students) {
                listView.setAdapter(new GoodsAdapter(MainActivity.this, students));
            }
        });

        for (int i = 0; i < 50; i++) {
            studentViewModel.insert(new Student("jett", "123", 1));
        }

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    studentViewModel.update(new Student(6, "jett" + i, "123", 1));
                }
            }
        }.start();

    }
}