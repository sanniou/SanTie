package com.saniou.santieba.viewmodel

import android.annotation.SuppressLint
import androidx.databinding.ObservableField
import com.saniou.santieba.R
import com.saniou.santieba.api.TiebaRequest
import com.saniou.santieba.constant.*
import com.saniou.santieba.kts.getDisplayTime
import com.saniou.santieba.vo.ForumTopItem
import com.saniou.santieba.vo.ThreadItem
import com.sanniou.common.databinding.BaseObservableListViewModel
import com.sanniou.common.helper.ListUtil
import com.sanniou.common.network.exception.ExceptionEngine
import com.sanniou.common.utilcode.util.ToastUtils
import com.sanniou.common.vo.LoadCallBack
import com.sanniou.common.vo.LoadMoreItem
import com.sanniou.common.vo.OnLoadListener

@SuppressLint("CheckResult")
class ForumMainViewModel : BaseObservableListViewModel(), OnLoadListener {

    override fun onLoad(callBack: LoadCallBack): Boolean {
        requestPosts(mPage)
        return true
    }

    private val loadMoreItem = LoadMoreItem(this)
    var name = ""
    var isGood = false
    private var mPage = 1
    private var fid = ""
    private var subscribed = false
    var forumName = ObservableField("")

    fun init() {
        clear()
        mPage = 1
        updateUi(if (isGood) 3 else 4)
        loadMoreItem.ready()
        add(loadMoreItem)
    }

    fun requestPosts(page: Int) {

        TiebaRequest.postPage(name, page, isGood)
            .`as`(bindLifeEvent())
            .subscribe({ threadProfile ->
                fid = threadProfile.forum.id
                mPage++
                val forum = threadProfile.forum
                forumName.set(forum.name)
                subscribed = forum.is_like == 1

                if (list.size == 1) {
                    add(
                        0,
                        ForumTopItem(
                            forum.id,
                            forum.avatar, forum.name,
                            "关注 ${forum.member_num} 帖子 ${forum.post_num}",
                            forum.slogan,
                            forum.is_like == 1,
                            "LV${forum.level_id}${forum.level_name}\r\n${forum.cur_score}/${forum.levelup_score}",
                            forum.sign_in_info.user_info.is_sign_in == 1,
                            forum.sign_in_info.user_info.c_sign_num,
                            this::subscribe
                        )
                    )
                }

                ListUtil.removeLast(items)

                //帖子列表
                threadProfile.thread_list.forEach { thread ->
                    var postImage = ""
                    if (!thread.media.isNullOrEmpty()) {
                        when (thread.media[0].type) {
                            IMAGE -> {
                                postImage = thread.media[0].big_pic
                            }
                            VOICE -> {
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
                            getDisplayTime(thread.create_time.toLong()),
                            "$PORTRAIT_HOST${thread.author.portrait}",
                            postImage
                        )
                    )
                }

                add(loadMoreItem)
                loadMoreItem.loadSuccess(threadProfile.thread_list.size >= threadProfile.page.page_size)
                updateUi(EVENT_UI_REFRESH_SUCCESS)
            }) {
                ToastUtils.showShort(ExceptionEngine.handleMessage(it))
                loadMoreItem.loadFailed()
                updateUi(EVENT_UI_REFRESH_FAILED)
            }
    }

    fun unSubscribe() {
        if (!subscribed) {
            ToastUtils.showShort("未关注")
            return
        }
        TiebaRequest.unSubscribe(fid, name)
            .`as`(bindLifeEvent())
            .subscribe({
                ToastUtils.showShort(R.string.unsubscribe_success)
                init()
            }) {
                ToastUtils.showShort(ExceptionEngine.handleMessage(it))
            }
    }

    fun subscribe() {
        if (subscribed) {
            ToastUtils.showShort("已关注")
            return
        }
        TiebaRequest.subscribe(fid, name)
            .`as`(bindLifeEvent())
            .subscribe({
                ToastUtils.showShort(R.string.subscribe_success)
                init()
            }) {
                ToastUtils.showShort(ExceptionEngine.handleMessage(it))
            }
    }


}

