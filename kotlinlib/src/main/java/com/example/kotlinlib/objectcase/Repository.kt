package com.example.kotlinlib.objectcase

import android.graphics.ImageFormat

/**
 * Created by futing on 2024/8/1.
 */
class Repository
private constructor() {

    //    private val users: MutableList<User> =  ArrayList()
    private val users: MutableList<User> = mutableListOf<User>()

    //val 就没有办法再init{}初始化，
//    private val users: MutableList<User>? = null
    val formattedUserNames: List<String>
        get() {
            val userNames = ArrayList<String>(users!!.size)
            for ((firstName, lastName) in users) {
                val name: String?
                if (lastName != null) {
                    if (firstName != null) {
                        name = "$firstName $lastName"
                    } else {
                        name = lastName
                    }
                } else if (firstName != null) {
                    name = firstName
                } else {
                    name = "unknow"
                }

//                name = firstName ?: "Unknown" 空则取 Unknown的写法
                userNames.add(name)

            }
            return userNames
        }

    //    在 Kotlin 中，主构造函数无法包含任何代码，因此初始化代码会置于 init 块中。不过，二者功能完全相同。
    init {
        val user1 = User("futing1", "")
        val user2 = User("futing2", null)
        val user3 = User("futing3", "jingjing")
//        users = ArrayList()
        //！！加在变量之后,对象不为空的情况下执行
        users!!.add(user1)
        users!!.add(user2)
        users!!.add(user3)

//    为了仅在特定对象的上下文中执行代码，而无需根据名称来访问该对象，Kotlin 专门创建了 5 个作用域函数，即：let、apply、with、run 和 also。
//    由于要在 Repository 中配置 _users 对象，我们可以使用 apply 函数，让代码更加符合使用习惯，具体如下：
        users.apply {
            add(user1)
            add(user2)
            add(user3)
        }


    }

    // TODO: 加个问号是什么意思
    fun getUser(): List<User>? {
        return users
    }


    //    在 Java 中，我们会在字段或函数中使用 static 关键字，以指出此等字段或函数属于某个类，但不属于该类的某个实例。
//    因此，我们在 Repository 类中创建了 INSTANCE 静态字段。在 Kotlin 中，companion object 代码块与此等效。
//    您还可在此处声明静态字段和静态函数。转换器已创建 INSTANCE 字段并将其移至此处。
    companion object {
        private var INSTANCE: Repository? = null

        // TODO: //为什么结尾要打个问好什么意思？？
        val instance: Repository?
            get() {
                if (INSTANCE == null) {
                    synchronized(Repository::class) {
                        if (INSTANCE == null) {
                            INSTANCE = Repository()
                        }
                    }
                }
                return INSTANCE
            }
    }


}