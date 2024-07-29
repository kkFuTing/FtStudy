package com.futing.javalib.javabase;

/**
 * Created by futing on 2024/6/12.
 */
public class StaticClass {
    public StaticClass(){
        InClassByStatic inClassByStatic = new InClassByStatic();
        //静态类内部类能脱离外部类被创建，。
        InClassByStatic.SInnerclass innerclass = new InClassByStatic.SInnerclass();
        //非静态类内部类不能脱离外部类被创建，。
//        InClassByStatic.Innerclass innerclass = new InClassByStatic.Innerclass();
    }
}
