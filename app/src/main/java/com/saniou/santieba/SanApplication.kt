package com.saniou.santieba

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import org.litepal.LitePal

class SanApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        LitePal.initialize(this)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}