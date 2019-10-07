package com.saniou.santieba.vo

import com.saniou.santieba.R
import com.sanniou.common.databinding.ImageViewDatabindingAdapter.bindingImage
import com.sanniou.common.helper.GlideApp
import com.sanniou.common.helper.ImageLoader
import com.sanniou.common.widget.recyclerview.Item


class CommentImageItem(
    var image: String,
    var orgImage: String,
    var first: Boolean = false,
    var isGif: Boolean = false
) :
    Item {
    override fun getType() = R.layout.item_comment_image
}

class CommentTextItem(var content: CharSequence, var first: Boolean = false) : Item {
    override fun getType() = R.layout.item_comment_text
}

class ThreadTitleItem(var content: CharSequence) : Item {
    override fun getType() = R.layout.item_thread_title
}

class CommentVoiceItem(var first: Boolean = false) : Item {
    override fun getType() = R.layout.item_comment_voice
}

class SubCommentItem(var content: CharSequence, var pid: String, var threadId: String) : Item {
    fun getShowText() = content
    override fun getType() = R.layout.item_sub_comment
}


