package ir.javadhashemi.debit.domain.repository

import android.arch.lifecycle.LiveData
import ir.javadhashemi.debit.data.entity.DebitEntity

interface DebitRepository {

    fun addNewDebit(debit: DebitEntity)

    fun getAllDebits(): LiveData<List<DebitEntity>>

}