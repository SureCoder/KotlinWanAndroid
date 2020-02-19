package com.my.kotlinwanandroid.net.factory

import com.my.kotlinwanandroid.net.ServerConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

interface RetrofitFactory {

    /**
     * 获取Retrofit
     */
    fun getInstance():Retrofit
    /**
     * 提供默认配置的OkHttpClient
     */
    fun initOkHttpClient():OkHttpClient{
        val loggingInterceptor = HttpLoggingInterceptor()
        return OkHttpClient.Builder()
            .readTimeout(ServerConfig.READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(ServerConfig.WRITE_TIMEOUT, TimeUnit.SECONDS)
            .callTimeout(ServerConfig.CALL_TIMEOUT, TimeUnit.SECONDS)
            .retryOnConnectionFailure(ServerConfig.RETRY_ON_CONNECTION_FAILURE)
            .addInterceptor(loggingInterceptor)
            .build()
    }
}



