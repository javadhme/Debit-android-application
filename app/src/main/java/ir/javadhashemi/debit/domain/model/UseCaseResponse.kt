package ir.javadhashemi.debit.domain.model


interface UseCaseResponse<T> {

    fun onSuccess(value: T)

    fun onError(error: Throwable)
}
