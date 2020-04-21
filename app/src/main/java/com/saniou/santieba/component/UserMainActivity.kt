package com.saniou.santieba.component

import androidx.databinding.ViewDataBinding
import com.blankj.utilcode.util.ToastUtils
import com.saniou.santieba.R
import com.saniou.santieba.viewmodel.UserMainViewModel
import com.sanniou.support.extensions.getViewModel

class UserMainActivity : SanBaseActivity<UserMainViewModel>() {

    override fun getLayoutRes() = R.layout.activity_user_main

    override fun createViewModel() = getViewModel<UserMainViewModel>()

    override fun onBindingCreated(binding: ViewDataBinding) {
        intent?.run {
            getStringExtra("uid")
        }?.run {
            viewModel.init(this)
        } ?: run {
            ToastUtils.showShort("no uid")
            finish()
        }
    }
}
