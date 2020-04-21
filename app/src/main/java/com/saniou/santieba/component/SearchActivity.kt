package com.saniou.santieba.component

import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.blankj.utilcode.util.KeyboardUtils
import com.saniou.santieba.R
import com.saniou.santieba.viewmodel.SearchViewModel
import com.saniou.santieba.vo.SearchForumItem
import com.saniou.santieba.vo.SearchThreadItem
import com.sanniou.multiitemkit.MultiClickAdapter
import com.sanniou.multiitemkit.OnItemClickListener
import com.sanniou.multiitemkit.decoration.VerticalItemDecoration
import com.sanniou.multiitemkit.drawable.DividerDrawable
import com.sanniou.support.extensions.getColor
import com.sanniou.support.extensions.getViewModel
import com.sanniou.support.extensions.getdimension
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : SanBaseActivity<SearchViewModel>() {


    override fun createViewModel() = getViewModel<SearchViewModel>()

    override fun getLayoutRes() = R.layout.activity_search

    override fun onBindingCreated(binding: ViewDataBinding) {


        save.setOnClickListener { onBackPressed() }
        search_text.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                viewModel.startSearch()
                KeyboardUtils.hideSoftInput(search_text)
                return@setOnEditorActionListener true
            }
            false
        }
        tab_strip.setupWithViewPager(search_pager)
        search_pager.adapter = ListPagerAdapter()
        search_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
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
    }

    override fun onBackPressed() {
        KeyboardUtils.hideSoftInput(search_text)
        super.onBackPressed()
    }

    override fun onResume() {
        super.onResume()
        KeyboardUtils.showSoftInput(search_text)
    }

    inner class ListPagerAdapter : PagerAdapter() {

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            return RecyclerView(this@SearchActivity).apply {
                val listAdapter =
                    MultiClickAdapter(if (position == 0) viewModel.forumList else viewModel.threadList)
                listAdapter.itemClickListener = OnItemClickListener {
                    if (position == 0) {
                        (it.item as SearchForumItem).run {
                            val intent = Intent(this@SearchActivity, ForumMainActivity::class.java)
                            intent.putExtra("name", fname)
                            startActivity(intent)
                        }

                    } else {
                        (it.item as SearchThreadItem).run {
                            val intent =
                                Intent(this@SearchActivity, ThreadDetailActivity::class.java)
                            intent.putExtra("tid", tid)
                            intent.putExtra("outside", true)
                            startActivity(intent)
                        }
                    }
                    true
                }
                adapter = listAdapter
                layoutManager = LinearLayoutManager(this@SearchActivity)
                val drawable = DividerDrawable(
                    getdimension(R.dimen.divider_height).toInt(),
                    getColor(R.color.backgroundColorPress)
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
