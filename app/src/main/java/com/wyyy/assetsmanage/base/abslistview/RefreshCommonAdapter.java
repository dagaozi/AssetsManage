package com.wyyy.assetsmanage.base.abslistview;


import android.content.Context;

import java.util.List;

/**
 * Created by 海滨 .（dagaozi@163.com）
 * 创建时间：2016/4/19 8:46
 * 类描述：
 */
public abstract class RefreshCommonAdapter extends CommonAdapter {
    public RefreshCommonAdapter(Context context, int layoutId, List datas) {
        super(context, layoutId, datas);
    }
}
