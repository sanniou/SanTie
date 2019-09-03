package com.saniou.santieba.viewmodel

import android.annotation.SuppressLint
import androidx.databinding.ObservableField
import com.saniou.santieba.api.TiebaRequest
import com.saniou.santieba.constant.RANGE_NUMBER
import com.saniou.santieba.constant.ThreadContentType
import com.saniou.santieba.utils.DateUtil
import com.saniou.santieba.vo.ForumTopItem
import com.saniou.santieba.vo.ThreadItem
import com.sanniou.common.databinding.BaseObservableListViewModel
import com.sanniou.common.helper.ListUtil
import com.sanniou.common.vo.LoadCallBack
import com.sanniou.common.vo.LoadMoreItem
import com.sanniou.common.vo.OnLoadListener

class ForumMainViewModel : BaseObservableListViewModel(), OnLoadListener {

    override fun onLoad(callBack: LoadCallBack): Boolean {
        requestPosts(mPage)
        return true
    }

    private val loadMoreItem = LoadMoreItem(this)
    var name = ""
    private var mPage = 1
    var forumName = ObservableField<String>()

    fun init() {
        clear()
        mPage = 1
        loadMoreItem.ready()
        add(loadMoreItem)

    }

    @SuppressLint("CheckResult")
    fun requestPosts(page: Int) {
        TiebaRequest.postPage(name, page)
            .`as`(bindLifeEvent())
            .subscribe { threadProfile ->
                mPage++
                val forum = threadProfile.forum
                forumName.set(forum.name)

                ListUtil.removeLast(items)
                if (list.size == 1) {
                    add(
                        ForumTopItem(
                            forum.avatar, forum.name,
                            "关注${forum.member_num} 帖子${forum.post_num} thread ${forum.thread_num}",
                            forum.slogan,
                            forum.is_like,
                            "LV${forum.level_id}${forum.level_name}\r\n${forum.cur_score}/${forum.levelup_score}",
                            forum.sign_in_info.user_info.is_sign_in == 1,
                            forum.sign_in_info.user_info.c_sign_num
                        )
                    )
                }

                //帖子列表
                threadProfile.thread_list.forEach { thread ->
                    var postImage = ""
                    if (!thread.media.isNullOrEmpty()) {
                        when (thread.media[0].type) {
                            ThreadContentType.IMAGE -> {
                                postImage = thread.media[0].src_pic
                            }
                            ThreadContentType.VOICE -> {
                                postImage =
                                    "https://apic.douyucdn.cn/upload/avatar/000/31/02/60_avatar_middle.jpg"
                            }
                        }
                    }

                    add(
                        ThreadItem(
                            thread.is_top == 1,
                            thread.is_good == 1,
                            thread.is_livepost == 1,
                            thread.tid,
                            thread.title,
                            "${thread.author.name_show}(${thread.author.name})",
                            thread.reply_num,
                            thread.abstract[0].text,
                            DateUtil.getDisplayTime(thread.create_time.toLong()),
                            "${ThreadContentType.PORTRAIT_HOST}${thread.author.portrait}",
                            postImage
                        )
                    )
                }

                add(loadMoreItem)
                loadMoreItem.loadSuccess(threadProfile.thread_list.size == threadProfile.page.page_size)
                updateUi(0)
            }
    }


}