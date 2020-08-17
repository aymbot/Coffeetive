package com.example.coffeetive.database


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "coffee_table")
class Coffee (
    @ColumnInfo(name = "coffeesize")
    var coffeesize: Int = -1/*,

    @ColumnInfo(name = "time")
    val time: Long = System.currentTimeMillis()*/
){
    @PrimaryKey(autoGenerate = true)
    var coffeeid: Long = 0L
}