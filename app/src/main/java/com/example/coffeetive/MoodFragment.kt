package com.example.coffeetive

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.coffeetive.database.CoffeetiveDatabase

import com.example.coffeetive.databinding.MoodFragmentBinding
import com.example.coffeetive.viewModelFactory.MoodViewModel
import com.example.coffeetive.viewModelFactory.MoodViewModelFactory
import kotlinx.android.synthetic.main.mood_fragment.*


class MoodFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: MoodFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.mood_fragment, container, false)
        val application = requireNotNull(this.activity).application
        val mooddataSource = CoffeetiveDatabase.getInstance(application).moodDAO
        val viewModelFactory = MoodViewModelFactory(mooddataSource, application)
        val moodViewModel = ViewModelProvider(this, viewModelFactory).get(MoodViewModel::class.java)
        binding.moodViewModel = moodViewModel
        binding.lifecycleOwner = this

        Log.i("test", "Mood")
        binding.moodBad.setOnClickListener{
            Log.i("test", "You clicked mood_bad")
            moodViewModel.insertMood(1)
        }
        binding.moodOk.setOnClickListener {
            Log.i("test", "You clicked mood_ok")
            moodViewModel.insertMood(2)
            //Toast.makeText(this@MoodFragment, "You clicked on mood_ok.", Toast.LENGTH_SHORT).show()
        }
        binding.moodGreat.setOnClickListener {
            Log.i("test", "You clicked mood_great")
            moodViewModel.insertMood(3)
            //Toast.makeText(this@MoodFragment, "You clicked on mood_ok.", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

}