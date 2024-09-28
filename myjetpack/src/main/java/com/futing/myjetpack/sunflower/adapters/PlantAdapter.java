package com.futing.myjetpack.sunflower.adapters;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.futing.myjetpack.databinding.ListItemPlantBinding;
import com.futing.myjetpack.sunflower.data.Plant;
import com.futing.myjetpack.sunflower.fragments.PlantListFragmentDirections;
//import com.futing.myjetpack.sunflower.databinding.ListItemPlantBinding;

/**
 * 植物目录 的 适配器
 */
public class PlantAdapter extends ListAdapter<Plant, PlantAdapter.ViewHolder> {

    public PlantAdapter() {
        super(new PlantDiffCallback());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ListItemPlantBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Plant plant = getItem(position);
        holder.itemView.setTag(plant);
        holder.bind(createOnClickListener(plant.getPlantId()), plant);
    }

    private View.OnClickListener createOnClickListener(String plantId) {
        // return v -> Log.e("item", "onClick: 你点击了植物列表的Item，plantId:" + plantId);

        // 导航过去了 到 详情
        return v -> Navigation.findNavController(v).navigate(
                //依赖args 相关
                PlantListFragmentDirections.actionPlantListFragmentToPlantDetailFragment(plantId)
        );
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private ListItemPlantBinding binding;

        ViewHolder(@NonNull ListItemPlantBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(View.OnClickListener listener, Plant item) {
            binding.setPlant(item); // 生成出来的，建立关联  ===  new Plant(行参1,行参2,行参3,xxx)
            //  binding.setXxx(item);
            binding.setClick(listener); // 直接和 布局里面的 click 绑定了 关联起来
            binding.executePendingBindings();
        }
    }

    static class PlantDiffCallback extends DiffUtil.ItemCallback<Plant> {

        @Override
        public boolean areItemsTheSame(@NonNull Plant oldItem, @NonNull Plant newItem) {
            return oldItem.getPlantId().equals(newItem.getPlantId());
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull Plant oldItem, @NonNull Plant newItem) {
            return oldItem == newItem;
        }
    }
}
