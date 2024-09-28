package com.futing.memorylib

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_main_memory)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        matTest()
//
//        Thread(){
//            kotlin.run {
//                Thread.sleep(1000*30)
//            }
//        val result = Utils.createDumpFile(this)

//        }.start()

    }

    private fun matTest() {
        TODO("Not yet implemented")

    }


    fun dumpClick(view: View) {
        incomingVsoutgoing()
        val result = Utils.createDumpFile(this)
        Utils.show(this, result)
    }

    private fun incomingVsoutgoing() {
        val a = A()
        val b = B()
    }
}