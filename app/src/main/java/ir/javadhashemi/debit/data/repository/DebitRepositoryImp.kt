package ir.javadhashemi.debit.data.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
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

    override fun editDebit(debit: DebitEntity) : Int{
        return debitDao.updateDebit(debit)

    }

    override fun getAllDebits(type: Int): LiveData<List<DebitEntity>> {
        return debitDao.getAllDebits(type)
    }

    override fun getDebitSumByType(type: Int): Long {
        return debitDao.getTotalDebitsByType(type)
    }
}