package com.saniou.santieba.viewmodel

import android.annotation.SuppressLint
import androidx.databinding.ObservableField
import com.saniou.santieba.R
import com.saniou.santieba.api.TiebaRequest
import com.saniou.santieba.api.bean.UserXX
import com.saniou.santieba.constant.*
import com.saniou.santieba.utils.DateUtil
import com.saniou.santieba.utils.analyzeText
import com.saniou.santieba.vo.*
import com.sanniou.common.databinding.BaseObservableListViewModel
import com.sanniou.common.helper.ListUtil
import com.sanniou.common.network.exception.ExceptionEngine
import com.sanniou.common.utilcode.util.*
import com.sanniou.common.vo.LoadCallBack
import com.sanniou.common.vo.LoadMoreItem
import com.sanniou.common.vo.OnLoadListener

@SuppressLint("CheckResult")
class ThreadDetailViewModel : BaseObservableListViewModel(), OnLoadListener {

    var lzOly = false
    private var store = false
    var reverse = false
    var tid = ""
    private var mPid = ""
    var forumName = ObservableField("")
    private val loadMoreItem = LoadMoreItem(this)

    override fun onLoad(callBack: LoadCallBack): Boolean {
        requestPosts(mPid)
        return true
    }

    fun init() {
        clear()
        mPid = ""
        loadMoreItem.ready()
        add(loadMoreItem)
    }

    fun requestPosts(pid: String) {
        TiebaRequest.threadDetail(tid, pid, lzOly, reverse)
            .`as`(bindLifeEvent())
            .subscribe({ threadDetail ->
                ListUtil.removeLast(items)
                forumName.set(threadDetail.forum.name)
                store = threadDetail.thread.collect_status == 1
                if (store) {
                    updateUi(3)
                }

                // 用户列表
                val treadId = threadDetail.thread.id
                val userMap = mutableMapOf<String, UserXX>()
                threadDetail.user_list.forEach {
                    userMap[it.id] = it
                }
                if (pid.isEmpty()) {
                    add(ThreadTitleItem(threadDetail.thread.title))
                }

                //帖子列表
                threadDetail.post_list.forEach { post ->
                    val first = post.floor == 1

                    if (mPid == post.id) {
                        return@forEach
                    }

                    val currentUser = userMap[post.author_id]
                    // 帖头
                    add(
                        ThreadCommentItem(
                            post.floor,
                            "$PORTRAIT_HOST${currentUser?.portrait}",
                            "${currentUser?.name_show}(${currentUser?.name})",
                            currentUser?.level_id ?: "0",
                            DateUtil.getDisplayTime(post.time.toLong())
                        )
                    )
                    // 帖子内容
                    post.content.takeIf { it.isNotEmpty() }
                        ?.apply {
                            analyzeText(this).forEach {
                                when (it.type) {
                                    TEXT -> {
                                        add(CommentTextItem(it.text, first))
                                    }
                                    VIDEO -> {
                                        add(CommentVoiceItem(first))
                                    }
                                    VOICE -> {
                                        add(CommentVoiceItem(first))
                                    }
                                    IMAGE -> {
                                        add(
                                            CommentImageItem(
                                                it.cdn_src_active,
                                                first,
                                                it.show_original_btn == 1
                                            )
                                        )
                                    }
                                }
                            }
                        }

                    if (post.sub_post_number != 0) {
                        post.sub_post_list.sub_post_list.forEach { subContent ->
                            val currentUser2 = userMap[subContent.author_id]
                            val name = "${currentUser2?.name_show}(${currentUser2?.name})"
                            analyzeText(subContent.content).forEach {
                                add(
                                    SubCommentItem(
                                        SpanUtils().append("$name:")
                                            .setForegroundColor(ColorUtils.getColor(R.color.design_blue))
                                            .append(it.text)
                                            .create()!!,
                                        post.id, treadId
                                    )
                                )
                            }
                        }
                        if (post.sub_post_number > 10) {
                            add(SubCommentItem("查看全部回复${post.sub_post_number}条", post.id, treadId))
                        }
                    }
                    if (first) {
                        add(ThreadBottomItem(threadDetail.thread.id, threadDetail.thread.reply_num))
                        add(
                            DividerItem(
                                SizeUtils.dp2px(4F),
                                ResourcesUtils.getColor(R.color.backgroundColor)
                            )
                        )


                    } else {
                        add(
                            DividerItem(
                                ResourcesUtils.getDimensionPixelSize(R.dimen.comment_padding),
                                ResourcesUtils.getColor(R.color.config_white)
                            )
                        )
                        add(
                            DividerItem(
                                SizeUtils.dp2px(0.5F),
                                ResourcesUtils.getColor(R.color.backgroundColor),
                                ResourcesUtils.getColor(R.color.config_white),
                                ResourcesUtils.getDimensionPixelSize(R.dimen.comment_padding)
                            )
                        )
                    }
                    mPid = post.id
                }
                add(loadMoreItem)
                // 不知道为什么返回多 2 条
                loadMoreItem.loadSuccess(threadDetail.post_list.size == threadDetail.page.page_size + 2)
                updateUi(0)
                items
            }) {
                ToastUtils.showShort(ExceptionEngine.handleMessage(it))
                loadMoreItem.loadFailed()
                updateUi(1)
            }
    }

    private fun addStore() {
        TiebaRequest.addStore(tid, mPid)
            .`as`(bindLifeEvent())
            .subscribe({
                ToastUtils.showShort("收藏成功")
                updateUi(3)
                store = !store
            }) {
                ToastUtils.showShort(ExceptionEngine.handleMessage(it))
                updateUi(4)
            }

    }

    private fun rmStore() {
        TiebaRequest.rmStore(tid)
            .`as`(bindLifeEvent())
            .subscribe({
                ToastUtils.showShort("取消收藏成功")
                updateUi(4)
                store = !store
            }) {
                ToastUtils.showShort(ExceptionEngine.handleMessage(it))
                updateUi(3)
            }

    }

    fun changeStore() {
        if (store) {
            rmStore()
        } else {
            addStore()
        }
    }
}
