package com.saniou.santieba.component;

import android.content.Context
import android.os.Bundle
import android.view.View
import android.webkit.CookieManager
import android.webkit.WebView
import androidx.annotation.CallSuper
import androidx.navigation.fragment.findNavController
import com.blankj.utilcode.util.LogUtils
import com.google.android.material.snackbar.Snackbar
import com.saniou.santieba.R
import com.saniou.santieba.model.api.reqeust.AccountUtil
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginFragment : WebViewFragment(),
    CoroutineScope by MainScope() {

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }

    override fun getNavigationHelper(context: Context?): NavigationHelper {
        return NavigationHelper.newInstance(context, "LoginActivity")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        loadUrl("https://wappass.baidu.com/passport?login&u=https%3A%2F%2Ftieba.baidu.com%2Findex%2Ftbwise%2Fmine")
    }

    override fun onWebPageFinished(view: WebView, url: String) {
        launch {
            val cookieManager = CookieManager.getInstance();
            val cookies = cookieManager.getCookie(url);
            if (cookies != null) {
                val bdussSplit = cookies.split("BDUSS=")

                val snackbar: Snackbar =
                    Snackbar.make(view, "请稍后…", Snackbar.LENGTH_INDEFINITE)

                try {
                    if (bdussSplit.size > 1) {
                        val bduss = bdussSplit[1].split(";")[0];
                        if (url.startsWith("https://tieba.baidu.com/index/tbwise/")
                            || url.startsWith("https://tiebac.baidu.com/index/tbwise/")
                        ) {
                            snackbar.show()

                            val info = AccountUtil.updateUserInfoByBduss(bduss)

                            var account = AccountUtil.getLoginInfo()
                            if (account == null) {
                                account = AccountUtil.getAccountInfoByBduss(bduss);
                            }
                            if (account == null) {
                                account = AccountUtil.getAccountInfoByUid(info.data.uid.toString());
                            }
                            if (account != null) {
                                AccountUtil.switchUser(requireContext(), account.id)
                                snackbar.setText("登录成功，即将跳转");

                                delay(1500)
                                snackbar.dismiss()
                                findNavController().navigate(R.id.login_to_update)
                            } else {
                                snackbar.setText("登录失败 未知错误");
                            }
                        }
                    }
                } catch (e: Exception) {
                    LogUtils.e(e)
                    snackbar.setText("登录失败，无法获取用户信息 " + e.message)
                    view.loadUrl("https://wappass.baidu.com/passport?login&u=https%3A%2F%2Ftieba.baidu.com%2Findex%2Ftbwise%2Fmine");
                }
            }
        }
    }
}
