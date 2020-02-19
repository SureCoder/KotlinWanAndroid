package com.my.kotlinwanandroid.ui.wechatpublic

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.my.kotlinwanandroid.base.BaseViewModel
import com.my.kotlinwanandroid.bean.User
import com.my.kotlinwanandroid.bean.WeChatPublic
import com.my.kotlinwanandroid.net.ApiEngine
import com.my.kotlinwanandroid.net.RetrofitInstance
import com.my.kotlinwanandroid.net.base.ApiResponse
import com.my.kotlinwanandroid.net.server.WeChatPublicService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class WeChatPublicViewModel : BaseViewModel() {

    val list: List<String>? = null

    fun getWeChatPublic() {
        viewModelScope.launch {
            val service = RetrofitInstance.getInstance<WeChatPublicService>()
//                Log.e("kotlin ${Thread.currentThread().name}", s.toString())
//                apiCall({ service.getWeChatPublic() }, onSuccess = { Log.e("test", it.toString()) })
//                apiCall(
//                    httpCall = { service.register("lishuo00010", "111111", "111111") },
//                    onSuccess = { Log.e("success", it.toString()) })
//                Log.e("test", "11")
            ApiEngine<List<WeChatPublic>>().httpCall { service.getWeChatPublic() }
                .before(Dispatchers.IO) {Log.e("kotlin ${Thread.currentThread().name}", "beforeCall") }
                .onSuccess { Log.e("kotlin ${Thread.currentThread().name}", " onSuccess+ $it") }
                .onFinish(Dispatchers.IO) { Log.e("kotlin ${Thread.currentThread().name}", "onFinish") }
                .start()

        }
                    Log.e("test", "22")

    }

    //模仿post  请求
//    fun test() = ApiResponse<Any>(null, 0, "null-test")

    fun testList() = ApiResponse(list, 0, "null-test")


}