package ir.javadhashemi.debit.domain.usecase

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import io.reactivex.Flowable
import ir.javadhashemi.debit.data.entity.DebitEntity
import ir.javadhashemi.debit.domain.mapper.DebitEntityMapper
import ir.javadhashemi.debit.domain.model.DebitModel
import ir.javadhashemi.debit.domain.repository.DebitRepository
import ir.javadhashemi.debit.domain.usecase.base.LiveDataUseCase
import javax.inject.Inject


class GetAllDebitsUseCase @Inject constructor(
        private val repository: DebitRepository,
        private val mapper: DebitEntityMapper
) : LiveDataUseCase<Any,List<DebitModel>>() {


    override fun execute(input: Any): LiveData<List<DebitModel>> {
        return Transformations.map(repository.getAllDebits()) {
            it.map { entity ->
                mapper.map(entity)
            }
        }

    }


}