package com.saniou.santieba.viewmodel

import com.saniou.santieba.api.TiebaRequest
import com.saniou.santieba.api.bean.MEDIA_TYPE_FLASH
import com.saniou.santieba.api.bean.MEDIA_TYPE_PIC
import com.saniou.santieba.constant.PORTRAIT_HOST
import com.saniou.santieba.kts.getDisplayTime
import com.saniou.santieba.kts.toBool
import com.saniou.santieba.vo.StoreThreadItem

class PostsListViewModel : PageAutoListItemViewModel() {

    override fun initParam(param: Map<String, String>) {
        super.initParam(param)
        title.value = "帖子"
    }

    override suspend fun fetchPage(page: Int) =
        TiebaRequest.userPosts(getValue("uid"), page.toString())
            .let { post ->
                post.postList
                    .forEach {
                        addItem(
                            StoreThreadItem(
                                "${it.nameShow}(${it.userName})",
                                it.forumName,
                                "$PORTRAIT_HOST${it.userPortrait}",
                                getDisplayTime(it.createTime),
                                "",
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
                                it.threadId,
                                it.isPostDeleted.toBool(),
                                it.userId,
                                it.postId,
                                "", false
                            )
                        )
                    }
                post.postList.isNotEmpty()
            }
}