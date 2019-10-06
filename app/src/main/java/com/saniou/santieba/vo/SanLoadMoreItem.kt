package com.saniou.santieba.vo

import androidx.databinding.ObservableField
import com.saniou.santieba.R

import com.sanniou.common.vo.LoadCallBack
import com.sanniou.common.widget.recyclerview.Item

class SanLoadMoreItem(private val mListener: OnLoadListener) : Item, LoadCallBack {


    companion object {
        private const val STATE_READY = 0
        private const val STATE_NO_MORE = 1
        private const val STATE_LOADING = 2
        private const val STATE_FAILED = 3
        private const val STATE_SUCCESS = 4
    }

    private var mStatus = STATE_READY
    val mText = ObservableField<String>()
    private var mNoMoreText = ""
    private var pageNumber = 0

    val string: String
        get() {
            return when (mStatus) {
                STATE_READY -> "待加载"
                STATE_LOADING -> "加载中"
                STATE_FAILED -> "加载失败"
                STATE_SUCCESS -> "加载成功"
                STATE_NO_MORE -> mNoMoreText
                else -> ""
            }
        }

    fun setNoMoreText(noMoreText: String) {
        mNoMoreText = noMoreText
    }

    /**
     * 初始状态，只有此时才响应加载
     */
    fun ready() {
        mStatus = STATE_READY
        mText.set(string)
    }

    fun firstLoad() {
        ready()
        pageNumber = 0
        load()
    }

    fun load() {
        if (mStatus != STATE_READY) {
            return
        }
        mStatus = STATE_LOADING
        mListener.onLoad(++pageNumber, this)
        mText.set(string)
    }

    override fun loadSuccess(hasMore: Boolean) {
        if (hasMore) {
            mStatus = STATE_SUCCESS
            // 可以补充一个切换过程
            mStatus = STATE_READY
        } else {
            mStatus = STATE_NO_MORE
        }
        mText.set(string)
    }

    override fun loadFailed() {
        pageNumber--
        mStatus = STATE_FAILED
        mText.set(string)
    }


    override fun getType(): Int {
        return R.layout.item_sanloadmore
    }

}

interface OnLoadListener {
    fun onLoad(page: Int, callBack: LoadCallBack)
}

