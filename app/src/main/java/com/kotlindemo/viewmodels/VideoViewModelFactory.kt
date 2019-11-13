package com.kotlindemo.viewmodels

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import com.kotlindemo.databinding.MainFragmentBinding

/*
    Created by javed on 12/11/19.
    class created for factory creation of viewmodel
    with the help of ViewModelProvider.NewInstanceFactory, we can simply pass parameter in constructor of ViewModel
*/
class VideoViewModelFactory(var ctx: Context, var binding: MainFragmentBinding) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return VideoViewModel(ctx, binding) as T
    }
}