package com.wyyy.assetsmanage.di.modules;


import com.wyyy.assetsmanage.net.ApiStores;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
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
    private static final int DEFAULT_TIMEOUT = 10;
    @Provides
    @Singleton
    OkHttpClient.Builder provideOkHttpClient(){
        //OKhttp的日志系统
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
     /*   Interceptor netinterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!NetUtils.isConnected(BaseApp.appContext)) {
                   *//* request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .url(path).build();*//*
                    LogUtils.d("没网");
                    throw new ApiException(100);
                }

                Response response = chain.proceed(request);
             *//*   if (AppUtil.isNetworkReachable(UIUtils.getContext())) {
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
                }*//*
                return response;
            }
        };*/
        //手动创建一个OkHttpClient并设置超时时间，网络判断拦截器、日志拦截器
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor);
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
