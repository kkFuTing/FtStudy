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
){
   fun toFilteredTypes(): List<FilteredType> {
        return this.types.map { type ->
            FilteredType(
                id = type.id,
                name = type.name
            )
        }
    }
}

//data class Type(
//    val id: String,
//    val introduction: String,
//    val location: String,
//    val name: String
//)
data class Type(
    val introduction: String,
    val location: String,
    override val id: String,
    override val name: String
) : baseType(id, name)

open class baseType(
    open val id: String,
    open val name: String
)


open class FilteredType(
    val id: String,
    val name: String
)


data class FilteredProduct(
    val name: String,
    val types: List<FilteredType>
)