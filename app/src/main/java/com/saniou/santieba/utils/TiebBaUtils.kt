package com.saniou.santieba.utils

import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.text.style.ClickableSpan
import android.view.View
import androidx.fragment.app.FragmentActivity
import com.saniou.santieba.R
import com.saniou.santieba.api.bean.Content
import com.saniou.santieba.constant.ThreadContentType
import com.sanniou.common.helper.ViewHelper
import com.sanniou.common.utilcode.util.*


fun analyzeText(contents: List<Content>): MutableList<Content> {
    val list = mutableListOf<Content>()
    var charSpan: SpanUtils? = null
    contents.forEach {
        when (it.type) {
            ThreadContentType.TEXT -> {
                charSpan ?: run {
                    charSpan = SpanUtils()
                }
                charSpan?.append(it.text)
            }
            ThreadContentType.LINK -> {
                charSpan ?: run {
                    charSpan = SpanUtils()
                }
                charSpan?.append(it.text)
                    ?.setForegroundColor(ResourcesUtils.getColor(R.color.design_blue))
                    ?.setClickSpan(LinkClickSpan())
            }
            ThreadContentType.EMOJI -> {
                charSpan ?: run {
                    charSpan = SpanUtils()
                }
                charSpan?.appendImage(getDrawable(it.text.toString()))
            }
            ThreadContentType.ATME -> {
                charSpan?.append(it.text)
                    ?.setForegroundColor(ResourcesUtils.getColor(R.color.design_blue))
                    ?.setClickSpan(LinkClickSpan())
            }
            else -> {
                charSpan?.run {
                    list.add(
                        Content(
                            "",
                            "",
                            "",
                            "",
                            "",
                            "",
                            "",
                            0,
                            "",
                            "",
                            charSpan!!.create(),
                            ThreadContentType.TEXT
                        )
                    )
                    charSpan = null
                }
                list.add(it)
            }
        }
    }
    charSpan?.run {
        list.add(
            Content(
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                0,
                "",
                "",
                charSpan!!.create(),
                ThreadContentType.TEXT
            )
        )
        charSpan = null
    }
    return list
}

fun getDrawable(name: String): Drawable {
    val resources = Utils.getApp().resources
    val resourceId = resources.getIdentifier(
        name, "drawable",
        Utils.getApp().packageName
    )
    return resources.getDrawable(resourceId)
}

class LinkClickSpan : ClickableSpan() {
    override fun updateDrawState(ds: TextPaint) {
        ds.isUnderlineText = false
    }

    override fun onClick(view: View) {

    }
}