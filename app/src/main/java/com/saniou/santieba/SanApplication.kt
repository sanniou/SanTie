package com.saniou.santieba

import android.app.Application
import com.saniou.santieba.constant.ThreadContentType
import com.sanniou.common.CommonAppUtils
import com.sanniou.common.CommonConfig
import com.sanniou.common.databinding.ImageViewDatabindingAdapter
import com.sanniou.common.network.CommonRetrofit

class SanApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        CommonAppUtils.init(CommonConfig(this, ThreadContentType.HOST, null, null))
    }
}