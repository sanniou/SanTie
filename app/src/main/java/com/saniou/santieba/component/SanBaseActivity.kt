package com.saniou.santieba.component

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.LayoutInflaterCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.saniou.santieba.BR
import com.saniou.santieba.R
import com.saniou.santieba.skin.SkinFactory
import com.saniou.santieba.skin.SkinResources
import com.sanniou.support.components.BaseScopedActivity

abstract class SanBaseActivity<T : ViewModel> : BaseScopedActivity<T>() {
    override fun getModelId() = BR.viewModel

    private val skinFactory = SkinFactory()

    override fun onCreate(savedInstanceState: Bundle?) {
        loadSkin()
        LayoutInflaterCompat.setFactory2(LayoutInflater.from(this), skinFactory)
        this.window
            .decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        super.onCreate(savedInstanceState)
    }

    /**
     * 加载皮肤包
     * 获取[AppCompatActivity]类,并通过反射取得[mResources]，并重新设置为[SkinResources]
     */
    private fun loadSkin() {
        val field =
            getSuperClassByName(AppCompatActivity::class.java.name).getDeclaredField("mResources")

        val skinResources = SkinResources(this, resources, "/storage/emulated/0/skin.src")
        skinResources.supportSkin = true
        field.let {
            it.isAccessible = true
            it.set(this, skinResources)
        }
        skinResources.loadedSkinLiveDate
            .observe(this, Observer { loaded ->
                if (loaded) {
                    applySkin()
                }
            })
    }

    /**
     * 支持插件更新
     */
    private fun applySkin() {
        skinFactory.viewMap.map {
            skinFactory.applySkin(it.key, it.value)
        }
        with(window) {
            navigationBarColor = resources.getColor(R.color.colorPrimary)
            setBackgroundDrawableResource(R.color.backgroundColor)
            statusBarColor = resources.getColor(R.color.colorPrimary)
        }
    }

    /**
     * 获取activity父类
     */
    private fun getSuperClassByName(className: String): Class<AppCompatActivity> {
        var clazz: Class<in Nothing> = this::class.java.superclass!!
        while (clazz.name != className) {
            clazz = clazz.superclass!!
        }
        return clazz as Class<AppCompatActivity>
    }
}