package com.wyyy.assetsmanage.net;


import com.wyyy.assetsmanage.di.component.ApiServiceComponent;
import com.wyyy.assetsmanage.di.component.DaggerApiServiceComponent;
import com.wyyy.assetsmanage.di.modules.ApiServiceModule;
import com.wyyy.assetsmanage.model.TestModel;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/**
 * Created by dagaozi on 2016/3/30.
 */
public class ApiMethods extends ApiFactory {
    public ApiMethods(){
        ApiServiceComponent component= DaggerApiServiceComponent.builder().apiServiceModule(new ApiServiceModule()).build();
        component.inject(this);
    }
    @Inject
    ApiStores apiStores;
    public Subscription getTaoboData(Subscriber<TestModel> subscriber, String ip){
        Observable observable=apiStores.getTaobaoData(ip);
        return toSubscribe(observable.map(new HttpResultFunc<TestModel>()),subscriber);
    }
    public Subscription getChaoshi(Subscriber<TestModel> subscriber){
        Observable observable=apiStores.chaoshi();
        return toSubscribe(observable.map(new HttpResultFunc<TestModel>()),subscriber);
    }

}
