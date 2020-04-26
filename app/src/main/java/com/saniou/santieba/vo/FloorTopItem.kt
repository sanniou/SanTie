package com.saniou.santieba.vo

import com.saniou.santieba.R
import com.saniou.santieba.constant.LEVEL_CLOLRS
import com.sanniou.multiitem.DataItem

class FloorTopItem(
    var floor: Int,
    var avatar: String,
    var name: CharSequence,
    var levle: Int,
    var time: CharSequence,
    var uid: String,
    var pid: String,
    var isPoster: Boolean = false
) : DataItem {
    var levelColor: Int = LEVEL_CLOLRS[levle]
    var radius = 0

    override fun getItemType() = R.layout.item_floor_top
}

class FloorBottomItem(
    var pid: CharSequence,
    var replayCounts: Int
) : DataItem {
    override fun getItemType() = R.layout.item_floor_bottom
}