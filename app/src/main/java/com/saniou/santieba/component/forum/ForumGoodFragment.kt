package com.saniou.santieba.component.forum

import com.saniou.santieba.component.ListItemFragment
import com.saniou.santieba.databinding.ActivityListBinding
import com.saniou.santieba.viewmodel.ForumGoodViewModel
import com.saniou.santieba.viewmodel.ForumPageViewModel
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
        super.onBinding(binding)
    }
}