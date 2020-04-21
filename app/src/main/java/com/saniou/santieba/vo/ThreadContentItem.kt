package com.saniou.santieba.vo

import android.widget.TextView
import com.saniou.santieba.R
import com.sanniou.multiitem.AdapterViewHolder
import com.sanniou.multiitem.DataItem
import com.sanniou.support.utils.BetterLinkMovementMethod

class CommentImageItem(
    var image: String,
    var orgImage: String,
    var first: Boolean = false
) : DataItem {
    override fun getItemType() = R.layout.item_comment_image
    fun getPlaceholder() = R.drawable.ic_launcher_background
}

class CommentTextItem(var content: CharSequence, var first: Boolean = false) : DataItem {

    override fun getItemType() = R.layout.item_comment_text

    override fun onAttached(holder: AdapterViewHolder) {
        super.onAttached(holder)
        holder.itemView.isEnabled = false
        holder.itemView.isEnabled = true
        (holder.itemView as TextView).movementMethod = BetterLinkMovementMethod.getInstance();
    }
}

class ThreadTitleItem(var content: CharSequence) : DataItem {
    override fun getItemType() = R.layout.item_thread_title
}

class CommentVoiceItem(var voice: String, var first: Boolean = false) : DataItem {
    override fun getItemType() = R.layout.item_comment_voice
}

class CommentVideoItem(var thumbnail: CharSequence, var video: CharSequence) : DataItem {
    override fun getItemType() = R.layout.item_comment_video
}

class SubCommentItem(var content: CharSequence, var pid: String, var threadId: String) : DataItem {
    fun getShowText() = content
    override fun getItemType() = R.layout.item_sub_comment
}


