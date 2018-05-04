package com.example.broadcastrcvrkotlin

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class SimpleRcvr : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        Log.i("Codekul","Welcome")
    }
}