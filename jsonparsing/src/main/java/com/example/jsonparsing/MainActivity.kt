package com.example.jsonparsing

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        usingJSON()

        usingGson()
    }

    private fun usingGson(){

        val gson=Gson()
        var mainObj = gson.fromJson(makeJSON(),MainObj::class.java)
        Log.i("@Pradip","Name is ${mainObj.nm}")
        Log.i("@Pradip","Os is ${mainObj.os}")

        mainObj.list.forEach{
            Log.i("@Pradip","inventor - ${it.inv}")
        }

    }

    private fun usingJSON(){

        val rtObj = JSONObject(makeJSON())
        Log.i("@Pradip",makeJSON())
        Log.i("@Pradip","Os - ${rtObj.get("os")}")
        val inObj = rtObj.getJSONObject("obj")
        val invr = inObj.getString("inv")
        Log.i("@Pradip","Inventor - ${invr}")
        val list = rtObj.getJSONArray("list")
        for (i in 0 until (list.length() -1 )){
            Log.i("@Pradip",(list.get(i)as JSONObject).getString("age"))
        }
    }

    private fun makeJSON() : String{

        return assets.open("my.json").bufferedReader().use {
            it.readText()
        }
    }

}
