package com.saniou.santieba.viewmodel

import com.saniou.santieba.R
import com.saniou.santieba.model.TiebaRequest
import com.saniou.santieba.constant.PORTRAIT_HOST
import com.saniou.santieba.kts.toBool
import com.saniou.santieba.vo.FansItem
import com.saniou.santieba.vo.SimpleHeaderItem

class FansListViewModel : PageAutoListItemViewModel() {

    override fun initParam(param: Map<String, String>) {
        super.initParam(param)
        // title.value = "${if (getValue("friendId").isEmpty()) "我" else "他"}的粉丝"
    }

    override fun getHeaderType() = R.layout.item_simple_header

    override suspend fun fetchPage(page: Int): Boolean {
        val uid = getValue("friendId")
        return TiebaRequest.fans(uid, page.toString())
            .let { fans ->
                set(0, SimpleHeaderItem("粉丝${fans.page.totalCount}人"))

                fans.userList
                    .forEach {
                        addItem(
                            FansItem(
                                "$PORTRAIT_HOST${it.portrait}",
                                "${it.nameShow}(${it.name})",
                                it.id,
                                it.portrait,
                                it.hasConcerned.toBool(),
                                it.intro.ifEmpty { null },
                                current = uid.isEmpty()
                            )
                        )
                    }
                fans.userList.isNotEmpty()
            }
    }
}