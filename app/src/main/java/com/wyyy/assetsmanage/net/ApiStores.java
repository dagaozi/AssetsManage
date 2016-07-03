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

    @GET("http://ip.taobao.com/service/getIpInfo.php?ip=21.22.11.33")
    Observable<HttpResult<TestModel>> getTaobaoData(@Query("ip") String ip);

    @GET( "http://10.11.74.18/Test02/getDate")
    Observable<HttpResult<TestModel>> chaoshi();
}
