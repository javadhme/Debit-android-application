package ir.javadhashemi.debit.di.module.home

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ir.javadhashemi.debit.presentation.home.HomeFragment

@Module
abstract class HomeFragmentProvider {


    @ContributesAndroidInjector
    abstract fun provideHomeFragmentFactory() : HomeFragment


}