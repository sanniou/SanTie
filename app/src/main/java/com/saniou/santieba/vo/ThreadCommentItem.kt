package com.saniou.santieba.vo

import com.saniou.santieba.R
import com.sanniou.common.widget.recyclerview.Item

class ThreadCommentItem(
    var avatar: String,
    var name: CharSequence,
    var levle: CharSequence,
    var time: CharSequence
) : Item {
    override fun getType() = R.layout.item_thread_comment
}