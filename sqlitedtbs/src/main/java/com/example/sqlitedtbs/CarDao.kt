package com.example.sqlitedtbs

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface CarDao {
    @Insert
fun insert(car: Car)

    @Query("select * from car")
fun cars():List<Car>
}