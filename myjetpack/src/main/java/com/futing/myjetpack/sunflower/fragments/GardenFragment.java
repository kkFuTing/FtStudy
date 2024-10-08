package com.futing.myjetpack.sunflower.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.futing.myjetpack.databinding.FragmentGardenBinding;
import com.futing.myjetpack.sunflower.adapters.GardenPlantingAdapter;
import com.futing.myjetpack.sunflower.data.PlantAndGardenPlantings;
import com.futing.myjetpack.sunflower.utilites.InjectorUtils;
import com.futing.myjetpack.sunflower.viewmodels.GardenPlantingListViewModel;
import com.futing.myjetpack.sunflower.viewmodels.GardenPlantingListViewModelFactory;

import java.util.List;

/**
 * 【Fragment1 我的花园】 【打开APP所展示的 默认首页Fragment】
 */
public class GardenFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // 使用 DataBinding的布局文件  (fragment用inflate)
        FragmentGardenBinding binding = FragmentGardenBinding.inflate(inflater, container, false);

        // 创建适配器 用于展示（我的花园）列表数据
        GardenPlantingAdapter adapter = new GardenPlantingAdapter();

        // 给RecycleView设置适配器数据展示画面
        binding.gardenList.setAdapter(adapter);

        // 数据的关联：极其复杂
        subScribeUi(adapter, binding);

        // 返回binding的root是View类型，为什么返回它（由于把整个布局交给了DataBinding进行管理，所以getRoot是获取DataBinding管理的根节点）
        return binding.getRoot();
    }

    /**
     * 画面真正的展示渲染 细节操作
     *
     * @param adapter 上面丢下来的 适配器
     * @param binding 上面丢下来的 布局==DataBinding
     */
    private void subScribeUi(@NonNull GardenPlantingAdapter adapter, @NonNull FragmentGardenBinding binding) {

        // 数据暴漏层，仓库
        // VM工厂
        // VM
        // 仓库

        /**
         * 【我的花园 List 列表的 ViewModel】的工厂，就是为了创建出 GardenPlantingListViewModel
         * 而下面的代码，就是为了，【我的花园 List 列表的 ViewModel】 的工厂   的 初始化工作而已哦
         */
        GardenPlantingListViewModelFactory factory =
                InjectorUtils.provideGardenPlantingListViewModelFactory(requireContext());

        // 初始化 （我的花园 List 列表的 ViewModel） 同学们注意：当执行到这里时，ViewModel就已经拥有数据了
        GardenPlantingListViewModel viewModel =
                ViewModelProviders.of(this, factory).get(GardenPlantingListViewModel.class);

        // 此时 VM 有值了

        /**
         *  当 观察到 （我的花园 List 列表的 ViewModel）  的
         *             gardenPlantings列表数据是空的 （就展示文本说没有数据） <-- 否则 -->（展示数据）  【的一个标记而已】
         */
        viewModel.gardenPlantings.observe(getViewLifecycleOwner(), gardenPlantings ->
                binding.setHasPlantings(gardenPlantings != null && !gardenPlantings.isEmpty()));

        /**
         *  当 观察到 （我的花园+植物 List 列表的 ViewModel）  的
         *             gardenPlantings列表数据是OK的，就刷新适配器展示列表数据到RecycleView上面去显示，所以就展示了列表数据了
         */
        // 把数据 刷新到 RecyleView 中去
        /*viewModel.plantAndGardenPlantings.observe(getViewLifecycleOwner(), plantAndGardenPlantings -> {
            if (plantAndGardenPlantings != null && !plantAndGardenPlantings.isEmpty()) {
                adapter.submitList(plantAndGardenPlantings);
            }
        });*/
        viewModel.plantAndGardenPlantings.observe(getViewLifecycleOwner(), new Observer<List<PlantAndGardenPlantings>>() {
            @Override
            public void onChanged(List<PlantAndGardenPlantings> plantAndGardenPlantings) {
                if (plantAndGardenPlantings != null && !plantAndGardenPlantings.isEmpty()) {
                    adapter.submitList(plantAndGardenPlantings);
                }
            }
        });
    }
}