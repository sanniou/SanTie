package com.saniou.santieba.viewmodel

import com.saniou.santieba.api.TiebaRequest
import com.saniou.santieba.vo.SearchForumItem
import com.sanniou.support.components.BaseListViewModel

class FeedViewModel : BaseListViewModel() {
    init {

        fetchFeed()
    }

    fun fetchFeed() {
        launch {
            TiebaRequest.feed("1")
                .let { thread ->
                    thread.feedThreadList
                        .forEach {
                            add(SearchForumItem(it.forumName))
                        }
                }
        }
    }
}