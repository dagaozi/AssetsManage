package com.wyyy.assetsmanage.di.modules;


import android.content.Context;

import com.wyyy.assetsmanage.net.ApiStores;
import com.wyyy.assetsmanage.utils.LogUtils;
import com.wyyy.assetsmanage.utils.NetUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dagaozi .（dagaozi@163.com）
 * 创建时间：2016/4/10 13:30
 * 类描述：提供网络访问客户端
 */
@Module
public class ApiServiceModule {
    public static final String PRODUCT_URL = "http://www.weather.com.cn/";
    public static final String DEBUG_URL = "http://www.weather.com.cn/";
    private static final int DEFAULT_TIMEOUT = 5;
    @Provides
    @Singleton
    OkHttpClient.Builder provideOkHttpClient(final  Context context){
        //OKhttp的日志系统
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        Interceptor netinterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!NetUtils.isConnected(context)) {
                    LogUtils.d("没有网络");
                   /* request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .url(path).build();*/
                    //UIUtils.showToastSafe("请检查忘了是否正常");//子线程安全显示Toast
                }

                Response response = chain.proceed(request);
             /*   if (AppUtil.isNetworkReachable(UIUtils.getContext())) {
                    int maxAge = 60 * 60; // read from cache for 1 minute
                    response.newBuilder()
                            .removeHeader("Pragma")
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .build();
                } else {
                    int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale
                    response.newBuilder()
                            .removeHeader("Pragma")
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .build();
                }*/
                return response;
            }
        };
        //手动创建一个OkHttpClient并设置超时时间，和日志
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor)
                .addInterceptor(netinterceptor);
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        httpClientBuilder.readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        //httpClientBuilder.sslSocketFactory(null);
        return httpClientBuilder;
    }
    @Provides
    @Singleton
    Retrofit provideRetrofit( OkHttpClient.Builder httpClientBuilder){
        Retrofit  retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .baseUrl(DEBUG_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;
    }
    @Provides
    @Singleton
    ApiStores provideApiStores(Retrofit retrofit){
        return retrofit.create(ApiStores.class);
    }

}
