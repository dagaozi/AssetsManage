package com.wyyy.assetsmanage.net;


import com.wyyy.assetsmanage.model.HttpResult;
import com.wyyy.assetsmanage.model.TestModel;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by dagaozi on 2016/3/25.
 */
public interface ApiStores {

    @GET("http://ip.taobao.com/service/getIpInfo.php")
    Observable<HttpResult<TestModel>> getTaobaoData(@Query("ip") String ip);

    @GET( "Test02/getDate")
    Observable<HttpResult<TestModel>> chaoshi();
}
