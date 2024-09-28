package simple02.s02

// TODO 数组
fun main() {
    // 第一种形式
    val numbers = arrayOf(1, 2, 3, 4, 5, 6, 7, 8)
    // println(numbers[0])
    // println(numbers[7])
    for (number in numbers) {
        // println(number)
    }



    // 第二种形式  value=0 //value 默认是从0开始的， size等于=10 就+10次
    // 0 + 200 = 200
    // 1 + 200 = 201
    val numbers2 = Array(10,  {value: Int -> (value + 200) })
    for (value in numbers2) {
        println(value)
    }

    // 定义一个变量 value Int类型
    // value=0 + 200
    // {value: Int                ->                     (value + 200) }
}