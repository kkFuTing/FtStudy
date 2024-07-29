package com.futing.javalib.oop;

/**
 * Created by futing on 2024/6/6.
 */
public class OOP {
    interface DogI {
        void eat();

        void sleep();
    }

    public abstract class DogA {
        public void sleep() {

        }

        public abstract void eat();
    }

    static class DogCI implements DogI {
        @Override
        public void eat() {

        }

        @Override
        public void sleep() {

        }
    }

    abstract class DogCA extends DogA {

    }

    public abstract class Handshake {
        abstract void doHandSake();
    }

    // DogA//Handshake 但是会引起二义性，所以没有办法通过抽象类实现一个能握手的狗
    public class DogCHandshake extends Handshake {
        @Override
        void doHandSake() {

        }
    }


}
