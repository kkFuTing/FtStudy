import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.*

object A {
    private val initDeferred = CompletableDeferred<Unit>()

    fun initialize() {
        CoroutineScope(Dispatchers.IO).launch {
            println("A initializing...")
            delay(2000) // 模拟耗时操作
            println("A initialized")
            initDeferred.complete(Unit) // 初始化完成
        }
    }

    suspend fun waitForInitialization() {
        initDeferred.await() // 等待初始化完成
    }
}
