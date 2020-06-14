package com.saniou.santieba.utils

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.text.style.ClickableSpan
import android.view.View
import androidx.core.content.ContextCompat
import com.blankj.utilcode.util.ActivityUtils
import com.blankj.utilcode.util.ColorUtils
import com.blankj.utilcode.util.SpanUtils
import com.blankj.utilcode.util.Utils
import com.saniou.santieba.R
import com.saniou.santieba.model.bean.Content
import com.saniou.santieba.model.bean.ThreadPage
import com.saniou.santieba.component.UserMainActivity
import com.saniou.santieba.component.toForum
import com.saniou.santieba.component.toThreadPageList
import com.saniou.santieba.constant.ATME
import com.saniou.santieba.constant.EMOJI
import com.saniou.santieba.constant.FORUM_SCHEME
import com.saniou.santieba.constant.LINK
import com.saniou.santieba.constant.TEXT
import com.saniou.santieba.constant.THREAD_SCHEME
import com.saniou.santieba.constant.THREAD_URL
import com.saniou.santieba.constant.TIEBA_FORUM_HOST
import com.saniou.santieba.constant.TIEBA_FORUM_HOST_2
import com.saniou.santieba.constant.TIEBA_HOST
import com.saniou.santieba.constant.TIEBA_HOST_2
import com.saniou.santieba.constant.TIEBA_USER_HOST
import com.sanniou.support.utils.ResourcesUtils
import com.sanniou.support.utils.openUrl
import java.net.URLDecoder

fun tiebaForumLinkFilter(intent: Intent): Boolean {
    if (Intent.ACTION_DEFAULT == intent.action) {
        if (FORUM_SCHEME == intent.scheme) {
            val decode = URLDecoder.decode(intent.data!!.toString(), "UTF-8")
            intent.putExtra(
                "name",
                decode.substring(decode.indexOf("kw=") + 3, decode.length)
            )
            return true;
        }
    }
    return false;
}

fun tiebaThreadLinkFilter(intent: Intent): Boolean {
    if (Intent.ACTION_DEFAULT == intent.action) {
        if (THREAD_SCHEME == intent.scheme) {
            intent.putExtra("outside", true)
            val uri = intent.data!!.toString()
            if (uri.startsWith(THREAD_URL)) {
                intent.putExtra("tid", uri.replace(".*tid=(\\d*)".toRegex(), "$1"))
            }
            return true
        }
    }
    return false;
}

fun analyzeSubText(
    name: String,
    subPoster: ThreadPage.Post.SubPostContent,
    isPoster: Boolean,
    contents: List<Content>
): MutableList<Content> {
    fun createSpan() = SpanUtils()
        .append(if (isPoster) "           " else "")
        .append("$name:")
        .setForegroundColor(ColorUtils.getColor(R.color.design_blue))
        .setClickSpan(LinkClickSpan(TIEBA_USER_HOST + subPoster.id))

    val list = mutableListOf<Content>()
    var charSpan: SpanUtils? = null
    contents.forEach {
        when (it.type) {
            TEXT -> {
                charSpan ?: run {
                    charSpan = createSpan()
                }
                charSpan?.append(it.text)
            }
            LINK -> {
                charSpan ?: run {
                    charSpan = createSpan()
                }
                charSpan?.append(it.text)
                    ?.setForegroundColor(ResourcesUtils.getColor(R.color.colorPrimary))
                    ?.setClickSpan(LinkClickSpan(it.text.toString()))
            }
            EMOJI -> {
                charSpan ?: run {
                    charSpan = createSpan()
                }
                getDrawable(it.text.toString())?.run {
                    charSpan?.appendImage(this)
                } ?: run {
                    charSpan?.append("[${it.c}]")
                }
            }
            ATME -> {
                charSpan ?: run {
                    charSpan = createSpan()
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
                type = TEXT,
                isPoster = isPoster
            )
        )
        charSpan = null
    }
    return list
}

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

class LinkClickSpan(val url: String) : ClickableSpan() {
    override fun updateDrawState(ds: TextPaint) {
        ds.isUnderlineText = false
    }

    override fun onClick(view: View) {

        if (url.startsWith(TIEBA_HOST) || url.startsWith(TIEBA_HOST_2)) {
            toThreadPageList(url.substring(url.indexOf("/p/") + 3, url.indexOf("?")))
            return
        }

        if (url.startsWith(TIEBA_FORUM_HOST) || url.startsWith(TIEBA_FORUM_HOST_2)) {
            toForum(url.substring(url.indexOf("kw=") + 3))
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