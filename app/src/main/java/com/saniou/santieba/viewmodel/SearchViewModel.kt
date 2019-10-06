package com.saniou.santieba.viewmodel

import android.annotation.SuppressLint
import android.text.Html
import com.saniou.santieba.NoNullLiveData
import com.saniou.santieba.api.TiebaRequest
import com.saniou.santieba.constant.BOOLEAN_TRUE
import com.saniou.santieba.kts.getDisplayTime
import com.saniou.santieba.kts.removeLast
import com.saniou.santieba.utils.StringUtil
import com.saniou.santieba.vo.OnLoadListener
import com.saniou.santieba.vo.SanLoadMoreItem
import com.saniou.santieba.vo.SearchForumItem
import com.saniou.santieba.vo.SearchThreadItem
import com.sanniou.common.component.NetWorkViewModel
import com.sanniou.common.databinding.DataBindingArrayList
import com.sanniou.common.helper.ListUtil
import com.sanniou.common.network.exception.ExceptionEngine
import com.sanniou.common.utilcode.util.ToastUtils
import com.sanniou.common.vo.LoadCallBack
import com.sanniou.common.widget.recyclerview.Item

@SuppressLint("CheckResult")
class SearchViewModel : NetWorkViewModel() {

    val threadList = DataBindingArrayList<Item>()
    val forumList = DataBindingArrayList<Item>()

    val searchText = NoNullLiveData("")
    var currentTab = 0
    private var lastForumKey = ""
    private var lastThreadKey = ""
    private val threadLoadMoreItem: SanLoadMoreItem
    private val forumLoadMoreItem: SanLoadMoreItem

    init {
        forumLoadMoreItem = SanLoadMoreItem(object : OnLoadListener {
            override fun onLoad(page: Int, callBack: LoadCallBack) {
                if (currentTab != 0) {
                    callBack.loadSuccess(false)
                    return
                }
                if (searchText.value.isBlank()) {
                    callBack.loadSuccess(false)
                    return
                }
                searchForum(page.toString())
            }
        })
        threadLoadMoreItem = SanLoadMoreItem(object : OnLoadListener {
            override fun onLoad(page: Int, callBack: LoadCallBack) {
                if (currentTab != 1) {
                    callBack.loadSuccess(false)
                    return
                }
                if (searchText.value.isBlank()) {
                    callBack.loadSuccess(false)
                    return
                }
                searchThread(page.toString())
            }
        })
        threadList.add(threadLoadMoreItem)
        forumList.add(forumLoadMoreItem)
    }

    fun startSearch() {
        if (currentTab == 0) {
            if (lastForumKey != searchText.value) {
                forumList.clear()
                forumList.add(forumLoadMoreItem)
                forumLoadMoreItem.firstLoad()
            }
        } else {
            if (lastThreadKey != searchText.value) {
                threadList.clear()
                threadList.add(threadLoadMoreItem)
                threadLoadMoreItem.firstLoad()
            }
        }
    }

    private fun searchThread(pageNo: String) {
        TiebaRequest.searchpost(pageNo, searchText.value)
            .`as`(bindLifeEvent())
            .subscribe({ threadData ->
                ListUtil.removeLast(threadList)
                lastThreadKey = searchText.value
                threadData.post_list.forEach {
                    threadList.add(
                        SearchThreadItem(
                            Html.fromHtml(it.title),
                            Html.fromHtml(it.content),
                            getDisplayTime(it.time),
                            it.author.name_show,
                            0,
                            it.is_floor == BOOLEAN_TRUE,
                            it.is_replay == BOOLEAN_TRUE,
                            it.pid,
                            it.tid,
                            it.fname
                        )
                    )
                }
                threadList.add(threadLoadMoreItem)
                threadLoadMoreItem.loadSuccess(threadData.page.has_more == 1)
            }) {
                ToastUtils.showShort(ExceptionEngine.handleMessage(it))
                threadLoadMoreItem.loadFailed()
            }

    }

    private fun searchForum(pageNo: String) {
        TiebaRequest.searchForum(searchText.value)
            .`as`(bindLifeEvent())
            .subscribe({ forumData ->
                ListUtil.removeLast(forumList)
                lastForumKey = searchText.value
                forumData.fname.forEach {
                    forumList.add(
                        SearchForumItem(it)
                    )
                }
                forumList.add(forumLoadMoreItem)
                forumLoadMoreItem.loadSuccess(false)
            }) {
                ToastUtils.showShort(ExceptionEngine.handleMessage(it))
                forumLoadMoreItem.loadFailed()
            }
    }
}