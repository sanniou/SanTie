package com.saniou.santieba.component.store

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.blankj.utilcode.util.SnackbarUtils
import com.blankj.utilcode.util.ToastUtils
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.saniou.santieba.MainNavigationDirections
import com.saniou.santieba.R
import com.saniou.santieba.component.ListItemFragment
import com.saniou.santieba.component.toStoreThreadPageList
import com.saniou.santieba.databinding.ActivityListBinding
import com.saniou.santieba.kts.changeMenu
import com.saniou.santieba.viewmodel.StoreListViewModel
import com.saniou.santieba.vo.StoreThreadItem
import com.sanniou.multiitemkit.ItemClickHelper
import com.sanniou.multiitemkit.OnItemClickListener
import com.sanniou.multiitemkit.OnLongPressListener
import com.sanniou.support.extensions.getActivityViewModel
import com.sanniou.support.extensions.getViewModel

class StoreFragment : ListItemFragment<StoreListViewModel>() {

    override fun getViewModelInstance() = getActivityViewModel<StoreListViewModel>()

    override fun onBinding(binding: ActivityListBinding) {
        ItemClickHelper.attachToRecyclerView(
            binding.recycler,
            itemClickListener = OnItemClickListener {

                (it.item as? StoreThreadItem)?.run {
                    takeIf { item -> !item.isDeleted }
                        ?.run {
                            findNavController().navigate(
                                StoreFragmentDirections.actionNavbarStoreToThreadPage(
                                    tid,
                                    markPid,
                                    markState
                                )
                            )
                        }
                        ?: run { SnackbarUtils.with(binding.root).setMessage("帖子被删除").show() }
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        changeMenu(R.menu.nav_home, Observer {
            when (it) {
                R.id.home_sign ->
                    findNavController()
                        .navigate(MainNavigationDirections.actionGlobalUserMsign())
                R.id.home_search -> {
                    findNavController()
                        .navigate(MainNavigationDirections.actionGlobalSearchFragment())
                }
            }
        })
        super.onViewCreated(view, savedInstanceState)
    }
}
