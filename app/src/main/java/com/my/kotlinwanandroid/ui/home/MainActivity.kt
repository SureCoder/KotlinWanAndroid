package com.my.kotlinwanandroid.ui.home

import android.os.Bundle
import android.util.Log
import android.widget.RadioGroup
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.commit
import com.my.kotlinwanandroid.R
import com.my.kotlinwanandroid.base.BaseFragment
import com.my.kotlinwanandroid.databinding.ActivityMainBinding
import com.my.kotlinwanandroid.ui.category.CategoryFragment
import com.my.kotlinwanandroid.ui.home.adapter.HomeTabAdapter
import com.my.kotlinwanandroid.ui.personal.PersonalFragment
import com.my.kotlinwanandroid.ui.search.SearchFragment
import com.my.kotlinwanandroid.ui.wechatpublic.WeChatPublicFragment
import com.my.kotlinwanandroid.ui.wechatpublic.WeChatPublicViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mFragmentList = mutableListOf<BaseFragment>()
    lateinit var mainBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainBinding.mainActivity = this
        initFragment()

    }

    private fun initFragment() {
        mFragmentList.add(HomeFragment.newInstance())
        mFragmentList.add(WeChatPublicFragment.newInstance())
        mFragmentList.add(SearchFragment.newInstance())
        mFragmentList.add(CategoryFragment.newInstance())
        mFragmentList.add(PersonalFragment.newInstance())
        supportFragmentManager.commit(true) {
            mFragmentList.forEach {
                add(
                    R.id.fragmentContainer,
                    it,
                    it.javaClass.simpleName
                ).hide(it)
            }
            show(mFragmentList[0])
        }
    }


    fun onCheckedChanged(group: RadioGroup, checkedId: Int) {
        when (checkedId) {
            R.id.homeRadioButton -> switchFragment(0)
            R.id.publicRadioButton -> switchFragment(1)
            R.id.searchRadioButton -> switchFragment(2)
            R.id.categoryRadioButton -> switchFragment(3)
            R.id.userRadioButton -> switchFragment(4)
        }
    }

    private fun switchFragment(tabPos: Int) {
        supportFragmentManager.commit(true) {
            mFragmentList.forEachIndexed { index, baseFragment ->
                if (index != tabPos)
                    hide(baseFragment)
                else {
                    show(baseFragment)
                }
            }
        }

    }


}
