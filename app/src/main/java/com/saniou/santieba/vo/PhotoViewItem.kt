package com.saniou.santieba.vo

import com.saniou.santieba.R
import com.saniou.santieba.widget.photoview.PhotoView
import com.sanniou.multiitem.AdapterViewHolder
import com.sanniou.multiitem.DataItem

class PhotoViewItem(val image: String) : DataItem {
    override fun getItemType() = R.layout.item_preview_image
    override fun onBind(holder: AdapterViewHolder) {
        (holder.itemView as PhotoView).run {
            maxScale = 5F
            enable()
            enableRotate()
        }
    }
}