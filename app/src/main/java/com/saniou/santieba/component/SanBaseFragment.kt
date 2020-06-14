package com.saniou.santieba.component

import androidx.lifecycle.ViewModel
import com.saniou.santieba.BR
import com.sanniou.support.components.BaseViewModelFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

abstract class SanBaseFragment<T : ViewModel> : BaseViewModelFragment<T>(),
    CoroutineScope by MainScope() {

    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }

    override fun getModelId() = BR.viewModel
}