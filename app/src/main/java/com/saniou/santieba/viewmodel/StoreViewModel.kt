package com.saniou.santieba.viewmodel

import android.annotation.SuppressLint
import com.saniou.santieba.api.TiebaRequest
import com.saniou.santieba.constant.EVENT_UI_REFRESH_FAILED
import com.saniou.santieba.constant.EVENT_UI_REFRESH_SUCCESS
import com.saniou.santieba.constant.PORTRAIT_HOST
import com.saniou.santieba.constant.RANGE_NUMBER
import com.saniou.santieba.kts.getDisplayTime
import com.saniou.santieba.vo.ThreadStoreItem
import com.sanniou.common.databinding.BaseObservableListViewModel
import com.sanniou.common.helper.ListUtil
import com.sanniou.common.network.exception.ExceptionEngine
import com.sanniou.common.utilcode.util.ToastUtils
import com.sanniou.common.vo.LoadCallBack
import com.sanniou.common.vo.LoadMoreItem
import com.sanniou.common.vo.OnLoadListener

@SuppressLint("CheckResult")
class StoreViewModel : BaseObservableListViewModel(), OnLoadListener {

    override fun onLoad(callBack: LoadCallBack): Boolean {
        threadStore(mPageNum)
        return true
    }

    private val loadMoreItem = LoadMoreItem(this)
    var uId: String = ""
    private var mPageNum = 1

    fun init() {
        clear()
        mPageNum = 1
        loadMoreItem.ready()
        add(loadMoreItem)
    }

    private fun threadStore(pageNumber: Int) {
        TiebaRequest.threadstore(pageNumber, uId)
            .`as`(bindLifeEvent())
            .subscribe({ threadData ->
                mPageNum++
                ListUtil.removeLast(items)

                threadData.store_thread.forEach {
                    add(
                        ThreadStoreItem(
                            "${it.author.name_show}(${it.author.name})",
                            it.forum_name,
                            "$PORTRAIT_HOST${it.author.user_portrait}",
                            getDisplayTime(it.create_time),
                            getDisplayTime(it.last_time),
                            it.title, it.media[0].small_pic,
                            it.reply_num,
                            it.thread_id,
                            it.is_deleted,
                            it.author.lz_uid
                        )
                    )
                }

                add(loadMoreItem)
                loadMoreItem.loadSuccess(threadData.store_thread.size == RANGE_NUMBER)
                updateUi(EVENT_UI_REFRESH_SUCCESS)
            }) {
                ToastUtils.showShort(ExceptionEngine.handleMessage(it))
                loadMoreItem.loadFailed()
                updateUi(EVENT_UI_REFRESH_FAILED)
            }
    }

}