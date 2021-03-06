package com.wyyy.assetsmanage.di.modules;

import android.app.Activity;

import com.wyyy.assetsmanage.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dagaozi .（dagaozi@163.com）
 * 创建时间：2016/4/8 10:29
 * 类描述：
 */
@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @Provides
    @ActivityScope
    Activity provideActivity(){
        return mActivity;
    }


}
