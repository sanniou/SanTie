package com.saniou.santieba.component;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.saniou.santieba.R;
import com.saniou.santieba.dialog.LMessageDialog;
import com.saniou.santieba.model.api.reqeust.AccountUtil;
import com.sanniou.support.widget.swiper.LSwipeRefreshLayout;

import org.jetbrains.annotations.NotNull;


public class WebViewFragment extends Fragment {
    private final static int FILE_CHOOSER_RESULT_CODE = 1;
    private boolean enableSwipeRefresh;
    private boolean isSapi;
    private WebView mWebView;
    private NavigationHelper navigationHelper;
    private ValueCallback<Uri> uploadMessage;
    private ValueCallback<Uri[]> uploadMessageAboveL;
    private LSwipeRefreshLayout swipeRefreshLayout;


    @NonNull
    public WebView getWebView() {
        return mWebView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putBoolean("enableSwipeRefresh", enableSwipeRefresh);
        outState.putBoolean("isSapi", isSapi);
        mWebView.saveState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            enableSwipeRefresh = savedInstanceState.getBoolean("enableSwipeRefresh", true);
            isSapi = savedInstanceState.getBoolean("isSapi", false);
            navigationHelper = NavigationHelper.newInstance(getContext());
            mWebView.restoreState(savedInstanceState);
        }
        super.onActivityCreated(savedInstanceState);
    }

//    @Override
//    public boolean onBackPressed() {
//        if (mWebView.canGoBack()) {
//            mWebView.goBack();
//            return true;
//        }
//        return super.onBackPressed();
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mWebView != null) {
            ((ViewGroup) mWebView.getParent()).removeView(mWebView);
            mWebView.removeAllViews();
            mWebView.destroy();
            mWebView = null;
        }
    }

    private void initData() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        Bundle bundle = getArguments();
        navigationHelper = NavigationHelper.newInstance(getContext());
        if (savedInstanceState == null && bundle != null) {
            enableSwipeRefresh = bundle.getBoolean("enableSwipeRefresh", true);
            isSapi = bundle.getBoolean("isSapi", false);
        }
    }


    @NotNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_web_view, null, false);
        swipeRefreshLayout = contentView.findViewById(R.id.refresh);
        mWebView = contentView.findViewById(R.id.webView);
        swipeRefreshLayout.setEnabled(enableSwipeRefresh);
        swipeRefreshLayout.setOnRefreshListener(() -> getWebView().reload());
        WebSettings webSettings = mWebView.getSettings();
        if (isSapi) {
            webSettings.setUserAgentString(webSettings.getUserAgentString() + " Sapi_8.7.5.1.6_Android_%E7%99%BE%E5%BA%A6%E8%B4%B4%E5%90%A7_9.9.8.40_" + Build.MODEL.replace(" ", "+") + "_" + Build.VERSION.RELEASE + "_Sapi");
        }
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowFileAccessFromFileURLs(true);
        webSettings.setAllowUniversalAccessFromFileURLs(true);
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        webSettings.setSupportZoom(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setDomStorageEnabled(true);
        String appCachePath = getContext().getCacheDir().getAbsolutePath();
        webSettings.setAppCachePath(appCachePath);
        webSettings.setAllowFileAccess(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        mWebView.setWebChromeClient(new ChromeClient());
        mWebView.setWebViewClient(new Client());
        mWebView.setBackgroundColor(Color.TRANSPARENT);
        CookieManager.getInstance().setAcceptCookie(true);
        return contentView;
    }

    public void loadUrl(String url) {
        mWebView.loadUrl(url);
    }


    private void openImageChooserActivity() {
        Intent i = new Intent(Intent.ACTION_GET_CONTENT);
        i.addCategory(Intent.CATEGORY_OPENABLE);
        i.setType("image/*");
        startActivityForResult(Intent.createChooser(i, getContext().getString(R.string.title_select_pic)), FILE_CHOOSER_RESULT_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == FILE_CHOOSER_RESULT_CODE) {
            if (null == uploadMessage && null == uploadMessageAboveL) {
                return;
            }
            Uri result = data == null || resultCode != Activity.RESULT_OK ? null : data.getData();
            if (uploadMessageAboveL != null) {
                onActivityResultAboveL(requestCode, resultCode, data);
            } else if (uploadMessage != null) {
                uploadMessage.onReceiveValue(result);
                uploadMessage = null;
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void onActivityResultAboveL(int requestCode, int resultCode, Intent intent) {
        if (requestCode != FILE_CHOOSER_RESULT_CODE || uploadMessageAboveL == null) {
            return;
        }
        Uri[] results = null;
        if (resultCode == Activity.RESULT_OK) {
            if (intent != null) {
                String dataString = intent.getDataString();
                ClipData clipData = intent.getClipData();
                if (clipData != null) {
                    results = new Uri[clipData.getItemCount()];
                    for (int i = 0; i < clipData.getItemCount(); i++) {
                        ClipData.Item item = clipData.getItemAt(i);
                        results[i] = item.getUri();
                    }
                }
                if (dataString != null) {
                    results = new Uri[]{Uri.parse(dataString)};
                }
            }
        }
        uploadMessageAboveL.onReceiveValue(results);
        uploadMessageAboveL = null;
    }

    public void onWebPageFinished(WebView view, String url) {

    }

    public void onWebPageStarted(WebView view, String url, Bitmap favicon) {
    }

    private class Client extends WebViewClient {
        @Override
        public void onPageFinished(WebView view, String url) {
            onWebPageFinished(view, url);
            if (enableSwipeRefresh) {
                swipeRefreshLayout.stopRefresh(true);
            }
        }

        @Override
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
            String url = request.getUrl().toString();
            return shouldInterceptRequest(view, url);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            onWebPageStarted(view, url, favicon);
            if (enableSwipeRefresh) {
                swipeRefreshLayout.startRefresh();
            }
            if (AccountUtil.INSTANCE.isLoggedIn(getContext())) {
                String cookieStr = AccountUtil.INSTANCE.getBdussCookie();
                CookieManager.getInstance().setCookie(url, cookieStr);
            }
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return navigationHelper.interceptWebViewRequest(view, request);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return navigationHelper.interceptWebViewRequest(view, url);
        }
    }

    private void injectJavaScript() {
    }

    private class ChromeClient extends WebChromeClient {


        @Override
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
            uploadMessageAboveL = filePathCallback;
            openImageChooserActivity();
            return true;
        }

        @Override
        public boolean onJsAlert(WebView webView, String url, String message, JsResult result) {
            new LMessageDialog(webView.getContext())
                    .setMessage(message)
                    .cancelHint("确定")
                    .show();
            result.confirm();
            return true;
        }

        @Override
        public boolean onJsConfirm(WebView view, String url, String message, final JsResult result) {
            new LMessageDialog(view.getContext())
                    .title("Confirm")
                    .setMessage(message)
                    .okListener((dialog, which) -> result.confirm())
                    .cancelListener((dialog, which) -> result.cancel())
                    .show();
            return true;
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            injectJavaScript();
        }

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if (newProgress >= 100) {
                if (enableSwipeRefresh) {
                    swipeRefreshLayout.stopRefresh(true);
                }
            }
        }
    }
}
