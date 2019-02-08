package ir.javadhashemi.debit.domain.usecase

import io.reactivex.Observable
import io.reactivex.Single
import ir.javadhashemi.debit.domain.mapper.DebitModelMapper
import ir.javadhashemi.debit.domain.model.DebitModel
import ir.javadhashemi.debit.domain.repository.DebitRepository
import ir.javadhashemi.debit.domain.usecase.base.NormalUseCase
import ir.javadhashemi.debit.domain.usecase.base.SingleUseCase
import javax.inject.Inject

/**
 * CREATED BY Javadroid FOR `Debit` PROJECT
 * AT: 2018/Nov/06 11:00
 */
class AddNewDebitUseCase @Inject constructor(
        private val repository: DebitRepository,
        private val mapper: DebitModelMapper
) : NormalUseCase<DebitModel, Long>() {

    override fun execute(input: DebitModel?): Long {
        return repository.addNewDebit(mapper.map(input!!))
    }

}