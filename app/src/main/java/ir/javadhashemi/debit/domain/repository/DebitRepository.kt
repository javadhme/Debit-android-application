package ir.javadhashemi.debit.domain.repository

import androidx.lifecycle.LiveData
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import ir.javadhashemi.debit.data.entity.DebitEntity

interface DebitRepository {

    fun addNewDebit(debit: DebitEntity) : Long

    fun editDebit(debit: DebitEntity) : Int

    fun getAllDebits(type: Int): LiveData<List<DebitEntity>>

    fun getDebitSumByType(type: Int) : Long
}