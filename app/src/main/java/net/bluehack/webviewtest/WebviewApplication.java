package net.bluehack.webviewtest;

import android.app.Application;
import android.webkit.WebView;

public class WebviewApplication extends Application {
    private static WebView webview;

    public static void setWebview(WebView webview) {
        WebviewApplication.webview = webview;
    }

    public static WebView getWebview() {
        return webview;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
