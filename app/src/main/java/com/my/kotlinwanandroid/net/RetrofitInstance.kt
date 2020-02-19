package com.my.kotlinwanandroid.net

import com.my.kotlinwanandroid.net.ServerConfig.Companion.BASE_URL
import com.my.kotlinwanandroid.net.factory.DefaultRetrofitFactory
import retrofit2.Retrofit

/**
 * 单例缓存Retrofit
 */
object RetrofitInstance {

    val RETROFIT_MAP = hashMapOf<String, Retrofit>()

    init {
        DefaultRetrofitFactory().getInstance()
    }

    /**
     * url的形式获取Retrofit
     */
    inline fun <reified T> getInstance(baseUrl: String = BASE_URL): T = RETROFIT_MAP[baseUrl]!!.create(T::class.java)

}

