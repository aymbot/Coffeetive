package com.example.coffeetive

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.example.coffeetive.databinding.CoffeeRegistrationFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
class CoffeeRegistrationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: CoffeeRegistrationFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.coffee_registration_fragment, container, false)
        return binding.root
    }

}
