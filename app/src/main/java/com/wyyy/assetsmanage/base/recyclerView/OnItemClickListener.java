package com.wyyy.assetsmanage.base.recyclerView;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by dagaozi .（dagaozi@163.com）
 * 创建时间：2016/4/12 23:48
 * 类描述：点击Item接口
 */
public interface OnItemClickListener<T> {
    void onItemClick(ViewGroup parent, View view, T t, int position);
}
