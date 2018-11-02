package ir.javadhashemi.debit.di.module

import android.app.Application
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import dagger.Module
import dagger.Provides
import ir.javadhashemi.debit.data.db.AppDatabase
import ir.javadhashemi.debit.data.db.DebitDao
import ir.javadhashemi.debit.util.Constants

@Module
class DatabaseModule {


    @Provides
    fun provideRoomDatabase(application: Application) : RoomDatabase {
        return Room
                .databaseBuilder(application, AppDatabase::class.java, Constants.DATABASE_NAME)
                .build()
    }

    @Provides
    fun provideDebitDao(appDatabase: AppDatabase) : DebitDao {
        return appDatabase.getDebitDao()
    }

}