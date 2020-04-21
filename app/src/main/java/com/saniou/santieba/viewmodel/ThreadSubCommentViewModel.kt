package com.saniou.santieba.viewmodel

import com.blankj.utilcode.util.ToastUtils
import com.saniou.santieba.api.TiebaRequest
import com.saniou.santieba.constant.ATME
import com.saniou.santieba.constant.EMOJI
import com.saniou.santieba.constant.IMAGE
import com.saniou.santieba.constant.PORTRAIT_HOST
import com.saniou.santieba.constant.TEXT
import com.saniou.santieba.constant.VIDEO
import com.saniou.santieba.constant.VOICE
import com.saniou.santieba.kts.getDisplayTime
import com.saniou.santieba.utils.analyzeText
import com.saniou.santieba.vo.CommentTextItem
import com.saniou.santieba.vo.ThreadCommentItem
import com.sanniou.multiitemkit.vo.LoadMoreItem
import com.sanniou.support.components.BaseListViewModel
import com.sanniou.support.exception.ExceptionEngine
import com.sanniou.support.extensions.deleteLast

class ThreadSubCommentViewModel : BaseListViewModel() {

    var pid = ""
    private var spid = ""
    var threadId = ""
    private var pageNumber = 1
    private val loadMoreItem = LoadMoreItem { getSubComment(pageNumber.toString()) }

    fun init() {
        clear()
        pageNumber = 1
        loadMoreItem.ready()
        add(loadMoreItem)
    }

    fun getSubComment(pn: String) {
        launch {
            try {
                TiebaRequest.subFloor(threadId, pid, spid, pn)
                    .let { subComment ->
                        list.deleteLast()

                        if (pageNumber == 1) {
                            subComment.post.run {

                                add(
                                    ThreadCommentItem(
                                        floor.toInt(),
                                        "$PORTRAIT_HOST${author.portrait}",
                                        "${author.nameShow}(${author.name})"
                                        , author.levelId,
                                        getDisplayTime(time),
                                        author.id
                                    )
                                )
                                analyzeText(content).forEach {
                                    when (it.type) {
                                        TEXT -> {
                                            add(CommentTextItem(it.text))
                                        }
                                        EMOJI -> {
                                            add(CommentTextItem(it.text))
                                        }
                                        ATME -> {
                                            add(CommentTextItem(it.text))
                                        }
                                        VIDEO -> {
                                            add(CommentTextItem(it.text))
                                        }
                                        IMAGE -> {
                                        }
                                        VOICE -> {
                                        }
                                    }
                                }
                            }
                        }


                        subComment.subpostList.forEach { subPost ->
                            val subAuthor = subPost.author
                            add(
                                ThreadCommentItem(
                                    subPost.floor.toInt(),
                                    "$PORTRAIT_HOST${subAuthor.portrait}",
                                    "${subAuthor.nameShow}(${subAuthor.name})"
                                    , subAuthor.levelId,
                                    getDisplayTime(subPost.time),
                                    subAuthor.id
                                )
                            )


                            analyzeText(subPost.content).forEach {
                                when (it.type) {
                                    TEXT -> {
                                        add(CommentTextItem(it.text))
                                    }
                                    EMOJI -> {
                                        add(CommentTextItem(it.text))
                                    }
                                    VIDEO -> {
                                    }
                                    IMAGE -> {
                                    }
                                    VOICE -> {
                                    }

                                }
                            }

                        }

                        pageNumber++
                        add(loadMoreItem)
                        loadMoreItem.loadSuccess(subComment.page.run {
                            totalPage != currentPage && subComment.subpostList.isNotEmpty()
                        })
                        sendEvent(0)
                    }
            } catch (e: Exception) {
                ToastUtils.showShort(ExceptionEngine.handleMessage(e))
                loadMoreItem.loadFailed()
                sendEvent(1)
            }
        }
    }
}