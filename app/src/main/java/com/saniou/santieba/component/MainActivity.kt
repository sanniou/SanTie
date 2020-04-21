package com.saniou.santieba.component

import android.content.Intent
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.blankj.utilcode.util.SPUtils
import com.saniou.santieba.R
import com.saniou.santieba.kts.startActivityEx
import com.saniou.santieba.viewmodel.MainViewModel
import com.sanniou.support.extensions.getViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : SanBaseActivity<MainViewModel>() {

    override fun createViewModel() = getViewModel<MainViewModel>()

    override fun getLayoutRes() = R.layout.activity_main

    override fun onBindingCreated(binding: ViewDataBinding) {

        viewModel.observeEventInt(this, Observer {
            when (it) {
                3 -> {
                    startActivityEx(StoreActivity::class.java, "UID", viewModel.mID)
                }
                4 -> {
                    startActivityEx(SearchActivity::class.java, "UID", viewModel.mID)
                }
                5 -> {
                    refresh.stopRefresh(true)
                }
                6 -> {
                    refresh.stopRefresh(false)
                }
            }
        })
        checkLogin()
    }

    private fun checkLogin() {
        if (SPUtils.getInstance("login_info").getString("BDUSS").isEmpty()) {
            startActivityEx(WebLoginActivity::class.java)
            finish()
        } else {
            viewModel.getFavorite()
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        checkLogin()
    }
}