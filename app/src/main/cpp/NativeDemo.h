//
// Created by javed on 12/11/19.
//
#include <jni.h>
#include <string>

#ifdef __cplusplus
extern "C" {
#endif

/* Declarations of this file */
jstring stringFromJNI(JNIEnv *env);             //declaration of method for getting string from JNI
jstring startedFromSplashJNI(JNIEnv* env);      //declaration of method for getting string when next activity started from splash activity

#ifdef __cplusplus
}
#endif

