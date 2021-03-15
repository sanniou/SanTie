package com.saniou.santieba.viewmodel

import androidx.lifecycle.MutableLiveData
import com.blankj.utilcode.util.ToastUtils
import com.saniou.santieba.R
import com.saniou.santieba.constant.IMAGE
import com.saniou.santieba.constant.PORTRAIT_HOST
import com.saniou.santieba.constant.TEXT
import com.saniou.santieba.constant.VIDEO
import com.saniou.santieba.constant.VOICE
import com.saniou.santieba.kts.getDisplayTime
import com.saniou.santieba.kts.toBool
import com.saniou.santieba.model.TiebaRequest
import com.saniou.santieba.model.api.interfaces.SanTiebaApi
import com.saniou.santieba.model.api.reqeust.ForumSortType
import com.saniou.santieba.model.bean.ForumPage
import com.saniou.santieba.vo.ThreadItem
import com.sanniou.support.exception.ExceptionEngine
import com.sanniou.support.lifecycle.NonNullLiveData
import com.sanniou.support.utils.ResourcesUtils

data class ForumInfo(
    var fid: String,
    val subscribed: Boolean,
    val avatar: String,
    val forumName: String,
    var forumMember: String,
    var forumPost: String,
    var forumSlogan: String,
    var forumLevel: String,
    var forumLevelName: String,
    val currentScore: Int,
    val nextScore: Int,
    val isSignIn: Boolean,
    val forumSignCount: Int
)

open class ForumPageViewModel : PageAutoListItemViewModel() {

    val sortType = NonNullLiveData(ForumSortType.REPLY_TIME)

    private var fid = ""

    val forumInfo = MutableLiveData<ForumInfo>()

    var goodClassify: List<ForumPage.Forum.GoodClassify> = emptyList()

    val name
        get() = getValue("forum")

    override val dividerHeight: Int
        get() = 2

    override val dividerColor: Int
        get() = ResourcesUtils.getColor(R.color.backgroundColorPress)

    override suspend fun fetchPage(page: Int): Boolean {

        val threadProfile = forumPage(page)

        fid = threadProfile.forum.id
        goodClassify = threadProfile.forum.goodClassify
        val forum = threadProfile.forum
        if (forumInfo.value == null) {
            forumInfo.value = ForumInfo(
                forum.id,
                forum.isLike.toBool(),
                forum.avatar,
                forum.name,
                forum.memberNum,
                forum.postNum,
                forum.slogan,
                forum.levelId,
                forum.levelName,
                forum.curScore.toInt(),
                forum.levelupScore.toInt(),
                forum.signInInfo.userInfo.isSignIn.toBool(),
                forum.signInInfo.userInfo.cSignNum
            )
        }

        //帖子列表
        threadProfile.threadList.forEach { thread ->
            var postImage = ""

            postImage = thread.videoInfo
                .takeIf {
                    it.thumbnailUrl.isNotEmpty()
                }
                ?.thumbnailUrl
                ?: run {
                    thread.firstPostContent
                        .firstOrNull { it.type != TEXT }
                        ?.let {
                            when (it.type) {
                                IMAGE -> it.originSrc

                                VOICE -> "https://apic.douyucdn.cn/upload/avatar/000/31/02/60_avatar_middle.jpg"

                                VIDEO -> it.text.toString()

                                else -> postImage
                            }
                        } ?: postImage
                }
            val author = threadProfile.userList.first { it.id == thread.authorId }
            addItem(
                ThreadItem(
                    thread.isTop.toBool(),
                    thread.isGood.toBool(),
                    thread.isLivepost.toBool(),
                    thread.isNtitle.toBool(),
                    thread.tid,
                    thread.title,
                    "${author.nameShow}(${author.name})",
                    thread.replyNum,
                    thread.zan.num,
                    thread.abstract[0].text,
                    getDisplayTime(thread.createTime.toLong()),
                    "$PORTRAIT_HOST${author.portrait}",
                    author.id,
                    forum.name,
                    postImage
                )
            )
        }

        return threadProfile.page.run {
            hasMore.toBool() && threadProfile.threadList.isNotEmpty()
        }
    }

    open suspend fun forumPage(page: Int) = SanTiebaApi.forumPage(name, page, sortType.value)

    fun unSubscribe() {
        if (!forumInfo.value!!.subscribed) {
            ToastUtils.showShort("未关注")
            return
        }
        launch {
            try {
                TiebaRequest.unlikeForum(fid, name)
                ToastUtils.showShort(R.string.unsubscribe_success)
                refresh()
            } catch (e: Exception) {
                ToastUtils.showShort(ExceptionEngine.handleMessage(e))
            }
        }
    }

    fun subscribe() {
        if (forumInfo.value!!.subscribed) {
            ToastUtils.showShort("已关注")
            return
        }
        launch {
            try {
                TiebaRequest.likeForum(fid, name)
                ToastUtils.showShort(R.string.subscribe_success)
                refresh()
            } catch (e: Exception) {
                ToastUtils.showShort(ExceptionEngine.handleMessage(e))
            }
        }
    }

    fun setSortType(sortType: ForumSortType) {
        this.sortType.value = sortType
        refresh()
    }
}

