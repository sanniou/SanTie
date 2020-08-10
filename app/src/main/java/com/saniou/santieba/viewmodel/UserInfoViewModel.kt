package com.saniou.santieba.viewmodel

import androidx.databinding.ObservableField
import com.blankj.utilcode.util.SPUtils
import com.blankj.utilcode.util.ToastUtils
import com.saniou.santieba.R
import com.saniou.santieba.model.TiebaRequest
import com.saniou.santieba.constant.PORTRAIT_HOST
import com.saniou.santieba.kts.toBool
import com.saniou.santieba.vo.ForumItem
import com.sanniou.support.components.BaseListViewModel
import com.sanniou.support.exception.ExceptionEngine

class UserInfoViewModel : BaseListViewModel() {
    val avatar = ObservableField<Any>(R.drawable.image_emoticon)
    val threadCount = ObservableField("")
    val fansCount = ObservableField("")
    val likeCount = ObservableField("")
    val storeCount = ObservableField("")
    var mID = ""

    init {
        getFavorite()
    }

    fun toFeed() {
    }

    fun getFavorite() {
        clear()
        launch {
            try {
                TiebaRequest.profile()
                    .let {
                        it.user.run {
                            avatar.set("$PORTRAIT_HOST$portrait")
                            threadCount.set(threadNum)
                            fansCount.set(fansNum)
                            likeCount.set(concernNum)
                            storeCount.set(likeForumNum)
                            mID = id
                        }
                        TiebaRequest.forumRecommend()
                    }
                    .let { forum ->
                        forum.likeForum
                            .forEach {
                                add(
                                    ForumItem(
                                        it.forumName,
                                        it.avatar,
                                        it.isSign.toBool(),
                                        it.levelId.toInt()
                                    )
                                )
                            }
                        sendEvent(5)
                    }
                val userPost = TiebaRequest.userPosts(mID, "1")
            } catch (e: Exception) {
                sendEvent(6)
                ToastUtils.showShort(ExceptionEngine.handleMessage(e))
            }
        }
    }

    fun toStore() {
        sendEvent(3)
    }

    fun toSearch() {
        sendEvent(4)
    }

    fun toFollows() {
        sendEvent(2)
    }

    fun toFans() {
        sendEvent(1)
    }

    fun toPosts() {
        sendEvent(0)
    }

    fun signInAll() {
        sendEvent(7)
    }
}