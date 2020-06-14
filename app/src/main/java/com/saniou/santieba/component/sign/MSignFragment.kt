package com.saniou.santieba.component.sign

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import com.saniou.santieba.R
import com.saniou.santieba.component.SanBaseFragment
import com.saniou.santieba.databinding.FragmentMsignBinding
import com.saniou.santieba.kts.changeMenu
import com.saniou.santieba.viewmodel.MsignViewModel
import com.sanniou.support.extensions.getViewModel
import com.sanniou.support.widget.recyclerview.PinnedHeaderItemDecoration

class MSignFragment : SanBaseFragment<MsignViewModel>() {

    override fun createViewModel() = getViewModel<MsignViewModel>()

    override fun getLayoutRes() = R.layout.fragment_msign

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        changeMenu(R.menu.empty)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onBindingCreated(binding: ViewDataBinding) {
        binding as FragmentMsignBinding
        binding.forumList
            .addItemDecoration(
                PinnedHeaderItemDecoration
                    .Builder(R.layout.item_simple_header)
                    .enableDivider(false)
                    .create()
            )

        viewModel.getForumList()
    }
}
