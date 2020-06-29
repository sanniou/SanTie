package com.saniou.santieba.component.feed

import androidx.navigation.fragment.findNavController
import com.blankj.utilcode.util.SnackbarUtils
import com.saniou.santieba.component.ListItemFragment
import com.saniou.santieba.component.store.StoreFragmentDirections
import com.saniou.santieba.databinding.ActivityListBinding
import com.saniou.santieba.viewmodel.FeedViewModel
import com.saniou.santieba.vo.StoreThreadItem
import com.sanniou.multiitemkit.ItemClickHelper
import com.sanniou.multiitemkit.OnItemClickListener
import com.sanniou.support.extensions.getViewModel

class FeedFragment : ListItemFragment<FeedViewModel>() {

    override fun createViewModel() = getViewModel<FeedViewModel>()

    override fun onBinding(binding: ActivityListBinding) {
        super.onBinding(binding)
        ItemClickHelper.attachToRecyclerView(
            binding.recycler,
            itemClickListener = OnItemClickListener {

                (it.item as? StoreThreadItem)?.run {
                    takeIf { item -> !item.isDeleted }
                        ?.run {
                            findNavController().navigate(
                                FeedFragmentDirections.actionNavbarExploreToThreadPage(
                                    tid,
                                    markPid,
                                    markState
                                )
                            )
                        }
                        ?: run { SnackbarUtils.with(binding.root).setMessage("帖子被删除").show() }
                }
                false
            })
    }
}
