package com.example.kotlinlib.ubt

/**
 * Created by ft on 2024/10/26.
 */
data class Products(
    val products: List<Product>
)

data class Product(
    val name: String,
    val types: List<Type>
)

data class Type(
    val id: String,
    val introduction: String,
    val location: String,
    val name: String
)
