package com.saniou.santieba.vo

import com.saniou.santieba.R
import com.saniou.santieba.constant.LEVEL_CLOLRS
import com.sanniou.multiitem.DataItem
import com.sanniou.support.utils.ResourcesUtils

class ForumItem(var name: String, var image: String, private var isSign: Boolean, levelInt: Int) :
    DataItem {

    var levelColor: Int = LEVEL_CLOLRS[levelInt]
    var radius = 0
    var level = "LV$levelInt"

    fun getSignColor() =
        ResourcesUtils.getColor(if (isSign) R.color.config_blue else R.color.func_color)

    fun getSignBoardColor() =
        ResourcesUtils.getColor(R.color.config_blue)

    override fun getItemType() = R.layout.item_forum_simple

    override fun getGridSpan() = 1
}