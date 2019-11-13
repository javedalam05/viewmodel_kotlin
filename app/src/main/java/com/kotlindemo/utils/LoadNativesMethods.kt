package com.kotlindemo.utils
//
// Created by javed on 12/11/19.
//
class LoadNativesMethods {

    init {
        // Used to load the 'native-lib' library on application startup.
        System.loadLibrary("native-lib")
    }

    private external fun stringFromJNI(): String                //JNI method which is same as it is define and declare in JNI
    private external fun startedFromSplashJNI(): String         //JNI method which is same as it is define and declare in JNI

    fun getTextString(): String {                               //This method define for fetching data from JNI methods and simply use in Kotlin classes
        return stringFromJNI()
    }


    fun startedFromSplah(): String {                            //This method define for fetching data from JNI methods and simply use in Kotlin classes
        return startedFromSplashJNI()
    }
}