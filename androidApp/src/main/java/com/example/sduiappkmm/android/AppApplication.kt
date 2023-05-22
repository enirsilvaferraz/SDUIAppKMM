package com.example.sduiappkmm.android

import InitKoin
import android.app.Application

class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        InitKoin()
    }
}