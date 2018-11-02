package ir.javadhashemi.debit.domain.usecase

import android.arch.lifecycle.LiveData
import io.reactivex.Flowable
import ir.javadhashemi.debit.data.entity.DebitEntity
import ir.javadhashemi.debit.domain.repository.DebitRepository
import ir.javadhashemi.debit.domain.usecase.base.LiveDataUseCase
import javax.inject.Inject


class DebitUseCase @Inject constructor(private val repository: DebitRepository
) : LiveDataUseCase<List<DebitEntity>>() {


    override fun execute(): LiveData<List<DebitEntity>> {
        return repository.getAllDebits()
    }


}