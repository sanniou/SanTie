package com.saniou.santieba.component

import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.blankj.utilcode.util.ActivityUtils
import com.saniou.santieba.R
import com.saniou.santieba.constant.BOOLEAN_FALSE
import com.saniou.santieba.databinding.ActivityListBinding
import com.saniou.santieba.viewmodel.FansListViewModel
import com.saniou.santieba.viewmodel.FollowsListViewModel
import com.saniou.santieba.viewmodel.ForumListViewModel
import com.saniou.santieba.viewmodel.ListItemViewModel
import com.saniou.santieba.viewmodel.PostsListViewModel
import com.saniou.santieba.viewmodel.ReplyListViewModel
import com.saniou.santieba.viewmodel.StoreListViewModel
import com.saniou.santieba.viewmodel.StoreThreadPageViewModel
import com.saniou.santieba.viewmodel.ThreadPageViewModel
import com.sanniou.support.extensions.getViewModel
import com.sanniou.support.widget.recyclerview.OnHeaderClickListener
import com.sanniou.support.widget.recyclerview.PinnedHeaderItemDecoration

open class ListItemActivity<T : ListItemViewModel> : SanBaseActivity<T>() {

    open fun getLayoutManager(): RecyclerView.LayoutManager? = null

    open fun onBinding(binding: ActivityListBinding) = Unit

    override fun createViewModel() =
        getViewModel(intent.getSerializableExtra(LIST_VIEW_MODEL) as Class<T>).apply {
            initParam(intent.getSerializableExtra(LIST_MAP) as Map<String, String>)
        }

    override fun getLayoutRes() = R.layout.activity_list

    final override fun onBindingCreated(binding: ViewDataBinding) {
        binding as ActivityListBinding

        onBinding(binding)

        var customerLayoutManager = false
        getLayoutManager()
            ?.apply {
                customerLayoutManager = true
                binding.recycler.layoutManager = this
            }

        binding.customerLayoutManager = customerLayoutManager

        // binding.actionBar.setNavigationOnClickListener { onBackPressed() }
        if (viewModel.getHeaderType() > 0) {
            binding.recycler.addItemDecoration(
                PinnedHeaderItemDecoration
                    .Builder(viewModel.getHeaderType())
                    .enableDivider(false)
                    .setClickIds(*viewModel.getHeaderClickable())
                    .setHeaderClickListener(object : OnHeaderClickListener {
                        override fun onHeaderLongClick(view: View?, id: Int, position: Int) {
                            viewModel.handlerHeaderLongClick(id, position)
                        }

                        override fun onHeaderClick(view: View?, id: Int, position: Int) {
                            viewModel.handlerHeaderClick(id, position)
                        }
                    })
                    .create()
            )
        }
        if (viewModel.autoRefresh) {
            viewModel.refresh()
        }
    }
}

fun toForum(forum: String) {
    // val context = ActivityUtils.getTopActivity()
    // val intent = Intent(context, ForumMainActivity::class.java)
    // intent.putExtra("name", forum)
    // context.startActivity(intent)
}

fun toStoreThreadPageList(
    tid: String,
    pid: String? = null,
    markState: String = BOOLEAN_FALSE
) {
    toListItemActivity(ThreadPageViewActivity::class.java) {
        putExtra(LIST_VIEW_MODEL, StoreThreadPageViewModel::class.java)
        putExtra(LIST_MAP, HashMap<String, String>()
            .apply {
                put("tid", tid)
                put("markState", markState)
                pid?.let {
                    put("pid", it)
                }
            })
    }
}

fun toThreadPageList(
    tid: String,
    outside: String? = null
) {
    toListItemActivity(ThreadPageViewActivity::class.java) {
        putExtra(LIST_VIEW_MODEL, ThreadPageViewModel::class.java)
        putExtra(LIST_MAP, HashMap<String, String>()
            .apply {
                put("tid", tid)
                outside?.let {
                    put("outside", it)
                }
            })
    }
}

// fun toStoreList(uid: String) {
//     toListItemActivity(StoreViewActivity::class.java) {
//         putExtra(LIST_VIEW_MODEL, StoreListViewModel::class.java)
//         putExtra(LIST_MAP, HashMap<String, String>()
//             .apply {
//                 put("uid", uid)
//             })
//     }
// }

fun toForumList(uid: String) {
    toListItemActivity {
        putExtra(LIST_VIEW_MODEL, ForumListViewModel::class.java)
        putExtra(LIST_MAP, HashMap<String, String>()
            .apply {
                put("friendId", uid)
            })
    }
}

private fun toListItemActivity(
    activity: Class<out Activity> = ListItemActivity::class.java,
    block: Intent.() -> Unit
) {
    ActivityUtils.startActivity(
        Intent(ActivityUtils.getTopActivity(), activity)
            .apply(block)
    )
}

fun toFansList(uid: String = "") {
    toListItemActivity {
        putExtra(LIST_VIEW_MODEL, FansListViewModel::class.java)
        putExtra(LIST_MAP, HashMap<String, String>()
            .apply {
                put("friendId", uid)
            })
    }
}

fun toReplyList(uid: String) {
    toListItemActivity {
        putExtra(LIST_VIEW_MODEL, ReplyListViewModel::class.java)
        putExtra(LIST_MAP, HashMap<String, String>()
            .apply {
                put("uid", uid)
            })
    }
}

fun toPostsList(uid: String) {
    toListItemActivity {
        putExtra(LIST_VIEW_MODEL, PostsListViewModel::class.java)
        putExtra(LIST_MAP, HashMap<String, String>()
            .apply {
                put("uid", uid)
            })
    }
}

fun toFollowsList(uid: String = "") {
    toListItemActivity {
        putExtra(LIST_VIEW_MODEL, FollowsListViewModel::class.java)
        putExtra(LIST_MAP, HashMap<String, String>()
            .apply {
                put("uid", uid)
            })
    }
}