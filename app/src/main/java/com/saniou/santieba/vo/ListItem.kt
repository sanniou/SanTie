package com.saniou.santieba.vo

import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.saniou.santieba.R
import com.sanniou.multiitem.AdapterViewHolder
import com.sanniou.multiitem.DataItem
import com.sanniou.multiitem.MultiItemArrayList

open class ListItem() : DataItem {
    var customerLayoutManager = false
    var layoutManager = "LinearLayoutManager"
    var data = MultiItemArrayList<DataItem>()

    override fun getItemType() = R.layout.item_list
}

class FlexListItem : ListItem() {

    init {
        customerLayoutManager = true
    }

    override fun onBind(holder: AdapterViewHolder) {
        (holder.itemView as RecyclerView).run {
            if (layoutManager !is FlexboxLayoutManager) {
                layoutManager = FlexboxLayoutManager(holder.itemView.context)
            }
        }
        super.onBind(holder)
    }
}