package com.futing.myjetpack.use_paging;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.futing.myjetpack.R;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getSimpleName();

    RecyclerView recyclerView;
    RecyclerPagingAdapter recyclerPagingAdapter;

    PersonViewModel personViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_paging);

        recyclerView = findViewById(R.id.recycle_view);
        recyclerPagingAdapter = new RecyclerPagingAdapter();

        personViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(PersonViewModel.class);
        personViewModel.getPagedListLiveData().observe(this, new Observer<PagedList<Person>>() {
            @Override
            public void onChanged(PagedList<Person> persons) {
                recyclerPagingAdapter.submitList(persons);
            }
        });

        recyclerView.setAdapter(recyclerPagingAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
