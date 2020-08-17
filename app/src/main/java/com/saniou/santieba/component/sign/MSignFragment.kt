package com.saniou.santieba.component.sign

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.navigation.fragment.findNavController
import com.saniou.santieba.R
import com.saniou.santieba.component.HomeFragmentDirections
import com.saniou.santieba.component.SanBaseFragment
import com.saniou.santieba.databinding.FragmentMsignBinding
import com.saniou.santieba.kts.changeMenu
import com.saniou.santieba.viewmodel.MsignViewModel
import com.saniou.santieba.vo.ForumItem
import com.saniou.santieba.vo.SimpleForumItem
import com.sanniou.multiitemkit.ItemClickHelper
import com.sanniou.multiitemkit.OnItemClickListener
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

        ItemClickHelper.attachToRecyclerView(
            binding.forumList,
            OnItemClickListener {
                when (val data = it.item) {
                    is SimpleForumItem -> {
                        findNavController().navigate(
                            MSignFragmentDirections.actionUserMsignToForumMain(data.forumName)
                        )
                    }
                    else -> {
                    }
                }
                false
            }
        )
        viewModel.getForumList()
    }
}
