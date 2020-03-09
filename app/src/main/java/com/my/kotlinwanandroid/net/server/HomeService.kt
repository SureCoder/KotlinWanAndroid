package com.my.kotlinwanandroid.net.server

import com.my.kotlinwanandroid.bean.ArticleWrapper
import com.my.kotlinwanandroid.net.base.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface HomeService {

    @GET("article/list/{page}/json")
    suspend fun getArticle(@Path("page") page: String): ApiResponse<ArticleWrapper>

}