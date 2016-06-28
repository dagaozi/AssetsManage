package com.wyyy.assetsmanage.di.modules;

import android.content.Context;
import android.content.res.Resources;

import com.wyyy.assetsmanage.base.BaseApp;
import com.wyyy.assetsmanage.net.ApiMethods;
import com.wyyy.assetsmanage.utils.ToastUtil;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dagaozi .（dagaozi@163.com）
 * 创建时间：2016/4/8 10:49
 * 类描述：
 */
@Module
public class AppModule {
    private BaseApp baseApp;
    public AppModule (BaseApp baseApp){
        this.baseApp=baseApp;
    }
    @Provides
    @Singleton
    public Context produceAppContext(){
        return baseApp.getApplicationContext();
    }
    @Provides
    @Singleton
    public Resources provideResources(){
        return baseApp.getApplicationContext().getResources();
    }

    @Provides
    @Singleton
    ApiMethods provideApiMethods(){
        return  new ApiMethods();
    }
    @Provides
    @Singleton
    ToastUtil provideToastUtil(){
        return  new ToastUtil(baseApp.getApplicationContext());
    }
}
