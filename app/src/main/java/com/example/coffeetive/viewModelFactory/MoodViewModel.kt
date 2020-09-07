package com.example.coffeetive.viewModelFactory

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Ignore
import com.example.coffeetive.database.Coffee
import com.example.coffeetive.database.Mood
import com.example.coffeetive.database.MoodDAO
import kotlinx.coroutines.*

class MoodViewModel(
    val database: MoodDAO,
    application: Application
) : AndroidViewModel(application) {
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    private val moods = database.getAllMood()
    private val allmoodarray =  ArrayList<Mood>()

    init {
        Log.i("test", "Mood Constructor")
        initializeMood()
    }

    suspend fun getMoodArray(): Array<Mood> {
        return withContext(Dispatchers.IO) {
            var allmood = database.getMoodArray()

            allmood
        }
    }

    fun getAllMood(): ArrayList<Mood> {
        uiScope.launch {
            val abc = getMoodArray()
            abc.forEach { allmoodarray.add(it) }
        }
        //Thread.sleep(2000L)
        allmoodarray.add(Mood(3))
        allmoodarray.add(Mood(2))
        allmoodarray.add(Mood(1))
        return allmoodarray
    }

    private fun initializeMood() {
        uiScope.launch {
            getMoodFromDatabase()
        }
    }

    private suspend fun insert(mood: Mood) {
        withContext(Dispatchers.IO) {
            database.insert(mood)
        }
    }

    fun insertMood(mood: Int) {
        Log.i("test", "Mood inserted into Database")
        uiScope.launch {
            insert(Mood(mood))
        }
    }

    fun convertNumericMoodtoString(mood: Int): String {
        var moodString = "--No Mood Recorded"
        when (mood) {
            1 -> moodString = "Bad"
            2 -> moodString = "OK"
            3 -> moodString = "Great"
        }
        return moodString
    }

    suspend fun getMoodFromDatabase(): LiveData<List<Mood>> {
        return withContext(Dispatchers.IO) {
            var mood = database.getAllMood()

            mood
        }
    }
}