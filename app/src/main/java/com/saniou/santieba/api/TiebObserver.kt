package com.saniou.santieba.api

import com.sanniou.common.network.exception.ExceptionEngine
import com.sanniou.common.utilcode.util.ToastUtils
import io.reactivex.Observer
import io.reactivex.disposables.Disposable


abstract class ToastObserver<T> : Observer<T> {
    override fun onComplete() {
    }

    override fun onSubscribe(d: Disposable) {

    }

    override fun onError(e: Throwable) {
        ToastUtils.showShort(ExceptionEngine.handleMessage(e))
    }
}