package com.futing.javalib.patterns.structure.adapter;

import com.futing.javalib.patterns.entity.bag.AppleBag;
import com.futing.javalib.patterns.entity.bag.OrangeBag;

/**
 * 桔子包装适配器
 *
 */
// TODO: 2024/8/29 苹果包装传进来，转回橘子包装盒
public class OrangeBagAdapter extends OrangeBag {
    private AppleBag appleBag;

    public OrangeBagAdapter(AppleBag appleBag){
        this.appleBag = appleBag;
    }

    @Override
    public void pack() {
        appleBag.pack();
    }
}
