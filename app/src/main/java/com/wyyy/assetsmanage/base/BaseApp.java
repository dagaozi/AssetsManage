package com.wyyy.assetsmanage.base;

import android.app.Application;

import com.wyyy.assetsmanage.di.component.AppComponent;
import com.wyyy.assetsmanage.di.component.DaggerAppComponent;
import com.wyyy.assetsmanage.di.modules.AppModule;

/**
 * Created by dagaozi .（dagaozi@163.com）
 * 创建时间：2016/4/8 10:43
 * 类描述：
 */
public class BaseApp extends Application{
    private AppComponent component;
    //public static Context appContext=null;
    private static BaseApp app;
    @Override
    public void onCreate() {
        super.onCreate();
        app=this;
      setUpComponent();
    }
    public static BaseApp getInstance() {
        return app;
    }

    private void setUpComponent() {
        component= DaggerAppComponent.builder().appModule(new AppModule(this)).build();
       // component.inject(this);
    }
    public AppComponent getAppcomponet(){
        return component;
    }
}
