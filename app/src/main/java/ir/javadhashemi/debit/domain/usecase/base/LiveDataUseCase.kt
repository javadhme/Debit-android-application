package ir.javadhashemi.debit.domain.usecase.base

import android.arch.lifecycle.LiveData

abstract class LiveDataUseCase<T> : UseCase<LiveData<T>>() {

}