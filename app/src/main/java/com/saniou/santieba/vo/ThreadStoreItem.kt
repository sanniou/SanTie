package com.saniou.santieba.vo

import com.saniou.santieba.R
import com.sanniou.common.widget.recyclerview.Item

class ThreadStoreItem(var name: String,var tid:String) : Item {
    override fun getType() = R.layout.item_thread_store
}