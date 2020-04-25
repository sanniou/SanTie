package com.saniou.santieba.vo

import com.saniou.santieba.R
import com.sanniou.multiitem.DataItem

class SimpleHeaderItem(
    var header: String
) : DataItem {
    override fun getItemType() = R.layout.item_simple_header
}