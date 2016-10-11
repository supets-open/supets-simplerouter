package com.supets.pet.router.router;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.supets.pet.router.activity.BaseActivity;

/**
 * 处理Http/Https链接
 */
public class LocalWebViewActivity extends BaseActivity {

    WebView  mWebView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String url = parseUrl();
        if (TextUtils.isEmpty(url)) {
            finish();
        }

        mWebView=new WebView(this);
        setContentView(mWebView);
        initWebView();
        mWebView.loadUrl(url);

    }

    private String parseUrl() {
        Intent intent = getIntent();
        Uri uri = intent.getData();
        return uri != null ? uri.getQueryParameter("url") : intent.getStringExtra("url");
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initWebView() {
        String userAgent = mWebView.getSettings().getUserAgentString();
        mWebView.getSettings().setUserAgentString(userAgent + "/miyabaobei_android " + "V2.1.0");
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setDomStorageEnabled(true); // 解决微信页面点击‘阅读原文’无反应的bug
        if (Build.VERSION.SDK_INT > 11) {
            mWebView.removeJavascriptInterface("accessibility");
            mWebView.removeJavascriptInterface("accessibilityTraversal");
            mWebView.removeJavascriptInterface("searchBoxJavaBridge_");
        }

        mWebView.setWebViewClient(new MYWebViewClient());
        mWebView.setWebChromeClient(new MYWebChromeClient());
    }

    public class MYWebChromeClient extends WebChromeClient {
        @Override
        public void onReceivedTitle(WebView view, String title) {

        }

        @Override
        public void onProgressChanged(WebView view, int newProgress) {

        }

        @Override
        public void onCloseWindow(WebView window) {

        }

        @Override
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return super.onConsoleMessage(consoleMessage);
        }
    }

    public class MYWebViewClient extends WebViewClient {

        @Override
        public void onPageStarted(WebView view, String url, android.graphics.Bitmap favicon) {

        }

        @Override
        public void onPageFinished(WebView view, String url) {

        }

        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url == null || "about:blank".equals(url)) {
                return true;
            }
            mWebView.loadUrl(url);
            return true;
        }
    }

}
