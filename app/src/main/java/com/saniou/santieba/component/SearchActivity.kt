package com.saniou.santieba.component

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.saniou.santieba.R
import com.saniou.santieba.databinding.ActivitySearchBinding
import com.saniou.santieba.kts.getViewModel
import com.saniou.santieba.kts.setDataBindingContentView
import com.saniou.santieba.viewmodel.SearchViewModel
import com.saniou.santieba.vo.ForumItem
import com.saniou.santieba.vo.SearchForumItem
import com.saniou.santieba.vo.SearchThreadItem
import com.sanniou.common.utilcode.util.ActivityUtils
import com.sanniou.common.utilcode.util.ResourcesUtils
import com.sanniou.common.widget.DividerDrawable
import com.sanniou.common.widget.recyclerview.ObservableListAdapter
import com.sanniou.common.widget.recyclerview.VerticalItemDecoration
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : SanBaseActivity() {

    lateinit var viewModel: SearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = setDataBindingContentView<ActivitySearchBinding>(R.layout.activity_search)
        viewModel = getViewModel()
        binding.viewModel = viewModel
        search_text.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                viewModel.startSearch()
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

    inner class ListPagerAdapter : PagerAdapter() {

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            return RecyclerView(this@SearchActivity).apply {
                val listAdapter =
                    ObservableListAdapter(if (position == 0) viewModel.forumList else viewModel.threadList)
                listAdapter.setOnItemClickListener {
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
                    ResourcesUtils.getDimension(R.dimen.divider_height),
                    ResourcesUtils.getColor(R.color.backgroundColorPress)
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
