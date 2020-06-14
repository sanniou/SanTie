package com.saniou.santieba.skin

import android.content.Context
import android.content.pm.PackageManager
import android.content.res.AssetManager
import android.content.res.ColorStateList
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.lifecycle.MutableLiveData
import java.io.File

class SkinResources(context: Context, private val originResources: Resources, skinPath: String) :
    Resources(
        originResources.assets,
        originResources.displayMetrics,
        originResources.configuration
    ) {
    private var resources: Resources? = null
    var supportSkin: Boolean = false
    var loadedSkinLiveDate = MutableLiveData<Boolean>()
    var skinPkgName: String? = null

    init {
        loadSkin(context, skinPath)
    }

    /**
     * 加载皮肤包
     */
    fun loadSkin(context: Context, skinPath: String) {
        if (File(skinPath).exists()) {
            val packageManager = context.packageManager
            val packageInfo =
                packageManager.getPackageArchiveInfo(skinPath, PackageManager.GET_ACTIVITIES)
            skinPkgName = packageInfo.packageName
            val asset = AssetManager::class.java.newInstance()
            val method = asset.javaClass.getMethod("addAssetPath", String::class.java)
            method.invoke(asset, skinPath)
            resources = Resources(asset, displayMetrics, configuration)
            loadedSkinLiveDate.value = true
        }
    }

    /**
     * 获取皮肤包里对应的资源id
     */
    private fun getTheSameResId(id: Int): Int {
        if (id == 0)
            return 0
        val resName = originResources.getResourceName(id).substringAfterLast(":")
        val skinResId = try {
            resources?.getIdentifier(resName, originResources.getResourceTypeName(id), skinPkgName)
        } catch (e: NotFoundException) {
            0
        }
        return skinResId ?: 0
    }

    override fun getColorStateList(id: Int): ColorStateList {
        val skinResId = getTheSameResId(id)
        return if (resources != null && supportSkin && skinResId != 0) {
            try {
                resources!!.getColorStateList(skinResId)
            } catch (e: NotFoundException) {
                originResources.getColorStateList(id)
            }
        } else {
            originResources.getColorStateList(id)
        }
    }

    override fun getColorStateList(id: Int, theme: Theme?): ColorStateList {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return getColorStateList(id)
        }
        val skinResId = getTheSameResId(id)
        return if (resources != null && supportSkin && skinResId != 0) {
            try {
                resources!!.getColorStateList(skinResId, theme)
            } catch (e: NotFoundException) {
                originResources.getColorStateList(id, theme)
            }
        } else {
            originResources.getColorStateList(id, theme)
        }
    }

    override fun getColor(id: Int): Int {
        val skinResId = getTheSameResId(id)
        return if (resources != null && supportSkin && skinResId != 0) {
            try {
                resources!!.getColor(skinResId)
            } catch (e: NotFoundException) {
                originResources.getColor(id)
            }
        } else {
            originResources.getColor(id)
        }
    }

    override fun getColor(id: Int, theme: Theme?): Int {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return getColor(id)
        }
        val skinResId = getTheSameResId(id)

        return if (resources != null && supportSkin && skinResId != 0) {
            try {
                resources!!.getColor(skinResId, theme)
            } catch (e: NotFoundException) {
                originResources.getColor(id, theme)
            }
        } else {
            originResources.getColor(id, theme)
        }
    }

    override fun getDrawable(id: Int): Drawable {
        val skinResId = getTheSameResId(id)
        return if (resources != null && supportSkin && skinResId != 0) {
            try {
                resources!!.getDrawable(skinResId)
            } catch (e: NotFoundException) {
                originResources.getDrawable(id)
            }
        } else {
            originResources.getDrawable(id)
        }
    }

    override fun getDrawable(id: Int, theme: Theme?): Drawable {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return getDrawable(id)
        }
        val skinResId = getTheSameResId(id)
        return if (resources != null && supportSkin && skinResId != 0) {
            try {
                resources!!.getDrawable(skinResId, theme)
            } catch (e: NotFoundException) {
                originResources.getDrawable(id, theme)
            }
        } else {
            originResources.getDrawable(id, theme)
        }
    }
}