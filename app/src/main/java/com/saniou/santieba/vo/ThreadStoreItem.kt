package com.saniou.santieba.vo

import com.saniou.santieba.R
import com.sanniou.common.widget.recyclerview.Item

class ThreadStoreItem(
    var name: String,
    var forum: String,
    var avatar: String,
    var firstTime: CharSequence,
    var lastTime: CharSequence,
    var title: String,
    var media: String,
    var replayCount: String,
    var tid: String,
    var isDeleted: Int,
    var lzid: String
) : Item {
    override fun getType() = R.layout.item_thread_store
}