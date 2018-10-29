package ir.javad_hashemi.debit.data.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import ir.javad_hashemi.debit.data.entity.DebitEntity

/**
 * CREATED BY Javadroid FOR `Debit` PROJECT
 * AT: 2018/Oct/29 12:42
 */
@Dao
interface DebitDao {

    @Insert
    fun addNewDebit(data: DebitEntity)

    @Query("select * from debit order by endDate DESC")
    fun getAllDebits()

    @Query("")
    fun getAllDebitsByType()

}