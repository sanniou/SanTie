package com.saniou.santieba.vo


import com.saniou.santieba.R
import com.sanniou.common.utilcode.util.SizeUtils
import com.sanniou.common.widget.recyclerview.Item

class DividerItem(
    var height: Int = 4,
    var color: Int = 0,
    var backgroundColor: Int = 0,
    var padding: Int = 0
) : Item {

    override fun getGridSpan() = -1

    override fun getType() = R.layout.item_divider

}