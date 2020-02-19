package com.my.kotlinwanandroid.net.base

sealed class Result<T> {

    data class Success<T>(val data: T) : Result<T>()

    data class Error(val code: Int, val errorMsg: String) : Result<Nothing>()
}

/**
{
"data": ...,
"errorCode": 0,
"errorMsg": ""
}
 */
data class ApiResponse<T>(var data: T, val errorCode: Int, val errorMsg: String)

enum class ApiCode(val code: Int, val errorMsg: String){
    OK(0,"api请求成功"),
    NEED_LOGIN( -1001,"登录失效，需要重新登录")
}