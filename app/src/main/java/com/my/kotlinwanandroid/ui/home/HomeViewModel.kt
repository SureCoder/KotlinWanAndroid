package com.my.kotlinwanandroid.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.my.kotlinwanandroid.base.BaseViewModel
import com.my.kotlinwanandroid.bean.ArticleWrapper
import com.my.kotlinwanandroid.net.ApiEngine
import com.my.kotlinwanandroid.net.RetrofitInstance
import com.my.kotlinwanandroid.net.server.HomeService
import kotlinx.coroutines.launch

class HomeViewModel : BaseViewModel() {

    val articleData: MutableLiveData<ArticleWrapper> = MutableLiveData()

    fun getArticle(page: String = "0") {
        viewModelScope.launch {
            val service = RetrofitInstance.getInstance<HomeService>()
            ApiEngine<ArticleWrapper>().httpCall { service.getArticle(page) }
                .onSuccess { articleData.value = it }
                .start()
            Log.e("HTTP-DATA:",articleData.value.toString())
        }
    }
}