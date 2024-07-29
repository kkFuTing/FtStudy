package com.futing.javalib.generic;

/**
 * Created by futing on 2024/6/4.
 */
public class LimitedGeneric {
    static class A {
    }

    static class A1 {
    }

    static interface B {
    }

    static interface C {
    }

    static interface E {
    }


    static class D1<T extends A & B & C> {

    }

    //下面是不行的
//    static class D2<T extends A1 & A & B & C> {
//
//    }


}
