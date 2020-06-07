package com.example.coffeetive

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.coffeetive.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        binding.homeBtnCoffeeReg.setOnClickListener(){v: View ->
            v.findNavController().navigate(R.id.action_homeFragment_to_coffeeRegistrationFragment)
        }
        binding.homeBtnStatistics.setOnClickListener(){v: View ->
            v.findNavController().navigate(R.id.action_homeFragment_to_statisticsFragment)
        }

        return binding.root
    }

}
