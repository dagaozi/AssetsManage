package com.wyyy.assetsmanage.di.component;

import android.content.Context;
import android.content.res.Resources;

import com.wyyy.assetsmanage.base.BaseApp;
import com.wyyy.assetsmanage.di.modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by dagaozi .（dagaozi@163.com）
 * 创建时间：2016/4/8 10:46
 * 类描述：
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(BaseApp app);
    Context getAppContext();
    Resources getResources();

}
