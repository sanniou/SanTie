package com.saniou.santieba.component.forum

import androidx.navigation.fragment.findNavController
import com.saniou.santieba.component.ListItemFragment
import com.saniou.santieba.databinding.ActivityListBinding
import com.saniou.santieba.viewmodel.ForumInfoViewModel
import com.saniou.santieba.viewmodel.ForumPageViewModel
import com.saniou.santieba.vo.ThreadItem
import com.sanniou.multiitemkit.ItemClickHelper
import com.sanniou.multiitemkit.OnItemClickListener
import com.sanniou.support.extensions.getViewModel

class ForumInfoFragment : ListItemFragment<ForumInfoViewModel>() {

    override fun getViewModelInstance() = requireParentFragment()
        .getViewModel<ForumInfoViewModel>()
        .apply {
            setValue("forum", requireArguments().getString("forum", ""))
        }

    override fun onBinding(binding: ActivityListBinding) {
        ItemClickHelper.attachToRecyclerView(binding.recycler, OnItemClickListener {
            (it.item as? ThreadItem)?.run {
                findNavController().navigate(ForumMainFragmentDirections.forumMainToThread(tid))
            }
            true
        })
    }

    override fun onResume() {
        if (viewModel.refreshState.value != true) {
            viewModel.startRefresh.value = Unit
        }
        super.onResume()
    }
}