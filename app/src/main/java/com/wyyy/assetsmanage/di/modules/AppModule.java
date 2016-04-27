package com.wyyy.assetsmanage.di.modules;

import android.content.Context;
import android.content.res.Resources;

import com.wyyy.assetsmanage.base.BaseApp;

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
    private BaseApp app;
    public AppModule (BaseApp app){
        this.app=app;
    }
    @Provides
    @Singleton
    public Context produceAppContext(){
        return app;
    }
    @Provides
    @Singleton
    public Resources provideResources(){
        return app.getResources();
    }
}
