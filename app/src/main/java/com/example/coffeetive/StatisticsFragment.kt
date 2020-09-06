package com.example.coffeetive

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.coffeetive.databinding.StatisticsFragmentBinding
import com.github.mikephil.charting.data.Entry
import kotlinx.android.synthetic.main.activity_main.*

class StatisticsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: StatisticsFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.statistics_fragment, container, false)


        val revenueComp1 = arrayListOf(10000f, 20000f, 30000f, 40000f)
        val revenueComp2 = arrayListOf(12000f, 23000f, 35000f, 48000f)

        val point1 = Entry(0f, 50f)  // on point/index 0, the data is 50
        val point2 = Entry(1f, 100f) // on point/index 1, the data is 100
        val point3 = Entry(2f, 75f)  // on point/index 2, the data is 75
        /*val entries1 = revenueComp1.mapIndexed { index, arrayList ->
            Entry(index, arrayList[index]) }

        val entries2 = revenueComp1.mapIndexed { index, arrayList ->
            Entry(index, arrayList[index]) }*/


        return binding.root
    }

}
