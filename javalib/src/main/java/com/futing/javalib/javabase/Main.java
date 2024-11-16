package com.futing.javalib.javabase;

interface Callback {
    void onSuccess(String result);
    void onError(String error);
}

class MyCallback implements Callback {
    @Override
    public void onSuccess(String result) {
        System.out.println("Success: " + result);
    }

    @Override
    public void onError(String error) {
        System.out.println("Error: " + error);
    }
}

class Service {
    void performAction(Callback callback) {
        // 假设这是一些操作，成功时调用回调
        callback.onSuccess("Operation completed!");
    }
}
//
//1. 接口本身是引用类型
//在许多编程语言（例如 Java、C# 等）中，接口是引用类型。这意味着，当你传递一个接口对象时，实际上是传递了该对象的引用，而不是对象的副本。这种传递方式意味着函数或方法可以修改接口对象的状态（如果对象本身是可变的）。
//
//        2. 回调的实现方式
//回调通常是通过传递一个接口类型的对象来实现的。比如，你会传递一个实现了某个接口的类的实例，这个实例会作为回调函数的参数进行传递。因为传递的是该对象的引用，回调函数内的操作实际上会影响到原对象的状态。

//在这个示例中，Service 类的 performAction 方法接收一个 Callback 类型的接口对象，并调用回调方法 onSuccess 或 onError。这里传递的是 Callback 接口的引用。因此，回调方法内部所做的任何操作，都会影响到传入的对象（例如输出它的状态、结果等）。
//
//结论
//在接口回调中，传递的是接口对象的引用，这意味着你通过回调可以修改对象的状态（如果对象是可变的），所以可以认为接口回调是引用传递。
// TODO: 2024/11/6 这个例子一般

public class Main {
    public static void main(String[] args) {
        Callback callback = new MyCallback();
        Service service = new Service();
        service.performAction(callback);
    }
}
