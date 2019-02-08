package ir.javadhashemi.debit.di.module

import dagger.Module
import dagger.Provides
import ir.javadhashemi.debit.domain.mapper.DebitEntityMapper
import ir.javadhashemi.debit.domain.mapper.DebitModelMapper

@Module
class MapperModule {

    @Provides
    fun provideModelMapper(): DebitModelMapper = DebitModelMapper()

    @Provides
    fun provideEntityMapper(): DebitEntityMapper = DebitEntityMapper()

}