package com.example.kotlinlib.project.net

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * 访问服务器的API接口(WanAndroidAPI) 的 客户端管理
 */
class APIClient {

    //单例的意思
    private object Holder {

        val INSTANCE = APIClient()

    }

    // 派生 （相当于java的静态）
    companion object {

        val instance = Holder.INSTANCE

    }

    // WanAndroidAPI实例化这个，  XXXAPI实例化这个，   BBBAPI实例化
    fun <T> instanceRetrofit(apiInterface: Class<T>) : T {

        // 之前的代码
        /*val mOkHttpClient: OkHttpClient = OkHttpClient().newBuilder()

            // 添加读取超时时间
            .readTimeout(10000, TimeUnit.SECONDS)

            // 添加连接超时时间
            .connectTimeout(10000, TimeUnit.SECONDS)

            // 添加写出超时时间
            .writeTimeout(10000, TimeUnit.SECONDS)

            .build()*/

        // OKHttpClient请求服务器  okhttp  todo 2024.8.24 不理解这里优化的意义哈哈
        val mOkHttpClient = OkHttpClient().newBuilder().myApply {

            // 添加读取超时时间
            readTimeout(10000, TimeUnit.SECONDS)

            // 添加连接超时时间
            connectTimeout(10000, TimeUnit.SECONDS)

            // 添加写出超时时间
            writeTimeout(10000, TimeUnit.SECONDS)

        }.build()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://www.wanandroid.com")

        // 请求方  ←
            //将okhttp  丢给retrofit
            .client(mOkHttpClient)

        // 响应方  →
            // Response的事情  回来
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // RxJava来处理
            .addConverterFactory(GsonConverterFactory.create()) // Gson 来解析 --- JavaBean
            .build()

        // TODO: 这里看不太懂
        return retrofit.create(apiInterface);
    }
}

// 默认 无参数的
fun <T> T.myApply(mm: T.() -> Unit) : T {
    // T == this
    mm()
    return this
}