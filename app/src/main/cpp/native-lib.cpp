#include <jni.h>
#include <string>
#include "NativeDemo.h"

extern "C" JNIEXPORT jstring JNICALL
Java_com_kotlindemo_utils_LoadNativesMethods_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {

    return stringFromJNI(env);
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_kotlindemo_utils_LoadNativesMethods_startedFromSplashJNI(JNIEnv *env, jobject /* this */) {

    return startedFromSplashJNI(env);
}
