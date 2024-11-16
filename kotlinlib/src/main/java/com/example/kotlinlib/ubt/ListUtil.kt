package com.example.kotlinlib.ubt


fun MutableMap<Int, MutableList<Float>>.putAll(keyList: List<Int>, valueList: List<Float>) {
    require(keyList.size == valueList.size) { "keyList and valueList must have the same size" }

    for ((i, key) in keyList.withIndex()) {
        if (this.containsKey(key)) {
            this[key]?.add(valueList[i])
        } else {
            this[key] = mutableListOf(valueList[i])
        }
    }
}

fun MutableMap<Int, MutableList<Float>>.putAll(keyList: List<Int>, valueList: List<Float>, startList: List<Int>) {
    require(keyList.size == valueList.size || keyList.size == startList.size || valueList.size == startList.size) {
        "keyList and valueList must have the same size"
    }
    for ((i, key) in keyList.withIndex()) {
        if (this[key]?.size == 0 || this[key] == null) {
            val first = valueList[i] + startList[i]
            if (this[key] == null) {
                this[key] = mutableListOf(first)
            } else
                this[key]?.add(first)//仅首次许需要加复位角度
        } else {
            this[key]?.add(valueList[i])
        }
    }
}

/**
 * size相同的list减法运算
 */
inline operator fun <reified T : Number> List<T>.minus(other: List<T>): List<T> {
    require(this.size == other.size) { "Lists must have the same size for subtraction." }
    val result = mutableListOf<T>()
    for (i in this.indices) {
        val element1 = this[i]
        val element2 = other[i]
        when (T::class) {
            Byte::class -> result.add((element1.toByte() - element2.toByte()) as T)
            Short::class -> result.add((element1.toShort() - element2.toShort()) as T)
            Int::class -> result.add((element1.toInt() - element2.toInt()) as T)
            Long::class -> result.add((element1.toLong() - element2.toLong()) as T)
            Float::class -> result.add((element1.toFloat() - element2.toFloat()) as T)
            Double::class -> result.add((element1.toDouble() - element2.toDouble()) as T)
            else -> throw UnsupportedOperationException("Unsupported numeric type！！type=${T::class}")
        }
    }
    return result
}

/**
 * size相同的list乘法运算
 */
inline operator fun <reified T : Number> List<T>.times(other: List<T>): List<T> {
    require(this.size == other.size) { "Lists must have the same size for times." }
    val result = mutableListOf<T>()
    for (i in this.indices) {
        val element1 = this[i]
        val element2 = other[i]
        when (T::class) {
            Byte::class -> result.add((element1.toByte() * element2.toByte()) as T)
            Short::class -> result.add((element1.toShort() * element2.toShort()) as T)
            Int::class -> result.add((element1.toInt() * element2.toInt()) as T)
            Long::class -> result.add((element1.toLong() * element2.toLong()) as T)
            Float::class -> result.add((element1.toFloat() * element2.toFloat()) as T)
            Double::class -> result.add((element1.toDouble() * element2.toDouble()) as T)
            else -> throw UnsupportedOperationException("Unsupported numeric type！！ type=${T::class}")
        }
    }
    return result
}

/**
 * list中的每一个元素都乘以一个数Double类型的数element2
 */
inline operator fun <reified T : Number> List<T>.times(element2: Float): List<Float> {
    val result = mutableListOf<Float>()
    for (i in this.indices) {
        val element1 = this[i]
        when (T::class) {
            Byte::class -> result.add(element1.toByte() * element2)
            Short::class -> result.add(element1.toShort() * element2)
            Int::class -> result.add(element1.toInt() * element2)
            Long::class -> result.add(element1.toLong() * element2)
            Float::class -> result.add(element1.toFloat() * element2)
            Double::class -> result.add(element1.toFloat() * element2)
            else -> throw UnsupportedOperationException("Unsupported numeric type! type=${T::class}")
        }
    }
    return result
}


/**
 * size相同的list加法运算
 */
inline operator fun <reified T : Number> List<T>.plus(other: List<T>): List<T> {
    require(this.size == other.size) { "Lists must have the same size for plus." }
    val result = mutableListOf<T>()
    for (i in this.indices) {
        val element1 = this[i]
        val element2 = other[i]
        when (T::class) {
            Byte::class -> result.add((element1.toByte() + element2.toByte()) as T)
            Short::class -> result.add((element1.toShort() + element2.toShort()) as T)
            Int::class -> result.add((element1.toInt() + element2.toInt()) as T)
            Long::class -> result.add((element1.toLong() + element2.toLong()) as T)
            Float::class -> result.add((element1.toFloat() + element2.toFloat()) as T)
            Double::class -> result.add((element1.toDouble() + element2.toDouble()) as T)
            else -> throw UnsupportedOperationException("Unsupported numeric type！！ type=${T::class}")
        }
    }
    return result
}


/**
 * size相同的list加法运算
 */
inline fun <reified T : Number> List<T>.add(other: List<Int>): List<Double> {
    require(this.size == other.size) { "Lists must have the same size for plus." }
    val result = mutableListOf<Double>()
    for (i in this.indices) {
        val element1 = this[i]
        val element2 = other[i]
        when (T::class) {
            Float::class -> result.add((element1.toFloat() + element2).toDouble())
            Double::class -> result.add((element1.toDouble() + element2))
            Byte::class -> result.add((element1.toInt() + element2).toDouble())
            Short::class -> result.add((element1.toShort() + element2).toDouble())
            Int::class -> result.add((element1.toInt() + element2).toDouble())
            Long::class -> result.add((element1.toLong() + element2).toDouble())
            else -> throw UnsupportedOperationException("Unsupported numeric type！！ type=${T::class}")
        }
    }
    return result
}


inline fun <reified T : Number> List<T>.add(element2: Int): List<Double> {
    val result = mutableListOf<Double>()
    for (i in this.indices) {
        val element1 = this[i]
//        val element2 = other[i]
        when (T::class) {
            Float::class -> result.add((element1.toFloat() + element2).toDouble())
            Double::class -> result.add((element1.toDouble() + element2))
            Byte::class -> result.add((element1.toInt() + element2).toDouble())
            Short::class -> result.add((element1.toShort() + element2).toDouble())
            Int::class -> result.add((element1.toInt() + element2).toDouble())
            Long::class -> result.add((element1.toLong() + element2).toDouble())
            else -> throw UnsupportedOperationException("Unsupported numeric type！！ type=${T::class}")
        }
    }
    return result
}
