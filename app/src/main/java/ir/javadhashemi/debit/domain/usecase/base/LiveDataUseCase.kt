package ir.javadhashemi.debit.domain.usecase.base

import android.arch.lifecycle.LiveData

abstract class LiveDataUseCase<R, T> : UseCase<R, LiveData<T>>() {

}