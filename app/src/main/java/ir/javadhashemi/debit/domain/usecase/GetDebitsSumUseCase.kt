package ir.javadhashemi.debit.domain.usecase

import ir.javadhashemi.debit.domain.repository.DebitRepository
import ir.javadhashemi.debit.domain.usecase.base.UseCase
import javax.inject.Inject

/**
 * CREATED BY Javadroid FOR `Debit` PROJECT
 * AT: 2018/Nov/06 18:05
 */
class GetDebitsSumUseCase @Inject constructor(
        private val repository: DebitRepository
) : UseCase<Int, Long>() {

    override fun execute(input: Int?): Long {
        return repository.getDebitSumByType(input!!)
    }

}