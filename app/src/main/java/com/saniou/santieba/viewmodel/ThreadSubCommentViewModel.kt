package com.saniou.santieba.viewmodel

import android.annotation.SuppressLint
import com.saniou.santieba.api.TiebaRequest
import com.saniou.santieba.constant.*
import com.saniou.santieba.utils.analyzeText
import com.saniou.santieba.vo.CommentTextItem
import com.saniou.santieba.vo.ThreadCommentItem
import com.sanniou.common.databinding.BaseObservableListViewModel
import com.sanniou.common.helper.ListUtil
import com.sanniou.common.network.exception.ExceptionEngine
import com.sanniou.common.utilcode.util.ToastUtils
import com.sanniou.common.vo.LoadCallBack
import com.sanniou.common.vo.LoadMoreItem
import com.sanniou.common.vo.OnLoadListener

class ThreadSubCommentViewModel : BaseObservableListViewModel(), OnLoadListener {

    var pid = ""
    private var spid = ""
    var threadId = ""
    private var pageNumber = 1
    private val loadMoreItem = LoadMoreItem(this)

    override fun onLoad(callBack: LoadCallBack): Boolean {
        getSubComment(pageNumber.toString())
        return true
    }


    fun init() {
        clear()
        pageNumber = 1
        loadMoreItem.ready()
        add(loadMoreItem)
    }


    @SuppressLint("CheckResult")
    fun getSubComment(pn: String) {
        TiebaRequest.getSubFloor(threadId, pid, spid, pn)
            .`as`(bindLifeEvent())
            .subscribe({ subComment ->
                ListUtil.removeLast(items)
                pageNumber++

                val author = subComment.post.author
                add(
                    ThreadCommentItem(
                        subComment.post.floor,
                        "$PORTRAIT_HOST + ${author.portrait}",
                        "${author.name_show}(${author.name})"
                        , author.level_id,
                        subComment.post.time
                    )
                )
                subComment.post.content.forEach {
                    when (it.type) {
                        TEXT -> {
                            add(CommentTextItem(it.text))
                        }
                        EMOJI -> {
                            add(CommentTextItem(it.text))
                        }
                        VIDEO -> {
                        }
                        IMAGE -> {
                        }
                        VOICE -> {
                        }

                    }
                }

                subComment.subpost_list.forEach { subPost ->
                    val subAuthor = subPost.author
                    add(
                        ThreadCommentItem(
                            subPost.floor,
                            "$PORTRAIT_HOST + ${subAuthor.portrait}",
                            "${subAuthor.name_show}(${subAuthor.name})"
                            , subAuthor.level_id,
                            subComment.post.time
                        )
                    )


                    analyzeText(subPost.content).forEach {
                        when (it.type) {
                            TEXT -> {
                                add(CommentTextItem(it.text))
                            }
                            EMOJI -> {
                                add(CommentTextItem(it.text))
                            }
                            VIDEO -> {
                            }
                            IMAGE -> {
                            }
                            VOICE -> {
                            }

                        }
                    }

                }

                add(loadMoreItem)
                loadMoreItem.loadSuccess(subComment.subpost_list.isNotEmpty())
                updateUi(0)
            }) {
                ToastUtils.showShort(ExceptionEngine.handleMessage(it))
                loadMoreItem.loadFailed()
                updateUi(1)
            }

    }


}