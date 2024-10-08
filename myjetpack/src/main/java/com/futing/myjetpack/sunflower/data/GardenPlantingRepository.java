package com.futing.myjetpack.sunflower.data;

import androidx.lifecycle.LiveData;

import com.futing.myjetpack.sunflower.utilites.AppExecutors;

import java.util.List;

/**
 * 这个是 我的花园 仓库层    服务 ----  Room(Dao)
 */
public class GardenPlantingRepository {

    // 此类 单例模式 成员
    private static GardenPlantingRepository instance;

    // 此类 我的花园的dao 用于对此数据的 增删改查
    private GardenPlantingDao gardenPlantingDao;

    // 构造函数 接收 DAO
    private GardenPlantingRepository(GardenPlantingDao gardenPlantingDao) {
        this.gardenPlantingDao = gardenPlantingDao;
    }

    // 单例模式
    public static GardenPlantingRepository getInstance(GardenPlantingDao gardenPlantingDao) {
        if (instance == null) {
            synchronized (GardenPlantingRepository.class) {
                if (instance == null) {
                    instance = new GardenPlantingRepository(gardenPlantingDao);
                }
            }
        }
        return instance;
    }

    // 【这就是数据进入的入口】
    // 在植物介绍详情页  用户点击 + 号的时候， 加入到 我的花园GardenPlantings Room数据库里面去
    // 插入一条 我的花园数据 进去到Room数据库
    public void createGardenPlanting(String plantId) {
        AppExecutors.getInstance().diskIO().execute(() ->
                // 植物 insert 插入进去
                gardenPlantingDao.insertGardenPlanting(new GardenPlanting(plantId, null, null)));
    }

    // 备用的 没有用到
    // 从Room数据库 删除一条 我的花园数据
    public void removeGardenPlanting(GardenPlanting gardenPlanting) {
        AppExecutors.getInstance().diskIO().execute(() ->
                gardenPlantingDao.deleteGardenPlanting(gardenPlanting));
    }

    /**
     * Room的dao--->plantId条件查询 我的花园数据（单个）
     * @param plantId
     * @return
     */
    public LiveData<GardenPlanting> getGardenPlantingForPlant(String plantId) {
        return gardenPlantingDao.getGardenPlantingForPlant(plantId);
    }

    /**
     * Room的dao-->查询 我的花园 数据
     * @return
     */
    public LiveData<List<GardenPlanting>> getGardenPlantings() {
        return gardenPlantingDao.getGardenPlantings();
    }

    /**
     * Room的dao--->查询 我的花园+植物 两者合并的数据
     * @return
     */
    public LiveData<List<PlantAndGardenPlantings>> getPlantAndGardenPlantings() {
        return gardenPlantingDao.getPlantAndGardenPlantings();
    }

}
