package com.kotlindemo.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v4.content.ContextCompat.startActivity
import com.kotlindemo.BuildConfig
import com.kotlindemo.R
import com.kotlindemo.utils.LoadNativesMethods
import com.kotlindemo.databinding.MainFragmentBinding
import com.kotlindemo.utils.AppConstants
import com.kotlindemo.views.activities.MainActivity
//
// Created by javed on 12/11/19.
//

class VideoViewModel(var ctx: Context, binding: MainFragmentBinding) : ViewModel() {

    var textString =
        MutableLiveData<String>()                  //Text String which is set at TextView added in main_fragment layout

    var nativesMethodObj: LoadNativesMethods                    //variable for loads JNI library and its methods

    init {
        val path = "android.resource://" + BuildConfig.APPLICATION_ID + "/" + R.raw.ad2                 //Video path
        binding.videoView.setVideoURI(Uri.parse(path))                                                          //Set Video path at video view
        binding.videoView.start()                                                                               //Start video when your video path is added at video view
        binding.videoView.setOnCompletionListener {
            //Listener for completion of video, it's called when your video completed successfully

            var intent = Intent(
                ctx,
                MainActivity::class.java
            )                               //intent variable for starting new activity
            intent.putExtra(
                AppConstants.whichFragement,
                AppConstants.EDIT_TEXT_FRAGMENT
            )    //here I started same MainActivity instance from MainActivity, for attaching different fragment I gives putExtra

            ctx.startActivity(intent)                                                             //Simply Start the activity
            if (ctx is MainActivity) {
                (ctx as MainActivity).finish()                                                   //Finishes current splash activity
            }
        }

        nativesMethodObj =
            LoadNativesMethods()                 //Create instance of Native Method class for loading native methods
        textString.value =
            nativesMethodObj.getTextString()     //Here I fetch the value from JNI (which is written in C and C++)
    }

}