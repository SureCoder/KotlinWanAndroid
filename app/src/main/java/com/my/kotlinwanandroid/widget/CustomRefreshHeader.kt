package com.my.kotlinwanandroid.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import com.my.kotlinwanandroid.R
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.constant.RefreshState
import com.scwang.smartrefresh.layout.internal.InternalAbstract
import kotlinx.android.synthetic.main.custom_header.view.*

class CustomRefreshHeader @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyleAttr: Int = 0
) : InternalAbstract(context, attr, defStyleAttr) {

    var REFRESH_HEADER_PULLING = "下拉可以刷新" //"下拉可以刷新";

    var REFRESH_HEADER_LOADING = "正在加载..." //"正在加载...";

    var REFRESH_HEADER_RELEASE = "释放立即刷新"
    var REFRESH_HEADER_FINISH = "刷新成功" //"刷新完成";

    var REFRESH_HEADER_FAILED = "刷新失败" //"刷新失败";

    init {
        val root = LayoutInflater.from(getContext()).inflate(R.layout.custom_header, this, false)
        addView(root)
    }

    override fun onFinish(refreshLayout: RefreshLayout, success: Boolean): Int {
         if (success)
             tv.text = REFRESH_HEADER_FINISH
        else{
             tv.text = REFRESH_HEADER_FAILED
         }
        super.onFinish(refreshLayout, success)
        return 500
    }

    override fun onStateChanged(
        refreshLayout: RefreshLayout,
        oldState: RefreshState,
        newState: RefreshState
    ) {
        when (newState) {
            RefreshState.PullDownToRefresh -> tv.text = REFRESH_HEADER_PULLING
            RefreshState.ReleaseToRefresh -> tv.text = REFRESH_HEADER_RELEASE
            RefreshState.Refreshing -> tv.text = REFRESH_HEADER_LOADING
        }

    }

}