package com.example.googlekeep

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.googlekeep.R.id.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.btnSave
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSave.setOnClickListener {  }

//        btnSave.setOnClickListener {
//            var title = edtTitle.text.toString()
//            var note = edtNote.text.toString()
//            save(title,note)
//            Log.i("@Codekul","data send filename = $title \n data = $note")
//            retrive(title)
//        }

//        btnSv.setOnClickListener {
//
//            var title=edtTitle.text.toString()
//            var note=edtNote.text.toString()
//
//            save(title,note)
//            Log.i("@Codekul","filename = $title \n data = $note")
//            retrive(note)
//        }

        btnShw.setOnClickListener {
            filesDir.list().forEach {
                Log.i("@codekul","$it")
            }
        }

        btnCk.setOnClickListener {
            delete("pradip")
        }
    }

    fun save(titlename:String,notename:String){

        openFileOutput("$titlename.txt", Context.MODE_PRIVATE).use {
            it.write(notename.toByteArray())
        }
    }

    fun retrive(titlename: String){
        val isp=openFileInput("$titlename.txt")
        val dt=isp.bufferedReader().use {
            it.readLine()
        }
        Log.i("@codekul","data save in $titlename.txt is $dt")
    }

    fun edit(titlename:String,notename:String) {
        val isp = openFileInput("$titlename.txt")
        val dt = isp.bufferedReader().use {
            it.readLine()
        }
        openFileOutput("$titlename.txt", Context.MODE_PRIVATE).use {
            it.write(notename.toByteArray())
        }
    }

    fun delete(notename: String){
        var file = File("$filesDir/$notename.txt")
        file.delete()
    }
}
