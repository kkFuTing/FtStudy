package simple05.s01

//继承 使用 :  只有open类型才能被继承
class Student(id: Int) : // Person() // 次构造
                Person(id) // 主构造了
{
    // 再Kotlin 全部都是没有默认值的
//    var name1 : String //这是会报错的
    // lateinit 懒加载  没有赋值 就不能使用，否则报错
//    lateinit val name2 : String //还不能用val修饰，因为是不可变
    lateinit var name : String

    // 再Java 成员有默认值，但是方法内部没有默认值
    var age: Int = 0
}