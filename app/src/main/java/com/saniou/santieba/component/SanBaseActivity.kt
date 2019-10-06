package com.saniou.santieba.component

import com.saniou.santieba.R
import com.sanniou.common.component.BaseActivity
import com.sanniou.common.utilcode.util.BarUtils

open class SanBaseActivity : BaseActivity() {

    override fun setStatusBar() {
        super.setStatusBar()
        BarUtils.setStatusBarColor(this, resources.getColor(R.color.backgroundColor))
    }

    override fun setStatusBarLightMode() {
        super.setStatusBarLightMode()
        BarUtils.setStatusBarLightMode(this, true)
    }

}