package com.saniou.santieba.viewmodel

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableInt
import com.blankj.utilcode.util.ToastUtils
import com.saniou.santieba.R
import com.saniou.santieba.api.TiebaRequest
import com.saniou.santieba.kts.getDisplayTime
import com.saniou.santieba.kts.toBool
import com.saniou.santieba.vo.MSignForumItem
import com.saniou.santieba.vo.MSignHeaderItem
import com.sanniou.support.components.BaseListViewModel
import com.sanniou.support.exception.ExceptionEngine

class MsignViewModel : BaseListViewModel() {
    private var forumIds = StringBuilder()
    private var manualSigns = mutableListOf<String>()
    val signImage = ObservableInt(R.drawable.icon_all_sign)

    val signed = ObservableBoolean(false);

    fun msign() {

        launch {
            try {
                if (signed.get()) {
                    ToastUtils.showShort("已签到")
                    return@launch
                }

                if (forumIds.isNotEmpty()) {
                    TiebaRequest.msign(forumIds.toString())
                }

                manualSigns.forEach {
                    TiebaRequest.sign(it)
                }

                ToastUtils.showShort("签到成功")
                getForumList()
                signImage.set(R.drawable.icon_all_sign_ok)
            } catch (e: Exception) {
                ToastUtils.showShort(ExceptionEngine.handleMessage(e))
            }
        }
    }

    fun getForumList() {
        clear()
        launch {
            try {
                TiebaRequest.getforumlist()
                    .let { forumListP ->
                        forumIds.clear()
                        add(MSignHeaderItem("7级以上的吧"))
                        forumListP.forumInfo.forEach {
                            if (!it.isSignIn.toBool()) {
                                forumIds.append(it.forumId)
                                forumIds.append(",")
                            }

                            add(
                                MSignForumItem(
                                    it.avatar,
                                    it.forumName,
                                    "LV${it.userLevel}",
                                    "${it.userExp}/${it.needExp}",
                                    it.isSignIn.toBool(),
                                    "已签到${it.contSignNum}天"
                                )
                            )
                        }
                        if (forumIds.isNotEmpty()) {
                            signImage.set(R.drawable.icon_all_sign)
                            forumIds.deleteCharAt(forumIds.length - 1)
                        } else {
                            signImage.set(R.drawable.icon_all_sign_ok)
                        }
                    }
                TiebaRequest.forumRecommend()
                    .let {
                        add(MSignHeaderItem("7级以下的吧"))

                        it.likeForum
                            .filter {
                                it.levelId.toInt() < 7
                            }
                            .forEach { forum ->
                                if (!forum.isSign.toBool()) {
                                    manualSigns.add(forum.forumName)
                                }
                                add(
                                    MSignForumItem(
                                        forum.avatar,
                                        forum.forumName,
                                        "LV${forum.levelId}",
                                        getDisplayTime(forum.inTime),
                                        forum.isSign.toBool(),
                                        if (forum.isSign.toBool()) "已签到" else "未签到"
                                    )
                                )
                            }
                    }

                signed.set(forumIds.isEmpty() && manualSigns.isEmpty())
            } catch (e: Exception) {
                ToastUtils.showShort(ExceptionEngine.handleMessage(e))
            }

        }
    }
}