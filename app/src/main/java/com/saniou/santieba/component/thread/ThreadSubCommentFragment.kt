package com.saniou.santieba.component.thread

import android.os.Bundle
import android.view.View
import com.saniou.santieba.R
import com.saniou.santieba.component.ListItemFragment
import com.saniou.santieba.kts.changeMenu
import com.saniou.santieba.viewmodel.ThreadSubCommentViewModel
import com.sanniou.support.extensions.getViewModel

class ThreadSubCommentFragment : ListItemFragment<ThreadSubCommentViewModel>() {

    override fun createViewModel() = getViewModel<ThreadSubCommentViewModel>()
        .apply {
            setValue("pid", requireArguments().getString("pid")!!)
            setValue("tid", requireArguments().getString("tid")!!)
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        changeMenu(R.menu.empty)
        super.onViewCreated(view, savedInstanceState)
    }
}
