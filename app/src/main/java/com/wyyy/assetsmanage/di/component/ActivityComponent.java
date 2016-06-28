package com.wyyy.assetsmanage.di.component;


import com.wyyy.assetsmanage.di.modules.ActivityModule;
import com.wyyy.assetsmanage.di.scope.ActivityScope;

import dagger.Component;

/**
 * Created by dagaozi .（dagaozi@163.com）
 * 创建时间：2016/4/10 21:05
 * 类描述：
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules ={ActivityModule.class}
)
public interface ActivityComponent {
}
