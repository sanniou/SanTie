package com.saniou.santieba.component

import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.blankj.utilcode.util.IntentUtils
import com.blankj.utilcode.util.ToastUtils
import com.saniou.santieba.R
import com.saniou.santieba.constant.MENU_COLOR
import com.saniou.santieba.constant.THREAD_SCHEME
import com.saniou.santieba.constant.THREAD_URL
import com.saniou.santieba.constant.TIEBA_HOST
import com.saniou.santieba.databinding.ActivityThreadDatailBinding
import com.saniou.santieba.kts.tintDrawable
import com.saniou.santieba.utils.ClipboardUtils
import com.saniou.santieba.utils.openBrowser
import com.saniou.santieba.viewmodel.ThreadDetailViewModel
import com.saniou.santieba.vo.CommentImageItem
import com.saniou.santieba.vo.SubCommentItem
import com.sanniou.support.extensions.getViewModel
import com.sanniou.support.utils.ResourcesUtils


class ThreadDetailActivity : SanBaseActivity<ThreadDetailViewModel>() {
    private var fromSide = false

    override fun createViewModel() = getViewModel<ThreadDetailViewModel>()

    override fun getLayoutRes() = R.layout.activity_thread_datail

    override fun onBindingCreated(binding: ViewDataBinding) {
        binding as ActivityThreadDatailBinding

        fromSide = intent.getBooleanExtra("outside", false)
        tiebaLinkFilter()

        setSupportActionBar(binding.actionBar)
        binding.actionBar.setNavigationOnClickListener {
            onBackPressed()
        }
        binding.actionBar.setOnClickListener {
            if (fromSide && binding.viewModel!!.forumName.get()!!.isNotBlank()) {
                val intent = Intent(this, ForumMainActivity::class.java)
                intent.putExtra("name", binding.viewModel!!.forumName.get())
                startActivity(intent)
            } else {
                onBackPressed()
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
                is CommentImageItem -> {
                    ImagePreviewActivity.imagePreview(
                        binding.viewModel!!.imageList.indexOf(item.orgImage),
                        binding.viewModel!!.imageList,
                        holder.itemView as ImageView
                    )
                }
            }

            false
        }
        val tid = intent.getStringExtra("tid")
        tid?.let {
            viewModel.observeEventInt(this, Observer {
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
                            .tintDrawable(MENU_COLOR)
                    }
                    4 -> {
                        val menuItem = binding.actionBar.menu.findItem(R.id.menu_star)
                        menuItem.icon = ResourcesUtils.getDrawable(R.drawable.ic_thread_store)

                    }
                }
            })
            viewModel.tid = tid
            binding.viewModel = viewModel
            binding.refresh.post {
                binding.refresh.startRefresh()
            }
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
        menuInflater.inflate(R.menu.thread_detail, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_single -> {
                viewModel.run {
                    lzOly = !lzOly
                    init()

                    item.setIcon(
                        if (lzOly)
                            ResourcesUtils.getDrawable(R.drawable.ic_lz_only)
                            !!.tintDrawable(MENU_COLOR)
                        else
                            ResourcesUtils.getDrawable(R.drawable.ic_lz_only)
                    )

                }
            }
            R.id.menu_reverse -> {
                viewModel.run {
                    reverse = !reverse
                    init()
                    item.setIcon(
                        if (reverse)
                            ResourcesUtils.getDrawable(R.drawable.ic_order)
                            !!.tintDrawable(MENU_COLOR)
                        else
                            ResourcesUtils.getDrawable(R.drawable.ic_order)
                    )
                }
            }
            R.id.menu_star -> {
                viewModel.changeStore()
            }
            R.id.menu_share -> {
                startActivity(IntentUtils.getShareTextIntent(TIEBA_HOST + viewModel.tid))
            }
            R.id.menu_link -> {
                ClipboardUtils.copyText(TIEBA_HOST + viewModel.tid)
                ToastUtils.showShort(R.string.copied_to_clipboard)
            }
            R.id.menu_browser -> {
                openBrowser(this, TIEBA_HOST + viewModel.tid)
            }
        }
        return true
    }

}

