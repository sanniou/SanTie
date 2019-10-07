package com.saniou.santieba.utils

import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.text.TextPaint
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView
import com.saniou.santieba.R
import com.saniou.santieba.api.bean.Content
import com.saniou.santieba.component.ForumMainActivity
import com.saniou.santieba.component.ThreadDetailActivity
import com.saniou.santieba.constant.*
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
                    ?.setForegroundColor(ResourcesUtils.getColor(R.color.colorPrimary))
                    ?.setClickSpan(LinkClickSpan(it.text.toString()))
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
                    ?.setClickSpan(LinkClickSpan(it.text.toString()))
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

private class LinkClickSpan(val url: String) : ClickableSpan() {
    override fun updateDrawState(ds: TextPaint) {
        ds.isUnderlineText = false
    }

    override fun onClick(view: View) {
        if (url.startsWith(TIEBA_HOST)) {
            val intent = Intent(ActivityUtils.getTopActivity(), ThreadDetailActivity::class.java)
            intent.putExtra("tid", url.replace(TIEBA_HOST, ""))
            ActivityUtils.startActivity(intent)
            return
        }

        if (url.startsWith(TIEBA_FORUM_HOST)) {
            val intent = Intent(ActivityUtils.getTopActivity(), ForumMainActivity::class.java)
            intent.putExtra("name", url.replace(TIEBA_HOST, ""))
            ActivityUtils.startActivity(intent)
            return
        }

        openBrowser(url)
    }
}

fun openBrowser(url: String) {

    val i = Intent(Intent.ACTION_VIEW)
    i.data = Uri.parse(url)
    ActivityUtils.startActivity(i)
}