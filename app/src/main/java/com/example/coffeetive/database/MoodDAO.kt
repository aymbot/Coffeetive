package com.example.coffeetive.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface MoodDAO {
    @Insert
    fun insert(mood: Mood)

    /*@Update
    fun update(mood: Mood)*/

    @Query("SELECT * from mood_table WHERE moodid = :key")
    fun get(key: Long): Mood?

    @Query("DELETE FROM mood_table")
    fun clear()

    @Query("SELECT * FROM mood_table ORDER BY moodid DESC")
    fun getMoodArray(): Array<Mood>

    @Query("SELECT * FROM mood_table ORDER BY moodid DESC")
    fun getAllMood(): LiveData<List<Mood>>

}