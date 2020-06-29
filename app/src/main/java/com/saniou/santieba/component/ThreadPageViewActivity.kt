package com.saniou.santieba.component

import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.saniou.santieba.component.thread.ThreadSubCommentFragment
import com.saniou.santieba.databinding.ActivityListBinding
import com.saniou.santieba.dialog.LMessageDialog
import com.saniou.santieba.kts.startActivityEx
import com.saniou.santieba.viewmodel.PageViewModel
import com.saniou.santieba.vo.CommentImageItem
import com.saniou.santieba.vo.FloorTopItem
import com.saniou.santieba.vo.SubCommentItem
import com.sanniou.multiitemkit.ItemClickHelper
import com.sanniou.multiitemkit.OnItemClickListener
import kotlinx.coroutines.launch

class ThreadPageViewActivity : ListItemActivity<PageViewModel>() {

    var top: Int = 0
    var viewHolder: RecyclerView.ViewHolder? = null

    override fun onBackPressed() {
        if (!viewModel.store.value) {
            return super.onBackPressed()
        }
        findFirstFloor(binding as ActivityListBinding)
            .also {
                LMessageDialog(this)
                    .setMessage("是否更新收藏到${it.floor}")
                    .okListener { dialog, button ->
                        launch {
                            viewModel.addStore(it.pid)
                            finish()
                        }
                    }
                    .cancelListener { dialog, button ->
                        super.onBackPressed()
                    }
                    .show()
            }
    }

    override fun onBinding(binding: ActivityListBinding) {

        viewModel.reverseLayoutPosition.observe(this, Observer {
            when (it) {
                -1 -> top = binding.recycler
                    .findViewHolderForAdapterPosition(viewModel.getReverseStartPosition())
                    .apply { viewHolder = this }
                    ?.itemView?.run { top } ?: 0

                else -> (binding.recycler.layoutManager as LinearLayoutManager)
                    .scrollToPositionWithOffset(viewHolder!!.adapterPosition, top)
            }

        })

        // viewModel.store.observe(this, Observer {
        //     binding.actionBar.menu.findItem(R.id.menu_store).icon =
        //         if (it)
        //             ResourcesUtils.getDrawable(R.drawable.ic_thread_store)!!
        //                 .tintDrawable(MENU_COLOR)
        //         else
        //             ResourcesUtils.getDrawable(R.drawable.ic_thread_store)
        // })
        //
        // viewModel.lzOly.observe(this, Observer {
        //     binding.actionBar.menu.findItem(R.id.menu_single).icon =
        //         if (it)
        //             ResourcesUtils.getDrawable(R.drawable.ic_lz_only)!!
        //                 .tintDrawable(MENU_COLOR)
        //         else
        //             ResourcesUtils.getDrawable(R.drawable.ic_lz_only)
        // })
        // viewModel.reverse.observe(this, Observer {
        //     binding.actionBar.menu.findItem(R.id.menu_reverse).icon =
        //         if (it)
        //             ResourcesUtils.getDrawable(R.drawable.ic_order)!!
        //                 .tintDrawable(MENU_COLOR)
        //         else
        //             ResourcesUtils.getDrawable(R.drawable.ic_order)
        // })
        //
        // binding.actionBar.run {
        //     inflateMenu(R.menu.thread_detail)
        //     setOnMenuItemClickListener { item ->
        //         when (item.itemId) {
        //             R.id.menu_single -> {
        //                 viewModel.run {
        //                     lzOly.value = !lzOly.value
        //                     refresh()
        //                 }
        //             }
        //             R.id.menu_reverse -> {
        //                 viewModel.run {
        //                     reverse.value = !reverse.value
        //                     refresh()
        //                 }
        //             }
        //             R.id.menu_store -> {
        //                 if (viewModel.store.value) {
        //                     viewModel.rmStore()
        //                 } else {
        //                     viewModel.addStore(findFirstPid(binding))
        //                 }
        //             }
        //             R.id.menu_share -> {
        //                 ActivityUtils.startActivity(IntentUtils.getShareTextIntent(TIEBA_HOST + viewModel.tid))
        //             }
        //             R.id.menu_link -> {
        //                 ClipboardUtils.copyText(TIEBA_HOST + viewModel.tid)
        //                 ToastUtils.showShort(R.string.copied_to_clipboard)
        //             }
        //             R.id.menu_browser -> {
        //                 openBrowser(context, TIEBA_HOST + viewModel.tid)
        //             }
        //         }
        //         true
        //     }
        // }

        ItemClickHelper.attachToRecyclerView(binding.recycler, OnItemClickListener {
            when (val item = it.item) {
                is SubCommentItem -> {
                    // this.startActivityEx<ThreadSubCommentFragment>(
                    //     "pid",
                    //     item.pid,
                    //     "tid",
                    //     item.threadId
                    // )
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

    private fun findFirstFloor(binding: ActivityListBinding): FloorTopItem {
        val firstPosition = (binding.recycler.layoutManager as LinearLayoutManager)
            .findFirstCompletelyVisibleItemPosition()
        viewModel.list.subList(firstPosition, viewModel.list.size)
            .forEach { item ->
                if (item is FloorTopItem && item.floor != 1)
                    return item
            }
        return viewModel.list[1] as FloorTopItem
    }

    private fun findFirstPid(binding: ActivityListBinding) = findFirstFloor(binding).pid
}
