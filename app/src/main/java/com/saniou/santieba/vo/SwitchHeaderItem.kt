package com.saniou.santieba.vo

import com.saniou.santieba.R
import com.sanniou.multiitem.DataItem

class SwitchHeaderItem(val des:String,val switchDes:String) : DataItem {
    override fun getItemType() = R.layout.item_switch_header
}