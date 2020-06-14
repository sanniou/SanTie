package com.saniou.santieba.viewmodel

import com.saniou.santieba.R
import com.saniou.santieba.model.TiebaRequest
import com.saniou.santieba.constant.PORTRAIT_HOST
import com.saniou.santieba.constant.RANGE_NUMBER
import com.saniou.santieba.kts.toBool
import com.saniou.santieba.vo.FollowItem
import com.saniou.santieba.vo.SwitchHeaderItem

class FollowsListViewModel : PageAutoListItemViewModel() {

    private var tab = 0

    override fun initParam(param: Map<String, String>) {
        super.initParam(param)
        // title.value = "${if (getValue("uid").isEmpty()) "我" else "他"}的关注"
    }

    override fun getHeaderType() = R.layout.item_switch_header

    override fun getHeaderClickable() = intArrayOf(R.id.layout_switch)

    override fun handlerHeaderClick(id: Int, position: Int) {
        tab = tab xor 1
        refresh()
    }

    override fun beforeRefresh() {
        add(SwitchHeaderItem("${getFollowState()}0人", getFollowState()))
    }

    override suspend fun fetchPage(page: Int) =
        TiebaRequest.followList(getValue("uid"), page, tab)
            .let { follows ->
                if (page == 1) {
                    if (follows.commonFollowList.isNotEmpty()) {
                        set(
                            0, SwitchHeaderItem(
                                "共同关注${follows.commonFollowList.size}人",
                                getFollowState()
                            )
                        )
                        follows.commonFollowList
                            .forEach {
                                addItem(
                                    FollowItem(
                                        "$PORTRAIT_HOST${it.portrait}",
                                        "${it.nameShow}(${it.name})",
                                        it.id,
                                        it.portrait,
                                        it.hasConcerned.toBool(),
                                        false,
                                        it.intro
                                    )
                                )
                            }

                        addItem(
                            SwitchHeaderItem(
                                "${getFollowState()}${follows.totalFollowNum}人",
                                getFollowState()
                            )
                        )
                    } else {
                        set(
                            0, SwitchHeaderItem(
                                "${getFollowState()}${follows.totalFollowNum}人",
                                getFollowState()
                            )
                        )
                    }
                }
                follows.followList
                    .forEach {
                        addItem(
                            FollowItem(
                                "$PORTRAIT_HOST${it.portrait}",
                                "${it.nameShow}(${it.name})",
                                it.id,
                                it.portrait,
                                it.hasConcerned.toBool(),
                                it.isFriend.toBool(),
                                it.intro
                            )
                        )
                    }
                follows.followList.size == RANGE_NUMBER
            }

    private fun getFollowState() = if (tab == 0) "全部关注" else "互相关注"
}