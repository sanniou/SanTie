package com.saniou.santieba.vo

import com.saniou.santieba.R
import com.sanniou.multiitem.DataItem

class FriendThreadItem(
    var forum: String,
    var firstTime: CharSequence,
    var title: String,
    var media: String?,
    var replayCount: String,
    var tid: String
) : DataItem {
    override fun getItemType() = R.layout.item_thread_friend
}