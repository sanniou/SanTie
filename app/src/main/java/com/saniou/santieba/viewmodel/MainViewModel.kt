package com.saniou.santieba.viewmodel

import androidx.databinding.ObservableField
import com.blankj.utilcode.util.ActivityUtils
import com.blankj.utilcode.util.SPUtils
import com.blankj.utilcode.util.ToastUtils
import com.saniou.santieba.R
import com.saniou.santieba.api.TiebaRequest
import com.saniou.santieba.component.FeedActivity
import com.saniou.santieba.component.MSignActivity
import com.saniou.santieba.constant.PORTRAIT_HOST
import com.saniou.santieba.kts.toBool
import com.saniou.santieba.vo.ForumItem
import com.sanniou.support.components.BaseListViewModel
import com.sanniou.support.exception.ExceptionEngine

class MainViewModel : BaseListViewModel() {
    val avatar = ObservableField<Any>(R.drawable.image_emoticon)
    val threadCount = ObservableField("")
    val fansCount = ObservableField("")
    val likeCount = ObservableField("")
    val storeCount = ObservableField("")
    var mID = ""

    fun signInAll() {
        ActivityUtils.startActivity(MSignActivity::class.java)
    }

    fun toFeed() {
        ActivityUtils.startActivity(FeedActivity::class.java)
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
                        val loginInfo = SPUtils.getInstance("login_info")
                        loginInfo.put("tbs", it.anti.tbs)
                        TiebaRequest.reset()
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
}