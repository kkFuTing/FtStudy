package com.futing.javalib.generic;

/**
 * Created by futing on 2024/6/4.
 * java中的泛型的三种类型
 * 泛型方法
 * 泛型类
 * 泛型接口
 */

//泛型类
public class Generic<T> {
    private T t;

    //普通方法
    public T getT() {
        return t;
    }
}

//泛型接口
interface IGeneric<T>{
}


class GenericMethod{

    //泛型方法
    public <T> T test(T t){
        return t;
    }

}

//泛型接口/类的实现1
class  GenericIMPL1<T> implements IGeneric<T>{
    public static void main(String[] args) {
        GenericIMPL1<Object> objectGenericIMPL1 = new GenericIMPL1<>();

    }
}

//泛型接口/类的实现2

class  GenericIMPL2 implements IGeneric<String>{
    public static void main(String[] args) {
        GenericIMPL2 genericIMPL2 = new GenericIMPL2();

    }

}