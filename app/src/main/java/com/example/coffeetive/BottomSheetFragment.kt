package com.example.coffeetive


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.coffeetive.databinding.BottomSheetFragmentBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class BottomSheetFragment : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: BottomSheetFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.bottom_sheet_fragment, container, false)
        return binding.root
    }

}