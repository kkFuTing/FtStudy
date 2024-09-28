package com.futing.myjetpack.sunflower.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.futing.myjetpack.sunflower.data.GardenPlantingRepository;

/**
 * Factory for creating a [GardenPlantingListViewModel] with a constructor that takes a
 * [GardenPlantingRepository].
 *
 * 【我的花园 List 列表的 ViewModel】 的工厂，就是为了创建出 GardenPlantingListViewModel(给我的VM 建立仓库)
 */
public class GardenPlantingListViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private GardenPlantingRepository repository;

    public GardenPlantingListViewModelFactory(GardenPlantingRepository repository) {
        super();
        this.repository = repository;
    }

    // 创建 ViewModel
    // 以前是ViewModelProvider反射创建VM ,   现在我们自己控制(主控权) 走我们自己的create函数
    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new GardenPlantingListViewModel(repository);
    }
}
