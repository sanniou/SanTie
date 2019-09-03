package com.saniou.santieba

import android.app.Application
import com.saniou.santieba.constant.HOST
import com.sanniou.common.CommonAppUtils
import com.sanniou.common.CommonConfig

class SanApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        CommonAppUtils.init(CommonConfig(this, HOST, null, null))
    }
}