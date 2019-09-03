package com.saniou.santieba.component

import com.saniou.santieba.R
import com.sanniou.common.component.BaseActivity
import com.sanniou.common.utilcode.util.BarUtils
import com.sanniou.common.utilcode.util.ResourcesUtils

open class SanBaseActivity : BaseActivity() {

    override fun setStatusBar() {
        super.setStatusBar()
        BarUtils.setStatusBarColor(this, ResourcesUtils.getColor(R.color.design_blue))
    }

}