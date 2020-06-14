package com.saniou.santieba.skin

import android.content.Context
import android.content.res.Resources
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class SkinFactory : LayoutInflater.Factory2 {

    var viewMap = mutableMapOf<View, SkinView>()
    override fun onCreateView(
        parent: View?,
        name: String?,
        context: Context?,
        attrs: AttributeSet?
    ): View? {
        return attrs?.let {
            val textColorId = getAttributeResourceValue(it, "textColor")
            var srcId = getAttributeResourceValue(it, "src")
            if (srcId == 0)
                srcId = getAppResourceValue(it, "srcCompat")
            val backgroundId = getAttributeResourceValue(it, "background")
            if (textColorId != 0 || backgroundId != 0 || srcId != 0) {
                return@let createView(context!!, name!!, attrs)
                    ?.let { view ->
                        with(
                            SkinView(
                                textColorId = textColorId,
                                backgroundId = backgroundId,
                                srcId = srcId
                            )
                        ) {
                            viewMap[view] = this
                            applySkin(view, this)
                        }
                        view
                    }
            }
            return@let null
        }
    }

    /**
     * 通过[name]获取[attrs]里[http://schemas.android.com/apk/res/android]下的资源id
     */
    private fun getAttributeResourceValue(attrs: AttributeSet, name: String): Int {
        return attrs.getAttributeResourceValue(
            "http://schemas.android.com/apk/res/android",
            name,
            0
        )
    }

    /**
     * 通过[name]获取[attrs]里[http://schemas.android.com/apk/res-auto]下的资源id
     */
    private fun getAppResourceValue(attrs: AttributeSet, name: String): Int {
        return attrs.getAttributeResourceValue("http://schemas.android.com/apk/res-auto", name, 0)
    }

    /**
     * 创建view
     */
    private fun createView(context: Context, name: String, attrs: AttributeSet): View? {
        var view: View? = null
        try {
            if (-1 == name.indexOf('.')) {
                if ("View" == name) {
                    view = LayoutInflater.from(context).createView(name, "android.view.", attrs)
                }
                if (view == null) {
                    view = LayoutInflater.from(context).createView(name, "android.widget.", attrs)
                }
                if (view == null) {
                    view = LayoutInflater.from(context).createView(name, "android.webkit.", attrs)
                }
            } else {
                view = LayoutInflater.from(context).createView(name, null, attrs)
            }
        } catch (e: Exception) {
            view = null
        }
        return view
    }

    /**
     * 支持插件皮肤
     */
    fun applySkin(view: View, skinView: SkinView) {
        if (skinView.textColorId != 0) {
            (view as TextView).setTextColor(view.resources.getColor(skinView.textColorId))
        }
        if (skinView.backgroundId != 0) {
            try {
                view.background = view.resources.getDrawable(skinView.backgroundId)
            } catch (e: Resources.NotFoundException) {
                view.setBackgroundColor(view.resources.getColor(skinView.backgroundId))
            }
        }
        if (skinView.srcId != 0) {
            (view as ImageView).setImageResource(skinView.srcId)
        }
    }

    override fun onCreateView(name: String?, context: Context?, attrs: AttributeSet?): View? {
        return onCreateView(null, name, context, attrs)
    }
}

data class SkinView(var textColorId: Int, var srcId: Int, var backgroundId: Int)