package com.saniou.santieba.viewmodel

import com.saniou.santieba.model.TiebaRequest
import com.saniou.santieba.model.bean.ThreadPage
import com.saniou.santieba.constant.BOOLEAN_FALSE
import com.saniou.santieba.constant.BOOLEAN_TRUE
import com.saniou.santieba.constant.PORTRAIT_HOST
import com.saniou.santieba.kts.getDisplayTime
import com.saniou.santieba.kts.toBool
import com.saniou.santieba.vo.FloorTopItem
import com.saniou.santieba.vo.ThreadTitleItem

enum class MARK_STATE(var value: String) {
    NORMAL("1"),
    SINGLE_NORMAL("3"),
    REVERSE("4"),
    SINGLE_REVERSE("6")
}

class StoreThreadPageViewModel : PageViewModel() {

    override fun getReverseStartPosition() = 5

    override fun initParam(param: Map<String, String>) {
        super.initParam(param)
        when (getValue("markState")) {
            MARK_STATE.NORMAL.value -> {
                lzOly.value = false
                reverse.value = false
            }
            MARK_STATE.REVERSE.value -> {
                lzOly.value = false
                reverse.value = true
            }
            MARK_STATE.SINGLE_REVERSE.value -> {
                lzOly.value = true
                reverse.value = true
            }
            MARK_STATE.SINGLE_NORMAL.value -> {
                lzOly.value = true
                reverse.value = false
            }
        }
    }

    override fun initPoint() {
        updatePoint(getValueOrNull("pid"))
        removeValue("pid")
    }

    override suspend fun fetchPoint(point: String?): Boolean {
        return TiebaRequest.threadPage(
            tid,
            point,
            lzOly.value,
            reverse.value,
            if (!headerAdded && !reverse.value) BOOLEAN_TRUE else BOOLEAN_FALSE,
            storeHead = if (!headerAdded) BOOLEAN_TRUE else BOOLEAN_FALSE
        )
            .let { threadDetail ->

                // title.value = threadDetail.forum.name

                store.value = threadDetail.thread.collectStatus.toBool()

                // 用户列表
                val userMap = mutableMapOf<String, ThreadPage.UserX>()
                threadDetail.userList.forEach {
                    userMap[it.id] = it
                }
                // 第一页
                if (!headerAdded) {

                    set(0, ThreadTitleItem(threadDetail.thread.title))
                    threadDetail.thread.run {

                        addItem(
                            FloorTopItem(
                                1,
                                "$PORTRAIT_HOST${author.portrait}",
                                "${author.nameShow}(${author.name})",
                                author.levelId.toInt(),
                                getDisplayTime(createTime),
                                author.id,
                                postId,
                                true
                            )
                        )

                    }

                    headerAdded = true
                    addHeaderContent(null, emptyList(), threadDetail)
                }

                //帖子列表
                threadDetail.postList
                    .forEach { post ->

                        val currentUser = userMap[post.authorId]!!

                        // 帖头
                        addFloorTop(post, currentUser, threadDetail)
                        // 帖子内容
                        addContent(post.id, post.content)

                        addSubComment(post, userMap, threadDetail)

                        addDivider()
                    }


                threadDetail.page.hasMore.toBool() && threadDetail.postList.isNotEmpty()
            }
    }
}
