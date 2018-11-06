package ir.javadhashemi.debit.data.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import ir.javadhashemi.debit.data.entity.DebitEntity

/**
 * CREATED BY Javadroid FOR `Debit` PROJECT
 * AT: 2018/Oct/29 12:42
 */
@Dao
interface DebitDao {

    @Insert
    fun addNewDebit(data: DebitEntity)

    @Query("select * from debit where `type` = :type order by endDate DESC")
    fun getAllDebits(type: Int): LiveData<List<DebitEntity>>

    @Query("select count(*) c from debit where `type` = :type and isDone = 0")
    fun getTotalDebitsByType(type: Int): Long

    @Update
    fun updateDebit(debit: DebitEntity)



}