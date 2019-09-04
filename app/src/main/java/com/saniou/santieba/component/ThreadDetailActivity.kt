package com.saniou.santieba.component

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import com.saniou.santieba.R
import com.saniou.santieba.constant.THREAD_SCHEME
import com.saniou.santieba.constant.THREAD_URL
import com.saniou.santieba.constant.TIEBA_HOST
import com.saniou.santieba.databinding.ActivityThreadDatailBinding
import com.saniou.santieba.kts.getViewModel
import com.saniou.santieba.kts.setDataBindingContentView
import com.saniou.santieba.kts.tintDrawable
import com.saniou.santieba.viewmodel.ThreadDetailViewModel
import com.saniou.santieba.vo.SubCommentItem
import com.sanniou.common.utilcode.subutil.ClipboardUtils
import com.sanniou.common.utilcode.util.IntentUtils
import com.sanniou.common.utilcode.util.ResourcesUtils
import com.sanniou.common.utilcode.util.ToastUtils


class ThreadDetailActivity : SanBaseActivity() {
    private val binding: ActivityThreadDatailBinding by lazy {
        setDataBindingContentView<ActivityThreadDatailBinding>(R.layout.activity_thread_datail)
    }
    private var fromSide = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tiebaLinkFilter()

        setSupportActionBar(binding.actionBar)
        binding.actionBar.setNavigationOnClickListener {
            if (fromSide && binding.viewModel!!.forumName.get()!!.isNotEmpty()) {
                val intent = Intent(this, ForumMainActivity::class.java)
                intent.putExtra("name", binding.viewModel!!.forumName.get())
                startActivity(intent)
            } else {
                onBackClick(it)
            }
        }


        binding.setClickListener { holder ->
            when (val item = holder.item) {
                is SubCommentItem -> {
                    val intent = Intent(this, ThreadSubCommentActivity::class.java)
                    intent.putExtra("pid", item.pid)
                    intent.putExtra("tid", item.threadId)
                    startActivity(intent)
                }
            }

            true
        }
        val tid = intent.getStringExtra("tid")
        tid?.let {
            val viewModel = getViewModel(ThreadDetailViewModel::class.java)
            viewModel.observeForever(this, Observer {
                when (it) {
                    0 -> {
                        binding.refresh.stopRefresh(true)
                    }
                    1 -> {
                        binding.refresh.stopRefresh(false)
                    }
                    2 -> {

                    }
                    3 -> {
                        val menuItem = binding.actionBar.menu.findItem(R.id.menu_star)
                        menuItem.icon = ResourcesUtils.getDrawable(R.drawable.ic_thread_store)
                            .tintDrawable(orangeColor)
                    }
                    4 -> {
                        val menuItem = binding.actionBar.menu.findItem(R.id.menu_star)
                        menuItem.icon = ResourcesUtils.getDrawable(R.drawable.ic_thread_store)

                    }
                }
            })
            viewModel.tid = tid
            binding.viewModel = viewModel
            viewModel.init()
        } ?: finish()
    }

    private fun tiebaLinkFilter() {
        if (Intent.ACTION_DEFAULT == intent.action) {
            if (THREAD_SCHEME == intent.scheme) {
                fromSide = true
                val uri = intent.data!!.toString()
                if (uri.startsWith(THREAD_URL)) {
                    intent.putExtra("tid", uri.replace(".*tid=(\\d*)".toRegex(), "$1"))
                }
            }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.thread_detail, menu)
        return true
    }

    val orangeColor = Color.rgb(250, 128, 10)

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_single -> {
                binding.viewModel?.run {
                    lzOly = !lzOly
                    init()

                    item.setIcon(
                        if (lzOly)
                            ResourcesUtils.getDrawable(R.drawable.ic_lz_only)
                            !!.tintDrawable(orangeColor)
                        else
                            ResourcesUtils.getDrawable(R.drawable.ic_lz_only)
                    )

                }
            }
            R.id.menu_reverse -> {
                binding.viewModel?.run {
                    reverse = !reverse
                    init()
                    item.setIcon(
                        if (reverse)
                            ResourcesUtils.getDrawable(R.drawable.ic_order)
                            !!.tintDrawable(orangeColor)
                        else
                            ResourcesUtils.getDrawable(R.drawable.ic_order)
                    )
                }
            }
            R.id.menu_star -> {
                binding.viewModel?.changeStore()
            }
            R.id.menu_share -> {
                startActivity(IntentUtils.getShareTextIntent(TIEBA_HOST + binding.viewModel?.tid))
            }
            R.id.menu_link -> {
                ClipboardUtils.copyText(TIEBA_HOST + binding.viewModel?.tid)
                ToastUtils.showShort("已复制至剪贴板")
            }
            else -> {
            }
        }
        return true
    }

}

