package com.example.coffeetive

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.coffeetive.databinding.AboutFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: AboutFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.about_fragment, container, false)
        return binding.root
    }
}
