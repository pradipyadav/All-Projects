package com.example.sqlitedtbs

import android.app.Application
import android.arch.persistence.room.Room

class DbApp : Application()
{
    val dbApp:AppDb by lazy {
        Room.databaseBuilder(this@DbApp,
                AppDb::class.java,"carDb").build()
    }
    override fun onCreate() {
        super.onCreate()

        dbApp
    }
}