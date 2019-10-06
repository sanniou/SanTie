package com.saniou.santieba.component

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.saniou.santieba.R
import com.saniou.santieba.databinding.ActivityMainBinding
import com.saniou.santieba.kts.getViewModel
import com.saniou.santieba.kts.startActivityEx
import com.saniou.santieba.viewmodel.MainViewModel
import com.saniou.santieba.vo.ForumItem
import com.sanniou.common.utilcode.util.SPUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : SanBaseActivity() {

    private val mViewModel by lazy {
        getViewModel<MainViewModel>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataBinding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        mViewModel.bindLifecycleOwner(this)
        dataBinding.viewModel = mViewModel
        dataBinding.setItemClick { holder ->
            val intent = Intent(this, ForumMainActivity::class.java)
            intent.putExtra("name", (holder.item as ForumItem).name)
            startActivity(intent)
            true
        }
        mViewModel.observe {
            when (it) {
                3 -> {
                    startActivityEx(StoreActivity::class.java, "UID", mViewModel.mID)
                }
                4 -> {
                    startActivityEx(SearchActivity::class.java, "UID", mViewModel.mID)
                }
                5 -> {
                    refresh.stopRefresh(true)
                }
                6 -> {
                    refresh.stopRefresh(false)
                }
            }
        }
        checkLogin()
    }

    private fun checkLogin() {
        if (SPUtils.getInstance("login_info").getString("BDUSS").isEmpty()) {
            startActivityEx(WebLoginActivity::class.java)
            finish()
        } else {
            mViewModel.getFavorite()
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        checkLogin()
    }

    fun requstsuccess() {

    }
}