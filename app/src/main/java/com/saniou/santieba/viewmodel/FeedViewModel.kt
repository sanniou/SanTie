package com.saniou.santieba.viewmodel

import com.saniou.santieba.constant.BOOLEAN_TRUE
import com.saniou.santieba.constant.RANGE_NUMBER
import com.saniou.santieba.model.TiebaRequest
import com.saniou.santieba.model.bean.MEDIA_TYPE_FLASH
import com.saniou.santieba.model.bean.MEDIA_TYPE_PIC
import com.saniou.santieba.utils.analyzeText
import com.saniou.santieba.vo.SearchForumItem
import com.saniou.santieba.vo.StoreThreadItem
import com.sanniou.support.components.BaseListViewModel

class FeedViewModel : PageAutoListItemViewModel() {

    override suspend fun fetchPage(page: Int): Boolean {
        return TiebaRequest.feed(page.toString())
            .let { thread ->
                thread.feedThreadList
                    .forEach {
                        addItem(
                            StoreThreadItem(
                                it.title,
                                it.forumName,
                                it.userPicUrl,
                                it.createTime,
                                it.modifyTime,
                                it.title,
                                it.media
                                    .getOrNull(0)
                                    ?.let { media ->
                                        when (media.type) {
                                            MEDIA_TYPE_FLASH -> {
                                                media.vpic
                                            }
                                            MEDIA_TYPE_PIC -> {
                                                media.smallPic
                                            }
                                            else -> {
                                                null
                                            }
                                        }

                                    }, "0", it.threadId, false, it.userId, "", "", false
                            )
                        )
                    }
                thread.hasMore == BOOLEAN_TRUE
            }
    }
}