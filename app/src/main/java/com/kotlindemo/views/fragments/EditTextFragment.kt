package com.kotlindemo.views.fragments

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlindemo.R
import com.kotlindemo.databinding.EditTextFragmentBinding
import com.kotlindemo.viewmodels.EditTextViewModel

//
// Created by javed on 12/11/19.
//

class EditTextFragment : Fragment() {

    lateinit var editTextViewModel: EditTextViewModel       //View model for EditTextViewModel

    lateinit var binding: EditTextFragmentBinding           //Data Binding instance variable for EditTextFragment

    /**
     * Override method of Fragment for setting layout and view at fragment
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.edit_text_fragment, container, false)
        editTextViewModel =
            activity?.run {
                ViewModelProviders.of(this)[EditTextViewModel::class.java]
            } ?: throw Exception("Invalid Activity")

        binding.editTextViewModel = editTextViewModel
        binding.setLifecycleOwner(this)

        return binding.root
    }

}