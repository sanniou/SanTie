package com.saniou.santieba.utils;

import android.content.Context;
import android.os.Handler;
import android.text.format.DateUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

import com.blankj.utilcode.util.SPUtils;

public class TiebaLiteJavaScript {
    public static final String TAG = "JsBridge";

    private static Handler handler = new Handler();
    public Context context;
    public WebView webView;

    public TiebaLiteJavaScript(WebView webView) {
        this.context = webView.getContext();
        this.webView = webView;
    }

    @JavascriptInterface
    public void toast(final String text) {
        handler.post(() -> {
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
        });
    }

    @JavascriptInterface
    public String getTimeFromNow(String time) {
        return String.valueOf(DateUtils.getRelativeTimeSpanString(Long.valueOf(time) * 1000L));
    }

    @JavascriptInterface
    public String getTheme() {
        return "ThemeUtil.getTheme(context)";
    }

    @JavascriptInterface
    public void copyText(String content) {
        ClipboardUtils.copyText(content);
    }

    @JavascriptInterface
    public void putString(String key, String value) {
        SPUtils.getInstance().put(key, value);
        Log.i(TAG, "putString: " + key + ": " + value);
    }

    @JavascriptInterface
    public String getString(String key) {
        return SPUtils.getInstance().getString(key);
    }

    @JavascriptInterface
    public int getInt(String key, int defValue) {
        return SPUtils.getInstance().getInt(key);
    }

    @JavascriptInterface
    public void putInt(String key, int value) {
        SPUtils.getInstance().put(key, value);
        Log.i(TAG, "putInt: " + key + ": " + value);
    }
}