package com.my.kotlinwanandroid.net

class ServerConfig {

    companion object{
        const val BASE_URL = "https://www.wanandroid.com/"
        const val READ_TIMEOUT = 30L
        const val WRITE_TIMEOUT = 30L
        const val CALL_TIMEOUT = 30L
        const val RETRY_ON_CONNECTION_FAILURE = true
    }
}