package com.example.internalstorage

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("@codekul","Internal Storage $filesDir")
        Log.i("@codekul","Cache Storage $cacheDir")

        filesDir.list().forEach {
            Log.i("@codekul","File is $it")
        }
        filesDir.parentFile.list().forEach {
            Log.i("@codekul","File is $it")
        }

        store()

        retrive()
    }

    private fun store(){

        openFileOutput("my.txt", Context.MODE_PRIVATE).use {
            it.write("Welcome Kotlin".toByteArray())
        }
    }

    private fun retrive(){

        val isp=openFileInput("my.txt")
        val dt=isp.bufferedReader().use {
            it.readLine()
        }

        Log.i("@codecul","Data is $dt")
    }
}
