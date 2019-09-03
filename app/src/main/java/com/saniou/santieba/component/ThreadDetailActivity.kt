package com.saniou.santieba.component

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.saniou.santieba.R
import com.saniou.santieba.databinding.ActivityThreadDatailBinding
import com.saniou.santieba.kts.getViewModel
import com.saniou.santieba.kts.setDataBindingContentView
import com.saniou.santieba.viewmodel.ThreadDetailViewModel
import com.saniou.santieba.vo.SubCommentItem

class ThreadDetailActivity : SanBaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tiebaLinkFilter()

        val binding =
            setDataBindingContentView<ActivityThreadDatailBinding>(R.layout.activity_thread_datail)
        binding.setClickListener { holder ->
            when (val item = holder.item) {
                is SubCommentItem -> {
                    val intent = Intent(this, ThreadSubCommentActivity::class.java)
                    intent.putExtra("pid", item.pid)
                    intent.putExtra("tid", item.threadId)
                    startActivity(intent)
                }
            }

            true
        }
        val tid = intent.getStringExtra("tid")
        tid?.let {
            val viewModel = getViewModel(ThreadDetailViewModel::class.java)
            viewModel.observeForever(this, Observer {
                when (it) {
                    0 -> {
                        binding.refresh.stopRefresh(true)
                    }
                    else -> {
                        binding.refresh.stopRefresh(false)
                    }
                }
            })
            viewModel.tid = tid
            binding.viewModel = viewModel
            viewModel.init()
        } ?: finish()
    }

    private fun tiebaLinkFilter() {
        if ("android.intent.action.VIEW" == intent.action) {
            if ("tbpb" == intent.scheme) {
                val uri = intent.data!!.toString()
                if (uri.startsWith("tbpb://tieba.baidu.com/")) {
                    intent.putExtra("tid", uri.replace(".*tid=(\\d*)".toRegex(), "$1"))
                }
            }
        }
    }
}

