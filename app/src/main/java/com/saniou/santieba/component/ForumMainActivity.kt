package com.saniou.santieba.component

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import com.saniou.santieba.R
import com.saniou.santieba.constant.FORUM_SCHEME
import com.saniou.santieba.constant.MENU_COLOR
import com.saniou.santieba.constant.TIEBA_FORUM_HOST
import com.saniou.santieba.databinding.ActivityForumMainBinding
import com.saniou.santieba.kts.getViewModel
import com.saniou.santieba.kts.setDataBindingContentView
import com.saniou.santieba.kts.tintDrawable
import com.saniou.santieba.viewmodel.ForumMainViewModel
import com.sanniou.common.utilcode.util.ResourcesUtils
import com.sanniou.common.utilcode.util.ToastUtils
import java.net.URLDecoder

class ForumMainActivity : SanBaseActivity() {
    private val binding: ActivityForumMainBinding by lazy {
        setDataBindingContentView<ActivityForumMainBinding>(R.layout.activity_forum_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tiebaLinkFilter()

        setSupportActionBar(binding.actionBar)
        binding.actionBar.setOnClickListener {
            binding.recycler.smoothScrollToPosition(0)
        }
        binding.actionBar.setNavigationOnClickListener {
            onBackClick(it)
        }
        val name = intent.getStringExtra("name")
        name?.run {
            val viewModel = getViewModel<ForumMainViewModel>()
            binding.viewModel = viewModel
            viewModel.observeForever(this@ForumMainActivity, Observer {
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

    private fun tiebaLinkFilter() {
        val intent = intent
        if (Intent.ACTION_DEFAULT == intent.action) {
            if (FORUM_SCHEME == intent.scheme) {
                val decode = URLDecoder.decode(intent.data!!.toString(), "UTF-8")
                intent.putExtra(
                    "name",
                    decode.substring(decode.indexOf("kw=") + 3, decode.length)
                )


            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.forum_detail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_good -> {
                binding.viewModel?.run {
                    isGood = !isGood
                    init()
                }
            }
            R.id.menu_unsubscribe -> {
                binding.viewModel?.unSubscribe()
            }
            R.id.menu_browser -> {
                val url = TIEBA_FORUM_HOST + binding.viewModel?.forumName?.get()
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(url)
                startActivity(i)
            }
        }
        return true
    }
}
