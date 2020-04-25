package com.saniou.santieba.viewmodel

import com.saniou.santieba.api.TiebaRequest
import com.saniou.santieba.constant.PORTRAIT_HOST
import com.saniou.santieba.kts.toBool
import com.saniou.santieba.vo.FansItem

class FansListViewModel : PageAutoListItemViewModel() {

    override fun initParam(param: Map<String, String>) {
        super.initParam(param)
        title.value = "${if (getValue("friendId").isEmpty()) "我" else "他"}的粉丝"
    }

    override suspend fun fetchPage(page: Int) =
        TiebaRequest.fans(getValue("friendId"), page.toString())
            .let { fans ->
                fans.userList
                    .forEach {
                        addItem(
                            FansItem(
                                "$PORTRAIT_HOST${it.portrait}",
                                "${it.nameShow}(${it.name})",
                                it.id,
                                it.portrait,
                                it.isFriend.toBool(),
                                it.intro.ifEmpty { null }
                            )
                        )
                    }
                fans.userList.isNotEmpty()
            }
}