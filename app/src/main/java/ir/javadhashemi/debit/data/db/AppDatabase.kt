package ir.javadhashemi.debit.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.javadhashemi.debit.data.entity.DebitEntity
import ir.javadhashemi.debit.util.Constants


@Database(entities = [DebitEntity::class] , version = Constants.DATABASE_VERSION, exportSchema = true )
abstract class AppDatabase : RoomDatabase() {


    abstract fun getDebitDao() : DebitDao
}