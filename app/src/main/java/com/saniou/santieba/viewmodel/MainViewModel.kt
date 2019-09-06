package com.saniou.santieba.viewmodel

import android.annotation.SuppressLint
import android.view.View
import androidx.databinding.ObservableField
import com.saniou.santieba.R
import com.saniou.santieba.api.TiebaRequest
import com.saniou.santieba.component.MSignActivity
import com.saniou.santieba.constant.PORTRAIT_HOST
import com.saniou.santieba.vo.ForumItem
import com.sanniou.common.databinding.BaseObservableListViewModel
import com.sanniou.common.network.exception.ExceptionEngine
import com.sanniou.common.utilcode.util.ActivityUtils
import com.sanniou.common.utilcode.util.SPUtils
import com.sanniou.common.utilcode.util.ToastUtils

class MainViewModel : BaseObservableListViewModel() {
    val avatar = ObservableField<Any>(R.drawable.image_emoticon)
    val threadCount = ObservableField("")
    val fansCount = ObservableField("")
    val likeCount = ObservableField("")
    val storeCount = ObservableField("")
    var mID = ""

    fun signInAll() {
        ActivityUtils.startActivity(MSignActivity::class.java)
    }

    @SuppressLint("CheckResult")
    fun getFavorite() {
        clear()
        TiebaRequest.profile()
            .flatMap {
                it.user.run {
                    avatar.set("$PORTRAIT_HOST$portrait")
                    threadCount.set(thread_num)
                    fansCount.set(fans_num)
                    likeCount.set(concern_num)
                    storeCount.set(like_forum_num)
                    mID = id
                }
                val loginInfo = SPUtils.getInstance("login_info")
                loginInfo.put("tbs", it.anti.tbs)
                TiebaRequest.reset()
                TiebaRequest.getFavorite()
            }
            .`as`(bindLifeEvent())
            .subscribe({ forum ->
                forum.like_forum
                    .forEach {
                        add(ForumItem(it.forum_name, it.avatar, it.is_sign == 1, it.level_id))
                    }

            }) {
                ToastUtils.showShort(ExceptionEngine.handleMessage(it))
            }
    }

    fun toStore() {
        updateUi(3)
    }
}