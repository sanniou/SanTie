package com.saniou.santieba.vo

import com.saniou.santieba.R
import com.sanniou.multiitem.DataItem

class TextItem(var text:CharSequence) : DataItem {
    override fun getItemType() = R.layout.item_text
}