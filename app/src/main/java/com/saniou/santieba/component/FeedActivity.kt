package com.saniou.santieba.component

import androidx.databinding.ViewDataBinding
import com.saniou.santieba.R
import com.saniou.santieba.viewmodel.FeedViewModel
import com.sanniou.support.extensions.getViewModel

class FeedActivity : SanBaseActivity<FeedViewModel>() {

    override fun createViewModel() = getViewModel<FeedViewModel>()

    override fun getLayoutRes() = R.layout.activity_feed

    override fun onBindingCreated(binding: ViewDataBinding) {
    }
}
