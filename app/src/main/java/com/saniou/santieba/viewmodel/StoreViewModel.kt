package com.saniou.santieba.viewmodel

import com.blankj.utilcode.util.ToastUtils
import com.saniou.santieba.api.TiebaRequest
import com.saniou.santieba.api.bean.MEDIA_TYPE_FLASH
import com.saniou.santieba.api.bean.MEDIA_TYPE_PIC
import com.saniou.santieba.constant.EVENT_UI_REFRESH_FAILED
import com.saniou.santieba.constant.EVENT_UI_REFRESH_SUCCESS
import com.saniou.santieba.constant.PORTRAIT_HOST
import com.saniou.santieba.constant.RANGE_NUMBER
import com.saniou.santieba.kts.getDisplayTime
import com.saniou.santieba.kts.toBool
import com.saniou.santieba.vo.StoreThreadItem
import com.sanniou.multiitemkit.vo.LoadMoreItem
import com.sanniou.support.components.BaseListViewModel
import com.sanniou.support.exception.ExceptionEngine
import com.sanniou.support.extensions.deleteLast

class StoreViewModel : BaseListViewModel() {

    private val loadMoreItem = LoadMoreItem { threadStore(mPageNum) }
    var uId: String = ""
    private var mPageNum = 1

    fun init() {
        clear()
        mPageNum = 1
        loadMoreItem.ready()
        add(loadMoreItem)
    }

    private fun threadStore(pageNumber: Int) {
        launch {
            try {
                TiebaRequest.threadstore(pageNumber, uId)
                    .let { threadData ->
                        mPageNum++
                        list.deleteLast()

                        threadData.storeThread
                            .forEach { thread ->
                                add(
                                    StoreThreadItem(
                                        "${thread.author.nameShow}(${thread.author.name})",
                                        thread.forumName,
                                        "$PORTRAIT_HOST${thread.author.userPortrait}",
                                        getDisplayTime(thread.createTime),
                                        getDisplayTime(thread.lastTime),
                                        thread.title,
                                        thread.media
                                            .getOrNull(0)
                                            ?.let {
                                                when (it.type) {
                                                    MEDIA_TYPE_FLASH -> {
                                                        it.vpic
                                                    }
                                                    MEDIA_TYPE_PIC -> {
                                                        it.smallPic
                                                    }
                                                    else -> {
                                                        null
                                                    }
                                                }

                                            },
                                        thread.replyNum,
                                        thread.threadId,
                                        thread.isDeleted.toBool(),
                                        thread.author.lzUid
                                    )
                                )
                            }

                        add(loadMoreItem)
                        loadMoreItem.loadSuccess(threadData.storeThread.size == RANGE_NUMBER)
                        sendEvent(EVENT_UI_REFRESH_SUCCESS)
                    }
            } catch (e: Exception) {
                ToastUtils.showShort(ExceptionEngine.handleMessage(e))
                loadMoreItem.loadFailed()
                sendEvent(EVENT_UI_REFRESH_FAILED)
            }
        }
    }

    fun rmStore(storeThreadItem: StoreThreadItem) {
        launch {
            try {
                TiebaRequest.rmStore(storeThreadItem.tid)
                remove(storeThreadItem)
                ToastUtils.showShort("取消收藏成功")
            } catch (e: Exception) {
                ToastUtils.showShort(ExceptionEngine.handleMessage(e))
            }

        }
    }
}