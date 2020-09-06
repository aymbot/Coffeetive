package com.example.coffeetive.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "mood_table")
data class Mood (
    @ColumnInfo(name = "mood")
    var mood: Int = -1,

    @ColumnInfo(name = "time")
    val time: Long = System.currentTimeMillis()
) {
    @PrimaryKey(autoGenerate = true)
    var moodid: Long = 0L
}