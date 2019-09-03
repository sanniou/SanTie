package com.saniou.santieba.viewmodel

import android.annotation.SuppressLint
import com.saniou.santieba.api.TiebaRequest
import com.saniou.santieba.component.MSignActivity
import com.saniou.santieba.vo.ForumItem
import com.sanniou.common.databinding.BaseObservableListViewModel
import com.sanniou.common.utilcode.util.ActivityUtils
import com.sanniou.common.utilcode.util.SPUtils
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
                val jSONObject = JSONObject(it)
                val jSONObject2 = jSONObject.getJSONObject("anti")
                val jSONObject3 = jSONObject.getJSONObject("user")
                val tbs = jSONObject2.getString("tbs")
                val loginInfo = SPUtils.getInstance("login_info")
                loginInfo.put("tbs", tbs)
                TiebaRequest.reset()
                TiebaRequest.getFavorite()
            }
            .`as`(bindLifeEvent())
            .subscribe { forum ->
                forum.like_forum
                    .forEach {
                        add(ForumItem(it.forum_name, it.avatar, it.is_sign == 1, it.level_id))
                    }

            }
    }

}