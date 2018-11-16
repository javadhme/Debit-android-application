package ir.javadhashemi.debit.domain.repository

import android.arch.lifecycle.LiveData
import ir.javadhashemi.debit.data.entity.DebitEntity

interface DebitRepository {

    fun addNewDebit(debit: DebitEntity)

    fun editDebit(debit: DebitEntity) : Int

    fun getAllDebits(type: Int): LiveData<List<DebitEntity>>

    fun getDebitSumByType(type: Int) : Long
}