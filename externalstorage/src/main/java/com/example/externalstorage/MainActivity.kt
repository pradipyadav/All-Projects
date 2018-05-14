package com.example.externalstorage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Toast
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        writeToPublic()
        readPublic()

        Log.i("Codekul", "External storage path ${getExternalFilesDir("Codekul")}")
        Log.i("Codekul", "External public storage ${Environment.getExternalStoragePublicDirectory("codekul")}")
    }

    fun writeToPublic() {

        Log.i("codekul", (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED).toString())

        if (Environment.getExternalStorageState() === Environment.MEDIA_MOUNTED) {

            val fl = File(
                    Environment.getExternalStoragePublicDirectory("codekul"),
                    "my.txt")

            FileOutputStream(fl).use {
                it.write("welcome codekul.com ".toByteArray())
            }

        } else {
            Toast.makeText(this@MainActivity, "storage not fund", Toast.LENGTH_SHORT)
        }
    }

    fun readPublic() {
        if (Environment.getExternalStorageState() === Environment.MEDIA_MOUNTED) {

            val fl = File(
                    Environment.getExternalStoragePublicDirectory("codekul"),
                    "my.txt")

            val dt = FileInputStream(fl).bufferedReader().use {
                it.readLine()
            }
            Log.i("@codekul", "data written is $dt")
        } else {
            Toast.makeText(this@MainActivity, "storage not fund", Toast.LENGTH_SHORT)
        }
    }
}

