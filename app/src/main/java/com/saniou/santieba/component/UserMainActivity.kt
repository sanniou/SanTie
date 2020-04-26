package com.saniou.santieba.component

import androidx.databinding.ViewDataBinding
import com.blankj.utilcode.util.ToastUtils
import com.saniou.santieba.R
import com.saniou.santieba.databinding.ActivityUserMainBinding
import com.saniou.santieba.viewmodel.MASK_TYPE_ALLOW
import com.saniou.santieba.viewmodel.MASK_TYPE_PRIVATE
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
            binding.forums.setOnClickListener {
                if (viewModel.maskType.value == MASK_TYPE_ALLOW) {
                    toForumList(this)
                } else {
                    ToastUtils.showShort("用户已设置隐藏")
                }
            }
            binding.forumsHint.setOnClickListener {
                if (viewModel.maskType.value == MASK_TYPE_ALLOW) {
                    toForumList(this)
                } else {
                    ToastUtils.showShort("用户已设置隐藏")
                }
            }
            binding.fans.setOnClickListener {
                toFansList(this)
            }
            binding.fansHint.setOnClickListener {
                toFansList(this)
            }
            binding.follows.setOnClickListener {
                toFollowsList(this)
            }
            binding.followsHint.setOnClickListener {
                toFollowsList(this)
            }
            binding.thread.setOnClickListener {
                if (viewModel.maskType.value != MASK_TYPE_PRIVATE) {
                    toPostsList(this)
                } else {
                    ToastUtils.showShort("用户已设置隐藏")
                }
            }
            binding.threadHint.setOnClickListener {
                if (viewModel.maskType.value != MASK_TYPE_PRIVATE) {
                    toPostsList(this)
                } else {
                    ToastUtils.showShort("用户已设置隐藏")
                }
            }
            viewModel.init(this)
        } ?: run {
            ToastUtils.showShort("no uid")
            finish()
        }
    }
}
