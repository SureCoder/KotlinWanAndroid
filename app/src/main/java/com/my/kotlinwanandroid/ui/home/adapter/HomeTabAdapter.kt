package com.my.kotlinwanandroid.ui.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.my.kotlinwanandroid.base.BaseFragment

class HomeTabAdapter(
    private val fragmentList: MutableList<BaseFragment>,
    fm: FragmentManager
) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment = fragmentList[position]


    override fun getCount(): Int = fragmentList.size

}