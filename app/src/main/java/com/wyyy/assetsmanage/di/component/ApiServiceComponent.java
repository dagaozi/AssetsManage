package com.wyyy.assetsmanage.di.component;


import com.wyyy.assetsmanage.di.modules.ApiServiceModule;
import com.wyyy.assetsmanage.net.ApiMethods;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by dagaozi .（dagaozi@163.com）
 * 创建时间：2016/4/11 16:26
 * 类描述：
 */
@Singleton
@Component(modules = {ApiServiceModule.class})
public interface ApiServiceComponent {
    void inject(ApiMethods apiMethods);
}
