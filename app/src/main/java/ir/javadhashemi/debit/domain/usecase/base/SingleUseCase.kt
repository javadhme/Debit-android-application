package ir.javadhashemi.debit.domain.usecase.base

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * CREATED BY Javadroid FOR `Debit` PROJECT
 * AT: 2018/Nov/06 13:02
 */
abstract class SingleUseCase<R, T> : UseCase<R, Single<T>>() {

    fun execute(input: R?,
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