package ir.javadhashemi.debit.di.module

import dagger.Module
import dagger.Provides
import ir.javadhashemi.debit.data.db.DebitDao
import ir.javadhashemi.debit.data.repository.DebitRepositoryImp
import ir.javadhashemi.debit.domain.repository.DebitRepository

@Module
class DebitRepositoryModule {

    @Provides
    fun provideRepository(dao : DebitDao) : DebitRepository {
        return DebitRepositoryImp(dao)
    }

}