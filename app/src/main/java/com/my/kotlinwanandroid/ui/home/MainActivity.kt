package com.my.kotlinwanandroid.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.my.kotlinwanandroid.R
import com.my.kotlinwanandroid.ui.wechatpublic.WeChatPublicViewModel

class MainActivity : AppCompatActivity() {

    val viewModel by viewModels<WeChatPublicViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.getWeChatPublic()

    }

}
