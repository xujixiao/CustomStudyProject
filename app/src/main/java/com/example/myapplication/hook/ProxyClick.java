package com.example.myapplication.hook;

import android.view.View;
import android.widget.Toast;

/**
 * create by xujixiao on 2019/5/10 10:24
 * hook view.onclicklistener的代理类
 */
public class ProxyClick implements View.OnClickListener {
    private View.OnClickListener onClickListener;

    public ProxyClick(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(v.getContext(), "按钮被点击了", Toast.LENGTH_LONG).show();
        if (onClickListener != null) {
            onClickListener.onClick(v);
        }
    }
}
