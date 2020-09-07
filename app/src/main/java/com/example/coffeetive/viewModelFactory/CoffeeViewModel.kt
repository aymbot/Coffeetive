package com.example.coffeetive.viewModelFactory

import android.app.Application
import android.os.Build
import android.text.Html
import android.text.Spanned
import android.util.Log
import androidx.core.text.HtmlCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.coffeetive.database.Coffee
import com.example.coffeetive.database.CoffeeDAO
import kotlinx.coroutines.*
import java.text.SimpleDateFormat

class CoffeeViewModel(val database: CoffeeDAO,
                      application: Application
) : AndroidViewModel(application) {
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    private var coffee = MutableLiveData<Coffee?>()
    private val coffees = database.getAllCoffee()
    private var allcoffeearray =  ArrayList<Coffee>()

    init {
        //deleteAllData()
        Log.i("test", "initDATABASEProc")
        initializeCoffee()
    }

    suspend fun getCoffeeArray(): Array<Coffee> {
        return withContext(Dispatchers.IO) {
            var allmood = database.getCoffeeArray()

            allmood
        }
    }

    fun getAllCoffee(): ArrayList<Coffee> {
        uiScope.launch {
            val abc = getCoffeeArray()
            abc.forEach { System.out.print(it) }
            allcoffeearray = abc.toCollection(ArrayList())
        }
        allcoffeearray.add(Coffee(60))
        allcoffeearray.add(Coffee(70))
        allcoffeearray.add(Coffee(80))
        return allcoffeearray
    }

    private fun initializeCoffee(){
        uiScope.launch {
            getCoffeeFromDatabase()
        }
    }

    suspend fun getCoffeeFromDatabase(): LiveData<List<Coffee>> {
        return withContext(Dispatchers.IO){
            var coffee = database.getAllCoffee()

            coffee
        }
    }

    private suspend fun insert (coffee: Coffee){
        withContext(Dispatchers.IO){
            database.insert(coffee)
        }
    }

    val coffeeString = Transformations.map(coffees){coffees ->
        formatCoffee(coffees)
    }

    fun createCoffee(coffe: Int) {
        uiScope.launch {
            Log.i("test", "Function: Create coffee")
            insert(Coffee(coffe))
        }
    }
    /*
    suspend fun getCoffeeArray(): ArrayList<Coffee>{
        uiScope.launch {
                return withContext(Dispatchers.IO) {
                    var coffeearr database.getCoffeeArray()
                    coffeearr
                }
        }
    }*/

    fun onSetConsumedCoffee(coffeesize: Int){
        Log.i("test","hier")
        uiScope.launch {
            withContext(Dispatchers.IO){
                val coffee = Coffee(coffeesize)
                insert(coffee)
            }
        }
    }

    private var _showSnackbarEvent = MutableLiveData<Boolean>()
    val showSnackBarEvent: LiveData<Boolean>
        get() = _showSnackbarEvent
    fun doneShowingSnackbar() {
        _showSnackbarEvent.value = false
    }

    // this function deletes all users inside the user_table
    fun deleteAllData(){
        uiScope.launch {
            withContext(Dispatchers.IO){
                database.clear()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel() //cancel all coroutines onCleared()
    }

    fun convertNumericCoffeSizetoString(coffesize: Int) : String{
        var coffeeSizeString = "--No Size Recorded"
        when (coffesize){
            1 -> coffeeSizeString = "Small"
            2 -> coffeeSizeString = "Medium"
            3 -> coffeeSizeString = "Large"
        }
        return coffeeSizeString
    }

    /*
      This function formats a list of users to HTML
      so it can be rendered easily inside TextView
    */
    private fun formatCoffee(coffees: List<Coffee>) : Spanned {
        val sb = StringBuilder()

        sb.apply {
            append("Coffee List: <br>")
            coffees.forEach{
                append("Coffeesize: ")
                append(convertNumericCoffeSizetoString(it.coffeesize) + "<br>")
                append("Date: ")
                append(
                    SimpleDateFormat("EEEE MMM-dd-yyyy' Time: 'HH:mm")
                        .format(it.time).toString() + "<br><br>")
            }
        }

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
        }else{
            return HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
        }
    }
}