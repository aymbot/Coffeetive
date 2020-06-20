package com.example.coffeetive

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.example.coffeetive.databinding.MoodFragmentBinding


class MoodFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: MoodFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.mood_fragment, container, false)
        return binding.root
    }
}