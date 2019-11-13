package com.kotlindemo.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.net.Uri
import android.view.View
import com.kotlindemo.BuildConfig
import com.kotlindemo.R
import com.kotlindemo.utils.LoadNativesMethods
import com.kotlindemo.databinding.MainFragmentBinding
import com.kotlindemo.model.DataModel

//
// Created by javed on 12/11/19.
//

class EditTextViewModel() : ViewModel() {

    var editString = MutableLiveData<String>()
    var textString = MutableLiveData<String>()

    init {
        var loadNativesMethods =
            LoadNativesMethods()                                            //Create instance of Native Method class for loading native methods

        var dataModel = DataModel()
        dataModel.textString =
            loadNativesMethods.startedFromSplah()                           //Here I fetch the value from JNI with second method (which is written in C and C++)

        textString.value =
            dataModel.textString + "\n-- Text Added From View Model --"     //Here I fetch value from DataModel and added some extra text for differentiation
    }


    fun btnClick(): View.OnClickListener {                      //Button click method/function which is directly calls from xml file with Data Binding
        return View.OnClickListener { view ->
            textString.value = editString.value
        }
    }

}