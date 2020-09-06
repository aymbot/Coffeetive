package com.example.coffeetive

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.coffeetive.viewModelFactory.CoffeeViewModel
import com.example.coffeetive.viewModelFactory.CoffeeViewModelFactory
import com.example.coffeetive.database.CoffeetiveDatabase
import com.example.coffeetive.databinding.HomeFragmentBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.bottom_sheet_fragment.*
import kotlinx.android.synthetic.main.home_fragment.*


class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: HomeFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)
        setHasOptionsMenu(true)

        val application = requireNotNull(this.activity).application
        val coffeedataSource = CoffeetiveDatabase.getInstance(application).coffeeDAO
        val mooddataSource = CoffeetiveDatabase.getInstance(application).moodDAO
        val viewModelFactory = CoffeeViewModelFactory(coffeedataSource, application)
        val coffeeViewModel = ViewModelProvider(this, viewModelFactory).get(CoffeeViewModel::class.java)
        binding.coffeeViewModel = coffeeViewModel
        binding.lifecycleOwner = this //Enable binding to observe liveData updates


        return binding.root
    }

    /*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)*/

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

        val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetFragment)
        val bottomfragment = BottomSheetFragment()

        /*floatingActionButton.setOnClickListener {
            if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_COLLAPSED) {

                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            } else {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            }
        }*/
        floatingActionButton.setOnClickListener {
            if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_COLLAPSED) {

                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            } else {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            }
        }

        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {

            override fun onStateChanged(view: View, state: Int) {

            }
            override fun onSlide(view: View, p1: Float) {
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,
            requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }



}

