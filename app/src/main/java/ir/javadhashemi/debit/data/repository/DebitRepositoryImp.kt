package ir.javadhashemi.debit.data.repository

import android.arch.lifecycle.LiveData
import io.reactivex.Flowable
import ir.javadhashemi.debit.data.db.DebitDao
import ir.javadhashemi.debit.data.entity.DebitEntity
import ir.javadhashemi.debit.domain.repository.DebitRepository
import javax.inject.Inject

class DebitRepositoryImp @Inject constructor(
        private val debitDao: DebitDao
) : DebitRepository {

    override fun addNewDebit(debit: DebitEntity) {
        debitDao.addNewDebit(debit)
    }

    override fun getAllDebits(): LiveData<List<DebitEntity>> {
        return debitDao.getAllDebits()
    }
}