package com.saniou.santieba.vo

import com.saniou.santieba.R
import com.sanniou.multiitem.DataItem

class SimpleForumItem(
    val forumName: String,
    val forumImage: CharSequence,
    val forumDes: CharSequence,
    val forumLevel: CharSequence,
    private val forumSignIn: Int? = null
) : DataItem {

    fun getForumStateText() =
        when (forumSignIn) {
            null -> ""
            0 -> "已签到"
            -1 -> "未签到"
            else -> "已签到${forumSignIn}天"
        }

    override fun getItemType() = R.layout.item_simple_forum
}