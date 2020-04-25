package com.saniou.santieba.vo

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import com.blankj.utilcode.util.ToastUtils
import com.saniou.santieba.R
import com.saniou.santieba.api.TiebaRequest
import com.sanniou.support.exception.ExceptionEngine
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
    var forumPost: String,
    var forumSlogan: String,
    val subscribe: Boolean,
    var forumLevel: String,
    var Score: Int,
    var needScore: Int,
    private var isSignIn: Boolean,
    private var forumSignCount: Int,
    private var subscribeEvent: () -> Unit
) : ScopeItem() {

    val isSubscribe = ObservableBoolean(subscribe)
    val strokeColor = ObservableInt()
    val signInStr = ObservableField(if (isSignIn) "已签${forumSignCount}天" else "未签到")

    init {
        updateStroke()
    }

    override fun getItemType() = R.layout.item_forum_top

    fun signIn() {
        if (isSignIn) return
        launch {
            try {
                TiebaRequest.sign(forumName)
                    .let {
                        ToastUtils.showShort("签到成功！")
                        isSignIn = true
                        signInStr.set("已签${forumSignCount + 1}天")
                    }
            } catch (e: Exception) {
                ToastUtils.showShort(ExceptionEngine.handleMessage(e))
            }

        }
    }

    fun getScoreString() = "$Score/$needScore"

    private fun updateStroke() {
        strokeColor.set(ResourcesUtils.getColor(if (subscribe && isSignIn) R.color.minorText else R.color.design_blue))
    }

    fun subscribe() {
        subscribeEvent()
    }
}