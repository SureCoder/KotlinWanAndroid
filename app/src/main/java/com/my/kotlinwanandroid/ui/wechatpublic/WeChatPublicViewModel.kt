package com.my.kotlinwanandroid.ui.wechatpublic

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.my.kotlinwanandroid.base.BaseViewModel
import com.my.kotlinwanandroid.bean.User
import com.my.kotlinwanandroid.bean.WeChatPublic
import com.my.kotlinwanandroid.net.ApiEngine
import com.my.kotlinwanandroid.net.RetrofitInstance
import com.my.kotlinwanandroid.net.server.WeChatPublicService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeChatPublicViewModel : BaseViewModel() {

    val weChatPublicData: MutableLiveData<List<WeChatPublic>> = MutableLiveData()

    fun getWeChatPublic() {
        viewModelScope.launch {
            val service = RetrofitInstance.getInstance<WeChatPublicService>()
//            ApiEngine<List<WeChatPublic>>().httpCall { service.getWeChatPublic() }
//                .before(Dispatchers.IO) { }
//                .onSuccess { weChatPublicData.value = it }
//                .onFinish(Dispatchers.IO) { }
//                .start()

            ApiEngine<User>().httpCall { service.register("lishuo00011","111111","111111") }
                .before(Dispatchers.IO) { }
                .onSuccess { Log.e("test11",it.toString()) }
                .onFinish(Dispatchers.IO) { }
                .start()
            val l:List<String?> = ArrayList()
            
        }


    }


}