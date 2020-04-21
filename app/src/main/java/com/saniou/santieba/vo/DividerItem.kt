package com.saniou.santieba.vo


import com.saniou.santieba.R
import com.sanniou.multiitem.DataItem

class DividerItem(
    var height: Int = 4,
    var color: Int = 0,
    var backgroundColor: Int = 0,
    var padding: Int = 0
) : DataItem {

    override fun getGridSpan() = -1

    override fun getItemType() = R.layout.item_divider

}
