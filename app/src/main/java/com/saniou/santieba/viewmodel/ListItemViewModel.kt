package com.saniou.santieba.viewmodel

import androidx.annotation.CallSuper
import androidx.lifecycle.MutableLiveData
import com.blankj.utilcode.util.ToastUtils
import com.sanniou.multiitem.DataItem
import com.sanniou.multiitemkit.vo.LoadMoreItem
import com.sanniou.multiitemkit.vo.NonItem
import com.sanniou.support.components.BaseListViewModel
import com.sanniou.support.exception.ExceptionEngine

abstract class ListItemViewModel : BaseListViewModel() {

    private val param = mutableMapOf<String, String>()

    val refreshState = MutableLiveData<Boolean>()

    val title = MutableLiveData<CharSequence>()

    @CallSuper
    open fun initParam(param: Map<String, String>) {
        this.param.putAll(param)
    }

    fun refresh() {
        clear()
        beforeRefresh()
        onRefresh()
    }

    abstract fun fetchData()

    open fun beforeRefresh() {
    }

    open fun onRefresh() {
    }

    open fun getDividerHeight() = 1

    open fun autoRefresh() = false

    open fun refreshable() = false

    fun getValue(key: String) = param[key]!!

    fun removeValue(key: String) = param.remove(key)

    fun getValueOrNull(key: String) = param.getOrDefault(key, null)

    fun getValueOrDefault(key: String, default: String) = param.getOrDefault(key, default)

    fun setValue(key: String, value: String) {
        param[key] = value
    }

    open fun getHeaderType() = -1

    open fun getHeaderClickable() = intArrayOf()

    open fun handlerHeaderLongClick(id: Int, position: Int) = Unit

    open fun handlerHeaderClick(id: Int, position: Int) = Unit
}

abstract class AutoListItemViewModel : ListItemViewModel() {

    private val loadMoreItem = LoadMoreItem { fetchData() }

    @CallSuper
    override fun onRefresh() {
        loadMoreItem.ready()
        // 可能会导致刷新失败，需要在合适的时机用 set 方法替换
        add(NonItem())
        add(loadMoreItem)
    }

    final override fun fetchData() {
        launch {
            try {
                val size = list.size
                val hasMore = fetchList()
                refreshState.value = true
                loadMoreItem.loadSuccess(hasMore)
                fetchSuccess()
            } catch (e: Exception) {
                fetchFailed()
                refreshState.value = false
                loadMoreItem.loadFailed()
                ToastUtils.showShort(ExceptionEngine.handleMessage(e))
            }
        }
    }

    open fun fetchSuccess() = Unit

    open fun fetchFailed() = Unit

    override fun autoRefresh() = true

    override fun refreshable() = true

    fun addItem(item: DataItem) {
        super.add(list.size - 1, item)
    }

    /**
     *
     *@return Boolean has more
     */
    abstract suspend fun fetchList(): Boolean
}

abstract class PointAutoListItemViewModel : AutoListItemViewModel() {

    private var point: String? = null

    override fun onRefresh() {
        initPoint()
        super.onRefresh()
    }

    open fun initPoint() {
        point = null
    }

    /**
     *
     *@return Boolean has more
     */
    final override suspend fun fetchList() = fetchPoint(point)

    fun updatePoint(newPoint: String?) {
        point = newPoint
    }

    /**
     *
     * @param page Int
     * @return Boolean has more
     */
    abstract suspend fun fetchPoint(point: String?): Boolean
}

abstract class PageAutoListItemViewModel : AutoListItemViewModel() {

    private var page = 1

    override fun onRefresh() {
        page = 1
        super.onRefresh()
    }

    /**
     *
     *@return Boolean has more
     */
    final override suspend fun fetchList() = fetchPage(page)

    /**
     *
     * @param page Int
     * @return Boolean has more
     */
    abstract suspend fun fetchPage(page: Int): Boolean

    @CallSuper
    override fun fetchSuccess() {
        page++
    }
}

abstract class OffsetAutoListItemViewModel : AutoListItemViewModel() {

    var offset = 0

    override fun onRefresh() {
        offset = 0
        super.onRefresh()
    }

    /**
     *
     *@return Boolean has more
     */
    final override suspend fun fetchList() = fetchOffset(offset)

    /**
     *
     * @param offset Int
     * @return Boolean has more
     */
    abstract suspend fun fetchOffset(offset: Int): Boolean

    @CallSuper
    override fun fetchSuccess() {
        calOffset()
    }

    open fun calOffset() {
        offset = list.size - 1
    }
}