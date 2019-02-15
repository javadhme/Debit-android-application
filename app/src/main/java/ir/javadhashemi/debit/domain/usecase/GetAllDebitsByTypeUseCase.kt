package ir.javadhashemi.debit.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import ir.javadhashemi.debit.domain.mapper.DebitEntityMapper
import ir.javadhashemi.debit.domain.model.DebitModel
import ir.javadhashemi.debit.domain.repository.DebitRepository
import ir.javadhashemi.debit.domain.usecase.base.LiveDataUseCase
import javax.inject.Inject


class GetAllDebitsByTypeUseCase @Inject constructor(
        private val repository: DebitRepository,
        private val mapper: DebitEntityMapper
) : LiveDataUseCase<Int,List<DebitModel>>() {


    override fun execute(input: Int?): LiveData<List<DebitModel>> {
        return Transformations.map(repository.getAllDebits(input!!)) {
            it.map { entity ->
                mapper.map(entity)
            }
        }

    }


}