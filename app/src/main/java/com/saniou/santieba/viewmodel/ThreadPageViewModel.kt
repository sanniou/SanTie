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
import com.saniou.santieba.constant.IMAGE
import com.saniou.santieba.constant.PORTRAIT_HOST
import com.saniou.santieba.constant.TEXT
import com.saniou.santieba.constant.TIEBA_USER_HOST
import com.saniou.santieba.constant.TIEBA_VOICE_HOST
import com.saniou.santieba.constant.VIDEO
import com.saniou.santieba.constant.VOICE
import com.saniou.santieba.kts.getDisplayTime
import com.saniou.santieba.kts.toBool
import com.saniou.santieba.utils.LinkClickSpan
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

abstract class PageViewModel : PointAutoListItemViewModel() {
    val imageList = mutableListOf<String>()
    var tid = ""
    var wifiConnected = false
    var forumName = NonNullLiveData("")
    var store = NonNullLiveData(false)
    var lzOly = NonNullLiveData(false)
    var reverse = NonNullLiveData(false)

    var headerAdded = false;

    override fun getDividerHeight() = 0

    override fun initParam(param: Map<String, String>) {
        super.initParam(param)
        tid = getValue("tid")
        title.value = "帖子"
    }

    override fun onRefresh() {
        headerAdded = false
        wifiConnected = NetworkUtils.isWifiConnected()
        super.onRefresh()
    }

    override fun getHeaderType() = R.layout.item_thread_title

    fun addStore(first: String) {
        launch {
            try {
                TiebaRequest.addStore(tid, first, lzOly.value, reverse.value)
                    .let {
                        ToastUtils.showShort("收藏成功")
                        store.value = !store.value
                    }
            } catch (e: Exception) {
                ToastUtils.showShort(ExceptionEngine.handleMessage(e))
            }
        }
    }

    fun rmStore() {
        launch {
            try {
                TiebaRequest.rmStore(tid)
                    .let {
                        ToastUtils.showShort("取消收藏成功")
                        sendEvent(4)
                        store.value = !store.value
                    }
            } catch (e: Exception) {
                ToastUtils.showShort(ExceptionEngine.handleMessage(e))
            }
        }
    }

    protected fun addHeaderContent(
        pid: String?,
        content: List<Content>,
        threadDetail: ThreadPage
    ) {
        addContent(pid, content, true)
        addItem(
            FloorBottomItem(
                threadDetail.thread.id,
                threadDetail.thread.replyNum.toInt()
            )
        )
        addItem(
            DividerItem(
                ResourcesUtils.getDimensionPixelSize(R.dimen.default_margin_small),
                ResourcesUtils.getColor(R.color.shadowColor)
            )
        )
    }

    protected fun addContent(pid: String?, contents: List<Content>, first: Boolean = false) {
        if (contents.isEmpty()) {
            return
        }
        updatePoint(pid)
        analyzeText(contents)
            .forEach {
                when (it.type) {
                    TEXT -> {
                        addItem(CommentTextItem(it.text, first))
                    }
                    VIDEO -> {
                        addItem(
                            CommentVideoItem(
                                it.src,
                                it.link.orEmpty(it.text.toString())
                            )
                        )
                    }
                    VOICE -> {
                        addItem(CommentVoiceItem(TIEBA_VOICE_HOST + it.voiceMd5))
                    }
                    ATME -> {
                        addItem(CommentTextItem(it.text, first))
                    }
                    IMAGE -> {
                        var orgImage: String
                        var image: String

                        val bigCdnSrc = it.bigCdnSrc

                        if (bigCdnSrc.isNotEmpty() && it.originSrc.isEmpty()) {
                            orgImage = bigCdnSrc
                            image = orgImage
                        } else {
                            orgImage = it.originSrc
                            image = it.cdnSrc
                        }

                        orgImage = splitImageUrl(orgImage)
                        image = splitImageUrl(image)

                        imageList.add(orgImage)
                        addItem(
                            CommentImageItem(
                                if (wifiConnected) orgImage else image,
                                orgImage,
                                first
                            )
                        )
                    }
                }
            }
    }

    private fun splitImageUrl(orgImage: String): String {
        val indexOf = orgImage.indexOf("src=")
        return if (indexOf != -1) {
            orgImage.substring(indexOf + 4, orgImage.indexOf("gif&") + 3)
        } else {
            orgImage
        }
    }

    protected fun addSubComment(
        post: ThreadPage.Post,
        userMap: MutableMap<String, ThreadPage.UserX>,
        threadDetail: ThreadPage
    ) {
        if (post.subPostNumber == 0) {
            return
        }

        addItem(
            DividerItem(
                ResourcesUtils.getDimensionPixelSize(R.dimen.default_margin_small),
                ResourcesUtils.getColor(R.color.config_white)
            )
        )

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
                                    .setForegroundColor(ColorUtils.getColor(R.color.design_blue))
                                    .setClickSpan(LinkClickSpan(TIEBA_USER_HOST + subPoster?.id))
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

    protected fun addDivider() {
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
}

class ThreadPageViewModel : PageViewModel() {

    override suspend fun fetchPoint(point: String?): Boolean {
        return TiebaRequest.threadPage(
            tid,
            point,
            lzOly.value,
            reverse.value
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

                        addSubComment(post, userMap, threadDetail)

                        addDivider()
                    }


                threadDetail.page.hasMore.toBool() && threadDetail.postList.isNotEmpty()
            }
    }
}
