package com.example.fragmentkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFrag(Laptop())
    }
    fun loadFrag(fragment: Fragment)=supportFragmentManager
            .beginTransaction()
            .add(R.id.frameLayout, fragment)
            .commit()

}
