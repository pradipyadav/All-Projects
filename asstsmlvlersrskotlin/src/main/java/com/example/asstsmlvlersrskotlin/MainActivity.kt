package com.example.asstsmlvlersrskotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wdth=resources.getDimension(R.dimen.btnWdth)
        val stng=resources.getString(R.string.btnGo)
        val color=resources.getColor(R.color.btncol)
    }
}
