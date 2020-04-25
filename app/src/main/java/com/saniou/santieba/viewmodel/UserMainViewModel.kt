package com.saniou.santieba.viewmodel

import androidx.databinding.ObservableField
import com.blankj.utilcode.util.ToastUtils
import com.saniou.santieba.R
import com.saniou.santieba.api.TiebaRequest
import com.saniou.santieba.api.bean.MEDIA_TYPE_FLASH
import com.saniou.santieba.api.bean.MEDIA_TYPE_PIC
import com.saniou.santieba.constant.PORTRAIT_HOST
import com.saniou.santieba.kts.getDisplayTime
import com.saniou.santieba.vo.FriendThreadItem
import com.sanniou.support.components.BaseListViewModel
import com.sanniou.support.exception.ExceptionEngine

class UserMainViewModel : BaseListViewModel() {

    var uid: String = "";

    val avatar = ObservableField<Any>(R.drawable.image_emoticon)
    val threadCount = ObservableField("")
    val fansCount = ObservableField("")
    val likeCount = ObservableField("")
    val concernCount = ObservableField("")
    val userName = ObservableField("")
    val forumAge = ObservableField("")
    val distance = ObservableField("")
    val distanceTime = ObservableField("")

    fun init(uid: String) {
        this.uid = uid
        getFriendProfile()
    }

    fun getFriendProfile() {
        launch {
            try {
                TiebaRequest.friendProfile(uid).let {

                    it.user.run {
                        avatar.set("$PORTRAIT_HOST$portrait")
                        threadCount.set(threadNum)
                        userName.set("$nameShow($name)")
                        fansCount.set(fansNum)
                        concernCount.set(concernNum)
                        likeCount.set(likeForumNum)
                        forumAge.set(tbAge)
                    }
                    distance.set(it.tainfo.distanceinfo.distance)
                    distanceTime.set(getDisplayTime(it.tainfo.distanceinfo.time))
                    it.postList.forEach { post ->
                        add(
                            FriendThreadItem(
                                post.forumName,
                                getDisplayTime(post.createTime),
                                post.title,
                                post.media
                                    .getOrNull(0)
                                    ?.let {
                                        when (it.type) {
                                            MEDIA_TYPE_FLASH -> {
                                                it.vpic
                                            }
                                            MEDIA_TYPE_PIC -> {
                                                it.smallPic
                                            }
                                            else -> {
                                                null
                                            }
                                        }

                                    },
                                post.replyNum,
                                post.threadId
                            )
                        )
                    }
                }
            } catch (e: Exception) {
                ToastUtils.showShort(ExceptionEngine.handleMessage(e))
            }
        }
    }
}