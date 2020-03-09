package com.my.kotlinwanandroid.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.my.kotlinwanandroid.R
import com.my.kotlinwanandroid.bean.Article
import com.my.kotlinwanandroid.databinding.ItemArticleBinding
import kotlinx.android.synthetic.main.custom_header.view.*

class BindAdapter(private val context: Context?, val list: MutableList<Article>) :
    RecyclerView.Adapter<StringHold>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StringHold {
        return StringHold(
            DataBindingUtil.inflate<ItemArticleBinding>(
                LayoutInflater.from(context),
                R.layout.item_article,
                parent,
                false
            )
        )

    }

    override fun getItemCount(): Int = list.size


    override fun onBindViewHolder(holder: StringHold, position: Int) {
        holder.bind(list[position])
    }

}

class StringHold(val binding: ItemArticleBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(article: Article) {
        binding.article =article
    }
}