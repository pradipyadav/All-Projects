package com.example.lifecycle

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

   //     textView.text = savedInstanceState?.getString("dtTm")

        btnok.setOnClickListener{
            textView.text=System.currentTimeMillis().toString()
        }

        mt(msg="onCreate")
    }
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putString("dtTm",textView.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        textView.text = savedInstanceState?.getString("dtTm")
    }

    override fun onStart() {
        mt(msg="onStart")
        super.onStart()
    }

    override fun onResume() {
        mt(msg="onResume")
        super.onResume()
    }

    override fun onPause() {
        mt(msg="onPause")
        super.onPause()
    }

    override fun onStop() {
        mt(msg="onStop")
        super.onStop()
    }

    override fun onRestart() {
        mt(msg="onRestart")
        super.onRestart()
    }

    override fun onDestroy() {
        mt(msg="onDestroy")

        super.onDestroy()
    }
    private fun mt(msg:String)=Toast
            .makeText(this@MainActivity,msg,Toast.LENGTH_SHORT)
            .show()
}
