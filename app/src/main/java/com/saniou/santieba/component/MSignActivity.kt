package com.saniou.santieba.component

import android.os.Bundle
import com.saniou.santieba.R
import com.saniou.santieba.databinding.ActivityMsignBinding
import com.saniou.santieba.kts.getViewModel
import com.saniou.santieba.kts.setDataBindingContentView
import com.saniou.santieba.viewmodel.MsignViewModel

class MSignActivity : SanBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = setDataBindingContentView<ActivityMsignBinding>(R.layout.activity_msign)
        val viewModel = getViewModel(MsignViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.bindLifecycleOwner(this)
        viewModel.getForumList()
    }

}
