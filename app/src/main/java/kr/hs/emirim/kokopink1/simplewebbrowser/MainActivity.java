package kr.hs.emirim.kokopink1.simplewebbrowser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.*;
import android.webkit.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edit;
    Button butMove,butPrev;
    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit=(EditText)findViewById(R.id.edit);
        butMove=(Button)findViewById(R.id.but_move);
        web.setWebViewClient(new WebViewClient());
        WebSettings WebSet=web.getSettings();
        WebSet.setBuiltInZoomControls(true);
        WebSet.setJavaScriptEnabled(true);
        butPrev=(Button)findViewById(R.id.but_prev);
        web=(WebView)findViewById(R.id.web);
        butMove.setOnClickListener(this);
        butPrev.setOnClickListener(this);
        //web.loadUrl("http://www.naver.com");
    }

    @Override
    public void onClick(View v) {
        String s="http://";
        String s2=edit.getText().toString();
        switch (v.getId())
        {
            case R.id.but_move:
                if(s2.contains(s))
                {
                    web.loadUrl(s2);
                }
                else
                {
                    web.loadUrl(s+s2);
                }
                break;
            case R.id.but_prev: web.goBack(); break;
        }
    }
}
