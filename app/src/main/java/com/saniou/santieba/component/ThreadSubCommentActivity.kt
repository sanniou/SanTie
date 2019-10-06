package com.saniou.santieba.component

import android.os.Bundle
import androidx.lifecycle.Observer
import com.saniou.santieba.R
import com.saniou.santieba.databinding.ActivityThreadSubCommentBinding
import com.saniou.santieba.kts.getViewModel
import com.saniou.santieba.kts.setDataBindingContentView
import com.saniou.santieba.viewmodel.ThreadSubCommentViewModel

class ThreadSubCommentActivity : SanBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            setDataBindingContentView<ActivityThreadSubCommentBinding>(R.layout.activity_thread_sub_comment)
        val model = getViewModel<ThreadSubCommentViewModel>()
        binding.viewModel = model
        intent.getStringExtra("pid")?.run {
            model.pid = this
        }
        intent.getStringExtra("tid")?.run {
            model.threadId = this
        }
        model.observeForever(this, Observer {
            when (it) {
                0 -> {
                    binding.refresh.stopRefresh(true)
                }
                else -> {
                    binding.refresh.stopRefresh(false)
                }
            }
        })

        binding.refresh.post {
            binding.refresh.startRefresh()
        }
    }
}
