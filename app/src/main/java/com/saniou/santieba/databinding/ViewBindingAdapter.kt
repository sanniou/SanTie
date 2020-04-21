package com.saniou.santieba.databinding

import android.content.Intent
import android.view.View
import androidx.databinding.BindingAdapter
import com.blankj.utilcode.util.ActivityUtils
import com.saniou.santieba.component.ForumMainActivity
import com.saniou.santieba.component.ThreadDetailActivity
import com.saniou.santieba.component.UserMainActivity
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
        val intent = Intent(view.context, ForumMainActivity::class.java)
        intent.putExtra("name", forum)
        view.context.startActivity(intent)
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
        val intent = Intent(view.context, ThreadDetailActivity::class.java)
        intent.putExtra("tid", threadId)
        view.context.startActivity(intent)
    }
}
