package com.my.kotlinwanandroid.net.factory

import com.my.kotlinwanandroid.net.RetrofitInstance
import com.my.kotlinwanandroid.net.ServerConfig.Companion.BASE_URL
import com.my.kotlinwanandroid.net.convert.CustomGsonConverterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * 默认的实现
 */
class DefaultRetrofitFactory : RetrofitFactory {

    override fun getInstance(): Retrofit {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(initOkHttpClient())
            .build()
        RetrofitInstance.RETROFIT_MAP[BASE_URL] = retrofit
        return retrofit
    }

}