package com.saniou.santieba.component

import android.os.Build
import android.view.KeyEvent
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.databinding.ViewDataBinding
import com.blankj.utilcode.constant.PermissionConstants
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.PermissionUtils
import com.blankj.utilcode.util.SPUtils
import com.google.android.material.snackbar.Snackbar
import com.saniou.santieba.R
import com.saniou.santieba.kts.startActivityEx
import com.saniou.santieba.utils.SQLiteUtil
import com.saniou.santieba.viewmodel.WebLoginViewModel
import com.sanniou.support.extensions.getViewModel
import org.apache.commons.text.lookup.StringLookupFactory
import java.io.UnsupportedEncodingException
import java.net.URLDecoder
import java.util.TreeMap

class WebLoginActivity : SanBaseActivity<WebLoginViewModel>() {

    private val REQUEST_CODE = 10086
    private val createAccountTableSql =
        "create table if not exists account(id integer primary key autoincrement,userId text,userName text,userBDUSS text,userPortrait text,tail text)"

    /* access modifiers changed from: private */
    var mBDUSS: String = ""
    private val mLayout by lazy {
        findViewById<View>(R.id.activity_web_login)
    }
    private var mParam = "clientfrom=native&tpl=tb&login_share_strategy=silent&client=ios&adapter=3"

    /* access modifiers changed from: private */
    var mPortrait: String = ""

    /* access modifiers changed from: private */
    val mProgressBar by lazy {
        findViewById<ProgressBar>(R.id.progress)
    }
    private val mRealUrl by lazy {
        StringBuilder()
            .append(mUrl)
            .append("?")
            .append(mParam)
            .toString()
    }

    /* access modifiers changed from: private */
    var mUid: String = ""
    private var mUrl = "https://wappass.baidu.com/passport/login"

    /* access modifiers changed from: private */
    var mUserName: String = ""

    /* access modifiers changed from: private */
    val mWebView by lazy {
        findViewById<WebView>(R.id.web_login);
    }

    override fun createViewModel() = getViewModel<WebLoginViewModel>()

    override fun getLayoutRes() = R.layout.activity_web_login

    override fun onBindingCreated(binding: ViewDataBinding) {
        webViewInit()
        requestPermission()
    }

    private fun requestPermission() {
        PermissionUtils.permission(PermissionConstants.STORAGE)
            .callback(object : PermissionUtils.SimpleCallback {
                override fun onGranted() {
                    Snackbar.make(mLayout, R.string.permission_granted, Snackbar.LENGTH_SHORT)
                        .show()
                    getImei()
                }

                override fun onDenied() {
                    Snackbar.make(mLayout, R.string.permission_deny, Snackbar.LENGTH_LONG)
                        .show()
                }
            })
    }

    private fun getImei() {
        /*this.imei = ((TelephonyManager) getSystemService("phone")).getDeviceId();
    if (this.imei == null) {
      this.imei = getString(R.string.default_imei);
    }*/
        val imei = getString(R.string.default_imei)
        val phoneInfo = applicationContext.getSharedPreferences("phone_info", 0)
        val phoneEditor = phoneInfo.edit()
        phoneEditor.putString("imei", imei)
        phoneEditor.apply()
    }

    private fun webViewInit() {
        mWebView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(webView: WebView, str: String): Boolean {
                var str2: String
                if (str.startsWith("sapi://loginSucceed")) {
                    try {
                        str2 = URLDecoder.decode(str, "utf-8")
                        LogUtils.e(StringLookupFactory.KEY_URL, str2)
                    } catch (e: UnsupportedEncodingException) {
                        LogUtils.e(e)
                        str2 = str
                    }

                    mBDUSS = str2
                        .substring(str2.indexOf("<bduss>") + 7, str2.indexOf("</bduss>"))
                    mUid = str2
                        .substring(str2.indexOf("<uid>") + 5, str2.indexOf("</uid>"))
                    mUserName = str2
                        .substring(
                            str2.indexOf("<displayname>") + 13,
                            str2.indexOf("</displayname>")
                        )
                    mPortrait = str2
                        .substring(str2.indexOf("<portrait>") + 10, str2.indexOf("</portrait>"))
                    loginSuccess()
                } else if (str.startsWith("http")) {
                    mWebView.loadUrl(str)
                }
                return true
            }
        }

        mWebView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(webView: WebView, i: Int) {
                mProgressBar.progress = i
                if (i == 100) {
                    mProgressBar.visibility = View.INVISIBLE
                }
            }
        }

        val settings = mWebView.settings
        settings.userAgentString =
            "Mozilla/5.0 (Linux; Android 7.1.2; A0001 Build/NJH47D) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.92 Mobile Safari/537.36"
        settings.javaScriptEnabled = true
        settings.allowUniversalAccessFromFileURLs = true
        if (Build.VERSION.SDK_INT >= 21) {
            settings.mixedContentMode = 0
        }
        mWebView.loadUrl(this.mRealUrl)
    }

    private fun loginSuccess() {

        SPUtils.getInstance("login_info").clear()
        SPUtils.getInstance("phone_info").clear()

        var z = false
        val edit = getSharedPreferences("login_info", 0).edit()
        edit.putBoolean("autologin", true)
        edit.putString("BDUSS", mBDUSS)
        edit.putString("ID", mUid)
        edit.putString("NAME", mUserName)
        edit.putString("PORTRAIT", mPortrait)
        edit.apply()
        val treeMap = TreeMap<String, String>()
        treeMap["userId"] = mUid
        treeMap["userName"] = mUserName
        treeMap["userBDUSS"] = mBDUSS
        treeMap["userPortrait"] = mPortrait
        treeMap["tail"] = ""

        val createOrOpenDataBase = SQLiteUtil.createOrOpenDataBase(
            applicationContext.getDatabasePath("account.db").absolutePath,
            applicationContext
        )
        for (account in SQLiteUtil.query(createOrOpenDataBase, "account")) {
            for ((_, value1) in account) {
                if (mUserName == value1) {
                    z = true
                }
            }
        }

        if (!z) {
            SQLiteUtil.createTables(createOrOpenDataBase, createAccountTableSql)
            SQLiteUtil.insert(createOrOpenDataBase, "account", treeMap)
            SQLiteUtil.closeDataBase(createOrOpenDataBase)
        }
        startActivityEx<TiebarMainActivity>()
        finish()
    }

    override fun onKeyDown(i: Int, keyEvent: KeyEvent): Boolean {
        if (i == KeyEvent.KEYCODE_BACK) {
            if (mWebView.canGoBack()) {
                mWebView.goBack()
                return true
            }
            finish()
        }
        return super.onKeyDown(i, keyEvent)
    }
}

