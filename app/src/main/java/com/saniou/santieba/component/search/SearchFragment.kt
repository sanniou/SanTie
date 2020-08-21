package com.saniou.santieba.component.search

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.activity.OnBackPressedCallback
import androidx.databinding.ViewDataBinding
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.blankj.utilcode.util.KeyboardUtils
import com.saniou.santieba.R
import com.saniou.santieba.component.SanBaseFragment
import com.saniou.santieba.databinding.FragmentSearchBinding
import com.saniou.santieba.kts.changeMenu
import com.saniou.santieba.viewmodel.SearchViewModel
import com.saniou.santieba.vo.SearchForumItem
import com.saniou.santieba.vo.SearchThreadItem
import com.sanniou.multiitem.MultiItemAdapter
import com.sanniou.multiitemkit.ItemClickHelper
import com.sanniou.multiitemkit.OnItemClickListener
import com.sanniou.multiitemkit.decoration.VerticalItemDecoration
import com.sanniou.multiitemkit.drawable.DividerDrawable
import com.sanniou.support.extensions.getColor
import com.sanniou.support.extensions.getViewModel
import com.sanniou.support.extensions.getdimension

class SearchFragment : SanBaseFragment<SearchViewModel>() {

    override fun createViewModel() = getViewModel<SearchViewModel>()

    override fun getLayoutRes() = R.layout.fragment_search

    override fun onBindingCreated(binding: ViewDataBinding) {
        binding as FragmentSearchBinding
        binding.searchText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                viewModel.startSearch()
                KeyboardUtils.hideSoftInput(binding.searchText)
                return@setOnEditorActionListener true
            }
            false
        }
        binding.tabStrip.setupWithViewPager(binding.searchPager)
        binding.searchPager.adapter = ListPagerAdapter()
        binding.searchPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                viewModel.currentTab = position
                viewModel.startSearch()
            }
        })

        KeyboardUtils.showSoftInput(binding.searchText)
    }

    override fun onDestroyView() {
        KeyboardUtils.hideSoftInput(requireActivity())
        super.onDestroyView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        changeMenu(R.menu.empty)
        super.onViewCreated(view, savedInstanceState)
    }

    inner class ListPagerAdapter : PagerAdapter() {

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            return RecyclerView(requireContext()).apply {
                val listAdapter =
                    MultiItemAdapter(if (position == 0) viewModel.forumList else viewModel.threadList)

                ItemClickHelper.attachToRecyclerView(this,
                    OnItemClickListener {
                        if (position == 0) {
                            (it.item as SearchForumItem).run {
                                this@SearchFragment.findNavController()
                                    .navigate(
                                        SearchFragmentDirections.actionSearchFragmentToForumMain(
                                            fname.toString()
                                        )
                                    )
                            }
                        } else {
                            (it.item as SearchThreadItem).run {
                                this@SearchFragment.findNavController()
                                    .navigate(
                                        SearchFragmentDirections.actionSearchFragmentToThreadPage(forum.toString(),
                                            tid
                                        )
                                    )
                            }
                        }
                        true
                    })

                adapter = listAdapter
                layoutManager = LinearLayoutManager(requireContext())
                val drawable = DividerDrawable(
                    getdimension(R.dimen.divider_height).toInt(),
                    getColor(R.color.shadowColor)
                )
                addItemDecoration(
                    VerticalItemDecoration.Builder(context)
                        .common(drawable)
                        .create()
                )
                container.addView(this)
            }
        }

        override fun getPageTitle(position: Int) = if (position == 0) "搜吧" else "搜贴"

        override fun isViewFromObject(view: View, view2: Any) = view == view2

        override fun getCount() = 2
    }
}
