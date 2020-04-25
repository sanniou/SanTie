package com.saniou.santieba.viewmodel

import com.blankj.utilcode.util.ToastUtils
import com.saniou.santieba.api.TiebaRequest
import com.saniou.santieba.api.bean.MEDIA_TYPE_FLASH
import com.saniou.santieba.api.bean.MEDIA_TYPE_PIC
import com.saniou.santieba.constant.PORTRAIT_HOST
import com.saniou.santieba.constant.RANGE_NUMBER
import com.saniou.santieba.kts.getDisplayTime
import com.saniou.santieba.kts.toBool
import com.saniou.santieba.vo.StoreThreadItem
import com.sanniou.support.exception.ExceptionEngine

class StoreListViewModel : OffsetAutoListItemViewModel() {

    override fun initParam(param: Map<String, String>) {
        super.initParam(param)
        title.value = "我的收藏"
    }

    override suspend fun fetchOffset(offset: Int) =

        TiebaRequest.threadstore(offset, getValue("uid"))
            .let { threadData ->

                threadData.storeThread
                    .forEach { thread ->
                        addItem(
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
                                thread.author.lzUid,
                                thread.markPid,
                                thread.postNoMsg,
                                thread.count > 0,
                                thread.markStatus

                            )
                        )
                    }
                threadData.storeThread.size == RANGE_NUMBER
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