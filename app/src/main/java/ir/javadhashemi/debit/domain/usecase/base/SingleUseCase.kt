package ir.javadhashemi.debit.domain.usecase.base

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import ir.javadhashemi.debit.domain.model.UseCaseResponse

/**
 * CREATED BY Javadroid FOR `Debit` PROJECT
 * AT: 2018/Nov/06 13:02
 */
abstract class SingleUseCase<R, T> : UseCase<R, Single<T>>() {

    fun execute(
            compositeDisposable: CompositeDisposable,
            input: R?,
            onResponse: UseCaseResponse<T>
    ): Disposable {
        return this
                .execute(input)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    onResponse.onSuccess(it)
                }, {
                    onResponse.onError(it)
                }).also { compositeDisposable.add(it) }
    }

}