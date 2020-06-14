package com.saniou.santieba.vo

import com.saniou.santieba.R
import com.sanniou.multiitem.DataItem

class SearchForumItem(var fname: CharSequence) : DataItem {
    override fun getItemType() = R.layout.item_search_forum
}

class SearchThreadItem(
    var title: CharSequence,
    var content: CharSequence,
    var time: CharSequence,
    var author: CharSequence,
    var replayCount: Int,
    var isFloor: Boolean,
    var isReplay: Boolean,
    var pid: String,
    var tid: String,
    var forum: CharSequence
) : DataItem {
    override fun getItemType() = R.layout.item_search_thread
}