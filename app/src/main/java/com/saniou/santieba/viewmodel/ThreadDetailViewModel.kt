package com.saniou.santieba.viewmodel

import androidx.databinding.ObservableField
import com.blankj.utilcode.util.ColorUtils
import com.blankj.utilcode.util.SpanUtils
import com.blankj.utilcode.util.ToastUtils
import com.saniou.santieba.R
import com.saniou.santieba.api.TiebaRequest
import com.saniou.santieba.api.bean.ThreadPage
import com.saniou.santieba.constant.*
import com.saniou.santieba.kts.getDisplayTime
import com.saniou.santieba.kts.toBool
import com.saniou.santieba.utils.analyzeText
import com.saniou.santieba.vo.*
import com.sanniou.multiitemkit.vo.LoadMoreItem
import com.sanniou.support.components.BaseListViewModel
import com.sanniou.support.exception.ExceptionEngine
import com.sanniou.support.extensions.deleteLast
import com.sanniou.support.extensions.orEmpty
import com.sanniou.support.utils.ResourcesUtils


class ThreadDetailViewModel : BaseListViewModel() {
    val imageList = mutableListOf<String>()
    var lzOly = false
    var store = false
    var reverse = false
    var tid = ""
    private var mPid = ""
    var forumName = ObservableField("")
    private val loadMoreItem = LoadMoreItem { requestPosts(mPid) }

    fun init() {
        clear()
        mPid = ""
        imageList.clear()
        loadMoreItem.ready()
        add(loadMoreItem)
    }

    private fun requestPosts(pid: String) {
        launch {
            try {
                TiebaRequest.threadPage(tid, pid, lzOly, reverse)
                    .let { threadDetail ->
                        list.deleteLast()

                        forumName.set(threadDetail.forum.name)
                        store = threadDetail.thread.collectStatus.toBool()
                        if (store) {
                            sendEvent(3)
                        }

                        // 用户列表
                        val treadId = threadDetail.thread.id
                        val userMap = mutableMapOf<String, ThreadPage.UserX>()
                        threadDetail.userList.forEach {
                            userMap[it.id] = it
                        }
                        if (pid.isEmpty()) {
                            add(ThreadTitleItem(threadDetail.thread.title))
                        }

                        //帖子列表
                        threadDetail.postList.forEach { post ->
                            val first = post.floor == "1"

                            if (mPid == post.id) {
                                return@forEach
                            }

                            val currentUser = userMap[post.authorId]!!
                            // 帖头
                            add(
                                ThreadCommentItem(
                                    post.floor.toInt(),
                                    "$PORTRAIT_HOST${currentUser.portrait}",
                                    "${currentUser.nameShow}(${currentUser.name})",
                                    currentUser.levelId ?: "0",
                                    getDisplayTime(post.time.toLong()),
                                    currentUser.id
                                )
                            )
                            // 帖子内容
                            post.content.takeIf { it.isNotEmpty() }
                                ?.apply {
                                    analyzeText(this).forEach {
                                        when (it.type) {
                                            TEXT -> {
                                                add(CommentTextItem(it.text, first))
                                            }
                                            VIDEO -> {
                                                add(
                                                    CommentVideoItem(
                                                        it.src,
                                                        it.link.orEmpty(it.text.toString())
                                                    )
                                                )
                                            }
                                            VOICE -> {
                                                add(CommentVoiceItem(TIEBA_VOICE_HOST + it.voiceMd5))
                                            }
                                            ATME -> {
                                                add(CommentTextItem(it.text, first))
                                            }
                                            IMAGE -> {
                                                val orgImage: String
                                                val image: String

                                                val bigCdnSrc = it.bigCdnSrc

                                                if (bigCdnSrc.isNotEmpty() && it.originSrc.isEmpty()) {
                                                    orgImage = bigCdnSrc.substring(
                                                        bigCdnSrc.indexOf("http://static"),
                                                        bigCdnSrc.indexOf("&width=")
                                                    )
                                                    image = orgImage
                                                } else {
                                                    orgImage = it.originSrc
                                                    image = it.cdnSrc
                                                }

                                                imageList.add(orgImage)
                                                add(
                                                    CommentImageItem(
                                                        image, orgImage,
                                                        first
                                                    )
                                                )
                                            }
                                        }
                                    }
                                }

                            if (post.subPostNumber != 0) {
                                post.subPostList.subPostList.forEach { subContent ->
                                    val currentUser2 = userMap[subContent.authorId]
                                    val name = "${currentUser2?.nameShow}(${currentUser2?.name})"
                                    analyzeText(subContent.content).forEach {
                                        add(
                                            SubCommentItem(
                                                SpanUtils().append("$name:")
                                                    .setForegroundColor(ColorUtils.getColor(R.color.design_blue))
                                                    .append(it.text)
                                                    .create()!!,
                                                post.id, treadId
                                            )
                                        )
                                    }
                                }
                                if (post.subPostNumber > 10) {
                                    add(
                                        SubCommentItem(
                                            "查看全部回复${post.subPostNumber}条",
                                            post.id,
                                            treadId
                                        )
                                    )
                                }
                            }
                            if (first) {
                                add(
                                    ThreadBottomItem(
                                        threadDetail.thread.id,
                                        threadDetail.thread.replyNum.toInt()
                                    )
                                )
                                add(
                                    DividerItem(
                                        ResourcesUtils.getDimensionPixelSize(R.dimen.default_margin_small),
                                        ResourcesUtils.getColor(R.color.shadowColor)
                                    )
                                )


                            } else {
                                add(
                                    DividerItem(
                                        ResourcesUtils.getDimensionPixelSize(R.dimen.default_margin_normal),
                                        ResourcesUtils.getColor(R.color.config_white)
                                    )
                                )
                                add(
                                    DividerItem(
                                        ResourcesUtils.getDimensionPixelSize(R.dimen.divider_height),
                                        ResourcesUtils.getColor(R.color.shadowColor),
                                        ResourcesUtils.getColor(R.color.config_white),
                                        ResourcesUtils.getDimensionPixelSize(R.dimen.default_margin_normal)
                                    )
                                )
                            }
                            mPid = post.id
                        }
                        add(loadMoreItem)
                        // 不知道为什么返回多
                        loadMoreItem.loadSuccess(
                            threadDetail.page.run {
                                hasMore.toBool() && threadDetail.postList.isNotEmpty()
                            })
                        sendEvent(0)
                        list
                    }
            } catch (e: Exception) {
                ToastUtils.showShort(ExceptionEngine.handleMessage(e))
                loadMoreItem.loadFailed()
                sendEvent(1)
            }
        }

    }

    private fun addStore() {
        launch {
            try {
                TiebaRequest.addStore(tid, mPid)
                    .let {
                        ToastUtils.showShort("收藏成功")
                        sendEvent(3)
                        store = !store
                    }

            } catch (e: Exception) {
                ToastUtils.showShort(ExceptionEngine.handleMessage(e))
                sendEvent(4)
            }
        }
    }


    private fun rmStore() {
        launch {
            try {
                TiebaRequest.rmStore(tid)
                    .let {
                        ToastUtils.showShort("取消收藏成功")
                        sendEvent(4)
                        store = !store
                    }
            } catch (e: Exception) {
                ToastUtils.showShort(ExceptionEngine.handleMessage(e))
                sendEvent(3)
            }
        }

    }

    fun changeStore() {
        if (store) {
            rmStore()
        } else {
            addStore()
        }
    }
}
