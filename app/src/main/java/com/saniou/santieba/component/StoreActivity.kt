package com.saniou.santieba.component

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.blankj.utilcode.util.ToastUtils
import com.saniou.santieba.R
import com.saniou.santieba.constant.EVENT_UI_REFRESH_FAILED
import com.saniou.santieba.constant.EVENT_UI_REFRESH_SUCCESS
import com.saniou.santieba.databinding.ActivityStoreBinding
import com.saniou.santieba.kts.startActivityEx
import com.saniou.santieba.viewmodel.StoreViewModel
import com.saniou.santieba.vo.ThreadStoreItem
import com.sanniou.support.extensions.getViewModel

class StoreActivity : SanBaseActivity<StoreViewModel>() {

    override fun createViewModel() = getViewModel<StoreViewModel>()

    override fun getLayoutRes() = R.layout.activity_store

    override fun onBindingCreated(binding: ViewDataBinding) {

        binding as ActivityStoreBinding

        setSupportActionBar(binding.actionBar)
        binding.actionBar.setNavigationOnClickListener {
            onBackPressed()
        }
        intent?.run {
            getStringExtra("UID")?.run {
                binding.setItemClick { holder ->
                    (holder.item as ThreadStoreItem)
                        .takeIf { !it.isDeleted }
                        ?.run { startActivityEx(ThreadDetailActivity::class.java, "tid", tid) }
                        ?: run { ToastUtils.showShort("帖子被删除") }
                    true
                }
                binding.setLongPressListener {
                    viewModel.rmStore(it.item as ThreadStoreItem)
                }

                viewModel.observeEventInt(this@StoreActivity, Observer {
                    when (it) {
                        EVENT_UI_REFRESH_SUCCESS -> {
                            binding.refresh.stopRefresh(true)
                        }
                        EVENT_UI_REFRESH_FAILED -> {
                            binding.refresh.stopRefresh(false)
                        }
                        else -> {
                        }
                    }
                })
                viewModel.uId = this
                binding.viewModel = viewModel
                viewModel.init()

            } ?: run {
                finish()
            }
        } ?: run {
            finish()
        }
    }
}
