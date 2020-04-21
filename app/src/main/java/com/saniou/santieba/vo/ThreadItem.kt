package com.saniou.santieba.vo

import android.text.SpannableStringBuilder
import com.blankj.utilcode.util.ColorUtils
import com.blankj.utilcode.util.SpanUtils
import com.saniou.santieba.R
import com.sanniou.multiitem.DataItem

//  暂定一个字段表示 top 的展示
const val showTop = false

class ThreadItem(
    private var isTop: Boolean,
    private var isGood: Boolean,
    private var isLivePost: Boolean,
    var tid: String,
    var title: CharSequence,
    var posterName: CharSequence,
    var replayCount: CharSequence,
    var zanCount: String,
    var content: CharSequence,
    var time: CharSequence,
    var avatar: String,
    var postImage: String = ""
) : DataItem {
    override fun getItemType() =
        if (isTop && !showTop) R.layout.item_thread_simple else R.layout.item_thread

    fun getShowTitle(): SpannableStringBuilder =
        SpanUtils()
            .append(if (isTop) "置顶." else "")
            .setForegroundColor(ColorUtils.getColor(R.color.design_blue))
            .append(if (isGood) "精." else "")
            .setForegroundColor(ColorUtils.getColor(R.color.design_red))
            .append(if (isLivePost) "话题." else "")
            .setForegroundColor(ColorUtils.getColor(R.color.design_blue))
            .append(title)
            .create()
}