package com.saniou.santieba.viewmodel

import android.annotation.SuppressLint
import com.saniou.santieba.api.TiebaRequest
import com.saniou.santieba.component.MSignActivity
import com.saniou.santieba.vo.ForumItem
import com.sanniou.common.databinding.BaseObservableListViewModel
import com.sanniou.common.network.exception.ExceptionEngine
import com.sanniou.common.utilcode.util.ActivityUtils
import com.sanniou.common.utilcode.util.SPUtils
import com.sanniou.common.utilcode.util.ToastUtils
import org.json.JSONObject

class MainViewModel : BaseObservableListViewModel() {
    fun signInAll() {
        ActivityUtils.startActivity(MSignActivity::class.java)
    }

    @SuppressLint("CheckResult")
    fun getFavorite() {
        clear()
        TiebaRequest.profile()
            .flatMap {
                val loginInfo = SPUtils.getInstance("login_info")
                loginInfo.put("tbs", it.anti.tbs)
                TiebaRequest.reset()
                TiebaRequest.getFavorite()
            }
            .`as`(bindLifeEvent())
            .subscribe({ forum ->
                forum.like_forum
                    .forEach {
                        add(ForumItem(it.forum_name, it.avatar, it.is_sign == 1, it.level_id))
                    }

            }) {
                ToastUtils.showShort(ExceptionEngine.handleMessage(it))
//                loadMoreItem.loadFailed()
                updateUi(1)
            }
    }

}