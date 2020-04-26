package com.saniou.santieba.vo

import androidx.databinding.ObservableBoolean
import com.blankj.utilcode.util.SnackbarUtils
import com.blankj.utilcode.util.ToastUtils
import com.google.android.material.snackbar.Snackbar
import com.saniou.santieba.R
import com.saniou.santieba.api.TiebaRequest
import com.sanniou.support.exception.ExceptionEngine
import com.sanniou.support.extensions.map
import com.sanniou.support.multiitem.ScopeItem
import com.sanniou.support.utils.ResourcesUtils
import kotlinx.coroutines.launch

abstract class BaseSimpleUserItem(
    val avatar: String,
    val name: String,
    val uid: String,
    val portrait: String,
    followed: Boolean,
    val des: CharSequence? = null
) : ScopeItem() {

    val followed = ObservableBoolean(followed)

    val strokeColor = this.followed.map {
        ResourcesUtils.getColor(if (it) followedColor else unfollowedColor)
    }

    val actionText = this.followed.map {
        ResourcesUtils.getString(if (it) followedString else unfollowedString)
    }

    abstract val followedColor: Int

    abstract val unfollowedColor: Int

    abstract val followedString: Int

    abstract val unfollowedString: Int

    override fun getItemType() = R.layout.item_simple_user

    open fun switchFollow() {
        launch {
            try {
                if (followed.get()) TiebaRequest.unFollow(portrait)
                else TiebaRequest.userFollow(portrait)

                followed.set(!followed.get())
                ToastUtils.showShort(if (followed.get()) "关注成功" else "取消关注成功")
            } catch (e: Exception) {
                ToastUtils.showShort(ExceptionEngine.handleMessage(e))
            }

        }
    }
}

class FansItem(
    avatar: String,
    name: String,
    uid: String,
    portrait: String,
    followed: Boolean,
    des: CharSequence? = null,
    current: Boolean = true
) : BaseSimpleUserItem(avatar, name, uid, portrait, followed, des) {
    override val followedColor = R.color.minorText
    override val unfollowedColor = R.color.design_blue
    override val followedString = if (current) R.string.mutual_subscribe else R.string.subscribed
    override val unfollowedString = R.string.subscribe
}

class FollowItem(
    avatar: String,
    name: String,
    uid: String,
    portrait: String,
    followed: Boolean,
    beenFollowed: Boolean,
    des: CharSequence? = null,
    current: Boolean = true
) : BaseSimpleUserItem(avatar, name, uid, portrait, followed, des) {
    override val followedColor = R.color.minorText
    override val unfollowedColor = R.color.design_blue
    override val followedString =
        if (beenFollowed) R.string.mutual_subscribe else R.string.subscribed
    override val unfollowedString = R.string.subscribe
}