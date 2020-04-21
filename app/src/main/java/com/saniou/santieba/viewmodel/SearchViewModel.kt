package com.saniou.santieba.viewmodel

import android.text.Html
import com.blankj.utilcode.util.ToastUtils
import com.saniou.santieba.api.TiebaRequest
import com.saniou.santieba.kts.getDisplayTime
import com.saniou.santieba.kts.toBool
import com.saniou.santieba.vo.OnLoadListener
import com.saniou.santieba.vo.SanLoadMoreItem
import com.saniou.santieba.vo.SearchForumItem
import com.saniou.santieba.vo.SearchThreadItem
import com.sanniou.multiitem.DataItem
import com.sanniou.multiitem.MultiItemArrayList
import com.sanniou.multiitemkit.vo.LoadCallBack
import com.sanniou.support.components.BaseViewModel
import com.sanniou.support.exception.ExceptionEngine
import com.sanniou.support.extensions.deleteLast
import com.sanniou.support.lifecycle.NonNullLiveData

class SearchViewModel : BaseViewModel() {

    val threadList = MultiItemArrayList<DataItem>()
    val forumList = MultiItemArrayList<DataItem>()

    val searchText = NonNullLiveData("")
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
        launch {
            try {
                TiebaRequest.searchpost(pageNo, searchText.value)
                    .let { threadData ->
                        threadList.deleteLast()
                        lastThreadKey = searchText.value
                        threadData.postList.forEach {
                            threadList.add(
                                SearchThreadItem(
                                    Html.fromHtml(it.title),
                                    Html.fromHtml(it.content),
                                    getDisplayTime(it.time),
                                    it.author.nameShow,
                                    0,
                                    it.isFloor.toBool(),
                                    it.isReplay.toBool(),
                                    it.pid,
                                    it.tid,
                                    it.fname
                                )
                            )
                        }
                        threadList.add(threadLoadMoreItem)
                        threadLoadMoreItem.loadSuccess(threadData.page.hasMore.toBool())
                    }
            } catch (e: Exception) {
                ToastUtils.showShort(ExceptionEngine.handleMessage(e))
                threadLoadMoreItem.loadFailed()
            }
        }
    }

    private fun searchForum(pageNo: String) {
        launch {
            try {
                TiebaRequest.searchForum(searchText.value)
                    .let { forumData ->
                        forumList.deleteLast()
                        lastForumKey = searchText.value
                        forumData.fname.forEach {
                            forumList.add(
                                SearchForumItem(it)
                            )
                        }
                        forumList.add(forumLoadMoreItem)
                        forumLoadMoreItem.loadSuccess(false)
                    }
            } catch (e: Exception) {
                ToastUtils.showShort(ExceptionEngine.handleMessage(e))
                forumLoadMoreItem.loadFailed()
            }
        }
    }
}
