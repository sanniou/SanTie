package com.saniou.santieba.viewmodel

import com.blankj.utilcode.util.ToastUtils
import com.saniou.santieba.constant.RANGE_NUMBER
import com.saniou.santieba.model.api.interfaces.SanTiebaApi
import com.saniou.santieba.model.api.reqeust.ForumSortType
import com.sanniou.support.exception.ExceptionEngine

class ForumInfoViewModel : ListItemViewModel() {

    override val autoRefresh: Boolean
        get() = true

    override fun onRefresh() {
        fetchData()
    }

    override fun fetchData() {
        launch {
            try {
                SanTiebaApi.webForumPage(
                    getValue("forum"),
                    1,
                    null,
                    ForumSortType.REPLY_TIME,
                    RANGE_NUMBER
                ).also {

                }
                refreshState.value = true
            } catch (e: Exception) {
                refreshState.value = false
                ToastUtils.showShort(ExceptionEngine.handleMessage(e))
            }
        }
    }
}