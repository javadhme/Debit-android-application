package ir.javadhashemi.debit.domain.usecase.base

import androidx.lifecycle.LiveData

abstract class LiveDataUseCase<R, T> : UseCase<R, LiveData<T>>() {

}