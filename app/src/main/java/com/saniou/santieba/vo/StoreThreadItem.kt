package com.saniou.santieba.vo

import com.saniou.santieba.R
import com.sanniou.multiitem.DataItem

class StoreThreadItem(
    var name: String,
    var forum: String,
    var avatar: String,
    var firstTime: CharSequence,
    var lastTime: CharSequence,
    var title: String,
    var media: String?,
    var replayCount: String,
    var tid: String,
    var isDeleted: Boolean,
    var uid: String
) : DataItem {
    override fun getItemType() = R.layout.item_thread_store
}