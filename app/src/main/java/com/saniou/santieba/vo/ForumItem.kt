package com.saniou.santieba.vo

import com.saniou.santieba.R
import com.sanniou.common.utilcode.util.ResourcesUtils
import com.sanniou.common.widget.recyclerview.Item

class ForumItem(var name: String, var image: String, private var isSign: Boolean, levelInt: Int) :
    Item {

    private val LEVEL_CLOLRS = intArrayOf(
        R.color.design_yellow,
        R.color.design_yellow,
        R.color.design_yellow,
        R.color.design_yellow,
        R.color.design_yellow,
        R.color.design_yellow,
        R.color.design_yellow,
        R.color.design_yellow,
        R.color.design_yellow,
        R.color.design_yellow,
        R.color.design_yellow,
        R.color.design_yellow,
        R.color.design_yellow,
        R.color.design_yellow,
        R.color.design_yellow,
        R.color.design_yellow,
        R.color.design_yellow,
        R.color.design_yellow,
        R.color.design_yellow,
        R.color.design_yellow,
        R.color.design_yellow
    )


    var levelColor: Int
    var radius = 6
    var level = "LV$levelInt"

    init {
        levelColor = LEVEL_CLOLRS[levelInt]
    }

    fun getSignColor() =
        ResourcesUtils.getColor(if (isSign) R.color.config_blue else R.color.func_color)

    override fun getType() = R.layout.item_ba_text

    override fun getGridSpan() = 1
}