package com.saniou.santieba.component

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModel
import com.saniou.santieba.BR
import com.sanniou.support.components.BaseScopedActivity

abstract class SanBaseActivity<T : ViewModel> : BaseScopedActivity<T>() {
    override fun getModelId() = BR.viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.getWindow()
            .getDecorView()
            .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }
}