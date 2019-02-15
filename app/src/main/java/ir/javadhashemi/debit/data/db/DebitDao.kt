package ir.javadhashemi.debit.data.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import io.reactivex.Observable
import io.reactivex.Single
import ir.javadhashemi.debit.data.entity.DebitEntity

/**
 * CREATED BY Javadroid FOR `Debit` PROJECT
 * AT: 2018/Oct/29 12:42
 */
@Dao
interface DebitDao {

    @Insert
    fun addNewDebit(data: DebitEntity): Long

    @Query("select * from debit where `type` = :type order by endDate DESC")
    fun getAllDebits(type: Int): LiveData<List<DebitEntity>>

    @Query("select count(*) c from debit where `type` = :type and isDone = 0")
    fun getTotalDebitsByType(type: Int): Long

    @Update
    fun updateDebit(debit: DebitEntity): Int


}