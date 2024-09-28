package com.futing.uiapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.futing.uiapplication.flowlayout.MainActivity
import com.futing.uiapplication.srl_vp.SRL_VP_main

class MyMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_my_main2)


    }

    fun onClick(v: View?) {
        when (v?.id) {
            R.id.id1 -> startActivity(Intent(this, MainActivity::class.java))
            R.id.id2 -> startActivity(
                Intent(
                    this,
                    com.futing.uiapplication.viewpagerheightwrap.MainActivity::class.java
                )
            )

            R.id.id3 -> startActivity(
                Intent(
                    this,
                    com.futing.uiapplication.clickevent.MainActivity::class.java
                )
            )

            R.id.id4 -> startActivity(
                Intent(
                    this,
                    com.futing.uiapplication.leo_dispatch.MainActivity::class.java
                )
            )

            R.id.id5 -> startActivity(
                Intent(
                    this,
                    SRL_VP_main::class.java
                )
            )

            R.id.id6 -> startActivity(
                Intent(
                    this,
                    com.futing.uiapplication.textdraw.MainActivity::class.java
                )
            )

            R.id.id7 -> startActivity(
                Intent(
                    this,
                    com.futing.uiapplication.fish.MainActivity::class.java
                )
            )

            R.id.id8 -> startActivity(
                Intent(
                    this,
                    com.futing.uiapplication.leo_recyclerview.MainActivity::class.java
                )
            )
            R.id.id9 -> startActivity(
                Intent(
                    this,
                    com.futing.uiapplication.leo_recycler.MainActivity::class.java
                )
            )
            R.id.id10-> startActivity(
                Intent(
                    this,
                    com.futing.uiapplication.leo_slidecard.MainActivity::class.java
                )
            )
            R.id.id11-> startActivity(
                Intent(
                    this,
                    com.futing.uiapplication.photoview.MainActivity::class.java
                )
            )

        }
    }
}