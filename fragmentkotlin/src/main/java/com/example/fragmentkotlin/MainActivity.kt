package com.example.fragmentkotlin

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFrag(SimpleFragment.create(Color.CYAN))
    }
    fun loadFrag(fragment: Fragment) {

        val tag = "${fragment::class.java.canonicalName}-${Math.random() * 255}"
        Log.i("@codekul", "backStack tag is $tag")
        val isPopped = supportFragmentManager.popBackStackImmediate(tag, 0)

        if (!isPopped) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frameLayout, fragment)
                    .addToBackStack(tag)
                    .commit()
        }
    }

    override fun onBackPressed() {

        Log.i("@codekul", "length of backstack is ${supportFragmentManager.backStackEntryCount}")

        if (supportFragmentManager.backStackEntryCount==1){
            finish()
        }
        else {
            super.onBackPressed()
        }
    }
}
