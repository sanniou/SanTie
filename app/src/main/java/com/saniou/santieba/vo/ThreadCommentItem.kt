package com.saniou.santieba.vo

import com.saniou.santieba.R
import com.sanniou.multiitem.DataItem

class ThreadCommentItem(
    var floor: Int,
    var avatar: String,
    var name: CharSequence,
    var levle: CharSequence,
    var time: CharSequence,
    var uid: String
) : DataItem {
    override fun getItemType() = R.layout.item_thread_comment
}

class ThreadBottomItem(
    var pid: CharSequence,
    var replayCounts: Int
) : DataItem {
    override fun getItemType() = R.layout.item_thread_bottom
}