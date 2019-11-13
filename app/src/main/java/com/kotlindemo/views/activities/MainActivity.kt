package com.kotlindemo.views.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.kotlindemo.R
import com.kotlindemo.utils.AppConstants
import com.kotlindemo.utils.AppConstants.Companion.EDIT_TEXT_FRAGMENT
import com.kotlindemo.utils.AppConstants.Companion.MAIN_FRAGMENT
import com.kotlindemo.views.fragments.EditTextFragment
import com.kotlindemo.views.fragments.MainFragment

//
// Created by javed on 12/11/19.
//


class MainActivity : AppCompatActivity() {

    private lateinit var fragment: Fragment

    /**
     * Override method of activity for setting a layout for activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mFragment: Fragment? = null     //fragment variable for saving which fragment is currently attached

        val whichFragmentToBeAttach = intent.getIntExtra(AppConstants.whichFragement, MAIN_FRAGMENT)   // fetch intent extra for attaching a fragment to frameLayout of activity, here auto casting is done by kotlin for Int Extra


        when (whichFragmentToBeAttach) {                //Kotlin switch case
            MAIN_FRAGMENT -> {                          //case for attaching MainFragment
                supportActionBar?.hide();
                mFragment = MainFragment()
            }
            EDIT_TEXT_FRAGMENT -> {                     //case for attaching EditTextFragment
                mFragment = EditTextFragment()
            }
        }

        if (mFragment != null)
            setFragmentToLayout(mFragment, R.id.fragment_container)    //Attach fragment to frameLayout

    }


    /**
     * Added by javed on 16-10-19
     * Use for adding a fragment to a particular layout
     *  @fragment - Instance of a android.support.v4.app.Fragment
     *  @layoutId - resource id of the layout for which you want to add given fragment
     */

    protected fun setFragmentToLayout(fragment: Fragment, layoutId: Int) {
        this.fragment = fragment;

        // Begin the fragment transition using support fragment manager
        val transaction = supportFragmentManager.beginTransaction()

        // Replace the fragment on container
        transaction.replace(layoutId, fragment)
        transaction.addToBackStack(null)

        // Finishing the transition
        transaction.commit()
    }


    /**
     * Added by javed on 11-11-19
     * override method for back button click
     */
    override fun onBackPressed() {
        if (fragment is MainFragment) {   //check main fragment is attached or not
            finish()
            return;
        }

        if (fragment is EditTextFragment) {  //check EditText fragment is attached or not
            finish()
            return;
        }

        super.onBackPressed()
    }


}
