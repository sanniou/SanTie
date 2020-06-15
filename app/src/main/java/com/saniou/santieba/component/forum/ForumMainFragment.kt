package com.saniou.santieba.component.forum

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.saniou.santieba.R
import com.saniou.santieba.component.SanBaseFragment
import com.saniou.santieba.constant.TIEBA_FORUM_HOST
import com.saniou.santieba.constant.TIEBA_RANK_HOST
import com.saniou.santieba.databinding.FragmentForumMainBinding
import com.saniou.santieba.kts.changeMenu
import com.saniou.santieba.utils.openBrowser
import com.saniou.santieba.viewmodel.ForumPageViewModel
import com.sanniou.support.components.BaseViewModel
import com.sanniou.support.extensions.getViewModel

class ForumMainFragment : SanBaseFragment<ForumMainViewModel>() {

    override fun getLayoutRes() = R.layout.fragment_forum_main

    override fun createViewModel() =
        getViewModel<ForumMainViewModel>()

    override fun onBindingCreated(binding: ViewDataBinding) {
        binding as FragmentForumMainBinding
        binding.pageViewModel = getViewModel<ForumPageViewModel>()
            .apply {
                setValue("forum", requireArguments().getString("forum", ""))
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val forumBinding = binding as FragmentForumMainBinding
        changeMenu(R.menu.forum_detail, Observer { itemId ->
            when (itemId) {
                R.id.menu_unsubscribe -> {
                    forumBinding.pageViewModel?.unSubscribe()
                }
                R.id.menu_browser -> {
                    openBrowser(
                        requireContext(),
                        TIEBA_FORUM_HOST + forumBinding.pageViewModel?.forumInfo?.value?.forumName
                    )
                }
                R.id.menu_rank -> {
                    openBrowser(
                        requireContext(),
                        TIEBA_RANK_HOST + forumBinding.pageViewModel?.forumInfo?.value?.forumName + "&ie=utf-8"
                    )
                }
            }
        })

        (binding as FragmentForumMainBinding)
            .let { binding ->
                // saveState 有问题，save 之后 childFragment 会被remove,无法 restore
                // 所以禁用 save ，childFragment 由 parent 持有
                binding.forumPage.isSaveEnabled = false
                binding.forumPage.adapter = ForumMainAdapter(this, arguments, fs)
                binding.forumPage.post {
                    binding.forumTab.setScrollPosition(1, 0f, true);
                    binding.forumPage.setCurrentItem(1,false)
                }
            }
        super.onViewCreated(view, savedInstanceState)
    }

    private val fs by lazy {
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