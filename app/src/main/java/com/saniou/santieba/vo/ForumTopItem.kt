package com.saniou.santieba.vo

import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.blankj.utilcode.util.ToastUtils
import com.saniou.santieba.R
import com.saniou.santieba.api.TiebaRequest
import com.sanniou.support.multiitem.ScopeItem
import com.sanniou.support.utils.ResourcesUtils
import kotlinx.coroutines.launch

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
    private var forumSignCount: Int,
    private var subscribeEvent: () -> Unit
) : ScopeItem() {

    val isSubscribe = ObservableBoolean(subscribe)
    val signInStr = ObservableField(if (isSignIn) "已签${forumSignCount}天" else "未签到")
    override fun getItemType() = R.layout.item_forum_top

    fun signIn(v: View) {
        if (isSignIn) return
        launch {
            TiebaRequest.sign(forumName)
                .let {
                    ToastUtils.showShort("签到成功！")
                    signInStr.set("已签${forumSignCount + 1}天")
                }

        }
    }

    fun subscribe(v: View) {
        subscribeEvent()
    }

    fun getStrokeColor() = ResourcesUtils.getColor(R.color.design_blue)
}