package com.enjoy.okhttp4

import okhttp3.*
import okhttp3.internal.okHttpName
import okhttp3.internal.threadFactory
import okhttp3.internal.wait
import org.junit.Test

import org.junit.Assert.*
import java.io.File
import java.net.InetAddress
import java.net.InetSocketAddress
import java.net.Proxy
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.SynchronousQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import kotlin.synchronized as synchronized

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
        // httplogginerinterceptor
        var okHttpClient = OkHttpClient.Builder()
            .connectionPool(ConnectionPool())
//            .cookieJar(CookieJar.NO_COOKIES)
//            .proxy()
//            .proxyAuthenticator(object: Authenticator{
//                override fun authenticate(route: Route?, response: Response): Request? {
//                    return response.request.newBuilder().addHeader("Proxy-Authorization","xxxx").build()
//                }
//
//            })
//            .authenticator()
//            .proxy()
//            .addInterceptor(object : Interceptor {
//                override fun intercept(chain: Interceptor.Chain): Response {
//                    chain.request()
//                }
//
//            })
//            .addNetworkInterceptor {
//
//
//            }
//            .cache(Cache(File("/xxx"),111))
            .build()
        //A: username pwd, sign=md5(username+pwd)
        var request = Request.Builder().url("https://www.baidu.com")
            .cacheControl(CacheControl.FORCE_CACHE)
            .build()
        var call = okHttpClient.newCall(request)
        val result = call.execute()
        println(result.isSuccessful)
        result.close()
    }

    @Test
    fun name() {
        var executorServiceOrNull = ThreadPoolExecutor(0, Int.MAX_VALUE, 60, TimeUnit.SECONDS,
            SynchronousQueue(), threadFactory("$okHttpName Dispatcher", false)
        )
//        executorServiceOrNull.execute {
//            println(1)
//            Thread.sleep(10_000)
//            println("1 执行完成")
//
//        }
//        executorServiceOrNull.execute {
//            println(2)
//        }
//        executorServiceOrNull.execute {
//            println(3)
//        }
        while (true){}
    }
}