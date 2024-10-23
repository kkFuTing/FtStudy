import kotlinx.coroutines.*

object B {
    suspend fun runTasks() {
       runBlocking {
           val task1 = async {
               println("B task1 started")
               delay(1000) // 模拟任务1耗时
               println("B task 1 completed")
           }

           val task2 = async {
               println("B task2 started")
               delay(1500) // 模拟任务2耗时
               println("B task 2 completed")
           }

           // 在任务三中确保 A 已初始化
           val task3 = async {
               // 等待 A 初始化完成
               println("B task3 started")
               A.waitForInitialization() // 确保 A 已初始化


               println("B task 3 started")
           }

           // 等待所有任务完成
           task1.await()
           task2.await()
           task3.await()

           println("All tasks in B completed.")
       }
    }
}
