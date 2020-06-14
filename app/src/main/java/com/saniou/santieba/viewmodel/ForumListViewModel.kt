package com.saniou.santieba.viewmodel

import com.saniou.santieba.model.TiebaRequest
import com.saniou.santieba.constant.RANGE_NUMBER
import com.saniou.santieba.vo.SimpleForumItem

class ForumListViewModel : PageAutoListItemViewModel() {

    override fun initParam(param: Map<String, String>) {
        super.initParam(param)
        // title.value = "${if (getValue("friendId").isEmpty()) "我" else "他"}关注的吧"
    }

    override suspend fun fetchPage(page: Int) =
        TiebaRequest.likedForum(getValue("friendId"), page)
            .let { forum ->
                forum.commonForumList.nonGconforum.forEach {
                    addItem(
                        SimpleForumItem(
                            it.name,
                            it.avatar,
                            it.slogan,
                            "${it.levelName}${it.levelupScore}"
                        )
                    )
                }
                forum.forumList.nonGconforum.forEach {
                    addItem(
                        SimpleForumItem(
                            it.name,
                            it.avatar,
                            it.slogan,
                            "${it.levelName}${it.levelupScore}"
                        )
                    )
                }
                forum.forumList.nonGconforum.size == RANGE_NUMBER
            }
}
