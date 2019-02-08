package ir.javadhashemi.debit.di.module

import dagger.Module
import dagger.Provides
import ir.javadhashemi.debit.domain.mapper.DebitModelMapper
import ir.javadhashemi.debit.domain.repository.DebitRepository
import ir.javadhashemi.debit.domain.usecase.AddNewDebitUseCase

@Module
class CreateDebitModule {


    @Provides
    fun provideCreateDebitUseCase(repository: DebitRepository, mapper: DebitModelMapper): AddNewDebitUseCase {
        return AddNewDebitUseCase(repository, mapper)
    }

}