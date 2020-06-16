package com.saniou.santieba.viewmodel

import androidx.annotation.CallSuper
import com.blankj.utilcode.util.ToastUtils
import com.sanniou.multiitem.DataItem
import com.sanniou.multiitemkit.vo.LoadMoreItem
import com.sanniou.multiitemkit.vo.NonItem
import com.sanniou.support.components.BaseListViewModel
import com.sanniou.support.exception.ExceptionEngine
import com.sanniou.support.lifecycle.OnceLiveData
import com.sanniou.support.lifecycle.SingleLiveData

abstract class ListItemViewModel : BaseListViewModel() {

    private val param = mutableMapOf<String, String>()

    val refreshState = SingleLiveData<Boolean>()

    val startRefresh = OnceLiveData<Any?>(1)

    open val dividerHeight = 1

    open val dividerColor = 0

    open val autoRefresh = false

    open val refreshable = false

    open val span = 0

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
        fetchData()
    }

    fun getValue(key: String) = param[key]!!

    fun getNullableValue(key: String) = param[key]

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
        // 不加可能会导致刷新手势失效，可以在合适的时机用 set（0） 方法替换
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

    override val autoRefresh = true

    override val refreshable = true

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