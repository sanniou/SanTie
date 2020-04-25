package com.saniou.santieba.databinding

import android.content.Intent
import android.view.View
import androidx.databinding.BindingAdapter
import com.blankj.utilcode.util.ActivityUtils
import com.saniou.santieba.component.UserMainActivity
import com.saniou.santieba.component.toForum
import com.saniou.santieba.component.toThreadPageList
import com.sanniou.support.utils.openUrl

@BindingAdapter("toUrl")
fun toUrl(view: View, url: CharSequence) {
    view.setOnClickListener {
        openUrl(view.context, url.toString())
    }
}

@BindingAdapter("toForum")
fun toForum(view: View, forum: String) {
    view.setOnClickListener {
        toForum(forum)
    }
}

@BindingAdapter("toUser")
fun toUser(view: View, userId: String) {
    view.setOnClickListener {
        val intent = Intent(ActivityUtils.getTopActivity(), UserMainActivity::class.java)
        intent.putExtra("uid", userId)
        ActivityUtils.startActivity(intent)
    }
}

@BindingAdapter("toThread")
fun toThread(view: View, threadId: String) {
    view.setOnClickListener {
        toThreadPageList(threadId)
    }
}
