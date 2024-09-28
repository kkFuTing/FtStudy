package simple05.s02

// 默认是 public final class Person 不能被人家继承的
// abstract有open的特征 相当于open
//灰色（）是隐式的，所以继承 Person的时候 是要写成 Person()
abstract class Person (): Callback , Callback2 {

    abstract fun getLayoutID() : Int

    abstract fun initView()

}