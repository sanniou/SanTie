package com.saniou.santieba.component;

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        loadUrl("https://wappass.baidu.com/passport?login&u=https%3A%2F%2Ftieba.baidu.com%2Findex%2Ftbwise%2Fmine")
    }

    override fun onWebPageFinished(view: WebView, url: String) {
        launch {
            val cookieManager = CookieManager.getInstance();
            val cookies = cookieManager.getCookie(url);
            if (cookies != null) {
                if (AccountUtil.updateLoginInfo(cookies)) {
                    val snackbar: Snackbar = Snackbar.make(
                        view,
                        "更新成功，即将跳转",
                        Snackbar.LENGTH_INDEFINITE
                    )
                    snackbar.show()
                    delay(1500)
                    snackbar.dismiss()
                    findNavController().popBackStack(R.id.navbar_home,false)
                }
            }
        }
    }
}
