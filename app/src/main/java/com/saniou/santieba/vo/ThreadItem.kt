package com.saniou.santieba.vo

import android.content.Intent
import android.text.SpannableStringBuilder
import android.view.View
import com.saniou.santieba.R
import com.saniou.santieba.component.ThreadDetailActivity
import com.sanniou.common.utilcode.util.ActivityUtils
import com.sanniou.common.utilcode.util.ColorUtils
import com.sanniou.common.utilcode.util.SizeUtils
import com.sanniou.common.utilcode.util.SpanUtils
import com.sanniou.common.widget.recyclerview.Item

//  暂定一个字段表示 top 的展示
const val showTop = false

class ThreadItem(
    private var isTop: Boolean,
    private var isGood: Boolean,
    private var isLivePost: Boolean,
    var tid: String,
    var title: CharSequence,
    var posterName: CharSequence,
    var readCount: CharSequence,
    var content: CharSequence,
    var time: CharSequence,
    var avatar: String,
    var postImage: String = ""
) : Item {
    override fun getType() = if (isTop && !showTop) R.layout.item_thread_simple else R.layout.item_thread

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

    fun onClick(view: View) {
        val activity = ActivityUtils.getActivityByView(view)
        val intent = Intent(activity, ThreadDetailActivity::class.java)
        intent.putExtra("tid", tid)
        activity.startActivity(intent)
    }
}