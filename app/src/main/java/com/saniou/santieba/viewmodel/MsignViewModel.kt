package com.saniou.santieba.viewmodel

import android.annotation.SuppressLint
import androidx.databinding.ObservableInt
import com.saniou.santieba.R
import com.saniou.santieba.api.TiebaRequest
import com.saniou.santieba.vo.MSignForumItem
import com.sanniou.common.databinding.BaseObservableListViewModel
import com.sanniou.common.network.exception.ExceptionEngine
import com.sanniou.common.utilcode.util.ToastUtils
import org.json.JSONObject
import java.util.HashMap
import kotlin.concurrent.fixedRateTimer

class MsignViewModel : BaseObservableListViewModel() {
    private var forumIds = StringBuilder()
    val signImage = ObservableInt(R.drawable.icon_all_sign)

    @SuppressLint("CheckResult")
    fun msign() {
        if (forumIds.isEmpty()) {
            ToastUtils.showShort("已签到")
            return
        }
        TiebaRequest.msing(forumIds.toString())
            .`as`(bindLifeEvent())
            .subscribe({
                ToastUtils.showShort("签到成功")
                getForumList()
            }) {
                ToastUtils.showShort(ExceptionEngine.handleMessage(it))
            }
    }

    @SuppressLint("CheckResult")
    fun getForumList() {
        clear()
        TiebaRequest.getforumlist()
            .`as`(bindLifeEvent())
            .subscribe({ forumListP ->
                forumIds.clear()
                forumListP.forum_info.forEach {
                    if (it.is_sign_in != 1) {
                        forumIds.append(it.forum_id)
                        forumIds.append(",")
                    }

                    add(
                        MSignForumItem(
                            it.avatar,
                            it.forum_name,
                            "LV${it.user_level}",
                            it.need_exp,
                            it.is_sign_in == 1,
                            "已签到${it.cont_sign_num}天"
                        )
                    )
                }
                if (forumIds.isNotEmpty()) {
                    forumIds.deleteCharAt(forumIds.length - 1)
                }
                signImage.set(R.drawable.icon_all_sign_ok)
            }) {
                ToastUtils.showShort(ExceptionEngine.handleMessage(it))
            }
    }
}