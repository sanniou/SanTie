package com.saniou.santieba.component

import androidx.databinding.ViewDataBinding
import com.saniou.santieba.R
import com.saniou.santieba.databinding.ActivityMsignBinding
import com.saniou.santieba.viewmodel.MsignViewModel
import com.sanniou.support.extensions.getViewModel
import com.sanniou.support.widget.recyclerview.PinnedHeaderItemDecoration
import kotlinx.android.synthetic.main.activity_msign.*

class MSignActivity : SanBaseActivity<MsignViewModel>() {

    override fun createViewModel() = getViewModel<MsignViewModel>()

    override fun getLayoutRes() = R.layout.activity_msign

    override fun onBindingCreated(binding: ViewDataBinding) {
        binding as ActivityMsignBinding
        binding.forumList
            .addItemDecoration(
                PinnedHeaderItemDecoration
                    .Builder(R.layout.item_msign_header)
                    .enableDivider(false)
                    .create()
            )

        viewModel.getForumList()
        msign_top.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}
