package com.saniou.santieba.component

import android.view.Menu
import android.view.MenuItem
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.blankj.utilcode.util.ToastUtils
import com.saniou.santieba.R
import com.saniou.santieba.constant.MENU_COLOR
import com.saniou.santieba.constant.TIEBA_FORUM_HOST
import com.saniou.santieba.constant.TIEBA_RANK_HOST
import com.saniou.santieba.databinding.ActivityForumMainBinding
import com.saniou.santieba.kts.tintDrawable
import com.saniou.santieba.utils.openBrowser
import com.saniou.santieba.utils.tiebaForumLinkFilter
import com.saniou.santieba.viewmodel.ForumMainViewModel
import com.sanniou.support.extensions.getViewModel
import com.sanniou.support.utils.ResourcesUtils

class ForumMainActivity : SanBaseActivity<ForumMainViewModel>() {

    override fun createViewModel() = getViewModel<ForumMainViewModel>()

    override fun getLayoutRes() = R.layout.activity_forum_main

    override fun onBindingCreated(binding: ViewDataBinding) {

        binding as ActivityForumMainBinding

        tiebaForumLinkFilter(intent)

        setSupportActionBar(binding.actionBar)

        binding.actionBar.setNavigationOnClickListener {
            onBackPressed()
        }
        val name = intent.getStringExtra("name")
        name?.run {
            binding.viewModel = viewModel
            viewModel.observeEventInt(this@ForumMainActivity, Observer {
                when (it) {
                    0 -> {
                        binding.refresh.stopRefresh(true)
                    }
                    1 -> {
                        binding.refresh.stopRefresh(false)
                    }
                    3 -> {
                        val menuItem = binding.actionBar.menu.findItem(R.id.menu_good)
                        menuItem?.icon = ResourcesUtils.getDrawable(R.drawable.ic_good)
                            .tintDrawable(MENU_COLOR)
                    }
                    4 -> {
                        val menuItem = binding.actionBar.menu.findItem(R.id.menu_good)
                        menuItem?.icon = ResourcesUtils.getDrawable(R.drawable.ic_good)
                    }
                }

            })
            viewModel.name = name
            binding.refresh.post {
                binding.refresh.startRefresh()
            }

        } ?: run {
            ToastUtils.showShort("no forum name")
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.forum_detail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_good -> {
                viewModel.run {
                    isGood = !isGood
                    init()
                }
            }
            R.id.menu_unsubscribe -> {
                viewModel.unSubscribe()
            }
            R.id.menu_browser -> {
                openBrowser(this, TIEBA_FORUM_HOST + viewModel.forumName.get())
            }
            R.id.menu_rank -> {
                openBrowser(this, TIEBA_RANK_HOST + viewModel.forumName.get() + "&ie=utf-8")
            }
        }
        return true
    }
}
