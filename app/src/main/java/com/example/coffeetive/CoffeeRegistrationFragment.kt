package com.example.coffeetive

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.coffeetive.databinding.FragmentCoffeeRegistrationBinding

/**
 * A simple [Fragment] subclass.
 */
class CoffeeRegistrationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentCoffeeRegistrationBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_coffee_registration, container, false)

        binding.cofregBtnCancel.setOnClickListener { v: View ->
            v.findNavController().navigate(R.id.action_coffeeRegistrationFragment_to_homeFragment)
        }
        binding.cofregBtnSubmit.setOnClickListener { v: View ->
            v.findNavController().navigate(R.id.action_coffeeRegistrationFragment_to_homeFragment)
        }

        return binding.root
    }

}
