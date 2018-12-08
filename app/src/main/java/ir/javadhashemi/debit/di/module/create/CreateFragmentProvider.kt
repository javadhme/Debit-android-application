package ir.javadhashemi.debit.di.module.create

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ir.javadhashemi.debit.presentation.create.CreateFragment

@Module
abstract class CreateFragmentProvider {

    @ContributesAndroidInjector
    abstract fun provideCreateFragment() : CreateFragment

}