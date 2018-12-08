package ir.javadhashemi.debit.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ir.javadhashemi.debit.di.module.create.CreateFragmentProvider
import ir.javadhashemi.debit.di.module.home.HomeFragmentProvider
import ir.javadhashemi.debit.presentation.main.MainActivity

@Module
abstract class ActivityBuilder {


    @ContributesAndroidInjector(modules = [
        (HomeFragmentProvider::class),
        (CreateFragmentProvider::class)
    ])
    abstract fun bindMainActivity() : MainActivity



}