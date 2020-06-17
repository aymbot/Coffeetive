package com.example.coffeetive

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.coffeetive.databinding.StatisticsFragmentBinding
import kotlinx.android.synthetic.main.activity_main.*

/**
 * A simple [Fragment] subclass.
 */
class StatisticsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: StatisticsFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.statistics_fragment, container, false)
        return binding.root
    }

}
