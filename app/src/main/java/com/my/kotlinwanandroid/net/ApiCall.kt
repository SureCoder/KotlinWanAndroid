package com.my.kotlinwanandroid.net

import android.util.Log
import com.google.gson.JsonParseException
import com.my.kotlinwanandroid.net.base.ApiCode
import com.my.kotlinwanandroid.net.base.ApiResponse
import com.my.kotlinwanandroid.net.base.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.net.SocketTimeoutException

class ApiEngine<T> {

    private lateinit var httpCall: (suspend () -> ApiResponse<T>)
    private var beforeCall: () -> Unit = {}
    private var onSuccess: (T) -> Unit = {}
    private var onApiError: (e: Result.Error) -> Unit = {}
    private var onFinishCall: () -> Unit = {}

    private var beforeCallDispatcher: CoroutineDispatcher = Dispatchers.Main
    private var onFinishCallDispatcher: CoroutineDispatcher = Dispatchers.Main
    private var onSuccessDispatcher: CoroutineDispatcher = Dispatchers.Main
    private var onApiErrorDispatcher: CoroutineDispatcher = Dispatchers.Main


    fun httpCall(httpCall: suspend () -> ApiResponse<T>): ApiEngine<T> {
        this.httpCall = httpCall
        return this
    }

    fun before(
        dispatcher: CoroutineDispatcher = Dispatchers.Main,
        beforeCall: () -> (Unit)
    ): ApiEngine<T> {
        this.beforeCall = beforeCall
        beforeCallDispatcher = dispatcher
        return this
    }

    fun onSuccess(
        dispatcher: CoroutineDispatcher = Dispatchers.Main,
        onSuccess: (T?) -> Unit
    ): ApiEngine<T> {
        this.onSuccess = onSuccess
        onSuccessDispatcher = dispatcher
        return this
    }

    fun onApiError(
        dispatcher: CoroutineDispatcher = Dispatchers.Main,
        onApiError: (e: Result.Error) -> Unit
    ): ApiEngine<T> {
        this.onApiError = onApiError
        this.onApiErrorDispatcher = dispatcher
        return this
    }

    fun onFinish(
        dispatcher: CoroutineDispatcher = Dispatchers.Main,
        onFinishCall: () -> Unit
    ): ApiEngine<T> {
        this.onFinishCall = onFinishCall
        onFinishCallDispatcher = dispatcher
        return this
    }

    suspend fun start() {
        apiCall(httpCall, onSuccess, onApiError, beforeCall, onFinishCall)
    }

    /**
     * @param httpCall 接口
     * @param onSuccess 成功的处理 返回可空的数据
     * @param onApiError 失败的处理
     */
    suspend fun apiCall(
        httpCall: suspend () -> ApiResponse<T>,
        onSuccess: (T) -> Unit = {},
        onApiError: (e: Result.Error) -> Unit = {}, onBeforeCall: () -> Unit = {}
        , onFinishCall: () -> Unit = {}
    ) {
        try {
            withContext(beforeCallDispatcher) { onBeforeCall() }
            val result = httpCall.invoke()
            when (result.errorCode) {
                ApiCode.OK.code -> {
                    if (result.data == null) {
                        Log.e("HTTP:API异常", "注意：data字段为null（API出错/或者是个无返回值的请求）")
                    }
                    withContext(onSuccessDispatcher) { onSuccess(result.data) }
                }
                else -> {
                    withContext(onApiErrorDispatcher) {
                        onApiError(Result.Error(result.errorCode, result.errorMsg))
                    }
                    Log.e("HTTP:API异常", result.toString())
                }
            }
        } catch (e: Throwable) {
            handleHttpError(e)
            e.printStackTrace()
        } finally {
            withContext(onFinishCallDispatcher) { onFinishCall() }
        }
    }


    private fun handleHttpError(e: Throwable) {
        when (e) {
            is HttpException -> {
            }
            is SocketTimeoutException -> {
            }
            is JsonParseException -> {
            }
            is ClassCastException -> {
                Log.e("HTTP-GSON转换异常", "错误：${e}")
            }
            else -> Log.e("HTTP", "错误：${e}")
        }
    }


}