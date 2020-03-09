package com.my.kotlinwanandroid.ui.home

import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.my.kotlinwanandroid.R
import com.my.kotlinwanandroid.base.BaseFragment
import com.my.kotlinwanandroid.bean.Article
import com.my.kotlinwanandroid.ui.home.adapter.BindAdapter
import com.my.kotlinwanandroid.ui.home.adapter.StringHold
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment() {


    val homeModel: HomeViewModel by viewModels()
    lateinit var adapter: Adapter<StringHold>
    val articleList: MutableList<Article> by lazy { mutableListOf<Article>() }

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun layoutId() = R.layout.fragment_home


    override fun http() {
        homeModel.getArticle()
    }

    override fun providerViewModel() {
        homeModel.articleData.observe(this, Observer {
            articleList.addAll(it.datas)
            adapter.notifyDataSetChanged()
        })
    }

    override fun initView() {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = BindAdapter(activity,articleList)
        recyclerView.adapter = adapter
    }

}


