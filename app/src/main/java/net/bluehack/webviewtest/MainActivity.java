package net.bluehack.webviewtest;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebViewInterface mWebViewInterface;
    private WebView webView;
    private final String baseUrl = "https://s3.ap-northeast-2.amazonaws.com/webview-test-android/webviewTest.html";
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        webView = (WebView)findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);

        mWebViewInterface = new WebViewInterface(MainActivity.this, webView);
        webView.addJavascriptInterface(mWebViewInterface, "AndroidBridge");
//        webView.addJavascriptInterface(mWebViewInterface, "result");

        webView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {


                Log.e("shouldOverrideUrlLoad", request.getUrl().toString());
                return super.shouldOverrideUrlLoading(view, request);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                Log.e("onReceivedError", error.toString());
                super.onReceivedError(view, request, error);
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            webView.setWebContentsDebuggingEnabled(true);
        }

        webView.loadUrl(baseUrl);
        WebviewApplication.setWebview(webView);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            Log.e("onActivityResultTest:", data.toString());
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
