package com.example.kotlinlib.coverkotlin

/**
 * Created by futing on 2024/8/1.
 * 在当前文件下，选择菜单栏的Code-》 【Convert java file to kotlin】 最后一个
 */
//public class JavaSwitchKotlinVisit {
//    private int name;
//    private int year;
//
//    public JavaSwitchKotlinVisit(int name, int year) {
//        this.name = name;
//        this.year = year;
//    }
//
//    public int getName() {
//        return name;
//    }
//
//
//    public int getYear() {
//        return year;
//    }
//
//    public void setYear(int year) {
//        this.year = year;
//    }
//}
//属性都带有 getter 和 setter 方法，因此属性值可变。Kotlin 的可变关键字是var，对于这两个属性，转换器均会使用var。
//如果Java属性只有getter，则属性值不可变，且会声明为val变量。val类似于Java中的final关键字。
class JavaSwitchKotlinVisit(val name: Int, var year: Int)