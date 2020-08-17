package com.saniou.santieba.component.forum

import androidx.navigation.fragment.findNavController
import com.saniou.santieba.component.ListItemFragment
import com.saniou.santieba.databinding.ActivityListBinding
import com.saniou.santieba.viewmodel.ForumGoodViewModel
import com.saniou.santieba.viewmodel.ForumPageViewModel
import com.saniou.santieba.vo.ThreadItem
import com.sanniou.multiitemkit.ItemClickHelper
import com.sanniou.multiitemkit.OnItemClickListener
import com.sanniou.support.extensions.getViewModel

class ForumGoodFragment : ListItemFragment<ForumGoodViewModel>() {

    override fun getViewModelInstance() = getViewModel<ForumGoodViewModel>().apply {
        setValue(
            "forum",
            requireArguments().getString("forum", "")
        )
    }

    override fun onBinding(binding: ActivityListBinding) {
        viewModel.goodClassify =
            requireParentFragment().getViewModel<ForumPageViewModel>().goodClassify

        ItemClickHelper.attachToRecyclerView(binding.recycler, OnItemClickListener {
            (it.item as? ThreadItem)?.run {
                findNavController().navigate(
                    ForumMainFragmentDirections.forumMainToThread(forum, tid)
                )
            }
            true
        })
        super.onBinding(binding)
    }
}