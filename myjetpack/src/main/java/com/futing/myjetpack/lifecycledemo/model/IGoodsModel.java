package com.futing.myjetpack.lifecycledemo.model;



import com.futing.myjetpack.lifecycledemo.bean.Goods;

import java.util.List;

public interface IGoodsModel {
    void loadGoodsData(OnLoadListener onLoadListener);
    interface OnLoadListener{
        void onComplete(List<Goods> goods);
        void onError(String msg);
    }
}









