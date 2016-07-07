package com.wyyy.assetsmanage.di.component;

import android.content.Context;
import android.content.res.Resources;

import com.wyyy.assetsmanage.base.BaseActivity;
import com.wyyy.assetsmanage.di.modules.ApiServiceModule;
import com.wyyy.assetsmanage.di.modules.AppModule;
import com.wyyy.assetsmanage.net.ApiMethods;
import com.wyyy.assetsmanage.net.ApiStores;
import com.wyyy.assetsmanage.utils.ToastUtil;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by dagaozi .（dagaozi@163.com）
 * 创建时间：2016/4/8 10:46
 * 类描述：
 */
@Singleton
@Component(modules = {AppModule.class, ApiServiceModule.class})
public interface AppComponent {
    //void inject(BaseApp app);
    void inject(BaseActivity baseActivity);
    Context getAppContext();
    Resources getResources();
    ApiStores getApiStoress();
    ApiMethods getApiMethods();
    ToastUtil getToastUtil();

}
