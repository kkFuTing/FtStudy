package com.futing.javalib.javabase;

/**
 * Created by futing on 2024/6/12.
 */
public class InClassByStatic {
    InClassByStatic.SInnerclass sInnerclass = new InClassByStatic.SInnerclass();

    Innerclass innerclass = new Innerclass();
    InClassByStatic.Innerclass innerclass1 = new InClassByStatic.Innerclass();

    public static void main(String[] args) {

    }

    int anInt;
    static int sanInt;

    static class SInnerclass {
        public SInnerclass() {
            //    不可以使用
//            anInt =0 ;
            sanInt = 0;
        }

    }


    class Innerclass {
        public Innerclass() {
            //可以使用
            anInt = 0;
            sanInt = 0;
        }
    }


}
