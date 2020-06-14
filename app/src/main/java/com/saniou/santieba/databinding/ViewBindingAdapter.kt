package com.saniou.santieba.databinding

import android.content.Intent
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.transition.ChangeBounds
import androidx.transition.Slide
import androidx.transition.Transition
import androidx.transition.TransitionManager
import com.blankj.utilcode.util.ActivityUtils
import com.saniou.santieba.component.UserMainActivity
import com.sanniou.support.utils.openUrl

@BindingAdapter("toUrl")
fun toUrl(view: View, url: CharSequence) {
    view.setOnClickListener {
        openUrl(view.context, url.toString())
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
    // view.setOnClickListener {
    //     it.findNavController().navigate(R.id.forum_page_to_thread, Bundle().apply {
    //
    //     })
    //     toThreadPageList(threadId)
    // }
}

@BindingAdapter("topAnimation")
fun showTopAnimation(view: View, goTop: Boolean) {
    TransitionManager.beginDelayedTransition(view.parent as ViewGroup, ChangeBounds())
}
