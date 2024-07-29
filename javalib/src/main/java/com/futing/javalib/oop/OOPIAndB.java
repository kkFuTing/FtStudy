package com.futing.javalib.oop;

/**
 * Created by futing on 2024/6/7.
 */
public class OOPIAndB {
    public abstract static class Dog{
        public void sleep(){
            //...
        }
        public abstract void eat();

        //XX是这样写的我发现无法加{}
//        public abstract void eat(){
//
//        }

    }

    public interface  HandShakeI{
        void doHandShake();
    }

    public class HandShake extends Dog implements HandShakeI{
        @Override
        public void eat() {

        }

        @Override
        public void doHandShake() {

        }
        //
    }

}
