package simple05.s01

// public final class Person 默认就是这样的，不能被继承，  可以加open就可以被人家继承了
open class Person(id: Int) // 主构造
{

    // 次构造 （次构造必须引用注构造，类似于Java的函数重载）
    constructor(id: Int, name: String) : this(id) {

    }


    // 次构造
    constructor(id: Int, sex: Char) : this(id) {

    }

    // 次构造
    constructor() : this(787) {

    }

}