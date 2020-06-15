package com.saniou.santieba.viewmodel

import com.saniou.santieba.model.api.interfaces.SanTiebaApi
import com.saniou.santieba.model.bean.ForumPage
import com.saniou.santieba.vo.FlexListItem
import com.saniou.santieba.vo.TextItem

class ForumGoodViewModel : ForumPageViewModel() {

    private var goodClassifyId = ""

    override suspend fun forumPage(page: Int): ForumPage {
        return SanTiebaApi.forumPage(name, page, goodClassifyId = goodClassifyId)
    }

    override fun onRefresh() {
        super.onRefresh()
        goodClassify.firstOrNull()?.run {
            goodClassifyId = this.classId
            set(0, FlexListItem().apply {
                data.addAll(goodClassify.map { TextItem(it.className) })
            })
        }
    }
}