package com.example.coffeetive.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CoffeeDAO {
    @Insert
    fun insert(coffee: Coffee)

    @Update
    fun update(coffee: Coffee)

    @Query("SELECT * from coffee_table WHERE coffeeid = :key")
    fun get(key: Long): Coffee?

    @Query("DELETE FROM coffee_table")
    fun clear()

    @Query("SELECT * FROM coffee_table ORDER BY coffeeid DESC")
    fun getAllCoffee(): LiveData<List<Coffee>>

    @Query("SELECT * FROM coffee_table ORDER BY coffeeid DESC")
    fun getCoffeeArray(): Array<Coffee>
}