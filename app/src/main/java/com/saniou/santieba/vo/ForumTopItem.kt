package com.saniou.santieba.vo

import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import com.saniou.santieba.R
import com.saniou.santieba.api.TiebaRequest
import com.sanniou.common.utilcode.util.ResourcesUtils
import com.sanniou.common.utilcode.util.ToastUtils
import com.sanniou.common.widget.recyclerview.Item

/**
 * 贴吧头
 */
class ForumTopItem(
    var forumImage: String,
    var forumName: String,
    var forumMember: String,
    var forumSlogan: String,
    var isLike: Boolean,
    var forumLevel: String,
    private var isSignIn: Boolean,
    private var forumSignCount: String
) : Item {
    val signInStr = ObservableField(if (isSignIn) "已签${forumSignCount}天" else "未签到")
    override fun getType() = R.layout.item_forum_top

    fun signIn() {
        if (isSignIn) return

        TiebaRequest.sign(forumName)
            .subscribe {
                ToastUtils.showShort("签到成功！")
                signInStr.set("已签${forumSignCount + 1}天")
            }

    }

    fun getStrokeColor() = ResourcesUtils.getColor(R.color.design_blue)
}