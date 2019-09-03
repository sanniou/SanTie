package com.saniou.santieba.component

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.saniou.santieba.viewmodel.MainViewModel
import com.saniou.santieba.R
import com.saniou.santieba.databinding.ActivityMainBinding
import com.saniou.santieba.kts.getViewModel
import com.saniou.santieba.kts.startActivityEx
import com.saniou.santieba.vo.ForumItem
import com.sanniou.common.databinding.DataBindingArrayList
import com.sanniou.common.utilcode.util.SPUtils

class MainActivity : SanBaseActivity() {

    private val mViewModel by lazy {
        getViewModel(MainViewModel::class.java)
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
        checkLogin()
    }

    private fun checkLogin() {
        if (SPUtils.getInstance("login_info").getString("BDUSS").isEmpty()) {
            startActivityEx(WebLoginActivity::class.java)
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
