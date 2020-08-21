package com.saniou.santieba.component;

import android.app.Activity
import android.os.Bundle
import com.saniou.santieba.utils.openBrowser
import com.saniou.santieba.utils.tiebaForumLinkFilter
import com.saniou.santieba.utils.tiebaThreadLinkFilter

class SchemeActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (tiebaThreadLinkFilter(intent)) {
            toThreadPageList(intent.getStringExtra("tid"))
        } else if (tiebaForumLinkFilter(intent)) {
            toForum(intent.getStringExtra("name"))
        } else {
            openBrowser(this, intent.data.toString())
        }
        finish()
        return
    }

    private fun toForum(stringExtra: String?) {
        TODO("Not yet implemented")
    }

    private fun toThreadPageList(stringExtra: String?) {
        TODO("Not yet implemented")
    }
}