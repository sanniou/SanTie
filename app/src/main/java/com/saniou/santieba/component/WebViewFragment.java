package com.saniou.santieba.component;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.GeolocationPermissions;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.saniou.santieba.R;
import com.saniou.santieba.dialog.LContentDialog;
import com.saniou.santieba.dialog.LMessageDialog;
import com.saniou.santieba.model.api.reqeust.AccountUtil;
import com.saniou.santieba.utils.AssetUtil;
import com.saniou.santieba.utils.TiebaLiteJavaScript;
import com.sanniou.support.widget.swiper.LSwipeRefreshLayout;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class WebViewFragment extends Fragment {
    private final static int FILE_CHOOSER_RESULT_CODE = 1;
    private String mUrl;
    private String mTitle;
    private boolean lazyLoad;
    private boolean enableSwipeRefresh;
    private boolean isSapi;
    private String activityName;
    private String tbliteJs;
    private String nightJs;
    private String aNightJs;
    private WebView mWebView;
    private NavigationHelper navigationHelper;
    private ValueCallback<Uri> uploadMessage;
    private ValueCallback<Uri[]> uploadMessageAboveL;
    private LSwipeRefreshLayout swipeRefreshLayout;


    private boolean isEnabledLocationFunction() {
        int locationMode = 0;
        try {
            locationMode = Settings.Secure.getInt(requireContext().getContentResolver(), Settings.Secure.LOCATION_MODE);
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return locationMode != Settings.Secure.LOCATION_MODE_OFF;
    }

    @NonNull
    public WebView getWebView() {
        return mWebView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("url", mUrl);
        outState.putString("title", mTitle);
        outState.putBoolean("lazyLoad", lazyLoad);
        outState.putBoolean("enableSwipeRefresh", enableSwipeRefresh);
        outState.putBoolean("isSapi", isSapi);
        outState.putString("activity", activityName);
        mWebView.saveState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mUrl = savedInstanceState.getString("url");
            mTitle = savedInstanceState.getString("title");
            lazyLoad = savedInstanceState.getBoolean("lazyLoad", false);
            enableSwipeRefresh = savedInstanceState.getBoolean("enableSwipeRefresh", true);
            isSapi = savedInstanceState.getBoolean("isSapi", false);
            activityName = savedInstanceState.getString("activity");
            navigationHelper = getNavigationHelper(requireContext());
            mWebView.restoreState(savedInstanceState);
        }
        super.onActivityCreated(savedInstanceState);
    }

    @NotNull
    protected NavigationHelper getNavigationHelper(Context context) {
        return NavigationHelper.newInstance(context);
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
        tbliteJs = AssetUtil.getStringFromAsset(requireContext(), "tblite.js");
        nightJs = AssetUtil.getStringFromAsset(requireContext(), "night.js");
        aNightJs = AssetUtil.getStringFromAsset(requireContext(), "anight.js");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        Bundle bundle = getArguments();
        navigationHelper = getNavigationHelper(getContext());
        if (savedInstanceState == null && bundle != null) {
            mUrl = bundle.getString("url");
            mTitle = bundle.getString("title");
            lazyLoad = bundle.getBoolean("lazyLoad", false);
            enableSwipeRefresh = bundle.getBoolean("enableSwipeRefresh", true);
            isSapi = bundle.getBoolean("isSapi", false);
            activityName = bundle.getString("activity");
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
        String appCachePath = requireContext().getCacheDir().getAbsolutePath();
        webSettings.setAppCachePath(appCachePath);
        webSettings.setAllowFileAccess(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        mWebView.setWebChromeClient(new ChromeClient());
        mWebView.setWebViewClient(new Client());
        mWebView.addJavascriptInterface(new TiebaLiteJavaScript(mWebView), "TiebaLiteJsBridge");
        mWebView.setBackgroundColor(Color.TRANSPARENT);
//        mWebView.setDownloadListener(this);
        CookieManager.getInstance().setAcceptCookie(true);
        if (!lazyLoad) {
            mWebView.loadUrl(mUrl);
        }
//        ThemeUtil.setTranslucentThemeWebViewBackground(mWebView);
        return contentView;
    }

//    private void injectJavaScript() {
//        if (mWebView == null) return;
//        String nowTheme = ThemeUtil.getTheme(getAttachContext());
//        String url = mWebView.getUrl();
//        if (url == null || nowTheme == null) {
//            return;
//        }
//        if (mWebView.getUrl().startsWith("http")) {
//            mWebView.evaluateJavascript(tbliteJs, (String value) -> {
//                if (mWebView != null)
//                    mWebView.evaluateJavascript("tblite.init();tblite.theme.init('" + nowTheme + "');", null);
//            });
//        }
//        if (nowTheme.equalsIgnoreCase(ThemeUtil.THEME_AMOLED_DARK)) {
//            mWebView.evaluateJavascript(aNightJs, null);
//        } else if (nowTheme.equalsIgnoreCase(ThemeUtil.THEME_BLUE_DARK)) {
//            mWebView.evaluateJavascript(nightJs, null);
//        }
//    }

    private void openImageChooserActivity() {
        Intent i = new Intent(Intent.ACTION_GET_CONTENT);
        i.addCategory(Intent.CATEGORY_OPENABLE);
        i.setType("image/*");
        startActivityForResult(Intent.createChooser(i, requireContext().getString(R.string.title_select_pic)), FILE_CHOOSER_RESULT_CODE);
    }

    public void loadUrl(String url) {
        mWebView.loadUrl(url);
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
            injectJavaScript();
        }

        @Override
        public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
            return super.shouldOverrideKeyEvent(view, event);
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
        @SuppressLint("WrongConstant")
        @Override
        public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
        /*    Uri uri = Uri.parse(mWebView.getUrl());
            if (uri != null && uri.getHost() != null) {
                new LMessageDialog(requireContext())
                        .ok("", (dialog, button) -> {

                        })
                        .cancel("", (dialog, button) -> {

                        })
                        .show();
                        new PermissionBean(PermissionConstant.PERMISSION_LOCATION,
                                uri.getHost(),
                                getAttachContext().getString(R.string.title_ask_permission, uri.getHost(), getAttachContext().getString(R.string.permission_name_location)),
                                R.drawable.ic_round_location_on))
                        .setOnGrantedCallback(isForever -> {
                            AndPermission.with(getAttachContext())
                                    .runtime()
                                    .permission(Permission.ACCESS_COARSE_LOCATION, Permission.ACCESS_FINE_LOCATION)
                                    .onGranted((List<String> permissions) -> {
                                        if (isEnabledLocationFunction()) {
                                            callback.invoke(origin, true, isForever);
                                        } else {
                                            callback.invoke(origin, false, false);
                                        }
                                    })
                                    .onDenied((List<String> permissions) -> callback.invoke(origin, false, false))
                                    .start();
                        })
                        .setOnDeniedCallback(isForever -> callback.invoke(origin, false, false))
                        .show();
            }*/
        }

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
            mTitle = title;
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
