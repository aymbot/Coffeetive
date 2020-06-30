package com.example.coffeetive.viewModelFactory

import android.app.Application
import android.os.Build
import android.text.Html
import android.text.Spanned
import android.util.Log
import androidx.core.text.HtmlCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Transformations
import com.example.coffeetive.database.Coffee
import com.example.coffeetive.database.CoffeeDAO
import kotlinx.coroutines.*

class CoffeeViewModel(val database: CoffeeDAO,
                      application: Application
) : AndroidViewModel(application) {
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    private val coffees = database.getAllCoffee()
    val coffeeString = Transformations.map(coffees){coffees ->
        formatCoffee(coffees)
    }

    fun createCoffee(coffe: Coffee) {
        uiScope.launch {
            val coffe = coffe
            withContext(Dispatchers.IO){
                val result = database.insert(coffe)
                Log.i("CoffeeViewmodel", result.toString())
            }
        }
    }

    // this function deletes all users inside the user_table
    fun deleteAllUsers(){
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
                append(it.coffeesize.toString() + "<br>")
                append("Time: ")
                /*append(it.time.toString() + "<br><br>")*/
            }
        }

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
        }else{
            return HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
        }
    }
}