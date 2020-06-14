package com.saniou.santieba.viewmodel

import com.blankj.utilcode.util.ToastUtils
import com.saniou.santieba.model.TiebaRequest
import com.saniou.santieba.constant.ATME
import com.saniou.santieba.constant.EMOJI
import com.saniou.santieba.constant.IMAGE
import com.saniou.santieba.constant.PORTRAIT_HOST
import com.saniou.santieba.constant.TEXT
import com.saniou.santieba.constant.VIDEO
import com.saniou.santieba.constant.VOICE
import com.saniou.santieba.kts.getDisplayTime
import com.saniou.santieba.model.api.interfaces.SanTiebaApi
import com.saniou.santieba.utils.analyzeText
import com.saniou.santieba.vo.CommentTextItem
import com.saniou.santieba.vo.FloorTopItem
import com.sanniou.multiitemkit.vo.LoadMoreItem
import com.sanniou.support.components.BaseListViewModel
import com.sanniou.support.exception.ExceptionEngine
import com.sanniou.support.extensions.deleteLast

class ThreadSubCommentViewModel : PageAutoListItemViewModel() {


    override suspend fun fetchPage(page: Int): Boolean {
        try {
            SanTiebaApi.floor(getValue("tid"), page,getNullableValue("pid"), getNullableValue("spid"))
                .let { subComment ->
                    if (page == 1) {
                        subComment.post.run {

                            addItem(
                                FloorTopItem(
                                    floor.toInt(),
                                    "$PORTRAIT_HOST${author.portrait}",
                                    "${author.nameShow}(${author.name})"
                                    , author.levelId,
                                    getDisplayTime(time),
                                    author.id,
                                    id
                                )
                            )
                            analyzeText(content).forEach {
                                when (it.type) {
                                    TEXT -> {
                                        addItem(CommentTextItem(it.text))
                                    }
                                    EMOJI -> {
                                        addItem(CommentTextItem(it.text))
                                    }
                                    ATME -> {
                                        addItem(CommentTextItem(it.text))
                                    }
                                    VIDEO -> {
                                        addItem(CommentTextItem(it.text))
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
                        addItem(
                            FloorTopItem(
                                subPost.floor.toInt(),
                                "$PORTRAIT_HOST${subAuthor.portrait}",
                                "${subAuthor.nameShow}(${subAuthor.name})"
                                , subAuthor.levelId,
                                getDisplayTime(subPost.time),
                                subAuthor.id,
                                subPost.id
                            )
                        )


                        analyzeText(subPost.content).forEach {
                            when (it.type) {
                                TEXT -> {
                                    addItem(CommentTextItem(it.text))
                                }
                                EMOJI -> {
                                    addItem(CommentTextItem(it.text))
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

                    return subComment.page.run {
                        totalPage != currentPage && subComment.subpostList.isNotEmpty()
                    }
                }
        } catch (e: Exception) {
            ToastUtils.showShort(ExceptionEngine.handleMessage(e))
            return false
        }
    }
}