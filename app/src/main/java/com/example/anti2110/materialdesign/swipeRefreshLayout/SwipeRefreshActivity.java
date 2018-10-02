package com.example.anti2110.materialdesign.swipeRefreshLayout;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.anti2110.materialdesign.R;

public class SwipeRefreshActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipeRefreshLayout;
    private WebView webView;
    private WebViewClient webViewClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_refresh);

        swipeRefreshLayout = findViewById(R.id.swipeRefresh_id);
        webView = findViewById(R.id.webView_id);

        webView.loadUrl("http://www.google.com");

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                webView.reload();

            }
        });

        webViewClient = new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onPageCommitVisible(WebView view, String url) {
                super.onPageCommitVisible(view, url);
                swipeRefreshLayout.setColorSchemeResources(R.color.colorFinishRefresh);
            }

            @Override
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
                swipeRefreshLayout.setColorSchemeResources(R.color.colorLoadRefresh);
            }
        };

        webView.setWebViewClient(webViewClient);

    }

}
