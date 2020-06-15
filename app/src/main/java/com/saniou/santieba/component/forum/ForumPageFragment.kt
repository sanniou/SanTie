package com.saniou.santieba.component.forum

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.findNavController
import com.blankj.utilcode.util.LogUtils
import com.saniou.santieba.component.ListItemFragment
import com.saniou.santieba.databinding.ActivityListBinding
import com.saniou.santieba.viewmodel.ForumPageViewModel
import com.saniou.santieba.vo.ThreadItem
import com.sanniou.multiitemkit.ItemClickHelper
import com.sanniou.multiitemkit.OnItemClickListener
import com.sanniou.support.components.LiveDataForeverObserver
import com.sanniou.support.extensions.getViewModel

class ForumPageFragment : ListItemFragment<ForumPageViewModel>() {

    override fun getViewModelInstance(): ForumPageViewModel {
        return requireParentFragment().getViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        lifecycle.addObserver(object : LifecycleEventObserver {
            override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                LogUtils.e(this@ForumPageFragment.hashCode().toString() + event)
            }
        })

        viewLifecycleOwner.lifecycle.addObserver(object : LifecycleEventObserver {
            override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                LogUtils.e(this@ForumPageFragment.hashCode().toString() +" view "+ event)
            }
        })
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onBinding(binding: ActivityListBinding) {
        ItemClickHelper.attachToRecyclerView(binding.recycler, OnItemClickListener {
            (it.item as? ThreadItem?)?.run {
                findNavController().navigate(ForumMainFragmentDirections.forumMainToThread(tid))
            }
            true
        })
    }
}
