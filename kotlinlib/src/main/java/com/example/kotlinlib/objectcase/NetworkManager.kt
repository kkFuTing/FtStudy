package com.example.kotlinlib.objectcase

/**
 * Created by futing on 2024/8/1.
 * 伴生对象是一个类内部的对象声明，它与该类的实例共享相同的名称。
 *使用场景：伴生对象适用于在类内部定义静态方法或静态属性，并与类的实例无关的场景。
 *
 */
class NetworkManager {
    //NetworkManager 类定义了一个伴生对象，其中的 performRequest() 方法提供了执行网络请求的逻辑。
    // 我们可以通过 NetworkManager.performRequest(url) 来调用该方法，而无需创建 NetworkManager 的实例。
    //伴生对象适用于在类内部定义静态方法或静态属性，并与类的实例无关的场景。
    companion object{
        fun performRequest(value: String){
            //执行网络请求的逻辑

        }

    }

    //其他类成员


}