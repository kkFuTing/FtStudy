package com.futing.memorylib;

/**
 * Created by futing on 2024/8/14.
 */



class A{
    private C c1 = C.getInstance();


}
class B{
    private C c2 = C.getInstance();
}

class C {
    private  static  C myC = new C();
    public static C getInstance(){
        return myC;
    }

    private D d1 = new D();
    private E e1 = new E();

}

class  D{}
class  E{}
public class MATRef {
    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        B b = new B();
        Thread.sleep(Integer.MAX_VALUE);//线程休眠
    }
}
