package com.my.kotlinwanandroid.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.my.kotlinwanandroid.R
import com.my.kotlinwanandroid.base.BaseFragment
import com.my.kotlinwanandroid.ui.personal.PersonalFragment

class HomeFragment : BaseFragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        PersonalFragment.newInstance()
        return inflater.inflate(R.layout.fragment_home,container,false)
    }

}