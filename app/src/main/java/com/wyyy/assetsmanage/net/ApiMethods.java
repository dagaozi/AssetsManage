package com.wyyy.assetsmanage.net;


import com.wyyy.assetsmanage.di.component.ApiServiceComponent;
import com.wyyy.assetsmanage.di.component.DaggerApiServiceComponent;
import com.wyyy.assetsmanage.di.modules.ApiServiceModule;
import com.wyyy.assetsmanage.model.TaskModel;
import com.wyyy.assetsmanage.model.TestModel;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/**
 * Created by dagaozi on 2016/3/30.
 * 网络返回数据加工处理类
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
        return toSubscribe(observable,subscriber);

    }
    public Subscription getTestData(Subscriber<TestModel> subscriber, String gid ,String key){
        Observable observable=apiStores.getTestData(gid,key);
        return toSubscribe(observable,subscriber);

    }
    public Subscription getTasksData(Subscriber<TaskModel> subscriber){
        Observable observable=apiStores.getTasksData();
        return toSubscribe(observable,subscriber);

    }
   /* public Subscription upLoad(Subscriber<UploadResult> subscriber, RequestBody description, MultipartBody.Part body){
        Observable observable=apiStores.upLoad(description,body);
        return toSubscribe(observable,subscriber);

    }*/

}
