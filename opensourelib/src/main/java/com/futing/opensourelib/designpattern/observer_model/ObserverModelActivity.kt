package com.futing.opensourelib.designpattern.observer_model

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.futing.opensourelib.R

class ObserverModelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_observer_model)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        test()

    }

    private fun test() {

        val server = WechatServerObservable()
        val futing = UserPerson("付婷")
        val ft2 = UserPerson("付婷1")
        val ft3 = UserPerson("付婷3")
        val ft4 = UserPerson("付婷4")

        server.addObServer(futing)
        server.addObServer(ft2)
        server.addObServer(ft3)
        server.addObServer(ft4)

        var mes: String = "重大消息"

        server.pushMessage(mes)
    }
}