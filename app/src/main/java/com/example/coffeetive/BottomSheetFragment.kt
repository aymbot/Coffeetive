package com.example.coffeetive


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.coffeetive.database.Coffee
import com.example.coffeetive.database.CoffeetiveDatabase
import com.example.coffeetive.databinding.BottomSheetFragmentBinding
import com.example.coffeetive.viewModelFactory.CoffeeViewModel
import com.example.coffeetive.viewModelFactory.CoffeeViewModelFactory
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class BottomSheetFragment : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: BottomSheetFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.bottom_sheet_fragment, container, false)

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


        binding.button3.setOnClickListener {
            coffeeViewModel.createCoffee(Coffee(3))
        }
        // binding.button4.setOnClickListener(){
        //     Log.i("test", "Button3")
        // }
        return binding.root
    }

}