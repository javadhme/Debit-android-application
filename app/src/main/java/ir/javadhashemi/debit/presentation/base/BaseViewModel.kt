package ir.javadhashemi.debit.presentation.base

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import io.reactivex.disposables.CompositeDisposable

/**
 * CREATED BY Javadroid FOR `WiCalory` PROJECT
 * AT: 2018/Jun/12 16:32
 */
open class BaseViewModel() : ViewModel() {

    val showProgress: ObservableField<Boolean> = ObservableField()
    val networkError: ObservableField<Boolean> = ObservableField()

    val commonMessage: MutableLiveData<String> = MutableLiveData()

    val compositeDisposable: CompositeDisposable = CompositeDisposable()


    init {
        showProgress.set(false)
        networkError.set(false)

    }

    open fun tryAgainFunction() {

    }

    fun showProgressBar() {
        showProgress.set(true)
    }

    fun hideProgressBar() {
        showProgress.set(false)

    }

    fun showConnectionError() {
        hideProgressBar()
        networkError.set(true)
    }

    fun hideConnectionError() {
        networkError.set(false)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}