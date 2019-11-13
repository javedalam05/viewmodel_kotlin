package com.kotlindemo.views.fragments

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlindemo.R
import com.kotlindemo.databinding.MainFragmentBinding
import com.kotlindemo.viewmodels.VideoViewModel
import com.kotlindemo.viewmodels.VideoViewModelFactory


//
// Created by javed on 12/11/19.
//

class MainFragment : Fragment() {

    lateinit var model: VideoViewModel              //View model for MainFragment

    lateinit var binding: MainFragmentBinding       //Data Binding instance variable for MainFragment

    var stopPosition: Int = 0                        //For saving state of video running position

    /**
     * Override method of Fragment for saving the state
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (binding.videoView.isPlaying()) {
            outState.putInt("pos", binding.videoView.getCurrentPosition()) //put position value in saveInstanceState for resetting the videoview when comes in onResume
        }
    }

    /**
     * Override method of Fragment for setting layout and view at fragment
     */

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        model =
            activity?.run {
                ViewModelProviders.of(this, VideoViewModelFactory(activity!!, binding!!))[VideoViewModel::class.java]
            } ?: throw Exception("Invalid Activity")

        binding?.videoViewModel = model
        binding?.setLifecycleOwner(this)


        var pos = 0
        if (savedInstanceState != null) {
            pos = savedInstanceState.getInt("pos")
            binding.videoView.seekTo(pos)
        }

        return binding.root
    }


    /**
     * Override method of Fragment for save the video player position in stopPosition variable
     */
    override fun onPause() {
        super.onPause()
        stopPosition = binding.videoView.getCurrentPosition() //stopPosition is an int
        binding.videoView.pause()
    }

    /**
     * Override method of Fragment for resume the position of video player
     */
    override fun onResume() {
        super.onResume()
        binding.videoView.seekTo(stopPosition)
        binding.videoView.start() //Or use resume() if it doesn't work. I'm not sure
    }
}