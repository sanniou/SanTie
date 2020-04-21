package com.saniou.santieba

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class SanApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}