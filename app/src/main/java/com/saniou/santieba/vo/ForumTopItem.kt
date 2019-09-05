package com.saniou.santieba.vo

import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.LifecycleOwner
import com.saniou.santieba.R
import com.saniou.santieba.api.TiebaRequest
import com.saniou.santieba.api.ToastObserver
import com.saniou.santieba.api.bean.StatusResponse
import com.sanniou.common.network.exception.ExceptionEngine
import com.sanniou.common.rx.RxHelper.bindLifeEvent
import com.sanniou.common.utilcode.util.ActivityUtils
import com.sanniou.common.utilcode.util.ResourcesUtils
import com.sanniou.common.utilcode.util.ToastUtils
import com.sanniou.common.widget.recyclerview.Item

/**
 * 贴吧头
 */


class ForumTopItem(
    var fid: String,
    var forumImage: String,
    var forumName: String,
    var forumMember: String,
    var forumSlogan: String,
    val subscribe: Boolean,
    var forumLevel: String,
    private var isSignIn: Boolean,
    private var forumSignCount: String,
    private var subscribeEvent: () -> Unit
) : Item {

    val isSubscribe = ObservableBoolean(subscribe)
    val signInStr = ObservableField(if (isSignIn) "已签${forumSignCount}天" else "未签到")
    override fun getType() = R.layout.item_forum_top


    fun signIn(v: View) {
        if (isSignIn) return
        TiebaRequest.sign(forumName)
            .`as`(bindLifeEvent(ActivityUtils.getActivityByView(v) as LifecycleOwner))
            .subscribe(object : ToastObserver<StatusResponse>() {
                override fun onNext(t: StatusResponse) {
                    ToastUtils.showShort("签到成功！")
                    signInStr.set("已签${forumSignCount + 1}天")
                }

            })

    }

    fun subscribe(v: View) {
        subscribeEvent.invoke()
    }

    fun getStrokeColor() = ResourcesUtils.getColor(R.color.design_blue)
}