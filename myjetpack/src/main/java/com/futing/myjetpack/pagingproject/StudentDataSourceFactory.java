package com.futing.myjetpack.pagingproject;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;

/**
 * //使用paging步骤五：
 * 数据的工厂
 */
public class StudentDataSourceFactory extends DataSource.Factory<Integer, Student> {

    @NonNull
    @Override
    public DataSource<Integer, Student> create() {
        //把数据源返回
        StudentDataSource studentDataSource = new StudentDataSource();
        return studentDataSource;
    }
}
