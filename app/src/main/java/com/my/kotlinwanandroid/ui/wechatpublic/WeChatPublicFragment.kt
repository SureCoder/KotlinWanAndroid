package com.my.kotlinwanandroid.ui.wechatpublic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.my.kotlinwanandroid.R
import com.my.kotlinwanandroid.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*

class WeChatPublicFragment :BaseFragment(){
    companion object{
        fun newInstance() = WeChatPublicFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_public_wechat,container,false)
    }

    override fun initView() {
    }
    override fun layoutId(): Int = R.layout.fragment_public_wechat
}