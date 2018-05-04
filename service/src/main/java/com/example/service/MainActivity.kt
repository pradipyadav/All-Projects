package com.example.service

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.time.Instant

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent=Intent (this@MainActivity,MyService::class.java)

        btnply.setOnClickListener {
            startService(intent)
        }
        btnPse.setOnClickListener{
            stopService(intent)
        }
    }
}
