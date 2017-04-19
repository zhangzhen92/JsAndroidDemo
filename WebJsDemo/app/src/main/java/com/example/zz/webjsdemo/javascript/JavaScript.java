package com.example.zz.webjsdemo.javascript;

import android.app.AlertDialog;
import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * 类描述：定义Android原生方法让JS调用
 * 创建人：zz
 * 创建时间： 2017/4/18 11:58
 */


public class JavaScript {
    private Context context;

    public JavaScript(Context context) {
        this.context = context;
    }

    @JavascriptInterface
    public void startFunction(){
        Toast.makeText(context,"点击了",Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public void startFunction(String getContent){
       new AlertDialog.Builder(context).setMessage(getContent).show();

    }
}
