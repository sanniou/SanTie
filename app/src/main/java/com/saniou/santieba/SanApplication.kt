package com.saniou.santieba

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.saniou.santieba.constant.HOST
import com.sanniou.common.CommonAppUtils
import com.sanniou.common.CommonConfig

class SanApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        CommonAppUtils.init(CommonConfig(this, HOST, null, null))
    }
}