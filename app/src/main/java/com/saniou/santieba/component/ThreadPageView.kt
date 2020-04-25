package com.saniou.santieba.component

import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.blankj.utilcode.util.ActivityUtils
import com.blankj.utilcode.util.IntentUtils
import com.blankj.utilcode.util.ToastUtils
import com.saniou.santieba.R
import com.saniou.santieba.constant.MENU_COLOR
import com.saniou.santieba.constant.TIEBA_HOST
import com.saniou.santieba.databinding.ActivityListBinding
import com.saniou.santieba.kts.startActivityEx
import com.saniou.santieba.kts.tintDrawable
import com.saniou.santieba.utils.ClipboardUtils
import com.saniou.santieba.utils.openBrowser
import com.saniou.santieba.viewmodel.ThreadPageViewModel
import com.saniou.santieba.vo.CommentImageItem
import com.saniou.santieba.vo.SubCommentItem
import com.sanniou.multiitemkit.ItemClickHelper
import com.sanniou.multiitemkit.OnItemClickListener
import com.sanniou.support.utils.ResourcesUtils

class ThreadPageView : ListItemView<ThreadPageViewModel> {

    override fun onBinding(
        context: ListItemActivity,
        binding: ActivityListBinding,
        viewModel: ThreadPageViewModel
    ) {

        viewModel.store.observe(context, Observer {
            binding.actionBar.menu.findItem(R.id.menu_store).icon =
                if (it)
                    ResourcesUtils.getDrawable(R.drawable.ic_thread_store)!!
                        .tintDrawable(MENU_COLOR)
                else
                    ResourcesUtils.getDrawable(R.drawable.ic_thread_store)
        })

        viewModel.lzOly.observe(context, Observer {
            binding.actionBar.menu.findItem(R.id.menu_single).icon =
                if (it)
                    ResourcesUtils.getDrawable(R.drawable.ic_lz_only)!!
                        .tintDrawable(MENU_COLOR)
                else
                    ResourcesUtils.getDrawable(R.drawable.ic_lz_only)
        })
        viewModel.reverse.observe(context, Observer {
            binding.actionBar.menu.findItem(R.id.menu_reverse).icon =
                if (it)
                    ResourcesUtils.getDrawable(R.drawable.ic_order)!!
                        .tintDrawable(MENU_COLOR)
                else
                    ResourcesUtils.getDrawable(R.drawable.ic_order)
        })

        binding.actionBar.run {
            inflateMenu(R.menu.thread_detail)
            setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.menu_single -> {
                        viewModel.run {
                            lzOly.value = !lzOly.value
                            refresh()
                        }
                    }
                    R.id.menu_reverse -> {
                        viewModel.run {
                            reverse.value = !reverse.value
                            refresh()
                        }
                    }
                    R.id.menu_store -> {
                        viewModel.changeStore((binding.recycler.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition())
                    }
                    R.id.menu_share -> {
                        ActivityUtils.startActivity(IntentUtils.getShareTextIntent(TIEBA_HOST + viewModel.tid))
                    }
                    R.id.menu_link -> {
                        ClipboardUtils.copyText(TIEBA_HOST + viewModel.tid)
                        ToastUtils.showShort(R.string.copied_to_clipboard)
                    }
                    R.id.menu_browser -> {
                        openBrowser(context, TIEBA_HOST + viewModel.tid)
                    }
                }
                true
            }
        }

        ItemClickHelper.attachToRecyclerView(binding.recycler, OnItemClickListener {
            when (val item = it.item) {
                is SubCommentItem -> {
                    context.startActivityEx<ThreadSubCommentActivity>(
                        "pid",
                        item.pid,
                        "tid",
                        item.threadId
                    )
                }
                is CommentImageItem -> {
                    ImagePreviewActivity.imagePreview(
                        viewModel.imageList.indexOf(item.orgImage),
                        viewModel.imageList,
                        it.itemView as ImageView
                    )
                }
            }

            false
        })
    }
}