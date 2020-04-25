package com.saniou.santieba.component

import androidx.databinding.ViewDataBinding
import com.blankj.utilcode.util.ToastUtils
import com.saniou.santieba.R
import com.saniou.santieba.databinding.ActivityUserMainBinding
import com.saniou.santieba.viewmodel.UserMainViewModel
import com.sanniou.support.extensions.getViewModel

class UserMainActivity : SanBaseActivity<UserMainViewModel>() {

    override fun getLayoutRes() = R.layout.activity_user_main

    override fun createViewModel() = getViewModel<UserMainViewModel>()

    override fun onBindingCreated(binding: ViewDataBinding) {
        binding as ActivityUserMainBinding

        setSupportActionBar(binding.actionBar)
        binding.actionBar.setNavigationOnClickListener {
            finish()
        }


        intent?.run {
            getStringExtra("uid")
        }?.run {
            binding.avatar.setOnClickListener {
                toForumList(this)
            }
            binding.fans.setOnClickListener {
                toFansList(this)
            }
            binding.follows.setOnClickListener {
                toFollowsList(this)
            }
            binding.thread.setOnClickListener {
                toPostsList(this)
            }
            viewModel.init(this)
        } ?: run {
            ToastUtils.showShort("no uid")
            finish()
        }
    }
}
