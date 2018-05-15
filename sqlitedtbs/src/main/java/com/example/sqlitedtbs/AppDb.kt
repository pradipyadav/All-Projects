package com.example.sqlitedtbs

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(version = 1,entities = [(Car::class)])
abstract class AppDb : RoomDatabase() {
    abstract fun carDao():CarDao
}