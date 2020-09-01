package com.example.coffeetive.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Coffee::class, Mood::class], version = 2, exportSchema = false)
abstract class CoffeetiveDatabase : RoomDatabase() {
    abstract val coffeeDAO: CoffeeDAO
    abstract val moodDAO: MoodDAO

    companion object {
        @Volatile
        private var INSTANCE: CoffeetiveDatabase? = null

        fun getInstance(context: Context): CoffeetiveDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CoffeetiveDatabase::class.java,
                        "coffeetive_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}