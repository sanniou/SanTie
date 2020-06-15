package com.saniou.santieba.vo

import com.saniou.santieba.R
import com.sanniou.multiitem.DataItem
import com.sanniou.support.utils.ResourcesUtils

class DividerItem(
    var height: Int = 4,
    var color: Int = 0,
    var backgroundColor: Int = 0,
    var padding: Int = 0
) : DataItem {

    override fun getGridSpan() = -1

    override fun getItemType() = R.layout.item_divider

    companion object {
        fun bar ()=DividerItem(height=10,backgroundColor = ResourcesUtils.getColor(R.color.backgroundColorPress))
    }
}
