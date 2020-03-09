package com.my.kotlinwanandroid.ui.personal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.my.kotlinwanandroid.R
import com.my.kotlinwanandroid.base.BaseFragment

class PersonalFragment :BaseFragment() {

    companion object{
        fun newInstance() = PersonalFragment()
    }


    override fun initView() {
    }
    override fun layoutId() = R.layout.fragment_personal
}