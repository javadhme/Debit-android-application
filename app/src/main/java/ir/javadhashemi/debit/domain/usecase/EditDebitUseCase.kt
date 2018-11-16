package ir.javadhashemi.debit.domain.usecase

import ir.javadhashemi.debit.domain.mapper.DebitModelMapper
import ir.javadhashemi.debit.domain.model.DebitModel
import ir.javadhashemi.debit.domain.repository.DebitRepository
import ir.javadhashemi.debit.domain.usecase.base.UseCase
import javax.inject.Inject

/**
 * CREATED BY Javadroid FOR `Debit` PROJECT
 * AT: 2018/Nov/06 15:03
 */
class EditDebitUseCase @Inject constructor(
        private val repository: DebitRepository,
        private val mapper: DebitModelMapper
) : UseCase<DebitModel, Int>() {

    override fun execute(input: DebitModel?): Int {
        return repository.editDebit(
                mapper.map(
                        input!!))
    }

}