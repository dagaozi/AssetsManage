package com.wyyy.assetsmanage.net;


import com.wyyy.assetsmanage.model.HttpResult;
import com.wyyy.assetsmanage.model.TaskModel;
import com.wyyy.assetsmanage.model.TestData;
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

    @GET( "http://web.juhe.cn:8080/finance/stock/hs")
    Observable<TestData> getTestData(@Query("gid") String gid, @Query("key") String key);

    @GET( "http://10.11.74.13/api/Test/GetTasks")
    Observable<TaskModel> getTasks();

    @GET( "http://10.11.74.13/api/Test/GetTasks")
    Observable<HttpResult<TaskModel>> getTasksData();

   /* @Multipart
    @POST( "http://10.11.74.13/api/Test/UploadFile2")
    Observable<HttpResult<UploadResult>> upLoad(@Part("abc") RequestBody description, @Part MultipartBody.Part file);*/

}
