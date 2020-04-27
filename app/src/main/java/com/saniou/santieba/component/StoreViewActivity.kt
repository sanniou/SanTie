package com.saniou.santieba.component

import com.blankj.utilcode.util.ToastUtils
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.saniou.santieba.databinding.ActivityListBinding
import com.saniou.santieba.viewmodel.StoreListViewModel
import com.saniou.santieba.vo.StoreThreadItem
import com.sanniou.multiitemkit.ItemClickHelper
import com.sanniou.multiitemkit.OnItemClickListener
import com.sanniou.multiitemkit.OnLongPressListener

class StoreViewActivity : ListItemActivity<StoreListViewModel>() {

    override fun onBinding(binding: ActivityListBinding) {
        ItemClickHelper.attachToRecyclerView(
            binding.recycler,
            itemClickListener = OnItemClickListener {

                (it.item as? StoreThreadItem)?.run {
                    takeIf { item -> !item.isDeleted }
                        ?.run {
                            toStoreThreadPageList(tid, markPid, markState)
                        }
                        ?: run { ToastUtils.showShort("帖子被删除") }
                }
                false
            },
            longPressListener = OnLongPressListener {

                val item = it.item as StoreThreadItem
                val index = viewModel.removeAt(item)

                Snackbar.make(binding.root, "", Snackbar.LENGTH_LONG)
                    .setAction("撤销") { _ ->
                        viewModel.add(index, item)
                    }
                    .addCallback(object : BaseTransientBottomBar.BaseCallback<Snackbar>() {
                        override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
                            if (event != DISMISS_EVENT_ACTION) {
                                viewModel.rmStore(item)
                            }
                        }
                    })
                    .setText("取消收藏成功")
                    .show()

            })
    }
}
