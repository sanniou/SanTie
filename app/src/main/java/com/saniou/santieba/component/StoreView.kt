package com.saniou.santieba.component

import com.blankj.utilcode.util.ToastUtils
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.saniou.santieba.constant.BOOLEAN_TRUE
import com.saniou.santieba.databinding.ActivityListBinding
import com.saniou.santieba.kts.startActivityEx
import com.saniou.santieba.viewmodel.StoreListViewModel
import com.saniou.santieba.vo.StoreThreadItem
import com.sanniou.multiitemkit.ItemClickHelper
import com.sanniou.multiitemkit.OnItemClickListener
import com.sanniou.multiitemkit.OnLongPressListener

class StoreView : ListItemView<StoreListViewModel> {

    override fun onBinding(
        context: ListItemActivity,
        binding: ActivityListBinding,
        listViewModel: StoreListViewModel
    ) {
        ItemClickHelper.attachToRecyclerView(
            binding.recycler,
            itemClickListener = OnItemClickListener {

                (it.item as? StoreThreadItem)?.run {
                    takeIf { item -> !item.isDeleted }
                        ?.run {
                            toStoreThreadPageList(tid, markPid, markState, isStore = BOOLEAN_TRUE)
                        }
                        ?: run { ToastUtils.showShort("帖子被删除") }
                }
                false
            },
            longPressListener = OnLongPressListener {

                val item = it.item as StoreThreadItem
                val index = listViewModel.removeAt(item)

                Snackbar.make(binding.root, "", Snackbar.LENGTH_LONG)
                    .setAction("撤销") { _ ->
                        listViewModel.add(index, item)
                    }
                    .addCallback(object : BaseTransientBottomBar.BaseCallback<Snackbar>() {
                        override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
                            if (event != DISMISS_EVENT_ACTION) {
                                listViewModel.rmStore(item)
                            }
                        }
                    })
                    .setText("取消收藏成功")
                    .show()

            })
    }
}
