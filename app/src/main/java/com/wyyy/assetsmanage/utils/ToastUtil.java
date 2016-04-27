package com.wyyy.assetsmanage.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by 海滨 .（dagaozi@163.com）
 * 创建时间：2016/4/27 8:57
 * 类描述：Toast统一管理类
 */
public class ToastUtil {
    public Context context;

    public ToastUtil(Context context)
    {
        this.context=context;
    }

    public void showToast(String text)
    {
        Toast.makeText(context,text,Toast.LENGTH_SHORT).show();
    }
}
