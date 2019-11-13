//
// Created by javed on 12/11/19.
//

#include "NativeDemo.h"

//Here is the function definition of declared method in Header file

jstring stringFromJNI(JNIEnv* env) {

    std::string hello = "Hello from Javed";
    return env->NewStringUTF(hello.c_str());

}

jstring startedFromSplashJNI(JNIEnv* env){
    std::string hello = "< This is started from Splash >";
    return env->NewStringUTF(hello.c_str());

}