package com.futing.myjetpack.use_paging;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;

public class PersonDataSourceFactory extends DataSource.Factory<Integer, Person> {

    @NonNull
    @Override
    public DataSource<Integer, Person> create() {
        return new CustomItemDataSource(new DataRepository());
    }
}
