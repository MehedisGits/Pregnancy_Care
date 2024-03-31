package com.lamusoft.zenmom_pregnancy;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

/**
 * @noinspection deprecation, deprecation
 */
public class PrivacyPolicy extends AppCompatActivity {

    private WebView webView;
    private  ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);
        getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.white));

        progressBar = findViewById(R.id.progressBar);
        webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                // Show ProgressBar when the page starts loading
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                // Hide ProgressBar when the page finishes loading
                progressBar.setVisibility(View.INVISIBLE);
            }
        });


        webView.getSettings().setJavaScriptEnabled(true);

        String url = "https://sites.google.com/view/privacypolicyzenmom/%E0%A6%B9%E0%A6%AE";
        webView.loadUrl(url);

        /*setStatusBar();*/

    }
    // Override onBackPressed to handle WebView navigation
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}