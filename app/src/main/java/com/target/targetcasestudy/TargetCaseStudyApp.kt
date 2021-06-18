package com.target.targetcasestudy

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TargetCaseStudyApp : Application(){
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}