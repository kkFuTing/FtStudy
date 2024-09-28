package com.futing.javalib.patterns.structure.bridge;

import com.futing.javalib.patterns.structure.bridge.bag.BagAbstraction;
import com.futing.javalib.patterns.structure.bridge.bag.SmallBag;
import com.futing.javalib.patterns.structure.bridge.material.Material;
import com.futing.javalib.patterns.structure.bridge.material.Paper;

/**
 * 园丁采摘水果　　　　　　　　　　　　　　　　　　　　　　 　
 */
public class BridgeClient {

    public static void main(String[] args) {

        //袋子型号
        BagAbstraction bag = new SmallBag();

        //袋子材质
        Material material = new Paper();
        bag.setMaterial(material);

        //开始采摘
        bag.pick();
    }
}
