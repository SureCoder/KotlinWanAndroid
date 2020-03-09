package com.my.kotlinwanandroid.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.my.kotlinwanandroid.R
import com.my.kotlinwanandroid.base.BaseFragment

class SearchFragment : BaseFragment() {

    companion object {
        fun newInstance() = SearchFragment()
    }

    override fun initView() {
    }

    override fun layoutId() = R.layout.fragment_search
}