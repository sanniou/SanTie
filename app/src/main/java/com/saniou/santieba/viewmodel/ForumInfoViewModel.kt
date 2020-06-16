package com.saniou.santieba.viewmodel

import com.blankj.utilcode.util.ToastUtils
import com.saniou.santieba.constant.RANGE_NUMBER
import com.saniou.santieba.model.api.interfaces.SanTiebaApi
import com.saniou.santieba.model.api.reqeust.ForumSortType
import com.saniou.santieba.vo.DividerItem
import com.saniou.santieba.vo.TextItem
import com.sanniou.support.exception.ExceptionEngine

class ForumInfoViewModel : ListItemViewModel() {

    override val refreshable: Boolean
        get() = true

    override fun fetchData() {
        launch {
            try {
                SanTiebaApi.webForumPage(
                    getValue("forum"),
                    1,
                    null,
                    ForumSortType.REPLY_TIME,
                    RANGE_NUMBER
                ).frsData.forum.run {
                    add(TextItem.major(name))
                    add(TextItem.minor(firstClass))
                    add(TextItem.minor(secondClass))
                    add(TextItem.normal(slogan))
                    add(TextItem.normal("关注：$memberNum"))
                    add(TextItem.normal("帖子：$postNum"))

                    add(DividerItem.bar())
                    add(TextItem.major("吧主"))
                    managers.forEach {
                        add(TextItem.normal(it.name))
                    }
                    attrs.run {
                        add(DividerItem.bar())
                        add(TextItem.major(zyqtitle))
                        zyqdefine.forEach {
                            add(TextItem.normal(it.key))
                        }
                        add(DividerItem.bar())
                        add(TextItem.major("友情贴吧"))
                        zyqfriend.forEach {
                            add(TextItem.normal(it))
                        }
                    }
                }
                refreshState.value = true
            } catch (e: Exception) {
                refreshState.value = false
                ToastUtils.showShort(ExceptionEngine.handleMessage(e))
            }
        }
    }
}