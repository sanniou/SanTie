package com.saniou.santieba.utils

import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.text.style.ClickableSpan
import android.view.View
import androidx.fragment.app.FragmentActivity
import com.saniou.santieba.R
import com.saniou.santieba.api.bean.Content
import com.saniou.santieba.constant.*
import com.sanniou.common.helper.ViewHelper
import com.sanniou.common.utilcode.util.*


fun analyzeText(contents: List<Content>): MutableList<Content> {
    val list = mutableListOf<Content>()
    var charSpan: SpanUtils? = null
    contents.forEach {
        when (it.type) {
            TEXT -> {
                charSpan ?: run {
                    charSpan = SpanUtils()
                }
                charSpan?.append(it.text)
            }
            LINK -> {
                charSpan ?: run {
                    charSpan = SpanUtils()
                }
                charSpan?.append(it.text)
                    ?.setForegroundColor(ResourcesUtils.getColor(R.color.design_blue))
                    ?.setClickSpan(LinkClickSpan())
            }
            EMOJI -> {
                charSpan ?: run {
                    charSpan = SpanUtils()
                }
                charSpan?.appendImage(getDrawable(it.text.toString()))
            }
            ATME -> {
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
                            TEXT
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
                TEXT
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