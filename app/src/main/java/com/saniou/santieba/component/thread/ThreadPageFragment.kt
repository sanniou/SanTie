package com.saniou.santieba.component.thread

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blankj.utilcode.util.ActivityUtils
import com.blankj.utilcode.util.IntentUtils
import com.blankj.utilcode.util.ToastUtils
import com.google.android.material.appbar.MaterialToolbar
import com.saniou.santieba.R
import com.saniou.santieba.component.ImagePreviewActivity
import com.saniou.santieba.component.ListItemFragment
import com.saniou.santieba.constant.MENU_COLOR
import com.saniou.santieba.constant.TIEBA_HOST
import com.saniou.santieba.databinding.ActivityListBinding
import com.saniou.santieba.dialog.LMessageDialog
import com.saniou.santieba.kts.changeMenu
import com.saniou.santieba.kts.tintDrawable
import com.saniou.santieba.utils.ClipboardUtils
import com.saniou.santieba.utils.openBrowser
import com.saniou.santieba.viewmodel.PageViewModel
import com.saniou.santieba.viewmodel.StoreThreadPageViewModel
import com.saniou.santieba.viewmodel.ThreadPageViewModel
import com.saniou.santieba.vo.CommentImageItem
import com.saniou.santieba.vo.FloorTopItem
import com.saniou.santieba.vo.SubCommentItem
import com.sanniou.multiitemkit.ItemClickHelper
import com.sanniou.multiitemkit.OnItemClickListener
import com.sanniou.support.extensions.getViewModel
import com.sanniou.support.utils.ResourcesUtils
import kotlinx.coroutines.launch

class ThreadPageFragment : ListItemFragment<PageViewModel>() {

    var top: Int = 0
    var viewHolder: RecyclerView.ViewHolder? = null

    override fun getViewModelInstance() =
        if (requireArguments().getString("markState") == null) createThreadPageViewModel() else createStoreThreadPageViewModel()

    private fun createThreadPageViewModel() =
        getViewModel<ThreadPageViewModel>()
            .apply {
                setValue("tid", requireArguments().getString("tid")!!)
            }

    private fun createStoreThreadPageViewModel() =
        getViewModel<StoreThreadPageViewModel>()
            .apply {
                val arguments = requireArguments()
                setValue("tid", arguments.getString("tid")!!)
                setValue("markState", arguments.getString("markState")!!)
                setValue("pid", arguments.getString("pid")!!)
            }

    fun onBackPressed() {
        if (!viewModel.store.value) {
            findNavController().navigateUp()
            return
        }
        findFirstFloor(binding as ActivityListBinding)
            .also {
                LMessageDialog(requireContext())
                    .setMessage("是否更新收藏到${it.floor}")
                    .okListener { _, _ ->
                        launch {
                            viewModel.addStore(it.pid)
                            findNavController().navigateUp()
                        }
                    }
                    .cancelListener { _, _ ->
                        findNavController().navigateUp()
                    }
                    .show()
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        changeMenu(R.menu.thread_detail, Observer { itemId ->
            when (itemId) {
                R.id.menu_single -> {
                    viewModel.run {
                        lzOly.value = !lzOly.value
                        refresh()
                    }
                }
                R.id.menu_reverse -> {
                    viewModel.run {
                        reverse.value = !reverse.value
                        refresh()
                    }
                }
                R.id.menu_store -> {
                    if (viewModel.store.value) {
                        viewModel.rmStore()
                    } else {
                        launch {
                            viewModel.addStore(findFirstPid(binding as ActivityListBinding))
                        }
                    }
                }
                R.id.menu_share -> {
                    ActivityUtils.startActivity(IntentUtils.getShareTextIntent(TIEBA_HOST + viewModel.tid))
                }
                R.id.menu_link -> {
                    ClipboardUtils.copyText(TIEBA_HOST + viewModel.tid)
                    ToastUtils.showShort(R.string.copied_to_clipboard)
                }
                R.id.menu_browser -> {
                    openBrowser(requireContext(), TIEBA_HOST + viewModel.tid)
                }
            }
        })
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onBinding(binding: ActivityListBinding) {

        requireActivity().onBackPressedDispatcher.addCallback(this, object :
            OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                onBackPressed()
            }
        })
        viewModel.reverseLayoutPosition.observe(this, Observer {
            when (it) {
                -1 -> top = binding.recycler
                    .findViewHolderForAdapterPosition(viewModel.getReverseStartPosition())
                    .apply { viewHolder = this }
                    ?.itemView?.run { top } ?: 0

                else -> (binding.recycler.layoutManager as LinearLayoutManager)
                    .scrollToPositionWithOffset(viewHolder!!.adapterPosition, top)
            }

        })

        viewModel.store.observe(this, Observer {
            findMenuItem(R.id.menu_store)?.icon =
                if (it)
                    ResourcesUtils.getDrawable(R.drawable.ic_thread_store)!!
                        .tintDrawable(MENU_COLOR)
                else
                    ResourcesUtils.getDrawable(R.drawable.ic_thread_store)
        })

        viewModel.lzOly.observe(this, Observer {
            findMenuItem(R.id.menu_single)?.icon =
                if (it)
                    ResourcesUtils.getDrawable(R.drawable.ic_lz_only)!!
                        .tintDrawable(MENU_COLOR)
                else
                    ResourcesUtils.getDrawable(R.drawable.ic_lz_only)
        })
        viewModel.reverse.observe(this, Observer {
            findMenuItem(R.id.menu_reverse)?.icon =
                if (it)
                    ResourcesUtils.getDrawable(R.drawable.ic_order)!!
                        .tintDrawable(MENU_COLOR)
                else
                    ResourcesUtils.getDrawable(R.drawable.ic_order)
        })


        ItemClickHelper.attachToRecyclerView(binding.recycler, OnItemClickListener {
            when (val item = it.item) {
                is SubCommentItem ->
                    findNavController().navigate(
                        ThreadPageFragmentDirections.forumThreadToSubThread(
                            item.threadId,
                            item.pid
                        )
                    )

                is CommentImageItem ->
                    ImagePreviewActivity.imagePreview(
                        viewModel.imageList.indexOf(item.orgImage),
                        viewModel.imageList,
                        it.itemView as ImageView
                    )

            }

            false
        })
    }

    private fun findMenuItem(id: Int) =
        (activity?.findViewById<MaterialToolbar>(R.id.action_bar))?.menu?.findItem(id)

    private fun findFirstFloor(binding: ActivityListBinding): FloorTopItem {
        val firstPosition = (binding.recycler.layoutManager as LinearLayoutManager)
            .findFirstCompletelyVisibleItemPosition()
        viewModel.list.subList(firstPosition, viewModel.list.size)
            .forEach { item ->
                if (item is FloorTopItem && item.floor != 1)
                    return item
            }
        return viewModel.list[1] as FloorTopItem
    }

    private fun findFirstPid(binding: ActivityListBinding) = findFirstFloor(binding).pid
}
