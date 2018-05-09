package com.example.dialogkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAlrt.setOnClickListener {
            sd("Alert")
        }
        btnDtp.setOnClickListener {
            sd("DatePickerDialog")
        }
        btnTmp.setOnClickListener {
            sd("TimePickerDialog")
        }
        btnCstmDlg.setOnClickListener {
            sd("CustomDialog")
        }
        btnCrtDt.setOnClickListener {
            sd("CurrentDateDialog")
        }
        btnCrtTm.setOnClickListener {
            sd("CurrentTimeDialog")
        }
    }
    fun sd(tag : String) = BlankFragment().show(supportFragmentManager,tag)
}
