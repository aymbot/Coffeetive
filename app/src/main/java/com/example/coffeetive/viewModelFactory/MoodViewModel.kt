package com.example.coffeetive.viewModelFactory

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.room.Ignore
import com.example.coffeetive.database.Mood
import com.example.coffeetive.database.MoodDAO
import kotlinx.coroutines.*

class MoodViewModel (val database: MoodDAO,
                     application: Application) : AndroidViewModel(application) {
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    init {
        Log.i("test", "Mood Constructor")
    }

    private suspend fun insert(mood: Mood){
            withContext(Dispatchers.IO) {
                database.insert(mood)
            }
    }

    fun insertMood(mood: Int){
        Log.i("test", "Mood inserted into Database")
        uiScope.launch {
            insert(Mood(mood))
        }
    }

    fun convertNumericMoodtoString(mood: Int) : String{
        var moodString = "--No Mood Recorded"
        when (mood){
            1 -> moodString = "Bad"
            2 -> moodString = "OK"
            3 -> moodString = "Great"
        }
        return moodString
    }
}