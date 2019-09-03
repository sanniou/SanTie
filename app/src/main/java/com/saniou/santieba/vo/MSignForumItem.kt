package com.saniou.santieba.vo

import com.saniou.santieba.R
import com.sanniou.common.widget.recyclerview.Item

class MSignForumItem(
    var forumImage: String,
    var forumName: String,
    var forumLevel: String,
    var forumProgress: String,
    var forumState: Boolean,
    var forumStateText: String
) : Item {
    override fun getType() = R.layout.item_msign_forum
}