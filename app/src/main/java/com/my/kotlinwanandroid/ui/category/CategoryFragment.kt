package com.my.kotlinwanandroid.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.my.kotlinwanandroid.R
import com.my.kotlinwanandroid.base.BaseFragment

class CategoryFragment : BaseFragment() {


    companion object {
        fun newInstance() = CategoryFragment()
    }

    override fun initView() {
    }

    override fun layoutId() = R.layout.fragment_category
}