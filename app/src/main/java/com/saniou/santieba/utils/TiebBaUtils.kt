package com.saniou.santieba.utils

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.text.style.ClickableSpan
import android.view.View
import androidx.core.content.ContextCompat
import com.blankj.utilcode.util.ActivityUtils
import com.blankj.utilcode.util.SpanUtils
import com.blankj.utilcode.util.Utils
import com.saniou.santieba.R
import com.saniou.santieba.api.bean.Content
import com.saniou.santieba.component.ForumMainActivity
import com.saniou.santieba.component.ThreadDetailActivity
import com.saniou.santieba.component.UserMainActivity
import com.saniou.santieba.constant.ATME
import com.saniou.santieba.constant.EMOJI
import com.saniou.santieba.constant.LINK
import com.saniou.santieba.constant.TEXT
import com.saniou.santieba.constant.TIEBA_FORUM_HOST
import com.saniou.santieba.constant.TIEBA_FORUM_HOST_2
import com.saniou.santieba.constant.TIEBA_HOST
import com.saniou.santieba.constant.TIEBA_HOST_2
import com.saniou.santieba.constant.TIEBA_USER_HOST
import com.sanniou.support.utils.ResourcesUtils
import com.sanniou.support.utils.openUrl

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
                getDrawable(it.text.toString())?.run {
                    charSpan?.appendImage(this)
                } ?: run {
                    charSpan?.append("[${it.c}]")
                }
            }
            ATME -> {
                charSpan ?: run {
                    charSpan = SpanUtils()
                }
                charSpan?.append(it.text)
                    ?.setForegroundColor(ResourcesUtils.getColor(R.color.design_blue))
                    ?.setClickSpan(LinkClickSpan(TIEBA_USER_HOST + it.uid))
            }

            else -> {
                charSpan?.run {
                    list.add(
                        Content(
                            text = charSpan!!.create(),
                            type = TEXT
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
                text = charSpan!!.create(),
                type = TEXT
            )
        )
        charSpan = null
    }
    return list
}

fun getDrawable(name: String): Drawable? {
    val resources = Utils.getApp().resources
    val resourceId = resources.getIdentifier(
        name, "drawable",
        Utils.getApp().packageName
    )
    return if (resourceId == 0) null else resources.getDrawable(resourceId)
}

private class LinkClickSpan(val url: String) : ClickableSpan() {
    override fun updateDrawState(ds: TextPaint) {
        ds.isUnderlineText = false
    }

    override fun onClick(view: View) {

        if (url.startsWith(TIEBA_HOST) || url.startsWith(TIEBA_HOST_2)) {
            val intent = Intent(ActivityUtils.getTopActivity(), ThreadDetailActivity::class.java)
            intent.putExtra("tid", url.replace(TIEBA_HOST, ""))
            ActivityUtils.startActivity(intent)
            return
        }

        if (url.startsWith(TIEBA_FORUM_HOST) || url.startsWith(TIEBA_FORUM_HOST_2)) {
            val intent = Intent(ActivityUtils.getTopActivity(), ForumMainActivity::class.java)
            intent.putExtra("name", url.replace(TIEBA_HOST, ""))
            ActivityUtils.startActivity(intent)
            return
        }

        if (url.startsWith(TIEBA_USER_HOST)) {
            val intent = Intent(ActivityUtils.getTopActivity(), UserMainActivity::class.java)
            intent.putExtra("uid", url.replace(TIEBA_USER_HOST, ""))
            ActivityUtils.startActivity(intent)
            return
        }
        openBrowser(view.context, url)
    }
}

fun openBrowser(context: Context, url: String) {
    openUrl(context, url, ContextCompat.getColor(context, R.color.colorPrimary))
}