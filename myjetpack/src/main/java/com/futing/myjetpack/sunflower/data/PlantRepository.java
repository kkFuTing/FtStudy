package com.futing.myjetpack.sunflower.data;

import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * 这个是 植物 的仓库层
 *
 * Repository module for handling data operations.
 */
public class PlantRepository {

    // 单例模式用的
    private static PlantRepository instance;

    // 仓库才能对 dao进行增删改查
    private PlantDao plantDao;

    // 构造函数 必须接收一个dao， 仓库才能对 dao进行增删改查
    private PlantRepository(PlantDao gardenPlantingDao) {
        this.plantDao = gardenPlantingDao;
    }

    // 单例模式
    public static PlantRepository getInstance(PlantDao gardenPlantingDao) {
        if (instance == null) {
            synchronized (PlantRepository.class) {
                if (instance == null) {
                    instance = new PlantRepository(gardenPlantingDao);
                }
            }
        }
        return instance;
    }

    // 查询 plantDao数据库 的所有 植物目录数据
    public LiveData<List<Plant>> getPlants() {
        return this.plantDao.getPlants();
    }

    // 根据条件plantId查询 plantDao数据库 的所有 植物目录数据 （单个）
    public LiveData<Plant> getPlant(String plantId) {
        return this.plantDao.getPlant(plantId);
    }

    // 在 plants.json 里面查询： growZoneNumber": 9  就明白了
    public LiveData<List<Plant>> getPlantsWithGrowZoneNumber(int growZoneNumber) {
        return this.plantDao.getPlantsWithGrowZoneNumber(growZoneNumber);
    }
}
