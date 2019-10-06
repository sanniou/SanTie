package com.saniou.santieba.component

import android.os.Bundle
import com.saniou.santieba.R
import com.saniou.santieba.databinding.ActivityMsignBinding
import com.saniou.santieba.kts.getViewModel
import com.saniou.santieba.kts.setDataBindingContentView
import com.saniou.santieba.viewmodel.MsignViewModel
import kotlinx.android.synthetic.main.activity_msign.*

class MSignActivity : SanBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = setDataBindingContentView<ActivityMsignBinding>(R.layout.activity_msign)
        val viewModel = getViewModel<MsignViewModel>()
        binding.viewModel = viewModel
        viewModel.bindLifecycleOwner(this)
        viewModel.getForumList()
        msign_top.setNavigationOnClickListener {
            onBackClick(it)
        }
    }

}
