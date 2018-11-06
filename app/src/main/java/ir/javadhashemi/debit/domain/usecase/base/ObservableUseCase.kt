package ir.javadhashemi.debit.domain.usecase.base

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

abstract class ObservableUseCase<R, T> : UseCase<R, Observable<T>>() {

    fun execute(
            input : R,
            onResponse: (T) -> Unit
    ): Disposable {
        return this
                .execute(input)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    onResponse(it)
                }, {

                })
    }

}