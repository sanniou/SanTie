package com.saniou.santieba.component.forum

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.widget.ListPopupWindow
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.blankj.utilcode.util.SizeUtils
import com.google.android.material.tabs.TabLayout
import com.saniou.santieba.R
import com.saniou.santieba.component.SanBaseFragment
import com.saniou.santieba.constant.TIEBA_FORUM_HOST
import com.saniou.santieba.constant.TIEBA_RANK_HOST
import com.saniou.santieba.databinding.FragmentForumMainBinding
import com.saniou.santieba.kts.changeMenu
import com.saniou.santieba.model.api.reqeust.ForumSortType
import com.saniou.santieba.utils.openBrowser
import com.saniou.santieba.viewmodel.ForumPageViewModel
import com.saniou.santieba.viewmodel.ListItemViewModel
import com.sanniou.support.components.BaseViewModel
import com.sanniou.support.extensions.getViewModel
import java.util.ArrayList

class ForumMainFragment : SanBaseFragment<ForumMainViewModel>() {

    override fun getLayoutRes() = R.layout.fragment_forum_main

    override fun createViewModel() =
        getViewModel<ForumMainViewModel>()

    override fun onBindingCreated(binding: ViewDataBinding) {
        binding as FragmentForumMainBinding
        val pageViewModel = getViewModel<ForumPageViewModel>()
            .apply {
                setValue("forum", requireArguments().getString("forum", ""))
            }
        binding.pageViewModel = pageViewModel
        binding.run {
            forumSortText.setOnClickListener {
                val sorts: MutableList<String> = ArrayList()
                sorts.add(getString(R.string.title_sort_by_reply))
                sorts.add(getString(R.string.title_sort_by_send))
                sorts.add(getString(R.string.title_sort_by_like_user))
                val listPopupWindow = ListPopupWindow(requireContext())
                // PopupUtil.replaceBackground(listPopupWindow)
                listPopupWindow.anchorView = it
                val width = it.width + SizeUtils.dp2px(36F)
                listPopupWindow.width = width
                listPopupWindow.height = ViewGroup.LayoutParams.WRAP_CONTENT
                val arrayAdapter =
                    ArrayAdapter(requireContext(), R.layout.item_list_text, R.id.item_text_view, sorts)

                listPopupWindow.setAdapter(arrayAdapter)
                listPopupWindow.setOnItemClickListener { _, _, position: Int, _ ->
                    listPopupWindow.dismiss()
                    pageViewModel.setSortType(ForumSortType.valueOf(position))
                }
                listPopupWindow.show()
                // it.tag = listPopupWindow
            }

            // saveState 有问题，save 之后destroy时 childFragments 会被 remove,恢复之后无法 restore
            // 所以禁用 save ，childFragment 由 parent 持有
            forumPage.isSaveEnabled = false
            forumPage.adapter = ForumMainAdapter(this@ForumMainFragment, arguments, childs)
            // forumPage.post {
            forumPage.setCurrentItem(1, false)
            // }
            forumTab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabReselected(tab: TabLayout.Tab) {
                    childs[tab.position].viewModel.startRefresh.value = Unit
                }

                override fun onTabUnselected(tab: TabLayout.Tab) {
                }

                override fun onTabSelected(tab: TabLayout.Tab) {
                }
            })
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val forumBinding = binding as FragmentForumMainBinding
        changeMenu(R.menu.forum_detail, Observer { itemId ->
            when (itemId) {
                R.id.menu_unsubscribe -> forumBinding.pageViewModel?.unSubscribe()
                R.id.menu_browser -> openBrowser(
                    requireContext(),
                    TIEBA_FORUM_HOST + forumBinding.pageViewModel?.forumInfo?.value?.forumName
                )
                R.id.menu_rank -> openBrowser(
                    requireContext(),
                    TIEBA_RANK_HOST + forumBinding.pageViewModel?.forumInfo?.value?.forumName + "&ie=utf-8"
                )
            }
        })
        super.onViewCreated(view, savedInstanceState)
    }

    private val childs by lazy {
        arrayOf(
            ForumInfoFragment().also { it.arguments = arguments },
            ForumPageFragment().also { it.arguments = arguments },
            ForumGoodFragment().also { it.arguments = arguments })
    }
}

class ForumMainAdapter(fragment: Fragment, val bundle: Bundle?, val fs: Array<out Fragment>) :
    FragmentStateAdapter(fragment) {

    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> fs[0]
            1 -> fs[1]
            else -> fs[2]

        }
    }
}

class ForumMainViewModel : BaseViewModel() {
    val titles = listOf(null, "帖子", "精品")
    val icons = listOf(R.drawable.ic_round_info)
}