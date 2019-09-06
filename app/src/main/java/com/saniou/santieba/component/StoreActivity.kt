package com.saniou.santieba.component

import android.os.Bundle
import com.saniou.santieba.R
import com.saniou.santieba.constant.EVENT_UI_REFRESH_FAILED
import com.saniou.santieba.constant.EVENT_UI_REFRESH_SUCCESS
import com.saniou.santieba.databinding.ActivityStoreBinding
import com.saniou.santieba.kts.getViewModel
import com.saniou.santieba.kts.setDataBindingContentView
import com.saniou.santieba.kts.startActivityEx
import com.saniou.santieba.viewmodel.StoreViewModel
import com.saniou.santieba.vo.ThreadStoreItem
import com.sanniou.common.widget.recyclerview.BaseBindingHolder

class StoreActivity : SanBaseActivity() {
    val binding: ActivityStoreBinding by lazy {
        setDataBindingContentView<ActivityStoreBinding>(R.layout.activity_store)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.actionBar)
        binding.actionBar.setNavigationOnClickListener {
            onBackPressed()
        }
        intent?.run {
            getStringExtra("UID")?.run {
                binding.setItemClick {
                    startActivityEx(
                        ThreadDetailActivity::class.java,
                        "tid",
                        (it.item as ThreadStoreItem).tid
                    )
                    true
                }
                val viewModel = getViewModel(StoreViewModel::class.java)
                viewModel.observe {
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
                }
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
