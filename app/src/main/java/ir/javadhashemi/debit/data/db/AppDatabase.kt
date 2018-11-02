package ir.javadhashemi.debit.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import ir.javadhashemi.debit.data.entity.DebitEntity
import ir.javadhashemi.debit.util.Constants


@Database(entities = [DebitEntity::class] , version = Constants.DATABASE_VERSION, exportSchema = true )
abstract class AppDatabase : RoomDatabase() {


    abstract fun getDebitDao() : DebitDao
}