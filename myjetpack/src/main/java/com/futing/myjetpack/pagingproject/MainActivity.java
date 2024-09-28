package com.futing.myjetpack.pagingproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.futing.myjetpack.R;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    RecyclerPagingAdapter recyclerPagingAdapter;
    StudentViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //使用paging步骤一：结合recycleview一起使用
        setContentView(R.layout.activity_main_paging);

        recyclerView =  findViewById(R.id.recycle_view);

        //使用paging步骤六： 到这一部，前面就算搭建好了，此处就可以开始使用了
        recyclerPagingAdapter = new RecyclerPagingAdapter();

        // 最新版本初始化 viewModel
        viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory())
                .get(StudentViewModel.class);

        //观察者是为了观察数据是否有变化，有变化就往上面放呀
        // LiveData 观察者 感应更新
        viewModel.getListLiveData().observe(this, new Observer<PagedList<Student>>() {
            @Override
            public void onChanged(PagedList<Student> students) {
                // 再这里更新适配器数据
                recyclerPagingAdapter.submitList(students);
            }
        });

        recyclerView.setAdapter(recyclerPagingAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
