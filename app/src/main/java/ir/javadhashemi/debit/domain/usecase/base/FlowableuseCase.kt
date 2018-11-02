package ir.javadhashemi.debit.domain.usecase.base

import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


abstract class FlowableuseCase<T> : UseCase<Flowable<T>>() {

    fun execute(onResponse: (T) -> Unit): Disposable {
        return this
                .execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    onResponse
                }, {

                })
    }

}