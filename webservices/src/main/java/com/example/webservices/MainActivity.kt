package com.example.webservices

import android.app.DownloadManager
import android.app.ProgressDialog
import android.app.VoiceInteractor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.service.voice.VoiceInteractionSession
import android.util.Log
import android.widget.ArrayAdapter
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        makeJsonArrayRequest()
    }

    fun makeJsonArrayRequest() {
        val arr = arrayListOf<String>()
        val pd = ProgressDialog.show(this@MainActivity, "Jobs", "Here are jobs of your requirement")

        (application as WebApp).q.add(object : JsonArrayRequest(
                Request.Method.GET,
                "https://api.dataatwork.org/v1/jobs",
                null,
                {
                    Log.i("@codekul", it.toString())
                    for (i in 0 until (it.length() - 2)) {
                        arr.add((it.get(i) as JSONObject).getString("title"))
                    }
                    listView.adapter = ArrayAdapter<String>(
                            this@MainActivity,
                            android.R.layout.simple_list_item_1,
                            arr
                    )
                    pd.dismiss()
                },
                {
                    Log.i("@codekul", "Error Occurred ${it.message}")
                    pd.dismiss()
                }
        ) {})
    }

    fun makeStringRequest() {

        (application as WebApp).q.add(object : StringRequest(
                "https://restcountries.eu/rest/v2/capital/tallinn",
                {
                    val jobs = (application as WebApp).gson.fromJson(
                            it, JobsNew::class.java
                    )
                },
                {}
        ) {
            override fun getHeaders(): MutableMap<String, String> {
                return super.getHeaders()
            }
        })
    }
}
