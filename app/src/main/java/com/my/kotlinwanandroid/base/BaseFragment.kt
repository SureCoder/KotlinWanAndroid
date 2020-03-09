package com.my.kotlinwanandroid.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

 abstract class BaseFragment :Fragment(){

     abstract fun layoutId():Int

     override fun onCreateView(
         inflater: LayoutInflater,
         container: ViewGroup?,
         savedInstanceState: Bundle?
     ): View? {
         return inflater.inflate(layoutId(),container,false)
     }

     override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
         initView()
         providerViewModel()
         http()
     }

     protected open fun providerViewModel(){

     }

     protected open fun http() {

     }

     abstract fun initView()

 }