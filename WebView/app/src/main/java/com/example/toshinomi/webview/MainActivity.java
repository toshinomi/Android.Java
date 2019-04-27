package com.example.toshinomi.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.webkit.WebView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    final private String m_strUri = "https://www.google.com/";

    private Button m_btnBack;
    private Button m_btnForward;
    private Button m_btnReload;
    private EditText m_textUri;
    private WebView m_webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitLayout();

        HomeWebView();
    }

    public void InitLayout() {
        m_btnBack = findViewById(R.id.buttonBack);
        m_btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackWebView();
            }
        });

        m_btnForward = findViewById(R.id.buttonForward);
        m_btnForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FowardWebView();
            }
        });

        m_btnReload = findViewById(R.id.buttonReload);
        m_btnReload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReloadWebView();
            }
        });

        m_textUri = findViewById(R.id.editTextUri);
        m_textUri.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent e) {
                if((e.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ShowWebView(m_textUri.getText().toString());
                }

                return true;
            }
        });

        m_webView = (WebView)findViewById(R.id.webView);
    }

    public Boolean BackWebView()
    {
        Boolean bRst = true;
        try
        {
            m_webView.goBack();
        }
        catch (Exception e)
        {
            bRst = false;
        }

        return bRst;
    }

    public Boolean FowardWebView()
    {
        Boolean bRst = true;
        try
        {
            m_webView.goForward();
        }
        catch (Exception e)
        {
            bRst = false;
        }

        return bRst;
    }

    public Boolean ReloadWebView()
    {
        Boolean bRst = true;
        try
        {
            m_webView.reload();
        }
        catch (Exception e)
        {
            bRst = false;
        }

        return bRst;
    }

    public void HomeWebView()
    {
        m_textUri.setText(m_strUri);
        ShowWebView(m_strUri);
    }

    public Boolean ShowWebView(String _strUri)
    {
        Boolean bRst = true;
        try
        {
            m_webView.loadUrl(_strUri);
            m_textUri.setText(_strUri);
        }
        catch (Exception e)
        {
            bRst = false;
        }

        return bRst;
    }
}