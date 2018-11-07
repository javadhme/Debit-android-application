package ir.javadhashemi.debit.domain.usecase.base

import io.reactivex.Maybe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

abstract class MaybeUseCase<R, T> : UseCase<R, Maybe<T>>() {

    fun execute(input: R? = null,
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