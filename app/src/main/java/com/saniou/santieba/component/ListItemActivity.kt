package com.saniou.santieba.component

import android.content.Intent
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.blankj.utilcode.util.ActivityUtils
import com.saniou.santieba.R
import com.saniou.santieba.constant.BOOLEAN_FALSE
import com.saniou.santieba.databinding.ActivityListBinding
import com.saniou.santieba.databinding.toUser
import com.saniou.santieba.viewmodel.FansListViewModel
import com.saniou.santieba.viewmodel.FollowsListViewModel
import com.saniou.santieba.viewmodel.ForumListViewModel
import com.saniou.santieba.viewmodel.ListItemViewModel
import com.saniou.santieba.viewmodel.PostsListViewModel
import com.saniou.santieba.viewmodel.StoreListViewModel
import com.saniou.santieba.viewmodel.StoreThreadPageViewModel
import com.saniou.santieba.viewmodel.ThreadPageViewModel
import com.sanniou.support.extensions.getViewModel
import com.sanniou.support.widget.recyclerview.OnHeaderClickListener
import com.sanniou.support.widget.recyclerview.PinnedHeaderItemDecoration

private val LIST_CLASS = "class"
private val LIST_MAP = "map"
private val LIST_VIEW = "view"

interface ListItemView<T : ListItemViewModel> {
    fun onBinding(
        context: ListItemActivity,
        binding: ActivityListBinding,
        viewModel: T
    )

    fun getLayoutManager(context: ListItemActivity): RecyclerView.LayoutManager? = null
}

class ListItemActivity : SanBaseActivity<ListItemViewModel>() {

    override fun createViewModel() =
        getViewModel(intent.getSerializableExtra(LIST_CLASS) as Class<ListItemViewModel>).apply {
            initParam(intent.getSerializableExtra(LIST_MAP) as Map<String, String>)
        }

    override fun getLayoutRes() = R.layout.activity_list

    override fun onBindingCreated(binding: ViewDataBinding) {
        binding as ActivityListBinding
        var customerLayoutManager = false

        (intent.getSerializableExtra(LIST_VIEW) as? (Class<ListItemView<ListItemViewModel>>))
            ?.run {
                newInstance()
                    .apply {
                        onBinding(this@ListItemActivity, binding, viewModel)
                        getLayoutManager(this@ListItemActivity)
                            ?.apply {
                                customerLayoutManager = true
                                binding.recycler.layoutManager = this
                            }
                    }
            }
        binding.customerLayoutManager = customerLayoutManager

        binding.actionBar.setNavigationOnClickListener { onBackPressed() }
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
        if (viewModel.autoRefresh()) {
            binding.refresh.startRefresh()
        }
    }
}

fun toForum(forum: String) {
    val context = ActivityUtils.getTopActivity()
    val intent = Intent(context, ForumMainActivity::class.java)
    intent.putExtra("name", forum)
    context.startActivity(intent)
}

fun toStoreThreadPageList(
    tid: String,
    pid: String? = null,
    markState: String = BOOLEAN_FALSE
) {
    toListItemActivity {
        putExtra(LIST_CLASS, StoreThreadPageViewModel::class.java)
        putExtra(LIST_VIEW, ThreadPageView::class.java)
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
    toListItemActivity {
        putExtra(LIST_CLASS, ThreadPageViewModel::class.java)
        putExtra(LIST_VIEW, ThreadPageView::class.java)
        putExtra(LIST_MAP, HashMap<String, String>()
            .apply {
                put("tid", tid)
                outside?.let {
                    put("outside", it)
                }
            })
    }
}

fun toStoreList(uid: String) {
    toListItemActivity {
        putExtra(LIST_CLASS, StoreListViewModel::class.java)
        putExtra(LIST_VIEW, StoreView::class.java)
        putExtra(LIST_MAP, HashMap<String, String>()
            .apply {
                put("uid", uid)
            })
    }
}

fun toForumList(uid: String) {
    toListItemActivity {
        putExtra(LIST_CLASS, ForumListViewModel::class.java)
        putExtra(LIST_MAP, HashMap<String, String>()
            .apply {
                put("friendId", uid)
            })
    }
}

private fun toListItemActivity(block: Intent.() -> Unit) {
    ActivityUtils.startActivity(
        Intent(ActivityUtils.getTopActivity(), ListItemActivity::class.java)
            .apply(block)
    )
}

fun toFansList(uid: String = "") {
    ActivityUtils.startActivity(
        Intent(ActivityUtils.getTopActivity(), ListItemActivity::class.java)
            .apply {
                putExtra(LIST_CLASS, FansListViewModel::class.java)
                putExtra(LIST_MAP, HashMap<String, String>()
                    .apply {
                        put("friendId", uid)
                    })
            })
}

fun toPostsList(uid: String) {
    ActivityUtils.startActivity(
        Intent(ActivityUtils.getTopActivity(), ListItemActivity::class.java)
            .apply {
                putExtra(LIST_CLASS, PostsListViewModel::class.java)
                putExtra(LIST_MAP, HashMap<String, String>()
                    .apply {
                        put("uid", uid)
                    })
            })
}

fun toFollowsList(uid: String = "") {
    ActivityUtils.startActivity(
        Intent(ActivityUtils.getTopActivity(), ListItemActivity::class.java)
            .apply {
                putExtra(LIST_CLASS, FollowsListViewModel::class.java)
                putExtra(LIST_MAP, HashMap<String, String>()
                    .apply {
                        put("uid", uid)
                    })
            })
}