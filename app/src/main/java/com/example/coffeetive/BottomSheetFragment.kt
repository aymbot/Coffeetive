package com.example.coffeetive


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.coffeetive.database.CoffeetiveDatabase
import com.example.coffeetive.databinding.BottomSheetFragmentBinding
import com.example.coffeetive.viewModelFactory.CoffeeViewModel
import com.example.coffeetive.viewModelFactory.CoffeeViewModelFactory
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class BottomSheetFragment : BottomSheetDialogFragment() {

    companion object{
        const val TAG = "ModalBottomSheet"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: BottomSheetFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.bottom_sheet_fragment, container, false)
        Log.i("test", "bottomsheet fragment")
/*
        val coffeedataSource = CoffeetiveDatabase.getInstance(application).coffeeDAO
        //val mooddataSource = CoffeetiveDatabase.getInstance(application).moodDAO
        val viewModelFactory = CoffeeViewModelFactory(coffeedataSource, application)
        val coffeeViewModel = ViewModelProvider(this, viewModelFactory).get(CoffeeViewModel::class.java)
        binding.coffeeViewModel = coffeeViewModel
        binding.lifecycleOwner = this //Enable binding to observe liveData updates
        */
        val application = requireNotNull(this.activity).application
        val coffeedataSource = CoffeetiveDatabase.getInstance(application).coffeeDAO
        val viewModelFactory = CoffeeViewModelFactory(coffeedataSource, application)
        val coffeeViewModel = ViewModelProviders.of(this, viewModelFactory).get(CoffeeViewModel::class.java)
        binding.coffeeViewModel = coffeeViewModel
        binding.setLifecycleOwner (this)

        //methode createCoffee funktioniert in CoffeeViewModel init Proc
        //Vermutung: Variable coffeeViewMdoel wird nicht initialisiert
        //da setOnClickListener auch nicht funktioniert, wird das gesamte Fragment
        //vielleicht nicht inflated oder so
        //coffeeViewModel.createCoffee(Coffee(3))

        binding.buttonCoffeeL.setOnClickListener {
            Log.i("test", "button 3")
            coffeeViewModel.createCoffee(3)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("test", "onCreate BottomSheet")
    }

    override fun onStart() {
        super.onStart()
        Log.i("test", "onStart BottomSheet")
    }

    override fun onResume() {
        super.onResume()
        Log.i("test", "onResume BottomSheet")
    }

    override fun onStop() {
        super.onStop()
        Log.i("test", "onStop BottomSheet")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("test", "onDestroy BottomSheet")
    }

}