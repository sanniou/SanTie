package com.saniou.santieba.component;

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.webkit.CookieManager
import android.webkit.WebView
import androidx.annotation.CallSuper
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.saniou.santieba.R
import com.saniou.santieba.model.api.reqeust.AccountUtil
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class UpdateInfoFragment : WebViewFragment(),
    CoroutineScope by MainScope() {

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }

    override fun getNavigationHelper(context: Context?): NavigationHelper {
        return NavigationHelper.newInstance(context, "UpdateInfoActivity")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        loadUrl("https://wappass.baidu.com/passport?login&u=https%3A%2F%2Ftieba.baidu.com%2Findex%2Ftbwise%2Fmine")
    }

    override fun onWebPageFinished(view: WebView, url: String) {
        launch {
            val cookieManager = CookieManager.getInstance();
            val cookies = cookieManager.getCookie(url);
            if (cookies != null && AccountUtil.updateLoginInfo(cookies)) {
                if (AccountUtil.updateLoginInfo(cookies)) {
                    val snackbar: Snackbar = Snackbar.make(
                        view,
                        "更新成功，即将跳转",
                        Snackbar.LENGTH_INDEFINITE
                    )
                    snackbar.show()
                    delay(1500)
                    snackbar.dismiss()
                    findNavController().popBackStack(R.id.navbar_home, false)
                }
            } else {
                // DialogUtil.build(this)
                //     .setTitle("出现问题")
                //     .setMessage("看起来您还没有登录或登录已失效，请先登录")
                //     .setPositiveButton(R.string.button_sure_default) { dialog, which ->
                //         finish()
                //         startActivity(Intent(this, LoginActivity::class.java))
                //     }
                //     .create()
                //     .show()
            }
        }
    }
}
