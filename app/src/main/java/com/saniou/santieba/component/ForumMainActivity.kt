package com.saniou.santieba.component

import android.os.Bundle
import androidx.lifecycle.Observer
import com.saniou.santieba.R
import com.saniou.santieba.databinding.ActivityForumMainBinding
import com.saniou.santieba.kts.getViewModel
import com.saniou.santieba.kts.setDataBindingContentView
import com.saniou.santieba.viewmodel.ForumMainViewModel
import com.sanniou.common.utilcode.util.ToastUtils
import java.io.UnsupportedEncodingException
import java.net.URLDecoder

class ForumMainActivity : SanBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tiebaLinkFilter()

        val binding =
            setDataBindingContentView<ActivityForumMainBinding>(R.layout.activity_forum_main)
        val name = intent.getStringExtra("name")
        name?.run {
            val viewModel = getViewModel(ForumMainViewModel::class.java)
            binding.viewModel = viewModel
            viewModel.observeForever(this@ForumMainActivity, Observer {
                when (it) {
                    0 -> {
                        binding.refresh.stopRefresh(true)
                    }
                    1 -> {
                        binding.refresh.stopRefresh(false)
                    }
                }

            })
            viewModel.name = name
            viewModel.init()
            binding.setRefreshListener {
                viewModel.init()
            }
        } ?: run {
            ToastUtils.showShort("no forum name")
            finish()
        }
    }

    private fun tiebaLinkFilter() {
        val intent = intent
        if ("android.intent.action.VIEW" == intent.action) {
            if ("tbfrs" == intent.scheme) {
                val decode = URLDecoder.decode(intent.data!!.toString(), "UTF-8")
                intent.putExtra(
                    "forum_name",
                    decode.substring(decode.indexOf("kw=") + 3, decode.length)
                )


            }
        }
    }
}
