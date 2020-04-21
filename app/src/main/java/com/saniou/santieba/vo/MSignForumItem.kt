package com.saniou.santieba.vo

import com.saniou.santieba.R
import com.sanniou.multiitem.DataItem

class MSignForumItem(
    var forumImage: String,
    var forumName: String,
    var forumLevel: String,
    var forumProgress: String,
    var forumSignIn: Boolean,
    var forumStateText: String
) : DataItem {
    override fun getItemType() = R.layout.item_msign_forum
}

class MSignHeaderItem(
    var header: String
) : DataItem {
    override fun getItemType() = R.layout.item_msign_header
}