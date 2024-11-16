//package com.example.kotlinlib.datadeal
//
//import com.google.gson.Gson
//import com.google.gson.reflect.TypeToken
//import com.squareup.moshi.Moshi
//import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
//
//fun main() {
//
//
//    val fileContent = "{\"duration\":0,\"phonemes\":[{\"end_time\":0.133,\"phone\":\"C0y\",\"start_time\":0.133},{\"end_time\":0.305,\"phone\":\"C0i\",\"start_time\":0.133},{\"end_time\":0.466,\"phone\":\"C0h\",\"start_time\":0.305},{\"end_time\":0.877,\"phone\":\"C0ou\",\"start_time\":0.466},{\"end_time\":0.877,\"phone\":\"C0w\",\"start_time\":0.877},{\"end_time\":0.999,\"phone\":\"C0uo\",\"start_time\":0.877},{\"end_time\":1.111,\"phone\":\"C0k\",\"start_time\":0.999},{\"end_time\":1.166,\"phone\":\"C0e\",\"start_time\":1.111},{\"end_time\":1.166,\"phone\":\"C0y\",\"start_time\":1.166},{\"end_time\":1.255,\"phone\":\"C0i\",\"start_time\":1.166},{\"end_time\":1.377,\"phone\":\"C0p\",\"start_time\":1.255},{\"end_time\":1.455,\"phone\":\"C0ei\",\"start_time\":1.377},{\"end_time\":1.499,\"phone\":\"C0n\",\"start_time\":1.455},{\"end_time\":1.588,\"phone\":\"C0i\",\"start_time\":1.499},{\"end_time\":1.661,\"phone\":\"C0l\",\"start_time\":1.588},{\"end_time\":1.783,\"phone\":\"C0iao\",\"start_time\":1.661},{\"end_time\":1.877,\"phone\":\"C0t\",\"start_time\":1.783},{\"end_time\":2.011,\"phone\":\"C0ian\",\"start_time\":1.877},{\"end_time\":2.116,\"phone\":\"C0j\",\"start_time\":2.011},{\"end_time\":2.238,\"phone\":\"C0ie\",\"start_time\":2.116},{\"end_time\":2.383,\"phone\":\"C0m\",\"start_time\":2.238},{\"end_time\":2.716,\"phone\":\"C0en\",\"start_time\":2.383},{\"end_time\":3.277,\"phone\":\"，\",\"start_time\":2.716},{\"end_time\":3.338,\"phone\":\"C0z\",\"start_time\":3.277},{\"end_time\":3.427,\"phone\":\"C0ai\",\"start_time\":3.338},{\"end_time\":3.466,\"phone\":\"C0n\",\"start_time\":3.427},{\"end_time\":3.566,\"phone\":\"C0i\",\"start_time\":3.466},{\"end_time\":3.638,\"phone\":\"C0zh\",\"start_time\":3.566},{\"end_time\":3.772,\"phone\":\"C0ao\",\"start_time\":3.638},{\"end_time\":3.827,\"phone\":\"C0d\",\"start_time\":3.772},{\"end_time\":3.977,\"phone\":\"C0ong\",\"start_time\":3.827},{\"end_time\":4.083,\"phone\":\"C0x\",\"start_time\":3.977},{\"end_time\":4.177,\"phone\":\"C0i\",\"start_time\":4.083},{\"end_time\":4.355,\"phone\":\"C0sh\",\"start_time\":4.177},{\"end_time\":4.449,\"phone\":\"C0iii\",\"start_time\":4.355},{\"end_time\":4.544,\"phone\":\"C0b\",\"start_time\":4.449},{\"end_time\":4.644,\"phone\":\"C0ang\",\"start_time\":4.544},{\"end_time\":4.694,\"phone\":\"C0n\",\"start_time\":4.644},{\"end_time\":4.783,\"phone\":\"C0i\",\"start_time\":4.694},{\"end_time\":4.938,\"phone\":\"C0k\",\"start_time\":4.783},{\"end_time\":5.049,\"phone\":\"C0uai\",\"start_time\":4.938},{\"end_time\":5.149,\"phone\":\"C0s\",\"start_time\":5.049},{\"end_time\":5.211,\"phone\":\"C0u\",\"start_time\":5.149},{\"end_time\":5.355,\"phone\":\"C0sh\",\"start_time\":5.211},{\"end_time\":5.405,\"phone\":\"C0iii\",\"start_time\":5.355},{\"end_time\":5.455,\"phone\":\"C0b\",\"start_time\":5.405},{\"end_time\":5.566,\"phone\":\"C0ie\",\"start_time\":5.455},{\"end_time\":5.705,\"phone\":\"C0t\",\"start_time\":5.566},{\"end_time\":5.777,\"phone\":\"C0u\",\"start_time\":5.705},{\"end_time\":5.927,\"phone\":\"C0x\",\"start_time\":5.777},{\"end_time\":6.133,\"phone\":\"C0iang\",\"start_time\":5.927},{\"end_time\":6.588,\"phone\":\"，\",\"start_time\":6.133},{\"end_time\":6.688,\"phone\":\"C0h\",\"start_time\":6.588},{\"end_time\":6.733,\"phone\":\"C0ai\",\"start_time\":6.688},{\"end_time\":6.788,\"phone\":\"C0n\",\"start_time\":6.733},{\"end_time\":6.922,\"phone\":\"C0eng\",\"start_time\":6.788},{\"end_time\":6.994,\"phone\":\"C0z\",\"start_time\":6.922},{\"end_time\":7.088,\"phone\":\"C0ai\",\"start_time\":6.994},{\"end_time\":7.138,\"phone\":\"C0n\",\"start_time\":7.088},{\"end_time\":7.249,\"phone\":\"C0i\",\"start_time\":7.138},{\"end_time\":7.249,\"phone\":\"C0y\",\"start_time\":7.249},{\"end_time\":7.377,\"phone\":\"C0iou\",\"start_time\":7.249},{\"end_time\":7.377,\"phone\":\"C0y\",\"start_time\":7.377},{\"end_time\":7.527,\"phone\":\"C0i\",\"start_time\":7.377},{\"end_time\":7.527,\"phone\":\"C0w\",\"start_time\":7.527},{\"end_time\":7.761,\"phone\":\"C0uen\",\"start_time\":7.527},{\"end_time\":7.977,\"phone\":\"C0sh\",\"start_time\":7.761},{\"end_time\":8.105,\"phone\":\"C0iii\",\"start_time\":7.977},{\"end_time\":8.205,\"phone\":\"C0g\",\"start_time\":8.105},{\"end_time\":8.283,\"phone\":\"C0ei\",\"start_time\":8.205},{\"end_time\":8.344,\"phone\":\"C0n\",\"start_time\":8.283},{\"end_time\":8.449,\"phone\":\"C0i\",\"start_time\":8.344},{\"end_time\":8.599,\"phone\":\"C0t\",\"start_time\":8.449},{\"end_time\":8.655,\"phone\":\"C0i\",\"start_time\":8.599},{\"end_time\":8.722,\"phone\":\"C0g\",\"start_time\":8.655},\n" +
//            "2024-10-09 14:37:40.338 15557-15557 ChatFragmentKt          com.ubt.uworld.chat                  I  {\"end_time\":8.861,\"phone\":\"C0ong\",\"start_time\":8.722},{\"end_time\":8.922,\"phone\":\"C0g\",\"start_time\":8.861},{\"end_time\":9.022,\"phone\":\"C0e\",\"start_time\":8.922},{\"end_time\":9.083,\"phone\":\"C0zh\",\"start_time\":9.022},{\"end_time\":9.205,\"phone\":\"C0ong\",\"start_time\":9.083},{\"end_time\":9.316,\"phone\":\"C0zh\",\"start_time\":9.205},{\"end_time\":9.411,\"phone\":\"C0iii\",\"start_time\":9.316},{\"end_time\":9.566,\"phone\":\"C0sh\",\"start_time\":9.411},{\"end_time\":9.677,\"phone\":\"C0iii\",\"start_time\":9.566},{\"end_time\":9.842,\"phone\":\"。\",\"start_time\":9.677}]}"
//    // 解析 JSON 数据
////    val json = Json {
////        ignoreUnknownKeys = true // 如果 JSON 中有未知字段，可以选择忽略它们
////    }
//    val type = object : TypeToken<MotionInfo>() {}.type
////    motionServoDegreeList = gson.fromJson(configJson, type)
//     val gson: Gson = Gson().newBuilder().create()
//    val fromJson = gson.fromJson(fileContent, MotionInfo::class.java)
//    println(fromJson.phonemeInfo)
//    /*创建moshi*/
//    val moshi = Moshi.Builder()
//        .addLast(KotlinJsonAdapterFactory())//使用kotlin反射处理，要加上这个
//        .build()
//    /*声明adapter，指定要处理的类型*/
//    val jsonAdapter = moshi.adapter(MotionInfo::class.java)
////    val jsonStr = """
////        {"name":null,"age":18}
////    """.trimIndent()
//    val user = jsonAdapter.fromJson(fileContent)
//}
//
//fun testmoshi(){
//    /*创建moshi*/
//    val moshi = Moshi.Builder()
//        .addLast(KotlinJsonAdapterFactory())//使用kotlin反射处理，要加上这个
//        .build()
//    /*声明adapter，指定要处理的类型*/
//    val jsonAdapter = moshi.adapter(MotionInfo::class.java)
//    val jsonStr = """
//        {"name":null,"age":18}
//    """.trimIndent()
//    val user = jsonAdapter.fromJson(jsonStr)
//
//}
//data class MotionInfo(
//    var index: Int = 0,//动作索引
//    var text: String="",//文本内容
//    var emotion: String = "中性",//情绪
//    var emotionLevel: Int = 5,// 情绪等级
//    var motion: String = "通用",//身体动作
//    var phonemeInfo:String//音素
//)
