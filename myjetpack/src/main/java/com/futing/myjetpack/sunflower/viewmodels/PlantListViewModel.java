package com.futing.myjetpack.sunflower.viewmodels;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.futing.myjetpack.sunflower.data.Plant;
import com.futing.myjetpack.sunflower.data.PlantRepository;

import java.util.List;

import kotlin.jvm.functions.Function1;

/**
 * 植物目录 列表 的 ViewModel
 */
public class PlantListViewModel extends ViewModel {

    private static final int NO_GROW_ZONE = -1; // 默认

    // ViewModel只负责操作仓库，向仓库拿数据
    private PlantRepository plantRepository;

    // 此LiveData是为了 （点击右上角按钮时 随机刷新数据的效果用的）
    private MutableLiveData<Integer> growZoneNumber;

    // 此LiveData 才是真正的 植物目录 的数据
    public LiveData<List<Plant>> plants;

    PlantListViewModel(@NonNull PlantRepository plantRepository) {
        super();
        this.plantRepository = plantRepository;
        this.growZoneNumber = new MutableLiveData<>(-1);

        // 眼睛：观察者 数据的变化
        // growZoneNumber.observe();  在Fragment/Activity 没有问题，因为有持有者        //ft但是这里没有持有者

        // (第一双眼睛)
        // 眼睛：growZoneNumber  你只要敢变 我就去刷新
        // 但是在这里没有持有者  (你拿不到持有者，就可以使用下面的操作，来观察数据)


        // TODO: 2024/8/25 好像新版本，下面那个用不了 了我才重新写了
        plants = Transformations.switchMap(growZoneNumber, new Function1<Integer, LiveData<List<Plant>>>() {
            @Override
            public LiveData<List<Plant>> invoke(Integer it) {
                if (it == NO_GROW_ZONE) { // -1 默认 正常查询
                    Log.d("item", "apply: 如果是 -1 就全部查询");
                    return PlantListViewModel.this.plantRepository.getPlants();
                } else {
                    Log.d("item", "apply: 否则就指定查询 并排序   【在 plants.json 里面查询： growZoneNumber\": 9  就明白了】");
                    return PlantListViewModel.this.plantRepository.getPlantsWithGrowZoneNumber(it);
                }
            }

        });


//        plants = Transformations.switchMap(growZoneNumber, new Function<Integer, LiveData<List<Plant>>>() {
//            @Override
//            public LiveData<List<Plant>> apply(Integer it) {
//                if (it == NO_GROW_ZONE) { // -1 默认 正常查询
//                    Log.d("item", "apply: 如果是 -1 就全部查询");
//                    return PlantListViewModel.this.plantRepository.getPlants();
//                } else {
//                    Log.d("item", "apply: 否则就指定查询 并排序   【在 plants.json 里面查询： growZoneNumber\": 9  就明白了】");
//                    return PlantListViewModel.this.plantRepository.getPlantsWithGrowZoneNumber(it);
//                }
//            }
//        });
    }

    // 是不是等于-1(默认)  true/false
    // （点击右上角按钮时 随机刷新数据的效果用的） 判断标记
    public boolean isFiltered() {
        return this.growZoneNumber.getValue() != NO_GROW_ZONE;  // NO_GROW_ZONE == -1
    }

    // （点击右上角按钮时 随机刷新数据的效果用的）
    public void setGrowZoneNumber(int num) {
        this.growZoneNumber.setValue(num);   // 修改成9  查询为9的数据
    }

    // （点击右上角按钮时 随机刷新数据的效果用的）
    public void cleanGrowZoneNumber() {
        this.growZoneNumber.setValue(NO_GROW_ZONE); // 修改成-1 默认 正常查询
    }
}
