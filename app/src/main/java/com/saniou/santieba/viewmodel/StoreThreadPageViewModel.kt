package com.saniou.santieba.viewmodel

import com.blankj.utilcode.util.ColorUtils
import com.blankj.utilcode.util.NetworkUtils
import com.blankj.utilcode.util.SpanUtils
import com.blankj.utilcode.util.ToastUtils
import com.saniou.santieba.R
import com.saniou.santieba.api.TiebaRequest
import com.saniou.santieba.api.bean.Content
import com.saniou.santieba.api.bean.ThreadPage
import com.saniou.santieba.constant.ATME
import com.saniou.santieba.constant.BOOLEAN_FALSE
import com.saniou.santieba.constant.BOOLEAN_TRUE
import com.saniou.santieba.constant.IMAGE
import com.saniou.santieba.constant.PORTRAIT_HOST
import com.saniou.santieba.constant.TEXT
import com.saniou.santieba.constant.TIEBA_VOICE_HOST
import com.saniou.santieba.constant.VIDEO
import com.saniou.santieba.constant.VOICE
import com.saniou.santieba.kts.getDisplayTime
import com.saniou.santieba.kts.toBool
import com.saniou.santieba.utils.analyzeText
import com.saniou.santieba.vo.CommentImageItem
import com.saniou.santieba.vo.CommentTextItem
import com.saniou.santieba.vo.CommentVideoItem
import com.saniou.santieba.vo.CommentVoiceItem
import com.saniou.santieba.vo.DividerItem
import com.saniou.santieba.vo.FloorBottomItem
import com.saniou.santieba.vo.FloorTopItem
import com.saniou.santieba.vo.SubCommentItem
import com.saniou.santieba.vo.ThreadTitleItem
import com.sanniou.support.exception.ExceptionEngine
import com.sanniou.support.extensions.orEmpty
import com.sanniou.support.lifecycle.NonNullLiveData
import com.sanniou.support.utils.ResourcesUtils

enum class MARK_STATE(var value: String) {
    NORMAL("1"),
    SINGLE_NORMAL("3"),
    REVERSE("4"),
    SINGLE_REVERSE("6")
}

class StoreThreadPageViewModel : PageViewModel() {

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
        val mark = getValueOrDefault("isStore", BOOLEAN_FALSE)
        setValue("isStore", BOOLEAN_FALSE)
        return TiebaRequest.threadPage(
            tid,
            point,
            lzOly.value,
            reverse.value,
            if (!headerAdded && !reverse.value && mark.toBool()) BOOLEAN_TRUE else BOOLEAN_FALSE
        )
            .let { threadDetail ->

                title.value = threadDetail.forum.name

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
                    // if mark is true,put headerAdded true ,or put this when put postList
                    if (mark == BOOLEAN_TRUE) {
                        headerAdded = true
                        addHeaderContent(null, emptyList(), threadDetail)
                    }
                }

                //帖子列表
                threadDetail.postList
                    .forEach { post ->

                        val currentUser = userMap[post.authorId]!!

                        // mark header
                        if (!headerAdded) {
                            headerAdded = true
                            if (!reverse.value) {
                                addHeaderContent(post.id, post.content, threadDetail)
                                return@forEach
                            } else {
                                addHeaderContent(null, emptyList(), threadDetail)
                            }
                        }

                        // 帖头
                        addItem(
                            FloorTopItem(
                                post.floor.toInt(),
                                "$PORTRAIT_HOST${currentUser.portrait}",
                                "${currentUser.nameShow}(${currentUser.name})",
                                currentUser.levelId.toInt(),
                                getDisplayTime(post.time.toLong()),
                                currentUser.id,
                                post.id,
                                threadDetail.thread.author.id == currentUser.id
                            )
                        )
                        // 帖子内容
                        addContent(post.id, post.content)

                        if (post.subPostNumber != 0) {
                            post.subPostList.subPostList
                                .forEach { subContent ->
                                    val subPoster = userMap[subContent.authorId]
                                    val name =
                                        "${subPoster?.nameShow}(${subPoster?.name})"
                                    analyzeText(subContent.content)
                                        .forEach {
                                            val isPoster =
                                                threadDetail.thread.author.id == subPoster?.id
                                            addItem(
                                                SubCommentItem(
                                                    SpanUtils()
                                                        .append(if (isPoster) "           " else "")
                                                        .append("$name:")
                                                        .setForegroundColor(
                                                            ColorUtils.getColor(
                                                                R.color.design_blue
                                                            )
                                                        )
                                                        .append(it.text)
                                                        .create()!!,
                                                    post.id, tid,
                                                    isPoster
                                                )
                                            )
                                        }
                                }
                            if (post.subPostNumber > 10) {
                                addItem(
                                    SubCommentItem(
                                        "查看全部回复${post.subPostNumber}条",
                                        post.id,
                                        tid
                                    )
                                )
                            }
                        }

                        addItem(
                            DividerItem(
                                ResourcesUtils.getDimensionPixelSize(R.dimen.default_margin_normal),
                                ResourcesUtils.getColor(R.color.config_white)
                            )
                        )
                        addItem(
                            DividerItem(
                                ResourcesUtils.getDimensionPixelSize(R.dimen.divider_height),
                                ResourcesUtils.getColor(R.color.shadowColor),
                                ResourcesUtils.getColor(R.color.config_white),
                                ResourcesUtils.getDimensionPixelSize(R.dimen.default_margin_normal)
                            )
                        )
                    }


                threadDetail.page.hasMore.toBool() && threadDetail.postList.isNotEmpty()
            }
    }
}
