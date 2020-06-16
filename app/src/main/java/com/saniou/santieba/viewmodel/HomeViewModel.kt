package com.saniou.santieba.viewmodel

import com.blankj.utilcode.util.ToastUtils
import com.saniou.santieba.kts.toBool
import com.saniou.santieba.model.api.interfaces.SanTiebaApi
import com.saniou.santieba.vo.ForumItem
import com.sanniou.support.exception.ExceptionEngine

class HomeViewModel : ListItemViewModel() {

    override val span = 2

    override val refreshable = true

    init {
        startRefresh.value = Unit
    }

    override fun fetchData() {
        launch {
            try {
                SanTiebaApi.forumRecommend()
                    .likeForum
                    .map {
                        ForumItem(
                            it.forumName,
                            it.avatar,
                            it.isSign.toBool(),
                            it.levelId.toInt()
                        )
                    }.addTo()
                refreshState.value = true
            } catch (e: Exception) {
                refreshState.value = false
                ToastUtils.showShort(ExceptionEngine.handleMessage(e))
            }
        }
    }
}