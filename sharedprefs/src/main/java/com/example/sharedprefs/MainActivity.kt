package com.example.sharedprefs

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prefs = getSharedPreferences(
                "myprefs",
                Context.MODE_PRIVATE
        )

        store(prefs)
        retrieve(prefs)
    }

    private fun store(prefs : SharedPreferences) {
        val editor = prefs.edit()
        editor.putInt("keyInt", 56)
        editor.putString("keyStr", "Android")
        editor.apply()
    }

    private fun retrieve(prefs : SharedPreferences) {

        val int = prefs.getInt("keyInt",12 )
        val str = prefs.getString("keyStr", "Kotlin")
        Log.i("@codekul", "String is $str and Int is $int")
    }
}