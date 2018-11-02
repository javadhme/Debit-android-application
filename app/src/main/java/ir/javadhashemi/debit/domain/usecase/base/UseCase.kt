package ir.javadhashemi.debit.domain.usecase.base

abstract class UseCase<T> {

    abstract fun execute(): T
}