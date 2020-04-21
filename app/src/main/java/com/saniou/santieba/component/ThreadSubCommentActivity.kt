package com.saniou.santieba.component

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.saniou.santieba.R
import com.saniou.santieba.viewmodel.ThreadSubCommentViewModel
import com.sanniou.support.extensions.getViewModel
import kotlinx.android.synthetic.main.activity_thread_sub_comment.*

class ThreadSubCommentActivity : SanBaseActivity<ThreadSubCommentViewModel>() {


    override fun createViewModel() = getViewModel<ThreadSubCommentViewModel>()

    override fun getLayoutRes() = R.layout.activity_thread_sub_comment

    override fun onBindingCreated(binding: ViewDataBinding) {


        intent.getStringExtra("pid")?.run {
            viewModel.pid = this
        }
        intent.getStringExtra("tid")?.run {
            viewModel.threadId = this
        }
        viewModel.observeEventInt(this, Observer {
            when (it) {
                0 -> {
                    refresh.stopRefresh(true)
                }
                else -> {
                    refresh.stopRefresh(false)
                }
            }
        })

        refresh.post {
            refresh.startRefresh()
        }
    }
}
