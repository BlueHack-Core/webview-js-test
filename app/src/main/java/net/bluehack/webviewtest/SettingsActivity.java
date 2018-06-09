package net.bluehack.webviewtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Button button = findViewById(R.id.ok);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WebView webview = WebviewApplication.getWebview();
                String value = "bok";
                webview.loadUrl("javascript:(function() { document.getElementById('search_keyword').value = '" + value + "'; ;})()");
                finish();
            }
        });
    }
}
