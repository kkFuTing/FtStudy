package com.example.kotlinlib.objectcase

/**
 * Created by futing on 2024/8/1.
 */


interface OnClickListener{
    fun onclick()

}

class Button {
    fun setonClickListener(listener: OnClickListener){
        //设置监听事件

    }
}

// TODO: 奴可以直接跑吗？
// TODO: 不知道直接写一个 fun main 是什么意思
fun  main(){
    val button = Button()
    button.setonClickListener(object:OnClickListener{
        override fun onclick() {
            println("button click")
            TODO("Not yet implemented")
        }
    })
}