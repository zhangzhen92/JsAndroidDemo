package com.example.zz.webjsdemo;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import com.example.zz.webjsdemo.javascript.JavaScript;

/**
 * 类描述：测试工具类
 * 创建人：zz
 * 创建时间：2017/4/19 16:13
 */
public class MainActivity extends Activity implements View.OnClickListener{

    private WebView webViewId;
    private Button buttonJSNo;
    private Button buttonJsHave;
    private TextView textFirst;
    private TextView textSecond;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    /**
     * 初始化UI
     */
    private void initView() {
        updataeFontStyle();

        webViewId = ((WebView) findViewById(R.id.webivew_id));
        WebSettings webSettings = webViewId.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webViewId.loadUrl("file:///android_asset/web.html");
        buttonJSNo = ((Button) findViewById(R.id.button_js_no));
        buttonJsHave = ((Button) findViewById(R.id.button_js_have));
        buttonJSNo.setOnClickListener(this);
        buttonJsHave.setOnClickListener(this);
        webViewId.addJavascriptInterface(new JavaScript(MainActivity.this),"android");
    }

    /**
     * 修改文本的字体属性
     */
    private void updataeFontStyle() {
        textFirst = ((TextView) findViewById(R.id.textview_first_content));
        textSecond = ((TextView) findViewById(R.id.textview_second_content));
        textFirst.setText(getString(R.string.text_content));
        textSecond.setText(getString(R.string.text_content));
        Typeface agTypeFace = Typeface.createFromAsset(getApplicationContext().getAssets(), "ag.TTF");  //加载Assets下的文本的属性，注意打开Assets资源比较耗时
        textSecond.setTypeface(agTypeFace);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_js_have:
                loadJsYes();
                break;
            case R.id.button_js_no:
                loadJsNo();
                break;
        }
    }

    /**
     * 加载JS有参构造
     */
    private void loadJsYes() {
        webViewId.loadUrl("javascript:javacalljswith(" + "'测试有参数的JS'" + ")");
    }

    /**
     * 执行JS无参数构造方法
     */
    private void loadJsNo() {
        webViewId.loadUrl("javascript:javacalljs()");
    }
}
