package com.example.kotlinlib.ubt

import java.util.ArrayList

/**
 * Created by ft on 2024/10/26.
 */
fun main() {

    val checkCardNUmber1 = true
    val checkCardNUmber2 = false
    val resultAll = arrayListOf(checkCardNUmber1, checkCardNUmber2)

// 生成所有字段的输出字符串
    val outputString = resultAll
        .mapIndexed { index, result -> "checkCardNUmber$index = $result" }
        .joinToString(", ")

    println(outputString)


    val type1 = Type("1", "健康", "陕西", "苹果")
    val type2 = Type("2", "甜的", "海南", "芒果")
    val type3 = Type("3", "好吃", "广西", "火龙果")
    val list = arrayListOf(type1, type2, type3)

    val product = Product("水果", list)
    val products = arrayListOf(product)
    println(products[0])

    println("----------获取过滤后的详情详情")
    println(products[0].toFilteredTypes())

    println("----------获取具体详情")
    getTypeById(products[0], "1")

}

//fun Product.toFilteredTypes(): List<FilteredType> {
//    return this.types.map { type ->
//        FilteredType(
//            id = type.id,
//            name = type.name
//        )
//    }
//}

fun getTypeById(products: Product, id: String): Type? {
    return products.types.find { it.id == id }
}
