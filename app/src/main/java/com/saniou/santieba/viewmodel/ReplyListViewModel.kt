package com.saniou.santieba.viewmodel

import com.saniou.santieba.model.TiebaRequest
import com.saniou.santieba.model.bean.MEDIA_TYPE_FLASH
import com.saniou.santieba.model.bean.MEDIA_TYPE_PIC
import com.saniou.santieba.kts.getDisplayTime
import com.saniou.santieba.vo.FriendThreadItem

class ReplyListViewModel : PageAutoListItemViewModel() {

    override fun initParam(param: Map<String, String>) {
        super.initParam(param)
        // title.value = "回复"
    }

    override suspend fun fetchPage(page: Int) =
        TiebaRequest.userPosts2(getValue("uid"), page.toString())
            .let { post ->
                post.postList
                    .forEach {
                        addItem(
                            FriendThreadItem(
                                it.forumName,
                                getDisplayTime(it.createTime),
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

                                    },
                                it.replyNum,
                                it.threadId

                            )
                        )
                    }
                post.postList.isNotEmpty()
            }
}