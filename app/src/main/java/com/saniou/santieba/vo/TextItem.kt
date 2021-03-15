package com.saniou.santieba.vo

import com.saniou.santieba.R
import com.sanniou.multiitem.DataItem

class TextItem(
    var text: CharSequence,
    val textSize: Int = 14,
    val textColor: Int = R.color.normalText,
    val any: Any? = null,
) : DataItem {
    override fun getItemType() = R.layout.item_text

    companion object {
        fun normal(text: CharSequence) = TextItem(text, 14, R.color.normalText)

        fun major(text: CharSequence) = TextItem(text, 16, R.color.majorText)

        fun minor(text: CharSequence) = TextItem(text, 11, R.color.minorText)
    }
}