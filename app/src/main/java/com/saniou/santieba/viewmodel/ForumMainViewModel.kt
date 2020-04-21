package com.saniou.santieba.viewmodel

import androidx.databinding.ObservableField
import com.blankj.utilcode.util.ToastUtils
import com.saniou.santieba.R
import com.saniou.santieba.api.TiebaRequest
import com.saniou.santieba.constant.EVENT_UI_REFRESH_FAILED
import com.saniou.santieba.constant.EVENT_UI_REFRESH_SUCCESS
import com.saniou.santieba.constant.IMAGE
import com.saniou.santieba.constant.PORTRAIT_HOST
import com.saniou.santieba.constant.TEXT
import com.saniou.santieba.constant.VIDEO
import com.saniou.santieba.constant.VOICE
import com.saniou.santieba.kts.getDisplayTime
import com.saniou.santieba.kts.toBool
import com.saniou.santieba.vo.ForumTopItem
import com.saniou.santieba.vo.ThreadItem
import com.sanniou.multiitemkit.vo.LoadMoreItem
import com.sanniou.support.components.BaseListViewModel
import com.sanniou.support.exception.ExceptionEngine
import com.sanniou.support.extensions.deleteLast

class ForumMainViewModel : BaseListViewModel() {

    private val loadMoreItem = LoadMoreItem { requestPosts(mPage) }
    var name = ""
    var isGood = false
    private var mPage = 1
    private var fid = ""
    private var subscribed = false
    var forumName = ObservableField("")

    fun init() {
        clear()
        mPage = 1
        sendEvent(if (isGood) 3 else 4)
        loadMoreItem.ready()
        add(loadMoreItem)
    }

    fun requestPosts(page: Int) {
        launch {
            try {

                val threadProfile = TiebaRequest.forumPage(name, page, isGood)

                fid = threadProfile.forum.id
                mPage++
                val forum = threadProfile.forum
                forumName.set(forum.name)
                subscribed = forum.isLike.toBool()

                if (list.size == 1) {
                    add(0, ForumTopItem(
                        forum.id,
                        forum.avatar, forum.name,
                        "关注 ${forum.memberNum} 帖子 ${forum.postNum}",
                        forum.slogan,
                        forum.isLike.toBool(),
                        "LV${forum.levelId}${forum.levelName}\r\n${forum.curScore}/${forum.levelupScore}",
                        forum.signInInfo.userInfo.isSignIn.toBool(),
                        forum.signInInfo.userInfo.cSignNum
                    ) { subscribe() }
                    )
                }

                list.deleteLast()

                //帖子列表
                threadProfile.threadList.forEach { thread ->
                    var postImage = ""
                    thread.getMedias()
                        .firstOrNull { it.type != TEXT }
                        ?.let {
                            when (it.type) {
                                IMAGE -> {
                                    postImage = it.bigPic
                                }
                                VOICE -> {
                                    postImage =
                                        "https://apic.douyucdn.cn/upload/avatar/000/31/02/60_avatar_middle.jpg"
                                }
                                VIDEO -> {
                                    postImage = it.src
                                }
                            }
                        }
                    add(
                        ThreadItem(
                            thread.isTop.toBool(),
                            thread.isGood.toBool(),
                            thread.isLivepost.toBool(),
                            thread.tid,
                            thread.title,
                            "${thread.author.nameShow}(${thread.author.name})",
                            thread.replyNum,
                            ((thread.zan as? Map<*, *>?)?.get("num") as String?) ?: "",
                            thread.abstract[0].text,
                            getDisplayTime(thread.createTime.toLong()),
                            "$PORTRAIT_HOST${thread.author.portrait}",
                            postImage
                        )
                    )
                }

                add(loadMoreItem)
                loadMoreItem.loadSuccess(threadProfile.page.run {
                    hasMore.toBool() && threadProfile.threadList.isNotEmpty()
                }
                )
                sendEvent(EVENT_UI_REFRESH_SUCCESS)
            } catch (e: Exception) {
                ToastUtils.showShort(ExceptionEngine.handleMessage(e))
                loadMoreItem.loadFailed()
                sendEvent(EVENT_UI_REFRESH_FAILED)
            }
        }
    }

    fun unSubscribe() {
        if (!subscribed) {
            ToastUtils.showShort("未关注")
            return
        }
        launch {
            try {
                TiebaRequest.unlikeForum(fid, name)
                ToastUtils.showShort(R.string.unsubscribe_success)
                init()
            } catch (e: Exception) {
                ToastUtils.showShort(ExceptionEngine.handleMessage(e))
            }
        }
    }

    fun subscribe() {
        if (subscribed) {
            ToastUtils.showShort("已关注")
            return
        }
        launch {
            try {
                TiebaRequest.likeForum(fid, name)
                ToastUtils.showShort(R.string.subscribe_success)
                init()
            } catch (e: Exception) {
                ToastUtils.showShort(ExceptionEngine.handleMessage(e))
            }
        }
    }
}

