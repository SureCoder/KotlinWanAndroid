package com.my.kotlinwanandroid.net.server

import com.my.kotlinwanandroid.bean.User
import com.my.kotlinwanandroid.bean.WeChatPublic
import com.my.kotlinwanandroid.net.base.ApiResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface WeChatPublicService {

    @GET("wxarticle/chapters/json")
    suspend fun getWeChatPublic(): ApiResponse<List<WeChatPublic>>

    @FormUrlEncoded
    @POST("user/register")
    suspend fun register(
        @Field("username") username: String, @Field("password") password: String, @Field(
            "repassword"
        ) repassword: String
    ): ApiResponse<User>
}