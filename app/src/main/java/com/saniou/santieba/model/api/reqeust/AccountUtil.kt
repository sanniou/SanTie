package com.saniou.santieba.model.api.reqeust

import android.content.Context
import android.content.Intent
import android.webkit.CookieManager
import android.widget.Toast
import com.blankj.utilcode.util.Utils
import com.saniou.santieba.R
import com.saniou.santieba.model.api.interfaces.SanTiebaApi.myInfo
import com.saniou.santieba.model.bean.UserInfo
import com.saniou.santieba.model.database.Account
import com.sanniou.support.exception.ApiErrorException
import com.sanniou.support.exception.AppErrorException
import org.litepal.LitePal

object AccountUtil {
    const val ACTION_SWITCH_ACCOUNT = "tieba.post.action.SWITCH_ACCOUNT"

    fun getLoginInfo(context: Context): Account? {

        val loginUser = context.getSharedPreferences("accountData", Context.MODE_PRIVATE)
            .getInt("now", -1)
        return if (loginUser == -1) null else getAccountInfo(loginUser)
    }

    val allAccounts: List<Account>
        get() = LitePal.findAll(Account::class.java)

    fun getAccountInfo(accountId: Int): Account {
        return LitePal.where("id = ?", accountId.toString())
            .findFirst(Account::class.java)
    }

    fun getAccountInfoByUid(uid: String): Account? {
        return LitePal.where("uid = ?", uid).findFirst(
            Account::class.java
        )
    }

    fun getAccountInfoByBduss(bduss: String): Account? {
        return LitePal.where("bduss = ?", bduss)
            .findFirst(
                Account::class.java
            )
    }

    fun isLoggedIn(context: Context): Boolean {
        return getLoginInfo(context) != null
    }

    fun newAccount(
        context: Context,
        account: Account,
        needSwitch: Boolean
    ): Boolean {
        return if (account.save()) {
            if (needSwitch) {
                switchUser(
                    context,
                    account.id
                )
            } else true
        } else false
    }

    fun switchUser(context: Context, id: Int): Boolean {
        context.sendBroadcast(
            Intent()
                .setAction(ACTION_SWITCH_ACCOUNT)
        )
        return context.getSharedPreferences("accountData", Context.MODE_PRIVATE)
            .edit().putInt("now", id).commit()
    }

    suspend fun updateUserInfo() {
        val account = getLoginInfo(Utils.getApp()) ?: throw AppErrorException("未登录")
        updateUserInfoByBduss(account.bduss)
    }

    fun updateLoginInfo(cookie: String): Boolean {
        val bdussSplit = cookie.split("BDUSS=").toTypedArray()
        val sTokenSplit = cookie.split("STOKEN=").toTypedArray()
        if (bdussSplit.size > 1 && sTokenSplit.size > 1) {
            val bduss = bdussSplit[1].split(";").toTypedArray()[0]
            val sToken = sTokenSplit[1].split(";").toTypedArray()[0]
            val account =
                getAccountInfoByBduss(
                    bduss
                )
            if (account != null) {
                account.setsToken(sToken)
                    .setCookie(cookie)
                    .update(account.id.toLong())
                return true
            }
        }
        return false
    }

    suspend fun updateUserInfoByBduss(bduss: String): UserInfo {
        val myInfoBean = myInfo(getBdussCookie(bduss))
        if (!myInfoBean.data.isLogin) {
            throw ApiErrorException(Error.ERROR_LOGGED_IN_EXPIRED, "登录已过期")
        }
        val id = myInfoBean.data.uid.toString()

        var account = getAccountInfoByBduss(bduss) ?: getAccountInfoByUid(id)

        if (account == null) {
            account = Account()
                .setBduss(bduss)
                .setPortrait(myInfoBean.data.portraitUrl)
                .setUid(id)
                .setTbs(myInfoBean.data.tbs)
                .setItbTbs(myInfoBean.data.itbTbs)
                .setName(myInfoBean.data.name)
                .setNameShow(myInfoBean.data.nameShow);
            account.save();
        } else {

            account.setBduss(bduss)
                .setPortrait(myInfoBean.data.portraitUrl)
                .setTbs(myInfoBean.data.tbs)
                .setItbTbs(myInfoBean.data.itbTbs)
                .setUid(myInfoBean.data.uid.toString())
                .setName(myInfoBean.data.name)
                .setNameShow(myInfoBean.data.nameShow)
                .update(account.id.toLong())
        }
        return myInfoBean;
    }

    fun exit(context: Context?) {
        if (context == null) return
        var accounts =
            allAccounts
        var account = getLoginInfo(
            context
        ) ?: return
        account.delete()
        CookieManager.getInstance().removeAllCookies(null)
        if (accounts.size > 1) {
            accounts =
                allAccounts
            account = accounts[0]
            switchUser(
                context,
                account.id
            )
            Toast.makeText(
                context,
                "退出登录成功，已切换至账号 " + account.nameShow,
                Toast.LENGTH_SHORT
            ).show()
            return
        }
        context.getSharedPreferences("accountData", Context.MODE_PRIVATE).edit()
            .clear().commit()
        Toast.makeText(
            context,
            R.string.toast_exit_account_success,
            Toast.LENGTH_SHORT
        ).show()
    }

    fun getSToken(context: Context?): String? {
        if (context == null) return null
        val account =
            getLoginInfo(
                context
            )
        return account?.getsToken()
    }

    fun getCookie(context: Context?): String? {
        if (context == null) return null
        val account =
            getLoginInfo(
                context
            )
        return account?.cookie
    }

    fun getUid(context: Context?): String? {
        if (context == null) return null
        val account =
            getLoginInfo(
                context
            )
        return account?.uid
    }

    fun getBduss(context: Context?): String? {
        if (context == null) return null
        val account =
            getLoginInfo(
                context
            )
        return account?.bduss
    }

    fun getBdussCookie(context: Context?): String? {
        if (context == null) return null
        val bduss =
            getBduss(context)
        return bduss?.let {
            getBdussCookie(
                it
            )
        }
    }

    fun getBdussCookie(bduss: String): String {
        return "BDUSS=$bduss; path=/; domain=.baidu.com; httponly"
    }
}